public class Monster{
    private int monshealth;
    private int strength;
    private int defense;
    private double atkRating;
    public Monster() {
       monshealth = 150;
       strength = (int)(Math.random()*45 + 20);
       defense = 20;
       atkRating = 1;
   }
   public boolean isAlive() {
       return (monshealth > 0);
   }
   public int getDefense() {
       return defense;
   }
   public void lowerHP(int dec) {
       monshealth -= dec;
   }
   public int attack(Warrior war) {
       int damage;
       damage =(int)( (strength*atkRating) - war.getDefense());
       war.lowerHP(damage);
       return damage;
   }
}
