package ro.pub.cs.pdsd.test2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends Activity {

	int nrun = 0; 
	int pid; 
	
	TextView tv0; 
	@Override
	protected void onCreate(Bundle bundle) {
		System.out.println ("aceasta este un mesaj catre consola standard");
		super.onCreate(bundle);
		tv0 = (TextView)findViewById(R.id.textView0);
		pid = android.os.Process.myPid();
		if(tv0 != null)
			tv0.append (" PID:" + pid);
		setContentView(R.layout.activity_main);
		
		EditText editText = (EditText)findViewById(R.id.editText1);
	    if (bundle != null) { 
//	    	if (bundle.getCharSequence("editText1") != null)
	    	if (bundle.getString("editText1") != null) 
	    		editText.setText(bundle.getString("editText1"));
	        Log.println (Log.DEBUG, "exe", "create old");
	    } else  
	    	Log.println (Log.DEBUG, "exe", "create new");
	    
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		Log.println (Log.DEBUG, "exe", "on createoptionsmenu");
		return true; 
	}
     
	public void apasa(View v)
    {
		
		
    	Toast.makeText(this, "Hello, I am PID "+pid, Toast.LENGTH_SHORT).show();
    	TextView textView = (TextView)findViewById(R.id.textView1);
    	EditText editText = (EditText)findViewById(R.id.editText1);
    	textView.setText(getResources().getString(R.string.hello)+editText.getText());
    	editText.setText("");
 
    	nrun++; 
    	Log.println (Log.DEBUG, "exe", "pressed " + nrun + " times");
    }
	
	 	 
	    @Override
	    public void onStart ()
	    {
	    	super.onStart();
	    	Log.println (Log.DEBUG, "exe", "on start");
	    }
	 
	    @Override
	    public void onRestart ()
	    {
	    	super.onRestart();
	    	Log.println (Log.DEBUG, "exe", "on restart");
	    }
	 
	    @Override
	    public void onResume ()
	    {
	    	super.onResume();
	    	Log.println (Log.DEBUG, "exe", "on resume");
	    }
	 
	    @Override
	    public void onPause ()
	    {
	    	super.onPause();
	    	Log.println (Log.DEBUG, "exe", "on pause");
	    }
	 
	    @Override
	    public void onStop ()
	    {
	    	super.onStop();
	    	Log.println (Log.DEBUG, "exe", "on stop");
	    }
	 
	    @Override
	    public void onDestroy ()
	    {
	    	super.onDestroy();
	    	Log.println (Log.DEBUG, "exe", "on destroy");
	    }
	 
	    // functii folosite pentru salvarea si restaurarea starii    
	 
	    @Override
	    public void onSaveInstanceState (Bundle outState)
	    {
	        // apelarea functiei din activitatea parinte este recomandata, dar nu obligatorie
	    	super.onSaveInstanceState(outState);
	    	Log.println (Log.DEBUG, "exe", "on saveinstance state");
	    	
	    	EditText editText = (EditText)findViewById(R.id.editText1);
			outState.putString("editText1", editText.getText().toString());
	    }
	  
	    @Override
	    public void onRestoreInstanceState (Bundle bundle)
	    {
	        // apelarea functiei din activitatea parinte este recomandata, dar nu obligatorie
	    	Log.println (Log.DEBUG, "exe", "on restoreinstancestate");	 
	    	super.onRestoreInstanceState(bundle);	
	    	 EditText editText = (EditText)findViewById(R.id.editText1);	
	    	 if (bundle.getString("editText1") != null) {	
	    	        editText.setText(bundle.getString("editText1"));	
	    	    }	
	    	 	
	    	
	    }
	
}
