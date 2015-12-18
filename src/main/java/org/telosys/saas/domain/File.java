package org.telosys.saas.domain;

import java.io.Serializable;

public class File implements Serializable {

	private static final long serialVersionUID = 1717762719485741897L;

	private String id;
	
	private String folderParentId;
	
	private String name;
	
	private String content = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFolderParentId() {
		return folderParentId;
	}

	public void setFolderParentId(String folderParentId) {
		this.folderParentId = folderParentId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
