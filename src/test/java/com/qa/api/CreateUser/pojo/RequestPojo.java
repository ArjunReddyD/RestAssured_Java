package com.qa.api.CreateUser.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "job" })
@javax.annotation.processing.Generated("jsonschema2pojo")

public class RequestPojo {
	@JsonProperty("name")
	private String name;
	@JsonProperty("job")
	private String job;

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("job")
	public String getJob() {
		return job;
	}

	@JsonProperty("job")
	public void setJob(String job) {
		this.job = job;
	}

}
