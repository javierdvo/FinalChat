package mx.itesm.javier.finalfantasychat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class ChangeHero extends ActionBarActivity implements View.OnClickListener {
    ImageView ayla ;
    ImageView bartz ;
    ImageView cecil;
    ImageView celes ;
    ImageView cid;
    ImageView crono;
    ImageView dalton;
    ImageView faris;
    ImageView flea ;
    ImageView frog ;
    ImageView greg ;
    ImageView kain ;
    ImageView kefka ;
    ImageView lenna ;
    ImageView light;
    ImageView locke ;
    ImageView lucca;
    ImageView magus ;
    ImageView marle;
    ImageView robo;
    ImageView terra;
    ImageView rydia;
    ImageView warrior;
    ImageView whitemage;
    ImageView zeal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_change_hero);
        ayla =(ImageView) findViewById(R.id.id_iv_ayla);
        bartz =(ImageView) findViewById(R.id.id_iv_bartz);
        cecil =(ImageView) findViewById(R.id.id_iv_cecil);
        celes =(ImageView) findViewById(R.id.id_iv_celes);
        cid =(ImageView) findViewById(R.id.id_iv_cid);
        crono =(ImageView) findViewById(R.id.id_iv_crono);
        dalton =(ImageView) findViewById(R.id.id_iv_dalton);
        faris =(ImageView) findViewById(R.id.id_iv_faris);
        flea =(ImageView) findViewById(R.id.id_iv_flea);
        frog =(ImageView) findViewById(R.id.id_iv_frog);
        greg =(ImageView) findViewById(R.id.id_iv_greg);
        kain =(ImageView) findViewById(R.id.id_iv_kain);
        kefka =(ImageView) findViewById(R.id.id_iv_kefka);
        lenna =(ImageView) findViewById(R.id.id_iv_lenna);
        light =(ImageView) findViewById(R.id.id_iv_light);
        locke =(ImageView) findViewById(R.id.id_iv_locke);
        lucca =(ImageView) findViewById(R.id.id_iv_lucca);
        magus =(ImageView) findViewById(R.id.id_iv_magus);
        marle =(ImageView) findViewById(R.id.id_iv_marle);
        robo =(ImageView) findViewById(R.id.id_iv_robo);
        terra =(ImageView) findViewById(R.id.id_iv_terra);
        rydia =(ImageView) findViewById(R.id.id_iv_rydia);
        warrior =(ImageView) findViewById(R.id.id_iv_warrior);
        whitemage =(ImageView) findViewById(R.id.id_iv_whitemage);
        zeal =(ImageView) findViewById(R.id.id_iv_zeal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_change_hero, menu);
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
    @Override
    public void onClick(View v) {

    }
    public void Ayla(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "ayla");
        setResult(1, resultData);
        finish();
    }
    public void Bartz(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "bartz");
        setResult(1, resultData);
        finish();
    }
    public void Cecil(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "cecil");
        setResult(1, resultData);
        finish();
    }
    public void Celes(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "celes");
        setResult(1, resultData);
        finish();
    }
    public void Cid(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "cid");
        setResult(1, resultData);
        finish();
    }public void Crono(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "crono");
        setResult(1, resultData);
        finish();
    }
    public void Dalton(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "dalton");
        setResult(1, resultData);
        finish();
    }
    public void Faris(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "faris");
        setResult(1, resultData);
        finish();
    }
    public void Flea(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "flea");
        setResult(1, resultData);
        finish();
    }
    public void Frog(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "frog");
        setResult(1, resultData);
        finish();
    }
    public void Greg(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "greg");
        setResult(1, resultData);
        finish();
    }
    public void Kain(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "kain");
        setResult(1, resultData);
        finish();
    }
    public void Kefka(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "kefka");
        setResult(1, resultData);
        finish();
    }
    public void Lenna(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "lenna");
        setResult(1, resultData);
        finish();
    }
    public void Light(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "light");
        setResult(1, resultData);
        finish();
    }
    public void Locke(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "locke");
        setResult(1, resultData);
        finish();
    }
    public void Lucca(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "lucca");
        setResult(1, resultData);
        finish();
    }public void Magus(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "magus");
        setResult(1, resultData);
        finish();
    }
    public void Marle(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "marle");
        setResult(1, resultData);
        finish();
    }
    public void Robo(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "robo");
        setResult(1, resultData);
        finish();
    }
    public void Rydia(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "rydia");
        setResult(1, resultData);
        finish();
    }
    public void Terra(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "terra");
        setResult(1, resultData);
        finish();
    }
    public void Warrior(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "warrior");
        setResult(1, resultData);
        finish();
    }
    public void Whitemage(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "whitemage");
        setResult(1, resultData);
        finish();
    }public void Zeal(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "zeal");
        setResult(1, resultData);
        finish();
    }





}
