public class Paladin extends Character {
    public Paladin(){
	_hitPts = 125;
	_strength = 100;
	_defense = 50;
	_attack = 0.3;
    }
    public Paladin(String name){
	this();
	_name = name;
    }

    public void specialize() {
	_attack = 0.65;
	_defense = 25;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .3;
	_defense = 50;
    }
}