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

/**
 *
 * @author USUARIO
 */
public class Sprite extends JFrame implements Runnable {

    private int anchoVentana = 500;
    private int altoVentana = 400;    
    
    private Image img;
    private Image img2;
    private Thread hilo;
    private BufferedImage bi;
    private BufferedImage bi2;
    private int incremento = 0;
    private static Teclado t;
    int i = 0;
    int posix = 0;
    int posiy = 64;
    int frames = 8;
    
    public Sprite(){
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
        img = herramienta.getImage(getClass().getResource("/img/spriteElfo.png"));
        img2 = herramienta.getImage(getClass().getResource("/img/spriteElfo.png"));
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
        
                
        g2d.drawImage(img, 200, 200, 200+64 ,200+64, posix, posix, posiy, posiy ,this);
        g2d.drawImage(img2, 50, 50, 50+64 , 50+64, posix, posix, posiy, posiy ,this);
        this.repaint(); 
        
        if(t.arriba){
            posix = 0;
            posiy = 64;
            g2d.drawImage(img, 200, 200, 200+64 ,200+64, posix, posix, posiy, posiy ,this);
            i = 256;
            g2d.drawImage(img, 200, 200, 200+64 ,200+64 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint();            
            
            
        }else if(t.abajo){ 
            posix = 128;
            posiy = 192;
            i = 384;
            
            g2d.drawImage(img, 200, 200, 200+64 ,200+64 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint();
            
        } else if(t.derecha){
            posix = 192;
            posiy = 256;
            i = 448;
            g2d.drawImage(img, 200, 200, 200+64 ,200+64 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint(); 
            
        }else if(t.izquierda){
            posix = 64;
            posiy = 128;
            i = 320;
            g2d.drawImage(img, 200, 200, 200+64 ,200+64 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint(); 
            
        }else if(t.atacar){            
            frames = 6;
            posix = 128;
            posiy = 192;
            i = 640;
            g2d.drawImage(img, 200, 200, 200+64 ,200+64 ,mx ,my ,mx+64 ,my+64 ,this);
            this.repaint(); 
            
        }
        
    }

    @Override
    public void run() {
        this.requestFocus();
        while(true){
            try { 
            t.actualizar();
            Thread.sleep(80);             
            } catch (InterruptedException ex){
                Logger.getLogger(Sprite.class.getName()).log(Level.SEVERE, null, ex);
            }
            incremento++; 
               
            
            if(incremento > 221){
                incremento = 0;
            }
            
        }
    }
    
    public static void main (String[] args){
    
        Sprite s = new Sprite();
    }
}
