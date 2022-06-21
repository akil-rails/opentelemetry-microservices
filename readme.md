# Use OpenTelemetry with Quarkus to push distributed traces to AWS X-Ray

Example microservices to integrate OpenTelemetry into a Java Quarkus microservice to send distributed traces to AWS X-Ray.

See the blog post for details: https://thomas.preissler.me/blog/2022/06/22/quarkus-with-opentelemetry

Contains the artefacts:

  - docker-compsose: docker-compose.yml with configuration for the AWS OTEL Collector to test the setup locally
  - is-odd: microservice to determine if a given number is odd
  - is-even: microservice to determine if a given number is even, calls the is-odd microservice and negates it's result
