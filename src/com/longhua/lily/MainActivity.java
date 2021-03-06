package com.longhua.lily;


import com.longhua.common.SimpleSideDrawer;
import com.longhua.update.UpdateManager;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
	
    private SimpleSideDrawer mNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check app update.
		UpdateManager manager = new UpdateManager(MainActivity.this);
		manager.checkUpdate();

		//Set side drawer.
        mNav = new SimpleSideDrawer(this);
        mNav.setLeftBehindContentView(R.layout.left);
        findViewById(R.id.mainLeftBtn).setOnClickListener(new OnClickListener() {
            @Override 
            public void onClick(View v) {
                mNav.toggleLeftDrawer();
            }
        });
        
        findViewById(R.id.imgMessageBtn).setOnClickListener(this);
        findViewById(R.id.imgLabelBtn).setOnClickListener(this);
        findViewById(R.id.imgContactBtn).setOnClickListener(this);
        findViewById(R.id.imgShopBtn).setOnClickListener(this);
        
        

		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager
				.beginTransaction();
		MainMessageFragment fragment = new MainMessageFragment();
		fragmentTransaction.replace(R.id.fragmentContainer, fragment);
//		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
        
        
        
    }

	@Override
	public void onClick(View view) {
		int id = view.getId();
		if (!view.isSelected()) {
			Fragment nextFragment = null;
			
			findViewById(R.id.imgMessageBtn).setSelected(id == R.id.imgMessageBtn);
			findViewById(R.id.imgLabelBtn).setSelected(id == R.id.imgLabelBtn);
			findViewById(R.id.imgContactBtn).setSelected(id == R.id.imgContactBtn);
			findViewById(R.id.imgShopBtn).setSelected(id == R.id.imgShopBtn);
			
			switch(id) {
			case R.id.imgMessageBtn:
				nextFragment = new MainMessageFragment();
				break;
			case R.id.imgLabelBtn:
				nextFragment = new MainLabelFragment();
				break;
			case R.id.imgContactBtn:
				nextFragment = new MainMessageFragment();
				break;
			case R.id.imgShopBtn:
				nextFragment = new MainMessageFragment();
				break;
			default:
				nextFragment = new MainMessageFragment();
				break;
			}
			
			
			
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			fragmentTransaction.replace(R.id.fragmentContainer, nextFragment);
//			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
			
			
		}
		
		
	}
	
//	private void switchToSegment() {
//		
//	}


}
