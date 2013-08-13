package com.ydev.blogreader;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class BlogWebViewActivity extends Activity {

	protected String mUrl; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blog_web_view);
		//fetch intent 
		Intent intent = getIntent();
		
		Uri blogUri = intent.getData();
		mUrl=blogUri.toString();
		WebView webView = (WebView) findViewById(R.id.webView1);
		webView.loadUrl(blogUri.toString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.blog_web_view, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		int itemId = item.getItemId();
		
		if (itemId==R.id.action_share){
			sharePost();
		}
		
		return super.onOptionsItemSelected(item);
	}
	
	private void sharePost(){
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.setType("text/plain");
		shareIntent.putExtra(Intent.EXTRA_TEXT, mUrl);
		//chooser to allow user to choose which application he want to use.
		startActivity(Intent.createChooser(shareIntent, "How do you want to share?"));
	
	}

}
