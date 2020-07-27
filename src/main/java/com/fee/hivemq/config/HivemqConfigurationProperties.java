package com.fee.hivemq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "hivemq")
public class HivemqConfigurationProperties {
  private String configuration = "./hivemq/conf";
  private String data = "./hivemq/data";
  private String extensions = "./hivemq/extensions";
}
