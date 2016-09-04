package mx.itesm.javier.finalfantasychat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class HeroStats extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);
        Intent intent= getIntent();
        String message= intent.getStringExtra(MainChat.EXTRA_MESSAGE);
        TextView name=(TextView) findViewById(R.id.name);
        TextView level=(TextView) findViewById(R.id.textView11);
        TextView maxhp=(TextView) findViewById(R.id.textView5);
        TextView currenthp=(TextView) findViewById(R.id.textView6);
        TextView maxmana=(TextView) findViewById(R.id.textView7);
        TextView currentmana=(TextView) findViewById(R.id.textView8);
        TextView skill=(TextView) findViewById(R.id.textView9);
        TextView attack=(TextView) findViewById(R.id.textView10);
        TextView magic=(TextView) findViewById(R.id.textView);
        TextView defense=(TextView) findViewById(R.id.textView3);
        TextView mdefense=(TextView) findViewById(R.id.textView4);
        TextView exp= (TextView)findViewById(R.id.textView15);
        ProgressBar health=(ProgressBar)findViewById(R.id.healthBar);
        ProgressBar mana=(ProgressBar)findViewById(R.id.manaBar);
        ImageView iv= (ImageView)findViewById(R.id.id_iv_heroimg);

        String delims= "[:]";
        String[] tokens= message.split(delims);
        int id = getResources().getIdentifier(tokens[0].toLowerCase(), "drawable", getPackageName());
        iv.setImageResource(id);
        iv.invalidate();
        name.setText(tokens[0]);
        level.setText(tokens[1]);
        maxhp.setText("MaxHp:"+tokens[2]);
        currenthp.setText("Hp:"+tokens[3]);
        maxmana.setText("MaxMp:"+tokens[4]);
        currentmana.setText("Mp:"+tokens[5]);
        skill.setText("Skill:"+tokens[8]);
        attack.setText("Attack:"+tokens[6]);
        magic.setText("Magic:"+tokens[7]);
        defense.setText("Defense:"+tokens[9]);
        mdefense.setText("Magic Def:"+tokens[10]);
        exp.setText("Exp:"+tokens[11]);

        health.setMax(Integer.parseInt(tokens[2]));
        mana.setMax(Integer.parseInt(tokens[4]));
        health.setProgress(Integer.parseInt(tokens[3]));
        mana.setProgress(Integer.parseInt(tokens[5]));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hero_stats, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
