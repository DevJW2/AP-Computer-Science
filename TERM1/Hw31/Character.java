public class Character {
    protected int HP;
    protected int strength;
    protected int defense;
    protected double atkRating;
    
    public boolean isAlive() {
	return (HP > 0);
    }
    public int getDefense() {
	return defense;
    }
    public void lowerHP(int dec) {
	HP -= dec;
    }
    public int attack(Character car) {
	int damage;
	damage =(int)( (strength*atkRating) - car.getDefense());
	car.HP -= damage;
	//System.out.println("HP = " + car.HP);
	return damage;
    }
}
