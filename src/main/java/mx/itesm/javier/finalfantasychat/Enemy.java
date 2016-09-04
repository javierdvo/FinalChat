package mx.itesm.javier.finalfantasychat;

/**
 * Created by Javier on 6/12/2015.
 */
public class Enemy {
    String name;
    int level;
    int Health;
    int mage;
    int strength;
    int weakness;
    int attack;
    int magic;
    int skill;
    int defense;
    int mdefense;
    int exp;
    public Enemy(){
        name="Default";
        level=1;
        Health=500;
        mage=0;
        strength=0;
        weakness=0;
        attack=150;
        magic=150;
        skill=0;
        defense=150;
        mdefense=150;
        exp=0;
    }
    public Enemy(String name,int lvl, int hp,int mage, int atk, int mag,int skl,int def, int mdef, int strong,int weak, int xp){
        this.name=name;
        level=lvl;
        Health=hp;
        attack=atk;
        magic=mag;
        weakness=weak;
        strength=strong;
        this.mage=mage;
        skill=skl;
        defense=def;
        mdefense=mdef;
        exp=xp;
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

    public int getHealth() {
        return Health;
    }

    public void setHealth(int health) {
        Health = health;
    }

    public int getMage() {
        return mage;
    }

    public void setMage(int mage) {
        this.mage = mage;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWeakness() {
        return weakness;
    }

    public void setWeakness(int weakness) {
        this.weakness = weakness;
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
