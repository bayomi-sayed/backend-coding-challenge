GitHub Search repositories "Microservice backend-coding-challenge" 

    This is a sample Java / Maven / Spring Boot  application that can be used as a REST microservice 
    that list the languages used by the 100 trending public repos on GitHub.
    For every language, we calculate the attributes below point_down:
            Number of repos using this language
            The list of repos using the language

How to Run
   
     This application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.
      Clone this repository
      Make sure you are using JDK 1.8+ and Maven 3.x
      cd into project folder
      You can build the project and run the tests by running mvn clean package
      Once successfully built, you can run the service by one of these two methods:
      If you use Maven, you can run the application by using ./mvnw spring-boot:run.
      Alternatively, you can build the JAR file with ./mvnw clean package and then run the JAR file, as follows:

       java -jar target/langList-0.0.1-SNAPSHOT.jar





 Test the Service
 
     Now that the service is up, visit http://localhost:8080/gitHubReposList
    
    
    you will see ouput like that

    C#	
    reposCount	5
    reposList	[…]
    PowerShell	
    reposCount	2
    reposList	[…]
    Java	
    reposCount	1
    reposList	[…]
    C++	{…}
    CSS	{…}
