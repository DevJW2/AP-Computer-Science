//Team_OhNo - Jeffrey Weng, Eric Li
//APCS2 pd3
//Hw40 -- All That Bouncin'
//2017-05-13

ArrayList<Ball> balls = new ArrayList<Ball>();  
boolean reactionStarted;
boolean click;


void setup(){
   size(600,600); 
  for (int i= 0; i< 25;i++) balls.add(new Ball());
  reactionStarted = false;
  click=false;
}


void draw(){
  background(0);
  for(int i=0 ; i < balls.size();i++){
    balls.get(i).display(); // display
    if (balls.get(i).getRad() <= 0){
      balls.remove(i);  
      if(i != 0){
      i--;
      }
    }
    if(reactionStarted){
      if(balls.size() != 0){
      if(balls.get(i).getState() == 1){
          balls.get(i).checkCollided();
          balls.get(i).reaction();
      }
 
           else{
             balls.get(i).move();
           }
    }
    }
    else{
      balls.get(i).move();
    }
    
  }
}

void mouseClicked(){
  if (click) return;
  else{
  balls.add(new Ball(mouseX,mouseY));
  balls.get(balls.size()-1).changeState();
  reactionStarted = true;
  click=true;
  }
}
 
  