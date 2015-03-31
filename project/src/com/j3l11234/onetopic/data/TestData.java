package com.j3l11234.onetopic.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.j3l11234.onetopic.R;
import com.j3l11234.onetopic.entity.ReplyItem;
import com.j3l11234.onetopic.entity.TopicItem;

public class TestData {
	public final static List<TopicItem> topicList; 
	public final static List<ReplyItem> messageList;
	static{
		String[] tpoicText = {
				"    Is it good or not to observe the experience?",
				"    City or village, which one is the best place to live in ",
				"    Can money buy happiness? ",
				"    Should we diet in order to keep fit? ",
				"    Is puppy love good or bad for studying?",
		};
		String[] nameList = {
				"j3l11234",
				"Sandy Thornton",
				"Darrin Melton",
				"Monroe Gillespie",
				"Ward Ball",
				"Myra Carlson",
				"Max Kirkland",
		};
		int[] portraitList = {
				R.drawable.portrait_sample,
				R.drawable.portrait_sample2,
				R.drawable.portrait_sample3,
				R.drawable.portrait_sample4,
				R.drawable.portrait_sample5,
				R.drawable.portrait_sample6,
				R.drawable.portrait_sample7,
		};
		
		messageList = new ArrayList<ReplyItem>();
		topicList = new ArrayList<TopicItem>();
		Date today = new Date();
		Calendar calendar = new GregorianCalendar();
        calendar.setTime(today);
		for (int i = 0; i < tpoicText.length; i++) {
			int replyNum = (int) (Math.random()*6)+5;
			Date time = calendar.getTime();
			TopicItem topic = new TopicItem();
			topic.setTopic(tpoicText[i]);
			topic.setDate(time);
			
			topic.setSupportNum((int) (Math.random()*30));
			topic.setAgainstNum((int) (Math.random()*30));
			topic.setFavoriteNum((int) (Math.random()*20));
			topic.setReplyNum((int)replyNum);
			topicList.add(topic);
			calendar.add(Calendar.DATE,-1);
			
			List<ReplyItem> replyList = new ArrayList<ReplyItem>(replyNum);
			for (int j = 0; j < replyNum; j++) {
				time = new Date((long) (time.getTime() + (Math.random()*2*3600000)));
				ReplyItem reply = new ReplyItem();
				int readom = (int) (Math.random()*nameList.length);
				reply.setName(nameList[readom]);
				reply.setPortrait(portraitList[readom]);
				reply.setDate(time);
				reply.setContent("sample reply text,"+i+","+j);
				messageList.add(reply);
				replyList.add(reply);
			}
			topic.setReplyList(replyList);
		}
		Collections.sort(messageList,new Comparator<ReplyItem>() {
			public int compare(ReplyItem lhs, ReplyItem rhs) {
				return lhs.getDate().compareTo(rhs.getDate());
			}
		});
	}
	
}
