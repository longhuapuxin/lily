package com.longhua.lily;

import com.navdrawer.SimpleSideDrawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {
	
    private SimpleSideDrawer mNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        mNav = new SimpleSideDrawer(this);
        mNav.setLeftBehindContentView(R.layout.left);
        findViewById(R.id.leftBtn).setOnClickListener(new OnClickListener() {
            @Override 
            public void onClick(View v) {
                mNav.toggleLeftDrawer();
            }
        });
        
    }


}
