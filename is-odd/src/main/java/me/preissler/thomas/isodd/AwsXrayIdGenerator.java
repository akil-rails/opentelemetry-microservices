package me.preissler.thomas.isodd;

import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.sdk.trace.IdGenerator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public final class AwsXrayIdGenerator implements IdGenerator {
  private static final AwsXrayIdGenerator INSTANCE = new AwsXrayIdGenerator();
  private static final IdGenerator RANDOM_ID_GENERATOR = IdGenerator.random();

  public static AwsXrayIdGenerator getInstance() {
    return INSTANCE;
  }

  @Override
  public String generateSpanId() {
    return RANDOM_ID_GENERATOR.generateSpanId();
  }

  @Override
  public String generateTraceId() {
    // hi - 4 bytes timestamp, 4 bytes random
    // low - 8 bytes random.
    // Since we include timestamp, impossible to be invalid.

    Random random = ThreadLocalRandom.current();
    long timestampSecs = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    long hiRandom = random.nextInt() & 0xFFFFFFFFL;

    long lowRandom = random.nextLong();

    return TraceId.fromLongs(timestampSecs << 32 | hiRandom, lowRandom);
  }

  private AwsXrayIdGenerator() {}  
}
