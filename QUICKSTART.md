# Quick Start Guide

## Run the Application in 3 Steps

### Step 1: Navigate to Project Directory
```bash
cd Vidal-Health
```

### Step 2: Run the JAR File
```bash
java -jar target/Vidal-Health-0.0.1-SNAPSHOT.jar
```

### Step 3: Verify Success
You should see:
```
Vidal Runner started
API task started
Final SQL query submitted successfully
```

## Alternative: Build from Source

If you want to rebuild the JAR:

```bash
# Windows
.\mvnw.cmd clean package -DskipTests

# Linux/Mac
./mvnw clean package -DskipTests
```

Then run:
```bash
java -jar target/Vidal-Health-0.0.1-SNAPSHOT.jar
```

## Requirements
- Java 21 or higher installed
- Internet connection (for API calls)

## Troubleshooting

### Java not found
Make sure Java 21+ is installed:
```bash
java -version
```

### Port 8080 already in use
The application uses port 8080. If it's in use, stop the other application or change the port in `application.properties`.

### API connection issues
Ensure you have internet connectivity to reach:
- `https://bfhldevapigw.healthrx.co.in`

## What Happens When You Run?

1. Spring Boot application starts
2. CommandLineRunner executes automatically
3. POST request sent to generate webhook
4. Webhook URL and JWT token received
5. SQL query submitted with JWT authentication
6. Success message logged
7. Application continues running (press Ctrl+C to stop)

## Registration Details Used
- Name: John Doe
- RegNo: REG12394 (Even - Question 2)
- Email: john@example.com
