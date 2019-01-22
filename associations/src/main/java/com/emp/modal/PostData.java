package com.emp.modal;

import java.util.Set;

public class PostData {

	private String description;
	private Set<TagData> tags;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<TagData> getTags() {
		return tags;
	}

	public void setTags(Set<TagData> tags) {
		this.tags = tags;
	}

}
