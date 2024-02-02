package com.metrics.cpuMetrics.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

@Configuration
public class AwsConfig {
	@Bean
	public CloudWatchClient cloudWatchClient() {
		AwsBasicCredentials awsCredentials = AwsBasicCredentials.create("AKIA4MTWISR4MOB6RWPF", "06OdDZhO/bHgs7YiBWPgKgfmKN2wO09IIo+roES5");

        return CloudWatchClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .build();
	}
}