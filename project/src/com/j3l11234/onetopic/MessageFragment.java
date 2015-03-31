package com.j3l11234.onetopic;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.j3l11234.onetopic.data.TestData;
import com.j3l11234.onetopic.entity.MessageItem;
import com.j3l11234.onetopic.entity.ReplyItem;
import com.j3l11234.onetopic.entity.MessageItem.MessageItemTag;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends ListFragment {
	private List<ReplyItem> messageList;
	private MessageAdapter messageAdapter;
	
    public MessageFragment() {
    	messageList = TestData.messageList;
    	
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    	
    	messageAdapter = new MessageAdapter(getActivity());
    	setListAdapter(messageAdapter);
    	
        return inflater.inflate(R.layout.fragment_message,container,false);
    }

    class MessageAdapter extends BaseAdapter{
    	private LayoutInflater mInflater;
    	
    	public MessageAdapter(Context context) {
    		this.mInflater = LayoutInflater.from(context);
		}
    	
		@Override
		public int getCount() {
			return 20;
			//return messageList.size();
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
            ReplyItem reply =  messageList.get(position);
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
