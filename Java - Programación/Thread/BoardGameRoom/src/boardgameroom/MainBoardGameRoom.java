/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package boardgameroom;

/**
 *
 * @author carril.danel
 */
public class MainBoardGameRoom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Chess chess = new Chess(2);
        Mus mus = new Mus(4);
        
        for (int i = 1; i <= 20; i++) {
            Thread player = new Thread(new Player(i, chess, mus));
            player.start();
            
            try {
                int tiempo = (int)(1000 + Math.random()*4000);
                Thread.sleep(tiempo);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
