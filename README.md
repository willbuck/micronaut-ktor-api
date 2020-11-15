# KTOR-1307 Replication

This serves as an example project to reproduce the issue found by github user @atrianic and filed to youtrack [here](https://youtrack.jetbrains.com/issue/KTOR-1307)

There are micronaut dependencies in the project (since he found it as a result of working on a micronaut ktor project),
but I believe a similar result could be achieved without any micronaut pieces in the puzzle.

This issue was originally reported [to mirconaut-kotlin](https://github.com/micronaut-projects/micronaut-kotlin/issues/163)

## Instructions

To reproduce the issue:

1. run the `./docker-build-jvm.sh` script file, 
2. then run `docker run -p 8080:8080 micronaut-api-jvm`
3. in a separate shell, run `curl localhost:8080/` and receive a plaintext "Hello World" response (illustrating the hotspot JVM runs the ktor app successfully)
4. run the `./docker-build.sh` script file, 
NOTE: This may take a fair bit of system resources; I struggled to run it on my 16gb RAM 2015 Macbook Pro, the build kept failing with a 137 exit code
5. run `docker run -p 8080:8080 micronaut-api`
6. in a separate shell, run `curl localhost:8080/` and no response (illustrating the graal JVM is having some kind of issue registering routes)

