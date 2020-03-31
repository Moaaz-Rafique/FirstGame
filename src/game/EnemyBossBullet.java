package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{
    Handler handler; 
    Random r = new Random();
    public EnemyBossBullet(int x, int y, ID id, Handler handler) {
        super(x, y, id);        
        this.handler = handler;
        
        velX = r.nextInt(10)-5;
        velY = 5;
        
    }    

    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
    
    public void tick() {
        x += velX;
        y += velY;
        if(y<0 || y>Game.HEIGHT-48) handler.removeObject(this);
        //if(x<0 || x>Game.WIDTH-32)velX*=-1;
        handler.addObject(new Trail((int)x ,(int)y, ID.Trail, Color.red, 16, 16, 0.02f,handler));
        
    }

    public void render(Graphics g) {        
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);
    }
    
}
