PreRequisite: Java 1.7 or above, Maven

Steps to run the application:-
-------------------------------------------
1. Download project from git:
   git clone https://github.com/prasenjit-karmakar/gordon-ramsey-prob.git

2. Go to the base directory where project is checked out and run:-
   mvn clean package spring-boot:repackage -DskipTests=true

3. Then run the below command from the same directory:
   java -jar target/problem-1.0-SNAPSHOT.jar

4. Hit the api and you will get maximum achievable satisfaction value.
    curl http://localhost/value/api/v0/person/satisfaction

