package com.j3l11234.onetopic.entity;

import java.util.Date;

public class ReplyItem {
	private int portrait;
	private String name;
	private String content;
	private Date date;
	private int topicIndex;


	public ReplyItem() {

	}
	
	public int getPortrait() {
		return portrait;
	}
	public void setPortrait(int portrait) {
		this.portrait = portrait;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTopicIndex() {
		return topicIndex;
	}

	public void setTopicIndex(int topicIndex) {
		this.topicIndex = topicIndex;
	}
}
