FROM openjdk:19-jdk-slim

WORKDIR /src
COPY . /src

RUN apt-get update
RUN apt-get install -y dos2unix
RUN dos2unix gradlew

RUN bash gradlew runFatJar

WORKDIR /run
RUN sp /src/build/libs/*.jar /run/server.jar

EXPOSE 8080

CMD java -jar /run/server.jar