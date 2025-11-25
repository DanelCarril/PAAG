/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm;

/**
 *
 * @author carril.danel
 */
public class Child implements Runnable {
    String type;
    Atm atm = new Atm();
    
    public Child (String type, Atm atm) {
        this.type = type;
        this.atm = atm;
    }
    
    public void run() {
        while (true) {
            int cantidad = (int) (Math.random() * 200);
            try {
                atm.withdraw(cantidad, type);
            } catch (InterruptedException e) {}
        }
    }
}
