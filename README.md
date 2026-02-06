# Bajaj Finserv Health - Vidal Health Challenge

## Project Overview
This Spring Boot application automatically:
1. Sends a POST request to generate a webhook on startup
2. Receives a webhook URL and JWT access token
3. Solves a SQL problem based on registration number
4. Submits the SQL solution to the webhook URL using JWT authentication

## Registration Details
- **Name**: John Doe
- **Registration Number**: REG12394 (Even - Question 2)
- **Email**: john@example.com

## SQL Solution
The application solves the following problem:
- Calculate average age by department
- List employees who received payments > 70,000
- Group by department and order by department ID descending

## How to Run

### Prerequisites
- Java 21 or higher
- Maven (or use included Maven wrapper)

### Running the Application

#### Option 1: Using Maven Wrapper (Recommended)
```bash
.\mvnw.cmd spring-boot:run
```

#### Option 2: Using JAR file
```bash
.\mvnw.cmd clean package -DskipTests
java -jar target/Vidal-Health-0.0.1-SNAPSHOT.jar
```

### Expected Output
```
Vidal Runner started
API task started
Final SQL query submitted successfully
```

## Project Structure
```
Vidal-Health/
├── src/
│   └── main/
│       └── java/
│           └── com/vidal/
│               ├── VidalHealthApplication.java    # Main Spring Boot application
│               ├── Vidal_Runner.java              # CommandLineRunner for startup execution
│               ├── Api_Vidal_Health.java          # API logic and SQL query
│               └── Vidal_JwtUtil.java             # JWT header utility
├── target/
│   └── Vidal-Health-0.0.1-SNAPSHOT.jar           # Executable JAR file
└── pom.xml                                        # Maven configuration
```

## Technical Implementation

### Technologies Used
- Spring Boot 4.0.2
- Java 21
- RestTemplate for HTTP requests
- Maven for build management

### Key Components

1. **VidalHealthApplication**: Main Spring Boot entry point
2. **Vidal_Runner**: Implements CommandLineRunner to execute on startup
3. **Api_Vidal_Health**: Contains the core logic:
   - Generates webhook via POST request
   - Constructs SQL query for even registration number
   - Submits solution with JWT authentication
4. **Vidal_JwtUtil**: Utility for adding JWT token to HTTP headers

### API Endpoints Used
- **Generate Webhook**: `POST https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
- **Submit Solution**: `POST https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`

## JAR File Location
The executable JAR file is located at:
```
target/Vidal-Health-0.0.1-SNAPSHOT.jar
```

## Build Information
- Build Tool: Maven
- Java Version: 21
- Spring Boot Version: 4.0.2
- Artifact: Vidal-Health-0.0.1-SNAPSHOT.jar
- Size: ~19.7 MB

## Notes
- No controller/endpoint triggers the flow - execution happens automatically on startup
- JWT token is used in Authorization header for webhook submission
- Application exits after successful submission
