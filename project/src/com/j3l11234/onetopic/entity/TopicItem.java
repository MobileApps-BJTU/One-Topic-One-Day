package com.j3l11234.onetopic.entity;

import java.util.Date;

public class TopicItem {
	private Date date;
	private String topic;
	
	private int supportNum;
	private int againstNum;
	private int favoriteNum;
	
	public TopicItem(){
		
	}
	
	public TopicItem(Date date, String topic, int supportNum, int againstNum,
			int favoriteNum, int replyNum) {
		this.date = date;
		this.topic = topic;
		this.supportNum = supportNum;
		this.againstNum = againstNum;
		this.favoriteNum = favoriteNum;
		this.replyNum = replyNum;
	}

	private int replyNum;
	
	private boolean isSupport;
	private boolean isAgainst;
	private boolean isFavorite;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public int getSupportNum() {
		return supportNum;
	}
	public void setSupportNum(int supportNum) {
		this.supportNum = supportNum;
	}
	public int getAgainstNum() {
		return againstNum;
	}
	public void setAgainstNum(int againstNum) {
		this.againstNum = againstNum;
	}
	public int getFavoriteNum() {
		return favoriteNum;
	}
	public void setFavoriteNum(int favoriteNum) {
		this.favoriteNum = favoriteNum;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public boolean isSupport() {
		return isSupport;
	}
	public void setSupport(boolean isSupport) {
		this.isSupport = isSupport;
	}

	public void reset(){
		isSupport = false;
		isAgainst = false;
		isFavorite = false;
	}
	
	public boolean addSupport(){
		if(isSupport){
			supportNum--;
			isSupport = false;
		}else{
			supportNum++;
			isSupport = true;
		}
		return isSupport;
	}
	
	public boolean addAgainst(){
		if(isAgainst){
			againstNum--;
			isAgainst = false;
		}else{
			againstNum++;
			isAgainst = true;
		}
		return isAgainst;
	}
	
	public boolean addFavorite(){
		if(isFavorite){
			favoriteNum--;
			isFavorite = false;
		}else{
			favoriteNum++;
			isFavorite = true;
		}
		return isFavorite;
	}
	
	public boolean addReply(){
		replyNum++;
		return true;
	}
}
