/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class Frame extends JFrame {
    
    public Frame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Juego");
        this.setResizable(false);
        this.setVisible(true);
    }
    
}
