/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;


import Control.Teclado;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author USUARIO
 */
public class Sprite extends JFrame implements Runnable {

    private int anchoVentana = 400;
    private int altoVentana = 400;    
    
    
    int x = 0,y = 0, x1 = 0, y1 = 0, velx = 0, vely = 0, velx1 = 0, vely1 = 0;
    
    private Image img;
    private Image img2;
    private Thread hilo;
    private BufferedImage bi;     
    private int incremento = 0;
    private static Teclado t;
    int i = 0;
    int posix = 0, posix1 = 0;
    int posiy = 64, posiy1 = 64;
    int frames = 8;
    
    public Sprite(String dir1, String dir2){
        this.setSize(anchoVentana, altoVentana);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Juego");
        this.setResizable(false);
        t = new Teclado();
        addKeyListener(t);
        hilo = new Thread(this);
        bi = new BufferedImage(anchoVentana, altoVentana, BufferedImage.TYPE_INT_RGB);        
        Toolkit herramienta;
        herramienta = Toolkit.getDefaultToolkit();
        img = herramienta.getImage(getClass().getResource(dir1));
        img2 = herramienta.getImage(getClass().getResource(dir2));
        hilo.start();       
        this.setVisible(true);
        
    }
    
    @Override
    public void paint(Graphics g) { 
        
        Graphics2D g2d;
        g.drawImage(bi,0 ,0 ,this);        
        g2d = (Graphics2D) bi.getGraphics();
        g2d.fillRect(0, 0 , anchoVentana, altoVentana);
        
        
        
        int mx = (incremento%frames)*64;
        int my = i; /*64;*///(incremento/13)*64; //multiplos de 64 de 0 a 1020
        
                
        g2d.drawImage(img, 200+x, 200+y, 200+64+x ,200+64+y, posix, posix, posiy, posiy ,this);
        g2d.drawImage(img2, 50+x1, 50+y1, 50+64+x1 , 50+64+y1, posix1, posix1, posiy1, posiy1 ,this);
        
        if((200+x)> anchoVentana-20 || (200+y)> altoVentana-20 || (200+x) < 20 || (200+y) < 20
                || (50+x1)> anchoVentana-5 || (50+y1)> altoVentana-5 || (50+x1) < 5 || (50+y1) < 5){
            x=0;
            y=0;
            x1 = 0;
            y1 = 0;
        }
        
        this.repaint(); 
        
        if(t.arriba){
            vely = -8;
            velx = 0;             
            posix = 0;
            posiy = 64;           
            i = 256;
            g2d.drawImage(img, 200+x, 200+y, 200+64+x ,200+64+y ,mx ,my ,mx+64 ,my+64 ,this);            
            this.repaint();            
            
            
        }else if(t.abajo){
            vely = 8;
            velx = 0;
          
            posix = 128;
            posiy = 192;
            i = 384;
            
            g2d.drawImage(img, 200+x, 200+y, 200+64+x ,200+64+y ,mx ,my ,mx+64 ,my+64 ,this);           
            this.repaint();
            
        } else if(t.derecha){
            vely = 0;
            velx = 8;          
            posix = 192;
            posiy = 256;
            i = 448;
            g2d.drawImage(img, 200+x, 200+y, 200+64+x ,200+64+y ,mx ,my ,mx+64 ,my+64 ,this);          
            this.repaint(); 
            
        }else if(t.izquierda){
            vely = 0;
            velx = -8;
           
            posix = 64;
            posiy = 128;
            i = 320;
            g2d.drawImage(img, 200+x, 200+y, 200+64+x ,200+64+y ,mx ,my ,mx+64 ,my+64 ,this);            
            this.repaint(); 
            
        }else if(t.atacar){            
            frames = 6;
            posix = 128;
            posiy = 192;
            i = 640;
            g2d.drawImage(img, 200+x, 200+y, 200+64+x ,200+64+y ,mx ,my ,mx+64 ,my+64 ,this);           
            this.repaint(); 
            
        }else if(t.arriba1){
            vely1 = -8;
            velx1 = 0;             
            posix1 = 0;
            posiy1 = 64;
            i = 256;
            g2d.drawImage(img2, 50+x1, 50+y1, 50+64+x1 , 50+64+y1 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint();
            
        }else if(t.abajo1){
            vely1 = 8;
            velx1 = 0;          
            posix1 = 128;
            posiy1 = 192;
            i = 384;
            g2d.drawImage(img2, 50+x1, 50+y1, 50+64+x1 , 50+64+y1 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint();
            
        }else if(t.derecha1){
            vely1 = 0;
            velx1 = 8;          
            posix1 = 192;
            posiy1 = 256;
            i = 448;
            g2d.drawImage(img2, 50+x1, 50+y1, 50+64+x1 , 50+64+y1 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint();
            
        }else if(t.izquierda1){
            vely1 = 0;
            velx1 = -8;
           
            posix1 = 64;
            posiy1 = 128;
            i = 320;
            g2d.drawImage(img2, 50+x1, 50+y1, 50+64+x1 , 50+64+y1 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint();
            
        }else if(t.atacar1){
            
            frames = 6;
            posix1 = 128;
            posiy1 = 192;
            i = 640;
            g2d.drawImage(img2, 50+x1, 50+y1, 50+64+x1 , 50+64+y1 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint();
            
        }
        
    }

    @Override
    public void run() {
        this.requestFocus();
        while(true){
            try { 
            t.actualizar();
            if(t.estado && !t.atacar){
                x += velx;
                y += vely;                
            }else if(t.estado1 && !t.atacar1){
                x1 += velx1;
                y1 += vely1;
            }            
            Thread.sleep(50);                        
            } catch (InterruptedException ex){
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            incremento++; 
               
            
            if(incremento > 221){
                incremento = 0;
            }
            
        }
    }
        
}
