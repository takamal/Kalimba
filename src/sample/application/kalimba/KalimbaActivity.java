package sample.application.kalimba;

import java.util.Iterator;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.res.TypedArray;
import android.view.View;
import android.view.View.OnClickListener;


public class KalimbaActivity extends Activity implements OnClickListener {

	public MediaPlayer[] mp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TypedArray notes = getResources().obtainTypedArray(R.array.notes);
        TypedArray buttons = getResources().obtainTypedArray(R.array.buttons);
        mp = new MediaPlayer[notes.length()];
        //これはなにをやっているのだろうか？
        
       for (int i = 0; i < notes.length(); i++) {
    	   mp[i]= MediaPlayer.create(this, notes.getResourceId(i, -1));
       }
		
       for (int i = 0; i < buttons.length(); i++) {
    	   findViewById(buttons.getResourceId(i, -1)).setOnClickListener(this);
       }
       
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_kalimba, menu);
//        return true;
//    }

	@Override
	public void onClick(View v) {
		TypedArray buttons = getResources().obtainTypedArray(R.array.buttons);
		
		for (int i = 0; i < buttons.length(); i++) {

			if (buttons.getResourceId(i, -1) == v.getId()) {
				mp[i].seekTo(0); 	//シークトウってなんなの？
				mp[i].start();
				break;
			}
		}
	}
}
