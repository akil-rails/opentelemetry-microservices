package me.preissler.thomas.isodd;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Singleton;

import io.opentelemetry.contrib.awsxray.AwsXrayIdGenerator;
import io.opentelemetry.sdk.trace.IdGenerator;

@Singleton
public class AwsOpenTelemetryIdGeneratorProducer {

  @Produces
  @Singleton
  public IdGenerator idGenerator() {
    return AwsXrayIdGenerator.getInstance();
  }
}
