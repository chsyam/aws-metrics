package com.metrics.cpuMetrics.model;

import java.util.ArrayList;
import java.util.List;


public class CustomMetricData {
	private String metricName;
	private List<String> timestamps;
	private List<Double> values;

	public CustomMetricData() {
	}

	public String getMetricName() {
		return metricName;
	}

	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	public List<String> getTimestamps() {
		return timestamps;
	}

	public void setTimestamps(ArrayList<String> timestamps) {
		this.timestamps = timestamps;
	}

	public List<Double> getValues() {
		return values;
	}

	public void setValues(List<Double> values) {
		this.values = values;
	}
	
}
