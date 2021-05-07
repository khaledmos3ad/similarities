# What is implemented.
* Task Implemented using Java 11 and Spring Boot. 
* Maven build.
* Exception Handling 
* Input validation.
* API Documentation with Swagger, will provide a swagger UI to test service through browser.
* Configurable interactive chart with dynamic substituation.
* Docker File and Docker Compose to run the service.

# How much time dedicated for the solution and How I went through the implementation?
* Almost 3 hours.
* Created the Spring framework through https://start.spring.io/ close spring, Lombok and spring web for having the core 
* Created the Controller with the endpoint with request and response and returned a dummy data.
* Swagger added to test the service in browser and can see endpoints with result. 
* Thought about validating the input and just created the dummy service (SimilartiesService)
* Started to write the docker file and docker compose.
* finally focused on the service layer logic and implemented it with the algorithm of measuring distance.

# Deliverable 
* Build the service using Maven : 
   mvn install.
* Run the service in docker using : 
   docker-compose up --build -d labforward-similarities
* Open Browser and test service through swagger: 
    http://localhost:8080/swagger-ui.html 

# What have to be done next. 
* Implement Testing cases with different senarios, not have too much time for covering all classes and think about dynamic cases.

Thanks