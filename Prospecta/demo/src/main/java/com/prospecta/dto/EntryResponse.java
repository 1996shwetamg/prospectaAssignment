package com.prospecta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class EntryResponse {
		@JsonProperty("API")
		private String title;
		@JsonProperty("Description")
		private String Description;
		@JsonProperty("Category")
		private String Category;
	
}
