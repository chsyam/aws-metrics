package com.metrics.cpuMetrics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.cloudwatch.CloudWatchClient;
import software.amazon.awssdk.services.cloudwatch.model.*;

import java.time.Instant;
import java.util.List;

@Service
public class CloudWatchService {

	@Autowired
	private CloudWatchClient cloudWatchClient;

	public List<MetricDataResult> getCPUMetrics(String instanceId) {
		GetMetricDataResponse response = cloudWatchClient.getMetricData(GetMetricDataRequest.builder()
				.metricDataQueries(MetricDataQuery.builder().id("m1").metricStat(MetricStat.builder()
						.metric(Metric.builder().namespace("AWS/EC2").metricName("CPUUtilization")
								.dimensions(Dimension.builder().name("InstanceId").value(instanceId).build()).build())
						.period(300) // Set the desired period in seconds
						.stat("Average").build()).returnData(true).build())
				.startTime(Instant.now().minusSeconds(3600)) // Set the start time accordingly
				.endTime(Instant.now()).build());

		return response.metricDataResults();
	}
}