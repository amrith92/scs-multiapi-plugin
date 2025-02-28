package com.sngular.scsplugin.filegeneration.model.event.producer;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sngular.scsplugin.filegeneration.model.event.schemas.CreateOrderMapper;

@Configuration
public class Producer {

  private final ISubscribeOperationFileGeneration subscribeOperationFileGeneration;

  protected Producer(final ISubscribeOperationFileGeneration subscribeOperationFileGeneration) {
    this.subscribeOperationFileGeneration = subscribeOperationFileGeneration;
  }

  @Bean
  public Supplier<CreateOrderMapper> subscribeOperationFileGeneration() {
    return () -> subscribeOperationFileGeneration.subscribeOperationFileGeneration();
  }


}
