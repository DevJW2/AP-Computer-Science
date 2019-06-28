public class Ranger extends Character {
    public Ranger(){
	_hitPts = 130;
	_strength = 80;
	_defense = 30;
	_attack = 0.4;
    }
    public Ranger(String name){
	this();
	_name = name;
    }

    public void specialize() {
	_attack = .75;
	_defense = 15;
    }

    //revert to normal mode
    public void normalize() {
	_attack = .4;
	_defense = 30;
    }
}