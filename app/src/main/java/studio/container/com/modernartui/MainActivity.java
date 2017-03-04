package studio.container.com.modernartui;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    private TextView tv1,tv2,tv3,tv4,tv5, tv1_menu, tv2_menu;
    private String URL = "http://www.moma.org";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.menu_id){
            final Dialog dialog = new Dialog(this);
            dialog.setTitle(getResources().getString(R.string.dialog_title));
            dialog.setContentView(R.layout.layout_menu);

            dialog.findViewById(R.id.tv_visit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                    startActivity(intent);
                }
            });
            dialog.findViewById(R.id.tv_notnow).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            dialog.show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

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
                tv1.setBackgroundColor(Color.rgb(27+i,94+i,32+i));
                tv2.setBackgroundColor(Color.rgb(56+i,142+i,60+i));
                tv3.setBackgroundColor(Color.rgb(76+i,175+i-50,80+i));
                tv4.setBackgroundColor(Color.rgb(129+i,199+i-80,132+i));
                tv5.setBackgroundColor(Color.rgb(232-i,245-i,233-i));
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
