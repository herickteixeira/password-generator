# Password generator
This project is an application developed in Java with Spring Boot that generates secure passwords according to user-specified criteria (length, use of special characters, etc.). Additionally, the application includes a feature to evaluate the strength of the generated password.

# Prerequisites
Before getting started, make sure you have the following installed in your development environment:

* Java JDK 17
* Maven
  
# Installation and Execution
1. Clone the repository:
```bash
git clone https://github.com/your-username/password-generator.git
```
Or download and extract the project manually.

2. Navigate to the project directory:
```bash
cd password-generator
```
3. Run the project using Maven:
```bash
mvn spring-boot:run
```
The application will start and be accessible at http://localhost:8080.

# API Endpoints
The application exposes the following endpoints:

* POST /api/password/generate
    * Request body:
      ```json
        {
          "length": 12,
          "useUpperCase": true,
          "useLowerCase": true,
          "useNumbers": true,
          "useSpecialChars": true
        }
      ```
    * Request example:
      ```bash
        curl --location 'http://localhost:8080/api/password/generate' \
        --header 'Content-Type: application/json' \
        --data '{
            "length": 12,
            "useUpperCase": true,
            "useLowerCase": true,
            "useNumbers": true,
            "useSpecialChars": true
        }'
      ```
      * Response:
        ```json
          "aB3$dE5!fG7@"
        ```  
* GET /api/password/strength
    * Request example:
      ```bash
        curl --location 'http://localhost:8080/api/password/strength?password=y6UzPRe3r%3Fxn'
       ```
      * Response:
        ```json
          {
              "password": "aB3$dE5!fG7@",
              "strength": "Very Strong"
          }
        ```

# Contributing
If you wish to contribute to this project, follow these steps:

1. Fork the project.
2. Create a branch for your feature:
```bash
git checkout -b feature-new-feature
```
3. Make your changes and commit them:
```bash
git commit -m 'Add a new feature
```
4. Push to the branch:
```bash
git push origin feature-new-feature
```
5. Submit a pull request.
