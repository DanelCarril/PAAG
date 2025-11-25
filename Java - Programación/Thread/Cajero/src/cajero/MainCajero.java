/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cajero;
/**
 *
 * @author carril.danel
 */
public class MainCajero {
    public static void main(String[] args) {
        int cajeros = 2;
        Cajero cajero = new Cajero(cajeros);
        
        int idCliente = 1;
        while (true) {
            Cliente c = new Cliente(idCliente++, cajero);
            c.start();
            
            try {
                int tiempo = (int) (1000 + Math.random() * 1000);
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
    
}
