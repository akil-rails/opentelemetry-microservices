package me.preissler.thomas.iseven;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

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
