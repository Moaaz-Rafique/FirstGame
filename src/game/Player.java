package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObject {

    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        x = Game.clamp((int)x, 0, Game.WIDTH - 38);
        y = Game.clamp((int)y, 0, Game.HEIGHT - 62);        
        collision();
    }

    private void collision(){
        for(int i =0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy || tempObject.getId() == ID.SmartEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //Collision code
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
    
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, 32, 32);
    }
}
