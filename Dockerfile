FROM openjdk:17.0.1-jdk-oracle AS build

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

WORKDIR /workspace/app

RUN chmod -R 777 ./mvnw

COPY src src

RUN ./mvnw install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM openjdk:17.0.1-jdk-oracle

VOLUME /tmp

ARG DEPENDENCY=/workspace/app/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","com.generation.blogpessoal.BlogpessoalApplication"]