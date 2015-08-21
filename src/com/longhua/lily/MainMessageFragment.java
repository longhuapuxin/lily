package com.longhua.lily;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainMessageFragment extends Fragment implements OnItemClickListener {
	
	ListView mMessageList = null;
	private static String[] mTestData = new String[] {
		"今日新闻",
		"昨日旧闻"
	};
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_message, null);
		
		mMessageList = (ListView)view.findViewById(R.id.messageList);
		
		mMessageList.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mTestData));
		
		mMessageList.setOnItemClickListener(this);
		
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Log.d("aaaaaaaa", "cccccccccccc");
		Intent intent = new Intent();
		intent.setClass(getActivity(), ChatActivity.class);
		getActivity().startActivity(intent);
		
	}

}
