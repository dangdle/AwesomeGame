package com.example.musicbuttons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainMusicScreenActivity extends Activity {

	List<Sound> soundsSet;
	boolean stopButton = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music_screen);
		// soundsSet = new ArrayList<>();
		soundsSet = Collections.synchronizedList(new ArrayList<Sound>());
		setButtons();

	}

	@Override
	protected void onResume() {
		super.onResume();

		// soundsSet = new ArrayList<>();
		soundsSet = Collections.synchronizedList(new ArrayList<Sound>());
	}

	public void setButtons() {
		// SharedPreferences sPreferences = this.getPreferences(MODE_PRIVATE);
		// ((Button) findViewById(R.id.B1)).setText(sPreferences.getString(
		// "Button01", "fail"));

	}

	public void stopButton(View view) {
		stopButton = !stopButton;
	}

	public void stopAllButton(View view) {
		synchronized (soundsSet) {
			for (Sound sound : soundsSet) {
				sound.stop();
			}
		}

		soundsSet.clear();
	}

	public void backButton(View view) {
		finish();
	}

	public void b1(View view) {
		playSound(R.raw.base2);
	}

	public void b2(View view) {
		playSound(R.raw.base3);
	}

	public void b3(View view) {
		playSound(R.raw.basedrum1);
	}

	public void b4(View view) {
		playSound(R.raw.crashcymbal15);
	}

	public void b5(View view) {
		playSound(R.raw.cymbal18);
	}

	public void b6(View view) {
		playSound(R.raw.high13hatlow);
	}

	public void b7(View view) {
		playSound(R.raw.high14hat3);
	}

	public void b8(View view) {
		playSound(R.raw.highhat_shock);
	}

	public void b9(View view) {
		playSound(R.raw.highhat1);
	}

	public void b10(View view) {
		playSound(R.raw.highhat2);
	}

	public void b11(View view) {
		playSound(R.raw.hithat3);
	}

	public void b12(View view) {
		playSound(R.raw.highhat4);
	}

	public void b13(View view) {
		playSound(R.raw.snare1);
	}

	public void b14(View view) {
		playSound(R.raw.snare2);
	}

	public void b15(View view) {
		playSound(R.raw.tom1);
	}

	public void b16(View view) {
		playSound(R.raw.tom2);
	}

	public void b17(View view) {
		playSound(R.raw.tom3);
	}

	public void b18(View view) {
		playSound(R.raw.tom4);
	}

	public void playSound(int id) {
		if (!stopButton) {
			Sound t = (new Sound(this, id));
			synchronized (soundsSet) {
				soundsSet.add(t);
			}
			
			new Thread(t).start();
		} else {
			synchronized (soundsSet) {
				ArrayList<Sound> clear = new ArrayList<>();
				for (Sound sound : soundsSet) {
					if (sound.id == id) {
						sound.stop();
						clear.add(sound);
					}
				}
				soundsSet.removeAll(clear);
			}
			
			stopButton = false;
		}
	}

	private class Sound implements Runnable {
		Activity activity;
		int id;
		MediaPlayer mp;

		public Sound(Activity activity, int id) {
			this.activity = activity;
			this.id = id;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			mp = MediaPlayer.create(activity, id);
			mp.start();
			while (mp.isPlaying()) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			mp.release();
			soundsSet.remove(this);
		}

		void stop() {
			if (mp != null && mp.isPlaying()) {
				mp.stop();

			}
		}

	}
}
