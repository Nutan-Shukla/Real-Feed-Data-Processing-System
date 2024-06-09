package com.example.Spring.configuration;

import com.example.Spring.protos.MetalPrice;
import com.example.Spring.utility.ProtoMessageConvertor;
import com.google.protobuf.util.JsonFormat;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource mysqlDataSource() {

        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    ProtoMessageConvertor getMessageConverter() {
        JsonFormat.TypeRegistry typeRegistry = JsonFormat.TypeRegistry.newBuilder()
                .add(MetalPrice.getDescriptor())
                .build();

        return new ProtoMessageConvertor(typeRegistry);
    }

    @Bean
    ProtobufHttpMessageConverter getProtobufHttpMessageConverter(ProtoMessageConvertor messageConverter) {
        return messageConverter.getHttpMessageConverter();
    }

    @Bean
    RestTemplate getRestTemplate(ProtobufHttpMessageConverter protobufHttpMessageConverter) {
        return new RestTemplate(Arrays.asList(protobufHttpMessageConverter));
    }
}
