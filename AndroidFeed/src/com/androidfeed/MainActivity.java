package com.androidfeed;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.feed.andorid.rssfeedlibrary.RssFeedProvider;
import com.feed.andorid.rssfeedlibrary.RssItem;

public class MainActivity extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		List<RssItem> list = RssFeedProvider
				  .parse("http://timesofindia.indiatimes.com/rssfeedstopstories.cms");
				String text = String.valueOf(list.size());
				tv=(TextView)findViewById(R.id.textView1);
				tv.setText(text);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
