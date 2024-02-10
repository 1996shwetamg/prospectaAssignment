package com.prospecta.dto;

import java.util.List;

import lombok.Data;

@Data
public class APIresponse {
private int count;
private List<EntryResponse> entries;
}
