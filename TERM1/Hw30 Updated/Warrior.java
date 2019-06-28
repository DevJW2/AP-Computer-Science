public class Warrior{
    private String name;
    private int health;
    private int strength;
    private int defense;
    private double atkRating;
    public Warrior(String input) {
       name = input;
       health = 100;
       strength = 10;
       defense = 10;
       atkRating = 1.5;
   }
   public boolean isAlive() {
       return (health > 0);
   }
   public int getDefense() {
       return defense;
   }
   public String getName() {
       return name;
   }
   public void lowerHP(int dec) {
       health -= dec;
   }
   public int attack(Monster mons) {
       int damage;
       damage =(int)( (strength*atkRating) - mons.getDefense());
       mons.lowerHP(damage);
       return damage;
   }
   public void specialize() {
       defense = (int) (defense *  0.5);
       atkRating *= 2;
   }
   public void normalize() {
       defense  = 10;
       atkRating = 1.5;
   }
}
