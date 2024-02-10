package com.prospecta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.dto.APIresponse;
import com.prospecta.model.Entry;
import com.prospecta.repository.EntryRepository;

import lombok.Data;

@Service
@Data
public class EntryService {
	private final EntryRepository repository;

	private RestTemplate restTemplate;

	@Value("${base.url}")
	private String BaseUrl;

	@Autowired
	public EntryService(EntryRepository repository, RestTemplate restTemplate) {
		this.repository = repository;
		this.restTemplate = restTemplate;
	}

	
	public APIresponse fetchEntriesFromApI(String category) {
		APIresponse forObject = restTemplate.getForObject(BaseUrl + "/entries?category=" + category, APIresponse.class);
		return forObject;
	}


	public Entry saveEntry(Entry entry) {
		return repository.save(entry);
	}
}
