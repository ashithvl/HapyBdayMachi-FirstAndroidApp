package hapybdaymachi.blueangel.com.hapybdaymachi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * Created by Ashith VL on 12/19/2016.
 */

public class SecondActivity extends AppCompatActivity {

    GridView gridView;


    @Override
    protected void onRestart() {
        super.onRestart();
        Intent play = new Intent(SecondActivity.this, MusicService.class);
        play.putExtra("clas", SecondActivity.class.getName());
        startService(play);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent play = new Intent(SecondActivity.this, MusicService.class);
        play.putExtra("clas", SecondActivity.class.getName());
        startService(play);


        //gridView to java using findViewById
        gridView = (GridView) findViewById(R.id.kirubaGrid);

        final ImagesQuotesAdapter imagesQuotesAdapter = new ImagesQuotesAdapter(this, imagesQuotes);
        gridView.setAdapter(imagesQuotesAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImagesQuotes imagesQuote = imagesQuotes[position];
                // This tells the GridView to redraw itself
                // in turn calling your imagesQuotesAdapter's getView method again for each cell
                imagesQuotesAdapter.notifyDataSetChanged();
                //Get item at position
                //Pass the image quotes and url to DetailsActivity
                Intent intent = new Intent(SecondActivity.this, MyDialog.class);
                intent.putExtra("position", position);
                intent.putExtra("quotes", imagesQuote.getQuotes());
                intent.putExtra("image", imagesQuote.getImages());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Intent play = new Intent(SecondActivity.this, MusicService.class);
        play.putExtra("clas", MainActivity.class.getName());
        stopService(play);
    }

    private ImagesQuotes[] imagesQuotes = {
            new ImagesQuotes(R.string.q1, R.drawable.i1),
            new ImagesQuotes(R.string.q2, R.drawable.i2),
            new ImagesQuotes(R.string.q3, R.drawable.i3),
            new ImagesQuotes(R.string.q4, R.drawable.i4),
            new ImagesQuotes(R.string.q5, R.drawable.i5),
            new ImagesQuotes(R.string.q6, R.drawable.i6),
            new ImagesQuotes(R.string.q7, R.drawable.i7),
            new ImagesQuotes(R.string.q8, R.drawable.i8),
            new ImagesQuotes(R.string.q9, R.drawable.i9),
            new ImagesQuotes(R.string.q10, R.drawable.i10),
            new ImagesQuotes(R.string.q11, R.drawable.i11),
            new ImagesQuotes(R.string.q12, R.drawable.i12),
            new ImagesQuotes(R.string.q13, R.drawable.i13),
            new ImagesQuotes(R.string.q14, R.drawable.i14),
            new ImagesQuotes(R.string.q15, R.drawable.i15),
            new ImagesQuotes(R.string.q16, R.drawable.i16),
            new ImagesQuotes(R.string.q17, R.drawable.i17),
            new ImagesQuotes(R.string.q18, R.drawable.i18),
            new ImagesQuotes(R.string.q19, R.drawable.i19),
            new ImagesQuotes(R.string.q20, R.drawable.i20),
            new ImagesQuotes(R.string.q21, R.drawable.i21),
            new ImagesQuotes(R.string.q22, R.drawable.i22),
            new ImagesQuotes(R.string.q23, R.drawable.i23),
            new ImagesQuotes(R.string.q24, R.drawable.i24)
    };

}
