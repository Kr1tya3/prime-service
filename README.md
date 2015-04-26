# prime-service
‌
To run all tests, including unit and integration tests, use:

```
mvn clean verify
```

To run the service, first build the package:

```
mvn clean package
```

Then run:
```
java -jar <path-to-jar> server
```

Service is then available on port 8080.

Example request: http://localhost:8080/primes/100