package com.vidal;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class Api_Vidal_Health {

    private final Vidal_JwtUtil jwtUtil;

    public Api_Vidal_Health(Vidal_JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public void runTask() {

        System.out.println("API Is started");

        RestTemplate restTemplate = new RestTemplate();


        String generateUrl =
                "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "John Doe");
        requestBody.put("regNo", "REG12394");
        requestBody.put("email", "john@example.com");

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> requestEntity =
                new HttpEntity<>(requestBody, requestHeaders);

        ResponseEntity<Map<String, Object>> responseEntity =
                restTemplate.exchange(
                        generateUrl,
                        HttpMethod.POST,
                        requestEntity,
                        new ParameterizedTypeReference<Map<String, Object>>() {}
                );

        Map<String, Object> response = responseEntity.getBody();

        if (response == null) {
            System.out.println("Failed to generate webhook");
            return;
        }

        String webhookUrl = response.get("webhook").toString();
        String jwtToken = response.get("accessToken").toString();


        String finalSqlQuery =
                "SELECT d.DEPARTMENT_NAME, " +
                        "AVG(YEAR(CURDATE()) - YEAR(e.DOB)) AS AVERAGE_AGE, " +
                        "GROUP_CONCAT(CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) " +
                        "ORDER BY e.EMP_ID SEPARATOR ', ') AS EMPLOYEE_LIST " +
                        "FROM DEPARTMENT d " +
                        "JOIN EMPLOYEE e ON e.DEPARTMENT = d.DEPARTMENT_ID " +
                        "JOIN (SELECT DISTINCT EMP_ID FROM PAYMENTS WHERE AMOUNT > 70000) p " +
                        "ON p.EMP_ID = e.EMP_ID " +
                        "GROUP BY d.DEPARTMENT_ID, d.DEPARTMENT_NAME " +
                        "ORDER BY d.DEPARTMENT_ID DESC";


        HttpHeaders headers = jwtUtil.getHeadersWithJwt(jwtToken);

        Map<String, String> submitBody = new HashMap<>();
        submitBody.put("finalQuery", finalSqlQuery);

        HttpEntity<Map<String, String>> entity =
                new HttpEntity<>(submitBody, headers);

        restTemplate.postForEntity(webhookUrl, entity, String.class);

        System.out.println(" Sql is Running , ");
    }
}