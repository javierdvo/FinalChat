package mx.itesm.javier.finalfantasychat;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;


public class SelectArea extends ActionBarActivity implements View.OnClickListener {

    ImageView forest,desert,mountain,ocean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        forest=(ImageView) findViewById(R.id.id_iv_forest);
        ocean=(ImageView) findViewById(R.id.id_iv_ocean);
        desert=(ImageView) findViewById(R.id.id_iv_desert);
        mountain=(ImageView) findViewById(R.id.id_iv_mountain);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_area);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_area, menu);
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
    public void Forest(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "Forest");
        setResult(1, resultData);
        finish();
    }
    public void Ocean(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "Ocean");
        setResult(1, resultData);
        finish();
    }
    public void Mountain(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "Mountain");
        setResult(1, resultData);
        finish();
    }
    public void Desert(View view){
        Intent resultData = new Intent();
        resultData.putExtra(MainChat.EXTRA_MESSAGE, "Desert");
        setResult(1, resultData);
        finish();
    }
}
