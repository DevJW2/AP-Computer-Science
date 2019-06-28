public class Rogue extends Character {
    public Rogue(){
	_hitPts = 100;
	_strength = 90;
	_defense = 20;
	_attack = 1.5;
    }
    public Rogue(String name){
	this();
	_name = name;
    }

    public void specialize() {
	_attack = 1.85;
	_defense = 10;
    }

    //revert to normal mode
    public void normalize() {
	_attack = 1.5;
	_defense = 20;
    }
}