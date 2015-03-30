package com.j3l11234.onetopic.entity;

import java.util.Date;

import android.widget.TextView;

public class MessageItem {
	private String name;
	private String content;
	private Date time;
	
	public MessageItem(String name, String content, Date time) {
		this.name = name;
		this.content = content;
		this.time = time;
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	public static class MessageItemTag{
		public TextView name;
		public TextView content;
		public TextView time;
	}
}
