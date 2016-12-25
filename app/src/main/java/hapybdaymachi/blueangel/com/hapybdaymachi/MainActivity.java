//open with 25 dec 1995 as date

package hapybdaymachi.blueangel.com.hapybdaymachi;


import android.app.DatePickerDialog;
import android.content.Intent;
import java.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button giftButton;
    private int day = 1;
    private int month = 11;//starts at 0,so 11
    private int year = 1995;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);
        giftButton = (Button) findViewById(R.id.button);

        Toast.makeText(MainActivity.this, "Enter Your DOB Machi", Toast.LENGTH_LONG).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calender = Calendar.getInstance();
                year = calender.get(Calendar.YEAR);
                month = calender.get(Calendar.MONTH);
                day = calender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                final String dob = String.valueOf(dayOfMonth) + String.valueOf(month)
                                        + String.valueOf(year);
                                giftButton.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        //Dec 25 1995
                                        if (dob.equals("25111995")) {
                                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(MainActivity.this, "Enter Your DOB Machi", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        }, year, month, day);
                datePickerDialog.show();

            }
        });
    }

}





/*        datePicker = (DatePicker) findViewById(R.id.datePicker);
        datePicker.updateDate(year, month, day);

        giftButton = (Button) findViewById(R.id.button);

        Toast.makeText(MainActivity.this, "Enter Your DOB Machi", Toast.LENGTH_LONG).show();

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                final StringBuffer buffer = new StringBuffer();
                buffer.append(dayOfMonth);
                buffer.append(monthOfYear);
                buffer.append(year);
                giftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Dec 25 1995
                        if (buffer.toString().equals("25111995")) {
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this, "Enter Your DOB Machi", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });*/