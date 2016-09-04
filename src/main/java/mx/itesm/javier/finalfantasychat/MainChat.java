package mx.itesm.javier.finalfantasychat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Selection;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import mx.itesm.javier.finalfantasychat.R;

public class MainChat extends ActionBarActivity implements View.OnClickListener{

    public class NetworkTask extends AsyncTask<Void,String,Boolean> {

        MainChat parent;

        SocketChannel sChannel = null;
        Selector selector = null;
        SelectionKey key = null;

        int flagLoop = 0;

        String msg = "";
        String msg2 = "";
        String msg3 = "";
        String msg4 = "";
        String msg5 = "";
        String msg6 = "";
        String msg7 = "";
        String msg8 = "";
        String msg9 = "";
        String msg10 = "";
        String msg11 = "";

        MainChat world = null;

        public void SetActivity(MainChat m) {
            parent = m;
        }

        public void SendToServer(String str) {

            if (!sChannel.isConnected()) {
                printToast("not connected to server");
                return;
            }
            msg=str;
            key.interestOps(SelectionKey.OP_WRITE);     // convert to write mode
            selector.wakeup();                          // force to return from blocking select()
        }


        @Override
        protected Boolean doInBackground(Void... params) {

                try {
                    sChannel = SocketChannel.open();
                    sChannel.configureBlocking(false);
                    selector = Selector.open();
                    key = sChannel.register(selector, SelectionKey.OP_READ);
                    sChannel.connect(new InetSocketAddress("210.115.230.198", 55585));
                    while(true) {
                        if(sChannel.finishConnect()) break;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            Log.i("Net", "Done connecting");

            while (true) {
                try {
                    int readyChannels = selector.select();
                    if (readyChannels == 0) continue;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isWritable()) {
                        Log.i("Net", "Sent stuff");
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        buf.clear();
                        buf.put(msg.getBytes());
                        buf.flip();
                        if (sChannel.isConnected()) {
                            try {
                                while (buf.hasRemaining()) {
                                    sChannel.write(buf);
                                }
                            } catch (IOException e) {
                                Log.i("AsyncTask", "IOException thrown while writing to a socket channel.");
                                e.printStackTrace();
                            }
                        }
                        key.interestOps(SelectionKey.OP_READ);

                    } else if (key.isConnectable()) {

                    } else if (key.isReadable()) {
                        msg = "";
                        msg2 = "";
                        msg3 = "";
                        msg4 = "";
                        msg5 = "";
                        msg6 = "";
                        msg7 = "";
                        msg8 = "";
                        msg9 = "";
                        msg10 = "";
                        msg11 = "";
                        Log.i("Net", "Received stuff");
                        ByteBuffer buf = ByteBuffer.allocate(1024);
                        int numBytesRead = 0;
                        try {
                            numBytesRead = sChannel.read(buf);
                            if (numBytesRead == -1) {
                                sChannel.close();
                                flagLoop = 1;
                                break;
                            }
                        } catch (IOException e) {
                            Log.i("NetworkThread", "IOException when reading from a socket");
                        }
                        String output = new String(buf.array()).trim();
                        Log.i("Net",output);
                        if(output.contains("/startbattle")){
                            battlemode=1;
                            String delims= "[:]";
                            monsterTokens=output.split(delims);
                            msg = "Enemy "+monsterTokens[1] +" appeared!";

                            enemy= new Enemy(monsterTokens[1],Integer.parseInt(monsterTokens[3]),Integer.parseInt(monsterTokens[5]),Integer.parseInt(monsterTokens[7]),Integer.parseInt(monsterTokens[9]),Integer.parseInt(monsterTokens[11]),Integer.parseInt(monsterTokens[13]),Integer.parseInt(monsterTokens[15]),Integer.parseInt(monsterTokens[17]),Integer.parseInt(monsterTokens[19]),Integer.parseInt(monsterTokens[21]),Integer.parseInt(monsterTokens[23]));
                            monsterMax=enemy.getHealth();
                            publishProgress(msg);
                        }
                        else if(output.contains("Choose")){
                            if(character==0) {
                                String delims = "[:]";
                                tokens = output.split(delims);
                                character = Integer.parseInt(tokens[1]);
                                msg=tokens[0];
                                publishProgress(msg);
                            }
                        }
                        else if(output.contains("/endbattle")){
                            battlemode=0;
                            String delims = "[:]";
                            tokens = output.split(delims);
                            msgTokens = output.split("\n");

                            if(output.contains("The party has been")) {
                                for (int k=0;k<=usernum-5;k++){
                                    heroes[k+5].setCurrentHealth(maxHealth);
                                    heroes[k+5].setCurrentMana(maxMana);
                                }
                                if (!tokens[0].contains("/monsterdata")) {
                                    msg = msgTokens[0];
                                    msg2 =msgTokens[43];
                                    msg2="The party has been defeated!";
                                    publishProgress(msg,msg2,msg3);

                                } else {
                                    msg4 = msgTokens[42];
                                    msg5 = msgTokens[57];
                                    msg2="The party has been defeated!";
                                    publishProgress(msg,msg2,msg3);

                                }

                            }
                            else{
                                if (!tokens[0].contains("/monsterdata")) {
                                    msg = msgTokens[0];
                                    msg2 =msgTokens[1];
                                    msg4="The enemy has been defeated!";

                                } else {
                                    msg = "";
                                    msg4="The enemy has been defeated!";
                                }
                                for (int k=0;k<=usernum-5;k++){
                                    if (tokens[0].contains("/monsterdata")) {
                                        msg2 = "";
                                        msg3 = "";
                                        enemy.setHealth(Integer.parseInt(tokens[5]));
                                        userId = Integer.parseInt(tokens[51+26*k]);
                                        name = tokens[53+26*k];
                                        level = Integer.parseInt(tokens[55+26*k]);
                                        maxHealth = Integer.parseInt(tokens[57+26*k]);
                                        currentHealth = Integer.parseInt(tokens[59+26*k]);
                                        maxMana = Integer.parseInt(tokens[61+26*k]);
                                        currentMana = Integer.parseInt(tokens[63+26*k]);
                                        attack = Integer.parseInt(tokens[65+26*k]);
                                        magic = Integer.parseInt(tokens[67+26*k]);
                                        skill = Integer.parseInt(tokens[69+26*k]);
                                        defense = Integer.parseInt(tokens[71+26*k]);
                                        mdefense = Integer.parseInt(tokens[73+26*k]);
                                        exp = Integer.parseInt(tokens[75+26*k]);

                                        Log.i("net", String.valueOf(k));
                                        msgTokens = output.split("\n");
                                        switch(k){
                                            case 0:
                                            {
                                                msg4 = msgTokens[27+14*k];
                                                break;
                                            }
                                            case 1:
                                            {
                                                msg5 = msgTokens[27+14*k];
                                                break;
                                            }
                                            case 2:
                                            {
                                                msg6 = msgTokens[27+14*k];
                                                break;
                                            }
                                            case 3:
                                            {
                                                msg7 = msgTokens[27+14*k];
                                                break;
                                            }
                                            case 4:
                                            {
                                                msg8 = msgTokens[27+14*k];
                                                break;
                                            }
                                            case 5:
                                            {
                                                msg9 = msgTokens[27+14*k];
                                                break;
                                            }
                                            case 6:
                                            {
                                                msg10 = msgTokens[27+14*k];
                                                break;
                                            }
                                            case 7:
                                            {
                                                msg11 = msgTokens[27+14*k];
                                                break;
                                            }
                                        }



                                        if (heroes[k+5] == null) {
                                            usernum++;
                                            heroes[k+5] = new Hero(userId, name, level, maxHealth, maxMana, attack, magic, skill, defense, mdefense, exp);
                                        }
                                        heroes[k+5].setLevel(level);
                                        heroes[k+5].setMaxHealth(maxHealth);
                                        heroes[k+5].setCurrentHealth(currentHealth);
                                        heroes[k+5].setMaxMana(maxMana);
                                        heroes[k+5].setCurrentMana(currentMana);
                                        heroes[k+5].setExp(exp);
                                    } else {
                                        enemy.setHealth(Integer.parseInt(tokens[6]));
                                        userId = Integer.parseInt(tokens[52+26*k]);
                                        name = tokens[54+26*k];
                                        level = Integer.parseInt(tokens[56+26*k]);
                                        maxHealth = Integer.parseInt(tokens[58+26*k]);
                                        currentHealth = Integer.parseInt(tokens[60+26*k]);
                                        maxMana = Integer.parseInt(tokens[62+26*k]);
                                        currentMana = Integer.parseInt(tokens[64+26*k]);
                                        attack = Integer.parseInt(tokens[66+26*k]);
                                        magic = Integer.parseInt(tokens[68+26*k]);
                                        skill = Integer.parseInt(tokens[70+26*k]);
                                        defense = Integer.parseInt(tokens[72+26*k]);
                                        mdefense = Integer.parseInt(tokens[74+26*k]);
                                        exp = Integer.parseInt(tokens[76+26*k]);
                                        msgTokens = output.split("\n");
                                        switch(k){
                                            case 0:
                                            {
                                                msg4 = msgTokens[31+14*k];
                                                break;
                                            }
                                            case 1:
                                            {
                                                msg5 = msgTokens[31+14*k];
                                                break;
                                            }
                                            case 2:
                                            {
                                                msg6 = msgTokens[31+14*k];
                                                break;
                                            }
                                            case 3:
                                            {
                                                msg7 = msgTokens[31+14*k];
                                                break;
                                            }
                                            case 4:
                                            {
                                                msg8 = msgTokens[31+14*k];
                                                break;
                                            }
                                            case 5:
                                            {
                                                msg9 = msgTokens[31+14*k];
                                                break;
                                            }
                                            case 6:
                                            {
                                                msg10 = msgTokens[31+14*k];
                                                break;
                                            }
                                            case 7:
                                            {
                                                msg11 = msgTokens[31+14*k];
                                                break;
                                            }
                                        }

                                        if (heroes[k+5] == null) {
                                            usernum++;
                                            heroes[k+5] = new Hero(userId, name, level, maxHealth, maxMana, attack, magic, skill, defense, mdefense, exp);
                                        }
                                        heroes[k+5].setLevel(level);
                                        heroes[k+5].setMaxHealth(maxHealth);
                                        heroes[k+5].setCurrentHealth(currentHealth);
                                        heroes[k+5].setMaxMana(maxMana);
                                        heroes[k+5].setCurrentMana(currentMana);
                                        heroes[k+5].setExp(exp);

                                    }
                                }
                                publishProgress(msg,msg4,msg5,msg6,msg7,msg8,msg9,msg10,msg11);
                            }


                        }
                        else if(output.contains("/enemyturn")){
                            String delims = "[:]";
                            tokens = output.split(delims);
                            if (!tokens[25].contains("/end")) {
                                enemy.setHealth(Integer.parseInt(tokens[55]));
                                userId = Integer.parseInt(tokens[75]);
                                name = tokens[77];
                                level = Integer.parseInt(tokens[79]);
                                maxHealth = Integer.parseInt(tokens[81]);
                                currentHealth = Integer.parseInt(tokens[83]);
                                maxMana = Integer.parseInt(tokens[85]);
                                currentMana = Integer.parseInt(tokens[87]);
                                attack = Integer.parseInt(tokens[89]);
                                magic = Integer.parseInt(tokens[91]);
                                skill = Integer.parseInt(tokens[93]);
                                defense = Integer.parseInt(tokens[95]);
                                mdefense = Integer.parseInt(tokens[97]);
                                exp = Integer.parseInt(tokens[99]);

                                msgTokens = output.split("\n");
                                msg = msgTokens[42];


                                if(heroes[userId]==null){
                                    usernum++;
                                    heroes[userId]= new Hero(userId,name,level,maxHealth,maxMana,attack,magic,skill,defense,mdefense,exp);
                                }
                                heroes[userId].setLevel(level);
                                heroes[userId].setMaxHealth(maxHealth);
                                heroes[userId].setCurrentHealth(currentHealth);
                                heroes[userId].setMaxMana(maxMana);
                                heroes[userId].setCurrentMana(currentMana);
                                heroes[userId].setExp(exp);
                                publishProgress(msg);
                            }
                            else {
                                enemy.setHealth(Integer.parseInt(tokens[56]));
                                userId = Integer.parseInt(tokens[76]);
                                name = tokens[78];
                                level = Integer.parseInt(tokens[80]);
                                maxHealth = Integer.parseInt(tokens[82]);
                                currentHealth = Integer.parseInt(tokens[84]);
                                maxMana = Integer.parseInt(tokens[86]);
                                currentMana = Integer.parseInt(tokens[88]);
                                attack = Integer.parseInt(tokens[90]);
                                magic = Integer.parseInt(tokens[92]);
                                skill = Integer.parseInt(tokens[94]);
                                defense = Integer.parseInt(tokens[96]);
                                mdefense = Integer.parseInt(tokens[98]);
                                exp = Integer.parseInt(tokens[100]);

                                msgTokens = output.split("\n");
                                Log.i("net",msgTokens[0]);
                                Log.i("net",msgTokens[1]);
                                msg = msgTokens[0];
                                msg2 = msgTokens[1];
                                msg3 = msgTokens[46];


                                if(heroes[userId]==null){
                                    usernum++;
                                    heroes[userId]= new Hero(userId,name,level,maxHealth,maxMana,attack,magic,skill,defense,mdefense,exp);
                                }
                                heroes[userId].setLevel(level);
                                heroes[userId].setMaxHealth(maxHealth);
                                heroes[userId].setCurrentHealth(currentHealth);
                                heroes[userId].setMaxMana(maxMana);
                                heroes[userId].setCurrentMana(currentMana);
                                heroes[userId].setExp(exp);
                                publishProgress(msg,msg2,msg3);

                            }
                        }
                        else if(output.contains("/monsterdata")) {
                            String delims = "[:]";
                            tokens = output.split(delims);
                            if (!tokens[25].contains("/end")) {
                                enemy.setHealth(Integer.parseInt(tokens[5]));
                                userId = Integer.parseInt(tokens[25]);
                                name = tokens[27];
                                level = Integer.parseInt(tokens[29]);
                                maxHealth = Integer.parseInt(tokens[31]);
                                currentHealth = Integer.parseInt(tokens[33]);
                                maxMana = Integer.parseInt(tokens[35]);
                                currentMana = Integer.parseInt(tokens[37]);
                                attack = Integer.parseInt(tokens[39]);
                                magic = Integer.parseInt(tokens[41]);
                                skill = Integer.parseInt(tokens[43]);
                                defense = Integer.parseInt(tokens[45]);
                                mdefense = Integer.parseInt(tokens[47]);
                                exp = Integer.parseInt(tokens[49]);

                                if(heroes[userId]==null){
                                    usernum++;
                                    heroes[userId]= new Hero(userId,name,level,maxHealth,maxMana,attack,magic,skill,defense,mdefense,exp);
                                }
                                heroes[userId].setLevel(level);
                                heroes[userId].setMaxHealth(maxHealth);
                                heroes[userId].setCurrentHealth(currentHealth);
                                heroes[userId].setMaxMana(maxMana);
                                heroes[userId].setCurrentMana(currentMana);
                                heroes[userId].setExp(exp);
                                publishProgress(msg, msg2);
                            }
                            else {
                                enemy.setHealth(Integer.parseInt(tokens[6]));
                                userId = Integer.parseInt(tokens[26]);
                                name = tokens[28];
                                level = Integer.parseInt(tokens[30]);
                                maxHealth = Integer.parseInt(tokens[32]);
                                currentHealth = Integer.parseInt(tokens[34]);
                                maxMana = Integer.parseInt(tokens[36]);
                                currentMana = Integer.parseInt(tokens[38]);
                                attack = Integer.parseInt(tokens[40]);
                                magic = Integer.parseInt(tokens[42]);
                                skill = Integer.parseInt(tokens[44]);
                                defense = Integer.parseInt(tokens[46]);
                                mdefense = Integer.parseInt(tokens[48]);
                                exp = Integer.parseInt(tokens[50]);

                                msgTokens = output.split("\n");
                                Log.i("net",msgTokens[0]);
                                Log.i("net",msgTokens[1]);
                                msg = msgTokens[0];
                                msg2 = msgTokens[1];

                                if(heroes[userId]==null){
                                    usernum++;
                                    heroes[userId]= new Hero(userId,name,level,maxHealth,maxMana,attack,magic,skill,defense,mdefense,exp);
                                }
                                heroes[userId].setLevel(level);
                                heroes[userId].setMaxHealth(maxHealth);
                                heroes[userId].setCurrentHealth(currentHealth);
                                heroes[userId].setMaxMana(maxMana);
                                heroes[userId].setCurrentMana(currentMana);
                                heroes[userId].setExp(exp);
                                publishProgress(msg, msg2);

                            }
                        }

                        else if(output.contains("/herodata")){

                            String delims= "[:]";
                            tokens=output.split(delims);
                            userId=Integer.parseInt(tokens[1]);
                            name=tokens[3];
                            level=Integer.parseInt(tokens[5]);
                            maxHealth=Integer.parseInt(tokens[7]);
                            currentHealth=Integer.parseInt(tokens[9]);
                            maxMana=Integer.parseInt(tokens[11]);
                            currentMana=Integer.parseInt(tokens[13]);
                            attack=Integer.parseInt(tokens[15]);
                            magic=Integer.parseInt(tokens[17]);
                            skill=Integer.parseInt(tokens[19]);
                            defense=Integer.parseInt(tokens[21]);
                            mdefense=Integer.parseInt(tokens[23]);
                            exp=Integer.parseInt(tokens[25]);

                            if(heroes[userId]==null){
                                usernum++;
                                heroes[userId]= new Hero(userId,name,level,maxHealth,maxMana,attack,magic,skill,defense,mdefense,exp);
                            }
                            else{
                                heroes[userId].setLevel(level);
                                heroes[userId].setMaxHealth(maxHealth);
                                heroes[userId].setCurrentHealth(currentHealth);
                                heroes[userId].setMaxMana(maxMana);
                                heroes[userId].setCurrentMana(currentMana);
                                heroes[userId].setExp(exp);
                                heroes[userId].setName(name);
                                heroes[userId].setAttack(attack);
                                heroes[userId].setMagic(magic);
                                heroes[userId].setDefense(defense);
                                heroes[userId].setMdefense(mdefense);

                            }
                            publishProgress(msg,msg2);
                        }

                        else {
                            if(!output.contains("Mdefense")) {
                                msg = output;
                                publishProgress(msg);
                            }
                        }
                        Log.i("Net",msg);

                    } else if (key.isAcceptable()) {

                    }
                }
                keyIterator.remove();
                if (flagLoop == 1) break;
            }
            return true;
        }
        @Override
        protected void onProgressUpdate(String... progress) {
            world.updateMonster(enemy.getName());
            world.updateHealthbars();
            msg=msg.trim();
            msg2=msg2.trim();
            msg3=msg3.trim();
            if(msg!="" ){
                world.listMessages.add(msg);
            }
            if(msg2!=""){
                world.listMessages.add(msg2);
            }
            if(msg3!=""){
                world.listMessages.add(msg3);
            }
            if(msg4!=""){
                world.listMessages.add(msg4);
            }
            if(msg5!=""){
                world.listMessages.add(msg5);
            }
            if(msg6!=""){
                world.listMessages.add(msg6);
            }
            if(msg7!=""){
                world.listMessages.add(msg7);
            }
            if(msg8!=""){
                world.listMessages.add(msg8);
            }
            if(msg9!=""){
                world.listMessages.add(msg9);
            }
            if(msg10!=""){
                world.listMessages.add(msg10);
            }
            if(msg11!=""){
                world.listMessages.add(msg11);
            }
            world.adapter.notifyDataSetChanged();

        }

        public void SetParent(MainChat k) {
            world = k;
        }
    }
    public final static String EXTRA_MESSAGE="msg";
    private Button button_send;
    Hero[] heroes= new Hero[20];
    Enemy enemy= new Enemy();
    int userId;
    String name;
    int level;
    int maxHealth;
    int currentHealth;
    int maxMana;
    int monsterMax=0;
    int currentMana;
    int attack;
    int magic;
    int skill;
    int defense;
    int character=0;
    int mdefense;
    int usernum=4;
    int exp;
    String area;
    int battlemode=0;
    ProgressBar hpBar,mpBar;
    String[] tokens;
    String[] msgTokens;
    ImageView monsterview;
    ImageView iv;


