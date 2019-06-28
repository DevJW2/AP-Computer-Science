// Team JIM: Jeffrey Weng, Irene Lam, Mark Shafran
// APCS1 pd05
// HW30 -- Ye Old Role Playing Game
// 2016-11-17   

public class Monster extends Character{
    public Monster() {
	HP = 150;
	strength = (int)(Math.random()*45 + 20);
	defense = 20;
	atkRating = 1;
    }
}
