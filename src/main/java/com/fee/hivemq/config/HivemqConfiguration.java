package com.fee.hivemq.config;

import java.nio.file.Path;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hivemq.configuration.service.InternalConfigurations;
import com.hivemq.embedded.EmbeddedHiveMQ;
import com.hivemq.embedded.EmbeddedHiveMQBuilder;
import com.hivemq.migration.meta.PersistenceType;

@Configuration
public class HivemqConfiguration {

  @Bean
  public EmbeddedHiveMQ himeMQ(final HivemqConfigurationProperties props) {
    InternalConfigurations.PAYLOAD_PERSISTENCE_TYPE.set(PersistenceType.FILE);
    InternalConfigurations.RETAINED_MESSAGE_PERSISTENCE_TYPE.set(PersistenceType.FILE);

    final EmbeddedHiveMQBuilder embeddedHiveMQBuilder = EmbeddedHiveMQBuilder.builder()
        .withConfigurationFolder(Path.of(props.getConfiguration()))
        .withDataFolder(Path.of(props.getData()))
        .withExtensionsFolder(Path.of(props.getExtensions()));
    return embeddedHiveMQBuilder.build();
  }

}