    String[] monsterTokens;

    public ArrayList<String> listMessages= new ArrayList<String>();
    public ArrayAdapter<String> adapter;

    NetworkTask n =new NetworkTask();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chat);
        iv = (ImageView) findViewById(R.id.id_iv_imgchat);
        monsterview = (ImageView) findViewById(R.id.id_iv_monsterchat);

        button_send=(Button) findViewById(R.id.id_button_send);
        button_send.setOnClickListener(this);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listMessages);
        hpBar= (ProgressBar)findViewById(R.id.hpBar);
        mpBar= (ProgressBar)findViewById(R.id.mpBar);
        ListView lv= (ListView) findViewById(R.id.id_lv_list);
        lv.setAdapter(adapter);
        n.SetParent(this);
        //n.SetActivity(this);
        n.execute();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_chat, menu);
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
        if (v.getId() == button_send.getId()) {
            EditText et = (EditText) findViewById(R.id.id_edit_text);
            String str = et.getText().toString();
            listMessages.add(str);
            adapter.notifyDataSetChanged();
            n.SendToServer(str);



            //TextView tv=(TextView) findViewById(R.id.id_tv_text);
            //tv.setText(str);
            // TextView tv=(TextView) findViewById(R.id.id_tv_text);
            //tv.setText("Button Pressed");
        }






    }

    public void printToast(String s){
        Toast.makeText(this,s,Toast.LENGTH_LONG).show();
    }
    public void updateMonster(String s){
        if(battlemode==1) {
            int id = getResources().getIdentifier(s.toLowerCase(), "drawable", getPackageName());
            monsterview.setImageResource(id);
            monsterview.invalidate();
        }
        else{
            monsterview.setImageResource(R.drawable.warning);
            monsterview.invalidate();
        }
    }
    public void updateHero(String s){
        int id = getResources().getIdentifier(s.toLowerCase(), "drawable", getPackageName());
        iv.setImageResource(id);
        iv.invalidate();
    }
    public void updateHealthbars(){
        if(battlemode==1) {
            if(enemy!=null) {
                mpBar.setMax(monsterMax);
                mpBar.setProgress(enemy.getHealth());
                mpBar.setVisibility(View.VISIBLE);
                mpBar.invalidate();
                if (heroes[character] != null) {
                    hpBar.setMax(heroes[character].getMaxHealth());
                    hpBar.setProgress(heroes[character].getCurrentHealth());
                    hpBar.setVisibility(View.VISIBLE);
                    hpBar.invalidate();
                }
            }
        }
        else{
            mpBar.setMax(100);
            mpBar.setProgress(100);
            hpBar.setMax(100);
            hpBar.setProgress(100);
            hpBar.setVisibility(View.INVISIBLE);
            mpBar.setVisibility(View.INVISIBLE);
            hpBar.invalidate();
            mpBar.invalidate();
        }
    }
    public void ChangeHero(View view)  {
            if(battlemode==0){
                Intent intent = new Intent(this, ChangeHero.class);
                startActivityForResult(intent,1);
            }
             else{
                Intent intent = new Intent(this, HeroStats.class);
                String message=heroes[character].getName()+":"+heroes[character].getLevel()+":"+heroes[character].getMaxHealth()+":"+heroes[character].getCurrentHealth()+":"+heroes[character].getMaxMana()+":"+heroes[character].getCurrentMana()+":"+heroes[character].getAttack()+":"+heroes[character].getMagic()+":"+heroes[character].getSkill()+":"+heroes[character].getDefense()+":"+heroes[character].getMdefense()+":" +heroes[character].getExp()+":";
                intent.putExtra(EXTRA_MESSAGE,message);
                startActivity(intent);

            }

    }
    public void ChangeMonster(View view){
        if(battlemode==0){
            Intent intent = new Intent(this, SelectArea.class);
            startActivityForResult(intent,2);
        }
        else{
            Intent intent = new Intent(this, MonsterStats.class);
            String message=monsterTokens[1]+":"+monsterTokens[3]+":"+enemy.getHealth()+":"+monsterTokens[7]+":"+monsterTokens[9]+":"+monsterTokens[11]+":"+monsterTokens[13]+":"+monsterTokens[15]+":"+monsterTokens[17]+":"+monsterTokens[19]+":"+monsterTokens[21]+":"+monsterTokens[23]+":"+area+":"+monsterMax;
            Log.i("woof",message);
            intent.putExtra(EXTRA_MESSAGE,message);
            startActivity(intent);

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == 1) {

                updateHero(data.getStringExtra(EXTRA_MESSAGE));
                String str = "/id "+ data.getStringExtra(EXTRA_MESSAGE);
                n.SendToServer(str);

            }
        }
        else if(requestCode==2){
            if(resultCode==1){
                area=data.getStringExtra(EXTRA_MESSAGE);
                String str = "/battle /"+ data.getStringExtra(EXTRA_MESSAGE);
                n.SendToServer(str);

            }
        }
    }
}