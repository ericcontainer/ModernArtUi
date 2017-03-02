package studio.container.com.modernartui;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    TextView tv1,tv2,tv3,tv4,tv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekbar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progress = i;

                tv1 = (TextView) findViewById(R.id.tv1);
                tv2 = (TextView) findViewById(R.id.tv2);
                tv3 = (TextView) findViewById(R.id.tv3);
                tv4 = (TextView) findViewById(R.id.tv4);
                tv5 = (TextView) findViewById(R.id.tv5);
                tv1.setBackgroundColor(Color.argb(255,27+i,94+i,32+i));
                tv2.setBackgroundColor(Color.argb(255,56+i,142+i,60+i));
                tv3.setBackgroundColor(Color.argb(255,76+i,175+i-50,80+i));
                tv4.setBackgroundColor(Color.argb(255,129+i,199+i-80,132+i));
                tv5.setBackgroundColor(Color.argb(255,232-i,245-i,233-i));
                //Toast.makeText(getApplicationContext(),Integer.toString(i),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
