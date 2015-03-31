package com.j3l11234.onetopic;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.j3l11234.onetopic.entity.MessageItem;
import com.j3l11234.onetopic.entity.MessageItem.MessageItemTag;
import com.j3l11234.onetopic.entity.ReplyItem;
import com.j3l11234.onetopic.entity.TopicItem;
import com.j3l11234.onetopic.widget.ListViewForScrollView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReplyFragment extends Fragment {
	private ListViewForScrollView listviewReplyList;
	private TopicItem topic;
	private List<ReplyItem> replyList;
	private MessageAdapter messageAdapter;
	
	private TextView textViewDate;
	private TextView textViewTopic;
	private TextView textViewSupportNum;
	private TextView textViewAgainstNum;
	private TextView textViewReplyNum;
	private TextView textViewFaveriteNum;
	
	private EditText editTextReply;
	private Button btnSubmit;
	
    public ReplyFragment(TopicItem topic) {
    	this.topic = topic;
    	this.replyList = topic.getReplyList();
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.fragment_reply,container,false);
    	
    	textViewDate = (TextView) view.findViewById(R.id.textView_date);
		textViewTopic = (TextView) view.findViewById(R.id.textView_topic);
		textViewSupportNum = (TextView) view.findViewById(R.id.textView_supportNum);
		textViewAgainstNum = (TextView) view.findViewById(R.id.textView_againstNum);
		textViewReplyNum = (TextView) view.findViewById(R.id.textView_replyNum);
		textViewFaveriteNum = (TextView) view.findViewById(R.id.textView_faveriteNum);
		
		editTextReply = (EditText) view.findViewById(R.id.editText_reply);
		btnSubmit = (Button) view.findViewById(R.id.button_submit);
		btnSubmit.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String text = editTextReply.getText().toString();
				editTextReply.setText("");
				if(text.length() > 0){
					ReplyItem reply = new ReplyItem();
					reply.setPortrait(R.drawable.portrait_sample);
					reply.setContent(text);
					reply.setDate(new Date());
					reply.setName("j3l11234");
					replyList.add(reply);
					topic.addReply();
					messageAdapter.notifyDataSetChanged();  
				}
			}
		});
		
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		textViewDate.setText(sdf.format(topic.getDate()));
		textViewTopic.setText(topic.getTopic());
		textViewSupportNum.setText(String.valueOf(topic.getSupportNum()));
		textViewAgainstNum.setText(String.valueOf(topic.getAgainstNum()));
		textViewReplyNum.setText(String.valueOf(topic.getReplyNum()));
		textViewFaveriteNum.setText(String.valueOf(topic.getFavoriteNum()));
		
    	listviewReplyList = (ListViewForScrollView) view.findViewById(R.id.listview_replyList);
    	messageAdapter = new MessageAdapter(getActivity());
    	listviewReplyList.setAdapter(messageAdapter);

        return view;
    }

    class MessageAdapter extends BaseAdapter{
    	private LayoutInflater mInflater;
    	
    	public MessageAdapter(Context context) {
    		this.mInflater = LayoutInflater.from(context);
		}
    	
		@Override
		public int getCount() {
			return replyList.size();
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			SimpleDateFormat sdf= new SimpleDateFormat("MM-dd HH:mm:ss");
            if (convertView == null){
            	convertView = mInflater.inflate(R.layout.reply_item, null); 
            }
            ReplyItem reply =  replyList.get(position);
            ImageView portrait = (ImageView) convertView.findViewById(R.id.reply_portrait);
            TextView name = (TextView) convertView.findViewById(R.id.reply_name);
    		TextView content = (TextView) convertView.findViewById(R.id.reply_content);
    		TextView time = (TextView) convertView.findViewById(R.id.reply_time);
    		
    		portrait.setImageResource(reply.getPortrait());
    		name.setText(reply.getName());
            content.setText(reply.getContent());
            time.setText(sdf.format(reply.getDate()));
             
			return convertView;
		}
    }

}
