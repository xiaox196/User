package com.ming.view;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.ming.model.User;
import com.ming.utils.SyncHttp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	private String loginf = "loginf";
	private Button button = null;
	private EditText editText = null;
	private ListView listview = null;
	List<User> userData = new ArrayList<User>();
	WLDBaseActivity wldBaseActivity = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		button = (Button) findViewById(R.id.button);
//		editText = (EditText) findViewById(R.id.edittext);
		listview = (ListView) findViewById(R.id.mylistview);
		LoadNewsAsyncTask sncy = new LoadNewsAsyncTask();
		sncy.execute();

//		new Thread(new Runnable() {
//			public void run() {`
//				userData = GetListData();
//			}
//		}).start();
		
		wldBaseActivity = new WLDBaseActivity(userData, this);
		Log.v(loginf, "userData:" + userData.size());
	}

	public List<User> GetListData() {
		String url = "http://172.30.46.181:8801/TestPlatform/GetUserInfo";
		String params = "count=1000";
		SyncHttp syncHttp = new SyncHttp();
		List<User> users = new ArrayList<User>();
		try {
			String strs = syncHttp.httpGet(url, params);
			JSONObject jsonObject = new JSONObject(strs);
			JSONArray jsonArray = jsonObject.getJSONArray("info");
			Log.v(loginf, "jsonArray:" + jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject newsObject = (JSONObject) jsonArray.opt(i);
				User user = new User();
				user.setBorrower_id(newsObject.getString("borrower_id"));
				user.setCnid(newsObject.getString("cnid"));
				user.setMobile(newsObject.getString("mobile"));
				user.setName(newsObject.getString("name"));
				user.setUuid(newsObject.getString("uuid"));
				user.setCreated_at(newsObject.getString("created_at"));
				Log.v(loginf, newsObject.getString("name"));
				userData.add(user);
			}
			Log.v(loginf, "size:" + users.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	public class LoadNewsAsyncTask extends AsyncTask<Object, Integer, Integer> {

		@Override
		protected void onPreExecute() {

		}

		@Override
		protected Integer doInBackground(Object... params) {
			GetListData();
			return null;
		}

		@Override
		protected void onPostExecute(Integer result) {
			// 根据返回值显示相关的Toast
			listview.setAdapter(wldBaseActivity);
		}
	}
}
