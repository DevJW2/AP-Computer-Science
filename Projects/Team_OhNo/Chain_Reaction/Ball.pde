class Ball {
  float x;
  float y;
  float rad;
  color c;
  float dx;
  float dy;
  float state;
  boolean stop;



Ball(){
  x=random(width);
  y=random(height);
  rad = 10;
  c =color(random(256),random(256),random(256));
  dx=random(-5,5);
  dy=random(-5,5);
  state = 0;
  stop = false;
}

Ball(int xcor, int ycor){
  x=xcor;
  y=ycor;
  rad = 10;
  c =color(random(256),random(256),random(256));
  dx=random(-5,5);
  dy=random(-5,5);
  state = 0;
  stop = false;
}

void move(){

  x=x+dx;
  y=y+dy;
  bounce();
  
}

void bounce(){
  if (x>=width || x <= 0) dx=dx*-1;
  else if (y>=height || y <= 0) dy =dy*-1;
  
}

void display(){
  fill(c);
  stroke(c);
  ellipse (x,y,rad + 10,rad + 10);
  
  
}

float x_position(){
  return x;
}

float y_position(){
  return y;
}



void changeState(){
  state = 1; 
}
float getState(){
   return state;
}

void reaction(){
  System.out.println(rad);
  if(state == 1 && !stop){
    rad += 1;
    if(rad >= 150){
      stop = true;
     }
  }
  else{
    rad -= 1;
  }
  ellipse(x,y,rad,rad);
    
}

void checkCollided(){
  for(int i = 0; i < balls.size(); i++){
      if(dist(balls.get(i).x_position(),balls.get(i).y_position(),x,y) <= balls.get(i).getRad() + rad){
        balls.get(i).changeState();
        
      }
  
  }
}

float getRad(){
  return rad;
  
}



}