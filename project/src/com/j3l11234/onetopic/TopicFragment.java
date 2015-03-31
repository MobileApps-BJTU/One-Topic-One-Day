package com.j3l11234.onetopic;


import java.text.SimpleDateFormat;
import java.util.List;

import com.j3l11234.onetopic.data.TestData;
import com.j3l11234.onetopic.entity.TopicItem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {
	private RelativeLayout layoutContent;
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
	private int postion = 0;

	public TopicFragment() {
		topicList = TestData.topicList;
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_topic,container,false);

		layoutContent = (RelativeLayout) view.findViewById(R.id.layout_content);
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

		NavOnClickListener topicOnClickListener = new NavOnClickListener();
		btnPrev.setOnClickListener(topicOnClickListener);
		btnNext.setOnClickListener(topicOnClickListener);
		textViewSupportBtn.setOnClickListener(topicOnClickListener);
		textViewAgainstBtn.setOnClickListener(topicOnClickListener);
		textViewReplyBtn.setOnClickListener(topicOnClickListener);
		textViewFaveriteBtn.setOnClickListener(topicOnClickListener);


		setDisplayTopic(topicList.get(postion));
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

		textViewSupportBtn.setCompoundDrawablesWithIntrinsicBounds(
				0, topic.isSupport() ? R.drawable.icon_support_red : R.drawable.icon_support, 0, 0);
		textViewAgainstBtn.setCompoundDrawablesWithIntrinsicBounds(
				0, topic.isAgainst() ? R.drawable.icon_against_red : R.drawable.icon_against, 0, 0);
		textViewFaveriteBtn.setCompoundDrawablesWithIntrinsicBounds(
				0, topic.isFavorite() ? R.drawable.icon_favorite_red : R.drawable.icon_favorite, 0, 0);
	}

	class NavOnClickListener implements OnClickListener{
		public void onClick(View view) {
			if(view.equals(btnPrev)){
				if(postion > 0){
					postion--;
					AnimationSet animationSet = new AnimationSet(true);
					AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1);
					alphaAnimation.setDuration(200);
					animationSet.addAnimation(alphaAnimation);
					layoutContent.startAnimation(animationSet);
					setDisplayTopic(topicList.get(postion));
				}else if(postion < 0){
					postion = 0;
					setDisplayTopic(topicList.get(postion));
				}
			}else if(view.equals(btnNext)){
				if(postion < topicList.size()-1){
					postion++;
					AnimationSet animationSet = new AnimationSet(true);
					AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1);
					alphaAnimation.setDuration(200);
					animationSet.addAnimation(alphaAnimation);
					layoutContent.startAnimation(animationSet);
					setDisplayTopic(topicList.get(postion));
				}else if(postion > topicList.size()-1){
					postion = topicList.size()-1;
					setDisplayTopic(topicList.get(postion));
				}
			}else if(view.equals(textViewSupportBtn)){
				TopicItem topic = topicList.get(postion);
				topic.addSupport();
				setDisplayTopic(topicList.get(postion));
			}else if(view.equals(textViewAgainstBtn)){
				TopicItem topic = topicList.get(postion);
				topic.addAgainst();
				setDisplayTopic(topicList.get(postion));
			}else if(view.equals(textViewFaveriteBtn)){
				TopicItem topic = topicList.get(postion);
				topic.addFavorite();
				setDisplayTopic(topicList.get(postion));
			}else if(view.equals(textViewReplyBtn)){
				getActivity().getSupportFragmentManager().beginTransaction()
				.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
				.replace(R.id.container, new ReplyFragment(topicList.get(postion)))
				.addToBackStack(null).commit();
			}
		}
	}
}
