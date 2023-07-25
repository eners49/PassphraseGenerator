FROM openjdk:19
RUN mkdir passphrasegenerator
COPY ./app/build/libs/app.jar /passphrasegenerator
RUN chmod u+x /passphrasegenerator/app.jar
ENTRYPOINT ["java", "-jar", "/passphrasegenerator/app.jar"]