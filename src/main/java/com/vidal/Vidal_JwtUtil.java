package com.vidal;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class Vidal_JwtUtil {

    public HttpHeaders getHeadersWithJwt(String jwtToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set("Authorization", jwtToken);

        return headers;
    }
}