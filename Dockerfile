FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut-api
WORKDIR /home/app/micronaut-api

RUN native-image --verbose --no-server --no-fallback --install-exit-handlers --verbose -J-Xmx8G -J-Xms1G -H:+ReportUnsupportedElementsAtRuntime -H:+ReportExceptionStackTraces -H:+TraceClassInitialization -H:+PrintClassInitialization -H:+RemoveSaturatedTypeFlows -cp build/libs/micronaut-api-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut-api/micronaut-api /app/micronaut-api
ENTRYPOINT ["/app/micronaut-api"]
