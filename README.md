## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `crud-quarkus-panache-1.0.0-runner.jar` file in the `/target` directory.

The application is now runnable using `java -jar target/crud-quarkus-panache-1.0.0-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/crud-quarkus-panache-1.0.0-runner`
