package com.fee.hivemq.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hivemq.embedded.EmbeddedHiveMQ;

@Component
public class HifemqLlifecycleBean {

  @Autowired
  private EmbeddedHiveMQ hiveMQ;

  @PostConstruct
  public void init() {
    hiveMQ.start().join();
  }

  @PreDestroy
  public void destroy() {
    hiveMQ.stop().join();
  }
}
