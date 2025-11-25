/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boardgameroom;

/**
 *
 * @author carril.danel
 */
public class Chess {
    //int idMesa;
    boolean[] ocupados;
    int kop;
    int libres = 2;
    
    public Chess(int kop) {
        //this.idMesa = idMesa;
        this.kop = kop;
        this.ocupados = new boolean[kop];
    }
    
    public synchronized int entersChess (int id) throws InterruptedException {
        while(true) {
            for (int i = 0; i < ocupados.length; i++) {
                if (!ocupados[i]) {
                    ocupados[i] = true;
                    libres--;
                    System.out.println("Player " + id + " is in Chess waiting. Places left --> " + libres);
                    
                    if (!ocupados[1]) {
                        wait();
                    }
                    
                    notifyAll();
                    return i;
                }
            }
            System.out.println("Player " + id + " is leaving, no places in Chess. Places left --> " + libres);
            return -1;
        }
    }
    
    public synchronized void leavesChess(int id, int tokia) {
        ocupados[tokia] = false;
        libres++;
        System.out.println("Player " + id + " is leaving Chess. Places left --> " + libres);
        notifyAll();
    }
}
