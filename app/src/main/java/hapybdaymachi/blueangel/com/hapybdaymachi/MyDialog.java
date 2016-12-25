package hapybdaymachi.blueangel.com.hapybdaymachi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MyDialog extends AppCompatActivity {

    int[] songs= {R.raw.s1,R.raw.s2,R.raw.s3,R.raw.s4,R.raw.s5,R.raw.s6,
            R.raw.s7,R.raw.s8,R.raw.s9,R.raw.s10,R.raw.s11,R.raw.s12,
            R.raw.s13,R.raw.s14,R.raw.s15,R.raw.s16,R.raw.s17,R.raw.s18,
            R.raw.s19,R.raw.s20,R.raw.s21,R.raw.s22,R.raw.s23,R.raw.s24};

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Intent play = new Intent(getApplicationContext(), MusicService.class);
        play.putExtra("clas",MyDialog.class.getName());
        startService(play);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog);

        int position = getIntent().getIntExtra("position", -1);
        if (position != -1) {
            Intent play = new Intent(getApplicationContext(), MusicService.class);
            play.putExtra("clas",MyDialog.class.getName());
            play.putExtra("position",songs[position]);

            startService(play);

            int image = getIntent().getIntExtra("image", 1);
            int quotes = getIntent().getIntExtra("quotes", 1);

            ImageView myImage = (ImageView) findViewById(R.id.imageView2);
            Picasso.with(this).load(image).into(myImage);

            TextView myText = (TextView) findViewById(R.id.textView);
            myText.setText(quotes);

        }
    }

    public void closeDialog(View view) {

        finish();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Intent play = new Intent(getApplicationContext(), MusicService.class);
        play.putExtra("clas",MyDialog.class.getName());
        stopService(play);
    }
}
