package com.example.barcodescanning;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Intent scanIntent = new Intent("com.google.zxing.client.android.SCAN");
        
        scanIntent.putExtra("SCAN_MODE", "PRODUCT_MODE");
        startActivityForResult(scanIntent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	if(requestCode == 0) {
    		if(resultCode == RESULT_OK) {
    			String contents = data.getStringExtra("SCAN_RESULT");
    			String format = data.getStringExtra("SCAN_RESULT_FORMAT");
    		}
    	}
    		
    	
    	super.onActivityResult(requestCode, resultCode, data);
    }
}
