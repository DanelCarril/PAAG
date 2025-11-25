/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

import static java.lang.Thread.sleep;

/**
 *
 * @author carril.danel
 */
public class Cliente extends Thread {
    private final int id;
    private final Cajero cajero;
    
    public Cliente(int id, Cajero cajero) {
        this.id = id;
        this.cajero = cajero;
    }
    
    @Override
    public void run() {
        int miCajero = -1;
        
        try {
            System.out.println("Ha llegado cliente " + id);
            miCajero = cajero.entrar(id);
            
            int tiempo = (int) (1000 + Math.random() * 4000); // 1-4s
            Thread.sleep(tiempo);
            
            cajero.salir(id, miCajero);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Cliebnte " + id + " interrumpido.");
            
            if (miCajero != -1) {
                cajero.salir(id, miCajero);
            }
        }
    }
}
