/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bicicletas;

/**
 *
 * @author carril.danel
 */
public class MainBicicletas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bicicletas bicicletas = new Bicicletas(5);
        
        try {
            for (int i = 1; i <= 20; i++) {
                Thread cliente = new Thread(new Cliente(i, bicicletas));
                cliente.start();
                int tiempo = (int) (0 + Math.random()*500);
                Thread.sleep(tiempo);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
}
