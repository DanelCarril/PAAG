/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package boardgameroom;

/**
 *
 * @author carril.danel
 */
public class Mus {
    boolean[] sillas;
    int libres = 4;
    
    public Mus(int kop) {
        this.sillas = new boolean[kop];
    }
    
    public synchronized int entersMus (int id) throws InterruptedException {
        while(true) {
            for (int i = 0; i < sillas.length; i++) {
                if (!sillas[i]) {
                    sillas[i] = true;
                    libres--;
                    System.out.println("Player " + id + " is in Mus waiting. Places left --> " + libres);
                    
                    if (!sillas[3]) {
                        wait();
                    }
                    
                    notifyAll();
                    return i;
                }
            }
            System.out.println("Player " + id + " is leaving, no places in Mus. Places left --> " + libres);
            return -1;
        }
    }
    
    public synchronized void leavesMus(int id, int tokia) {
        sillas[tokia] = false;
        libres++;
        System.out.println("Player " + id + " is leaving Mus. Places left --> " + libres);
        notifyAll();
    }
}
