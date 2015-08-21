package com.longhua.lily;

import java.util.ArrayList;
import java.util.List;





import com.longhua.chat.ChatMessage;
import com.longhua.chat.ChatMessageAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class ChatActivity extends Activity implements OnClickListener {
	
	ListView mChatMessageListView = null;
	ChatMessageAdapter mAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		findViewById(R.id.chatBackBtn).setOnClickListener(this);
		
		mChatMessageListView = (ListView)findViewById(R.id.chatMessagesListView);
		
		
		
		//*****************temp data*********************************
		List<ChatMessage> tempData = new ArrayList<ChatMessage>();
		tempData.add(new ChatMessage("222d", true, "1", 1, "xinxin", false, "2015-8-21"));
		tempData.add(new ChatMessage("message2message2message2message2message2message2message2message2message2", false, "1", 1, "hehe", false, "2015-8-21"));
		//***********************************************************
		mAdapter = new ChatMessageAdapter(this, tempData);
		
		
		mChatMessageListView.setAdapter(mAdapter);

	}

	@Override
	public void onClick(View v) {
		finish();
	}



}
