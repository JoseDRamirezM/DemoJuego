/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graficos;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author USUARIO
 */
public class Frame extends JFrame {
    
    private String texto;
    private JLabel label;
    
    public Frame(){
        texto = "<HTML>  Instrucciones<br>"
                + "  Para controlar al humano utilizar las flechas y espacio para  atacar <br>"
                + "  Para controlar al elfo utilizar WASD y x para atacar</HTML>";
        label = new JLabel();
        label.setText(texto);
        this.add(label);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Juego");
        this.setResizable(false);
        this.setSize(500,300);
        this.setVisible(true);
    }
    
}
