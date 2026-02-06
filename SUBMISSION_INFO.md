# Submission Information

## Challenge Details
- **Challenge**: Bajaj Finserv Health & Vidal Health | Qualifier 1 | JAVA
- **Duration**: 1 Hour
- **Registration Number**: REG12394 (Even - Question 2)

## Submission Checklist

### ✅ Code Repository
- All source code is in the `src/` directory
- Main application files:
  - `VidalHealthApplication.java` - Spring Boot main class
  - `Vidal_Runner.java` - CommandLineRunner for startup execution
  - `Api_Vidal_Health.java` - Core API logic and SQL query
  - `Vidal_JwtUtil.java` - JWT utility

### ✅ JAR File
- **Location**: `target/Vidal-Health-0.0.1-SNAPSHOT.jar`
- **Size**: ~19.7 MB
- **Build Command**: `.\mvnw.cmd clean package -DskipTests`
- **Run Command**: `java -jar target/Vidal-Health-0.0.1-SNAPSHOT.jar`

### ✅ Documentation
- `README.md` - Complete project documentation
- `SUBMISSION_INFO.md` - This file with submission details

## How to Submit

1. **Push to GitHub**:
   ```bash
   git init
   git add .
   git commit -m "Bajaj Finserv Health Challenge - REG12394"
   git branch -M main
   git remote add origin https://github.com/YOUR_USERNAME/vidal-health-challenge.git
   git push -u origin main
   ```

2. **GitHub Repository URL Format**:
   ```
   https://github.com/YOUR_USERNAME/vidal-health-challenge.git
   ```

3. **RAW JAR Download Link Format**:
   ```
   https://github.com/YOUR_USERNAME/vidal-health-challenge/raw/main/target/Vidal-Health-0.0.1-SNAPSHOT.jar
   ```

4. **Submit Form**:
   - Form URL: https://forms.office.com/r/bDts9GjetN
   - Include GitHub repository link
   - Include RAW downloadable JAR link

## Application Flow

1. **Startup**: Application starts via `VidalHealthApplication.main()`
2. **Runner Execution**: `Vidal_Runner` executes automatically (CommandLineRunner)
3. **Generate Webhook**: POST request to generate webhook endpoint
4. **Receive Response**: Gets webhook URL and JWT access token
5. **SQL Query**: Constructs SQL query for even registration number (Question 2)
6. **Submit Solution**: POST request to webhook URL with JWT authentication
7. **Success**: Application logs "Final SQL query submitted successfully"

## SQL Query (Question 2 - Even Registration)

```sql
SELECT d.DEPARTMENT_NAME, 
       AVG(YEAR(CURDATE()) - YEAR(e.DOB)) AS AVERAGE_AGE, 
       GROUP_CONCAT(CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) 
       ORDER BY e.EMP_ID SEPARATOR ', ') AS EMPLOYEE_LIST 
FROM DEPARTMENT d 
JOIN EMPLOYEE e ON e.DEPARTMENT = d.DEPARTMENT_ID 
JOIN (SELECT DISTINCT EMP_ID FROM PAYMENTS WHERE AMOUNT > 70000) p 
ON p.EMP_ID = e.EMP_ID 
GROUP BY d.DEPARTMENT_ID, d.DEPARTMENT_NAME 
ORDER BY d.DEPARTMENT_ID DESC
```

## Technical Stack
- **Framework**: Spring Boot 4.0.2
- **Java Version**: 21
- **Build Tool**: Maven
- **HTTP Client**: RestTemplate
- **Dependencies**: spring-boot-starter-web, spring-boot-starter-test

## Testing
The application has been tested and successfully:
- ✅ Starts up correctly
- ✅ Executes CommandLineRunner on startup
- ✅ Makes POST request to generate webhook
- ✅ Submits SQL query with JWT authentication
- ✅ Logs success message

## Contact Information
- **Name**: John Doe
- **Email**: john@example.com
- **Registration**: REG12394
