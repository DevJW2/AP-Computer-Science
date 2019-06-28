// Team JIM: Jeffrey Weng, Irene Lam, Mark Shafran
// APCS1 pd05
// HW30 -- Ye Old Role Playing Game
// 2016-11-17   

public class Warrior extends Character{
    public String name;
    public Warrior(String input) {
	name = input;
	HP = 100;
	strength = 20;
	defense = 20;
	atkRating = 0.5;
    }
    public String getName() {
	return name;
    }
    public void specialize() {
	defense = (int) (defense *  0.5);
	atkRating *= 2;
    }
    public void normalize() {
	defense  = 10;
        atkRating = 0.5;
    }
}
