package com.ming.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ming.model.User;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WLDBaseActivity extends BaseAdapter {
	private List<User> list = null;
	private Map<Integer, View> myView = new HashMap<Integer, View>();
	private Context context;

	public WLDBaseActivity(List<User> list, Context context) {
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View showview = myView.get(position);
		if (showview == null) {
			LayoutInflater inflater = LayoutInflater.from(context);
			showview = inflater.inflate(R.layout.activity_listview, null);
			RelativeLayout relativeLayout = (RelativeLayout) showview.findViewById(R.id.relatlayout);
			TextView name = (TextView) showview.findViewById(R.id.name);
			TextView mobile = (TextView) showview.findViewById(R.id.mobile);
			TextView idcard = (TextView) showview.findViewById(R.id.idcard);
			TextView uuid = (TextView) showview.findViewById(R.id.uuid);
			TextView create_at = (TextView) showview.findViewById(R.id.create_at);
			User user = list.get(position);
			name.setText(user.getName());
			mobile.setText(user.getMobile());
			idcard.setText(user.getCnid());
			uuid.setText(user.getUuid());
			create_at.setText(user.getCreated_at() + "");
			if (position % 2 == 0) {
				relativeLayout.setBackgroundColor(Color.parseColor("#FFFFCC"));
			}
			myView.put(position, showview);
		}
		return showview;
	}
}
