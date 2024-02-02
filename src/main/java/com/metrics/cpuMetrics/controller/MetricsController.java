package com.metrics.cpuMetrics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metrics.cpuMetrics.model.CustomMetricData;
import com.metrics.cpuMetrics.service.CloudWatchService;

import software.amazon.awssdk.services.cloudwatch.model.MetricDataResult;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

	@Autowired
	private CloudWatchService cloudWatchService;

	@GetMapping("/cpu/{instanceId}")
	public CustomMetricData getCPUMetrics(@PathVariable String instanceId) {
		CustomMetricData customMetricData = new CustomMetricData();
		List<MetricDataResult> metricDataResult = this.cloudWatchService.getCPUMetrics(instanceId);
		List<Instant> temp = metricDataResult.get(0).timestamps();
		ArrayList<String> timestamps = new ArrayList<>();
		for (Instant value : temp) {
			timestamps.add(value.toString());
		}
		List<Double> values = metricDataResult.get(0).values();
		customMetricData.setMetricName(metricDataResult.get(0).label());
		customMetricData.setTimestamps(timestamps);
		customMetricData.setValues(values);
		return customMetricData;
	}
}