package com.j3l11234.onetopic;


import java.text.SimpleDateFormat;
import java.util.List;

import com.j3l11234.onetopic.data.TestData;
import com.j3l11234.onetopic.entity.TopicItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {
	private TextView textViewDate;
	private TextView textViewTopic;
	private TextView textViewSupportNum;
	private TextView textViewAgainstNum;
	private TextView textViewReplyNum;
	private TextView textViewFaveriteNum;
	private Button btnPrev;
	private Button btnNext;
	private TextView textViewSupportBtn;
	private TextView textViewAgainstBtn;
	private TextView textViewReplyBtn;
	private TextView textViewFaveriteBtn;

	private List<TopicItem> topicList;

	public TopicFragment() {
		topicList = TestData.topicList;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_topic,container,false);

		textViewDate = (TextView) view.findViewById(R.id.textView_date);
		textViewTopic = (TextView) view.findViewById(R.id.textView_topic);
		textViewSupportNum = (TextView) view.findViewById(R.id.textView_supportNum);
		textViewAgainstNum = (TextView) view.findViewById(R.id.textView_againstNum);
		textViewReplyNum = (TextView) view.findViewById(R.id.textView_replyNum);
		textViewFaveriteNum = (TextView) view.findViewById(R.id.textView_faveriteNum);

		btnPrev = (Button) view.findViewById(R.id.btn_prev);
		btnNext = (Button) view.findViewById(R.id.btn_next);
		textViewSupportBtn = (TextView) view.findViewById(R.id.textView_support_btn);
		textViewAgainstBtn = (TextView) view.findViewById(R.id.textView_against_btn);
		textViewReplyBtn = (TextView) view.findViewById(R.id.textView_reply_btn);
		textViewFaveriteBtn = (TextView) view.findViewById(R.id.textView_faverite_btn);

		NavOnClickListener navOnClickListener = new NavOnClickListener();
		btnPrev.setOnClickListener(navOnClickListener);
		btnNext.setOnClickListener(navOnClickListener);

		setDisplayTopic(topicList.get(0));
		return view;
	}

	private void setDisplayTopic(TopicItem topic){
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		textViewDate.setText(sdf.format(topic.getDate()));
		textViewTopic.setText(topic.getTopic());
		textViewSupportNum.setText(String.valueOf(topic.getSupportNum()));
		textViewAgainstNum.setText(String.valueOf(topic.getAgainstNum()));
		textViewReplyNum.setText(String.valueOf(topic.getReplyNum()));
		textViewFaveriteNum.setText(String.valueOf(topic.getFavoriteNum()));
	}

	class NavOnClickListener implements OnClickListener{
		private int postion = 0;

		public void onClick(View view) {
			if(view.equals(btnPrev)){
				if(postion > 0){
					postion--;
					setDisplayTopic(topicList.get(postion));
				}else if(postion < 0){
					postion = 0;
					setDisplayTopic(topicList.get(postion));
				}
			}else if(view.equals(btnNext)){
				if(postion < topicList.size()-1){
					postion++;
					setDisplayTopic(topicList.get(postion));
				}else if(postion > topicList.size()-1){
					postion = topicList.size()-1;
					setDisplayTopic(topicList.get(postion));
				}
			}
		}
	}
}
