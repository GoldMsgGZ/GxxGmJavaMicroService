package com.baggio.logstashservice.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import net.logstash.logback.appender.LogstashTcpSocketAppender;
import net.logstash.logback.encoder.LogstashEncoder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

@Component
public class LogstashConfig {
    @Value("${logstash.shipper.host}")
    private String shipperHost;

    @Value("${logstash.shipper.port}")
    private int    shipperPort;

    @Value("${logstash.level}")
    private String logLevel;

    @PostConstruct
    public void startLogbackAppender() {
        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

        // TCP appender
        LogstashTcpSocketAppender appender = new LogstashTcpSocketAppender();
        appender.setName("stash");
        appender.addDestinations(new InetSocketAddress(shipperHost, shipperPort));

        // 服务名称会在日志中显示
        String servicename = "logstashservice";
        LogstashEncoder encoder = new LogstashEncoder();
        encoder.setCustomFields("{\"service\":\"" + servicename + "\"}");
        encoder.start();

        appender.setEncoder(encoder);
        appender.setContext(rootLogger.getLoggerContext());
        appender.start();

        rootLogger.addAppender(appender);
        rootLogger.setLevel(Level.toLevel(logLevel));
    }
}
