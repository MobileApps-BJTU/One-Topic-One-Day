package com.j3l11234.onetopic;


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
import android.widget.TextView;

import com.j3l11234.onetopic.entity.MessageItem;
import com.j3l11234.onetopic.entity.MessageItem.MessageItemTag;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends ListFragment {
	private List<MessageItem> messageList;
	private MessageAdapter messageAdapter;
	
    public MessageFragment() {
    	messageList = new ArrayList<MessageItem>();
    	
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
			MessageItemTag holder;
            if (convertView == null){
            	convertView = mInflater.inflate(R.layout.message_listview_item, null);
            	holder = new MessageItemTag();
            	holder.name = (TextView) convertView.findViewById(R.id.message_name);
            	holder.content = (TextView) convertView.findViewById(R.id.message_content);
            	holder.time = (TextView) convertView.findViewById(R.id.message_time);
            	convertView.setTag(holder);//绑定ViewHolder对象                   
            }
            else{
            	holder = (MessageItemTag)convertView.getTag();            
            }
            
            holder.name.setText("Name - "+position);
            holder.content.setText("Content - "+position);
            holder.time.setText("Time - "+position);
             
//            /**为Button添加点击事件*/             
//            holder.bt.setOnClickListener(new OnClickListener() {
//                @Override
//                publicvoid onClick(View v) {
//                    Log.v("MyListViewBase", "你点击了按钮" + position);//打印Button的点击信息                    
//                }
//            });
            
			return convertView;
		}
    }

}
