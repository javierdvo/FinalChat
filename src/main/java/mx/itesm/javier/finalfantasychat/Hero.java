package mx.itesm.javier.finalfantasychat;

/**
 * Created by Javier on 6/12/2015.
 */
public class Hero {
    int userId;
    String name;
    int level;
    int maxHealth;
    int currentHealth;
    int maxMana;
    int currentMana;
    int attack;
    int magic;
    int skill;
    int defense;
    int mdefense;
    int exp;
    public Hero(){
        userId=0;
        name="Default";
        level=1;
        maxHealth=50;
        currentHealth=50;
        maxMana=10;
        currentMana=10;
        attack=15;
        magic=15;
        skill=15;
        defense=150;
        mdefense=150;
        exp=0;
    }
    public Hero(int user,String name,int lvl, int hp,int mp, int atk, int mag,int skl,int def, int mdef, int xp){
        userId=user;
        this.name=name;
        level=lvl;
        maxHealth=hp;
        currentHealth=hp;
        maxMana=mp;
        currentMana=mp;
        attack=atk;
        magic=mag;
        skill=skl;
        defense=def;
        mdefense=mdef;
        exp=xp;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMdefense() {
        return mdefense;
    }

    public void setMdefense(int mdefense) {
        this.mdefense = mdefense;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
}
