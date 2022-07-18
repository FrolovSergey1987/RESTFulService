FROM openjdk:16.0.1
WORKDIR /code
COPY . /code
EXPOSE 8080
ARG  JAR_FILE=target/*.jar
COPY ${JAR_FILE} /code/question.jar
ENTRYPOINT ["java","-jar","question.jar"]