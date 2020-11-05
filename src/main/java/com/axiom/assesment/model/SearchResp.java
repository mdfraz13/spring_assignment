package com.axiom.assesment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResp {

	private int totalHandsetsFound;
	private List<MobileHandset> data;
	private ErrResp error;

	public SearchResp() {}

	public SearchResp(List<MobileHandset> data) {
		this.data = data;
		if (data != null) {
			this.totalHandsetsFound = data.size();
		}
	}

	public SearchResp(ErrResp error) {
		this.error = error;
	}

	public List<MobileHandset> getData() {
		return data;
	}

	public void setData(List<MobileHandset> data) {
		this.data = data;
	}

	public ErrResp getError() {
		return error;
	}

	public void setError(ErrResp error) {
		this.error = error;
	}

	public int getTotalHandsetsFound() {
		return totalHandsetsFound;
	}

	public void setTotalHandsetsFound(int totalHandsetsFound) {
		this.totalHandsetsFound = totalHandsetsFound;
	}
}
