/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boardgameroom;

/**
 *
 * @author carril.danel
 */
public class Player implements Runnable {
    int id;
    Chess chess;
    Mus mus;
    
    public Player(int id, Chess chess, Mus mus) {
        this.id = id;
        this.chess = chess;
        this.mus = mus;
    }
    
    public int getId() {
        return id;
    }
    
    public void run() {
        System.out.println("Player " + id + " has arrived");
        try {
            int decision = (int) (0 + Math.random()*1000);
            
            if (decision < 500) {
                int miSitio = -1;
                miSitio = chess.entersChess(id);
                if (miSitio != -1) {
                    System.out.println("Player " + id + " is playing Chess");
                    Thread.sleep(4000);
                    chess.leavesChess(id, miSitio);
                }
            } else {
                int miSitio = -1;
                miSitio = mus.entersMus(id);
                if (miSitio != -1) {
                    System.out.println("Player " + id + " is playing Mus");
                    Thread.sleep(4000);
                    mus.leavesMus(id, miSitio);
                }
            }
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
