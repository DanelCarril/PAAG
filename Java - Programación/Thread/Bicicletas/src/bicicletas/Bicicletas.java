/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bicicletas;

/**
 *
 * @author carril.danel
 */
public class Bicicletas {
    boolean[] ocupadas;
    
    public Bicicletas(int kop) {
        this.ocupadas = new boolean[kop];
    }
    
    public synchronized int entra(int id) throws InterruptedException {
        while(true) {
            for (int i = 0; i < ocupadas.length; i++) {
                if(!ocupadas[i]) {
                    ocupadas[i] = true;
                    System.out.println("Cliente " + id + " alquila bici");
                    return i;
                }
            }
            System.out.println("Cliente " + id + " se va porque no hay bicis");
            return -1;
        }
    }
    
    public synchronized void sale(int id, int bici) {
        ocupadas[bici] = false;
        System.out.println("Cliente " + id + " deja la bici y se va");
    }
}
