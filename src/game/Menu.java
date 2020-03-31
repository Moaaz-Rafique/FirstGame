package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends MouseAdapter{
    
    private Game game;
    private Handler handler;
    private HUD hud;
    private Random r;
    
    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        
        r = new Random();
        if(this.game.gameState == Game.STATE.Menu){
            //play button
            if(mouseOver(mx, my, 210, 150, 200, 64)){
                
            game.gameState = Game.STATE.Game;
            
            handler.addObject(new Player((Game.WIDTH/2),(Game.HEIGHT/2), ID.Player, handler));        
            handler.clearEnemys();
            handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));        
            }
            //help button
            if(mouseOver(mx, my, 210, 250, 200, 64)){
                this.game.gameState = Game.STATE.Help;
            }

            //quit button
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                System.exit(1);
            }
        }
        if(this.game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                this.game.gameState = Game.STATE.Menu;                
            }
        }
        if(this.game.gameState == Game.STATE.End){
            if(mouseOver(mx, my, 240, 350, 200, 64)){
                handler.clearEnemys();                
                game.gameState = Game.STATE.Game;
            
                handler.addObject(new Player((Game.WIDTH/2),(Game.HEIGHT/2), ID.Player, handler));        
                handler.clearEnemys();
                handler.addObject(new BasicEnemy( r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));                     
                hud.setScore(0);
                hud.setLevel(1);
            }
        }
    }
    public void mouseReleased(MouseEvent e){
        
    }
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;            
            }
        }
        return false;
    }
    
    public void tick(){
        
    }
    public void render(Graphics g){
        g.setColor(Color.white);
        Font fnt = new Font ("arial", 1,50);
        Font fnt2 = new Font ("arial", 1,30);
        if(game.gameState == Game.STATE.Menu){
            g.setFont(fnt);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);        
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 280, 190);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 280, 290);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 280, 390);
        }
        else if(game.gameState == Game.STATE.Help){
            g.setFont(fnt);
            g.drawString("Menu", 240, 70);
            g.setFont(fnt2); 
            g.drawString("Use WSAD keys to move", 150, 190);
            g.drawString("and", 250, 190);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 280, 390);
        }            
        else if(game.gameState == Game.STATE.End){
            g.setFont(fnt);
            g.drawString("You Died", 230, 70);
            g.setFont(fnt2); 
            g.drawString("Your final score is: " + hud.getScore(), 185, 190);            
            g.drawRect(240, 350, 200, 64);
            g.drawString("Try Again", 275, 390);
        } 
    }
}
