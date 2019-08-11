package com.solr.model;

import java.util.ArrayList;

public class NCRSolrModel {
	private String id;
	private String title;
	private ArrayList<String> type;
	private String url;
	private String metaDescription;
	private String tstamp;
	private String lastModified;
	private String content;
	private String product;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<String> getType() {
		return type;
	}

	public void setType(ArrayList<String> type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getTstamp() {
		return tstamp;
	}

	public void setTstamp(String tstamp) {
		this.tstamp = tstamp;
	}

	public String getLastModified() {
		return lastModified;
	}

	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public NCRSolrModel(String id, String title, ArrayList<String> type, String url, String metaDescription,
			String tstamp, String lastModified, String content, String product) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.url = url;
		this.metaDescription = metaDescription;
		this.tstamp = tstamp;
		this.lastModified = lastModified;
		this.content = content;
		this.product = product;
	}

	@Override
	public String toString() {
		return "NCRSolrModel [id=" + id + ", title=" + title + ", type=" + type + ", url=" + url + ", metaDescription="
				+ metaDescription + ", tstamp=" + tstamp + ", lastModified=" + lastModified + ", content=" + content
				+ ", product=" + product + "]";
	}
}
