
package game;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    protected float x, y;
    protected ID id;
    protected float velX, velY;
    
    public GameObject(int x, int y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();
    
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return (int)this.x;
    }
    public void setId(ID id){
        this.id = id;
    }
    
    public ID getId(){
        return this.id;
    }
    public int getY(){
        return (int)this.y;
    }
    public void setVelX(int velX){
        this.velX = velX;
    }
    public void setVelY(int velY){
        this.velY = velY;
    }
    
    public int getVelX(){
        return (int)this.velX;
    }
    public int getVelY(){
        return (int)this.velY;
    }
}
