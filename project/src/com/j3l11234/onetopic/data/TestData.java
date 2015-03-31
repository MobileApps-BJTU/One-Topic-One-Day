package com.j3l11234.onetopic.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.j3l11234.onetopic.entity.TopicItem;

public class TestData {
	public final static List<TopicItem> topicList; 
	
	static{
		String[] tpoicText = {
				"Is it good or not to observe the experience?",
				"City or village, which one is the best place to live in ",
				"Can money buy happiness? ",
				"Should we diet in order to keep fit? ",
				"Is puppy love good or bad for studying?",
		};
		
		topicList = new ArrayList<TopicItem>();
		Date today = new Date();
		Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
		for (int i = 0; i < tpoicText.length; i++) {
			TopicItem topic = new TopicItem();
			topic.setTopic(tpoicText[i]);
			topic.setDate(calendar.getTime());
			
			topic.setSupportNum((int) Math.floor(Math.random()*30));
			topic.setAgainstNum((int) Math.floor(Math.random()*30));
			topic.setFavoriteNum((int) Math.floor(Math.random()*20));
			topic.setReplyNum((int) Math.floor(Math.random()*10));
			topicList.add(topic);
			calendar.add(Calendar.DATE,-1);
		}
	}
}
