public class Mage extends Character {
    public Mage(){
	_hitPts = 90;
	_strength = 80;
	_defense = 30;
	_attack = 1;
    }
    public Mage(String name){
	this();
	_name = name;
    }

    public void specialize() {
    	System.out.println(_attack);
    	System.out.println(_defense);
	_attack = 1.35;
	_defense = 15;
    }

    //revert to normal mode
    public void normalize() {
	_attack = 1;
	_defense = 30;
    }
}