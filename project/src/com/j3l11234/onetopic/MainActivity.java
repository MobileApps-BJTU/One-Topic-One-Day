package com.j3l11234.onetopic;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
	private FragmentManager fragmentManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        
		fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
        	fragmentManager.beginTransaction()
					.add(R.id.container, new MainFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.action_settings:
			return true;
		case R.id.action_login:
			fragmentManager.beginTransaction()
			.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
			.replace(R.id.container, new LoginFragment())
			.addToBackStack(null).commit();
			break;
		case R.id.action_register:
			fragmentManager.beginTransaction()
			.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
			.replace(R.id.container, new RegisterFragment())
			.addToBackStack(null).commit();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
