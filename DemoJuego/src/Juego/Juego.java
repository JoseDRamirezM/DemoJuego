/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Constructores.ConstructorElfo;
import Constructores.ConstructorHumano;
import Graficos.Frame;
import Graficos.Sprite;
import Personajes.Personaje;



public class Juego {

    public static void main(String args[]){
        Personaje p1 = new Personaje();
        Personaje p2 = new Personaje();
        
        ConstructorElfo e = new ConstructorElfo();
        e.consruirPersonaje();
        e.construirPartes();
        p1 = e.getPersonaje();
        
        ConstructorHumano h = new ConstructorHumano();
        h.consruirPersonaje();
        h.construirPartes();
        p2 = h.getPersonaje();
        
        Sprite s = new Sprite(p1.getImgDir(), p2.getImgDir());
        Frame f = new Frame();
    }
}
