package mx.itesm.javier.finalfantasychat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MonsterStats extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster_stats);
        Intent intent= getIntent();
        String message= intent.getStringExtra(MainChat.EXTRA_MESSAGE);
        TextView name=(TextView) findViewById(R.id.Mname);
        TextView level=(TextView) findViewById(R.id.Mlevel);
        TextView maxhp=(TextView) findViewById(R.id.MtextView5);
        TextView currenthp=(TextView) findViewById(R.id.MtextView6);
        TextView mage=(TextView) findViewById(R.id.MtextView7);
        TextView weak=(TextView) findViewById(R.id.MtextView8);
        TextView strong=(TextView) findViewById(R.id.Mstrong);
        TextView skill=(TextView) findViewById(R.id.MtextView9);
        TextView attack=(TextView) findViewById(R.id.MtextView10);
        TextView magic=(TextView) findViewById(R.id.MtextView);
        TextView defense=(TextView) findViewById(R.id.MtextView3);
        TextView mdefense=(TextView) findViewById(R.id.MtextView4);
        TextView exp= (TextView)findViewById(R.id.MtextView15);
        ProgressBar health=(ProgressBar)findViewById(R.id.MhealthBar);

        ImageView iv= (ImageView)findViewById(R.id.id_iv_Mheroimg);
        ImageView bg= (ImageView)findViewById(R.id.id_iv_monsterbg);

        String delims= "[:]";
        String[] tokens= message.split(delims);
        int id = getResources().getIdentifier(tokens[0].toLowerCase(), "drawable", getPackageName());
        iv.setImageResource(id);
        iv.invalidate();
        name.setText(tokens[0]);
        level.setText(tokens[1]);
        maxhp.setText("MaxHp:"+tokens[13]);
        currenthp.setText("Hp:"+tokens[2]);
        if(Integer.parseInt(tokens[3])==1){
            mage.setText("Is a Mage");
        }
        else{
            mage.setText("Is not a Mage");
        }
        attack.setText("Attack:"+tokens[4]);
        magic.setText("Magic:"+tokens[5]);
        if(Integer.parseInt(tokens[6])==1){
            skill.setText("Knows skills");
        }
        else{
            skill.setText("No skills");
        }
        switch(Integer.parseInt(tokens[9])){
            case 0:{
                strong.setText("No Strengths");
                break;
            }
            case 1:{
                strong.setText("Strong vs Fire");
                break;
            }
            case 2:{
                strong.setText("Strong vs Thunder");
                break;
            }
            case 3:{
                strong.setText("Strong vs Ice");
                break;
            }
        }
        switch(Integer.parseInt(tokens[10])){
            case 0:{
                weak.setText("No Weakness");
                break;
            }
            case 1:{
                weak.setText("Weak vs Fire");
                break;
            }
            case 2:{
                weak.setText("Weak vs Thunder");
                break;
            }
            case 3:{
                weak.setText("Weak vs Ice");
                break;
            }
            default:{
                weak.setText("No Weakness");
                break;
            }
        }
        defense.setText("Defense:"+tokens[7]);
        mdefense.setText("Magic Def:" + tokens[8]);
        int exper= Integer.parseInt(tokens[11])*Integer.parseInt(tokens[1]);
        exp.setText("Exp:" + exper);
        int id2 = getResources().getIdentifier("bg"+tokens[12].toLowerCase(), "drawable", getPackageName());
        bg.setImageResource(id2);
        health.setMax(Integer.parseInt(tokens[13]));

        health.setProgress(Integer.parseInt(tokens[2]));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monster_stats, menu);
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
