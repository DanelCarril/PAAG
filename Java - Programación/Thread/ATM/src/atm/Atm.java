/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atm;

/**
 *
 * @author carril.danel
 */
public class Atm {
    int money;
    
    public Atm () {}
    
    public Atm (int money) {
        this.money = money;
    }
    
    public synchronized void deposit(int cantidad, String type) {
        money += cantidad;
        System.out.println(type + " deposited " + cantidad + "€");
        System.out.println("Current money: " + money);
        
        try {
            Thread.sleep(2000); // pausa 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // reinterrumpir el hilo
        }
    }
    
    public synchronized void withdraw(int cantidad, String type) throws InterruptedException {
        while (money - cantidad < 1) {
            return;
        }
        money -= cantidad;
        System.out.println(type + " has withdrawn " + cantidad + "€");
        System.out.println("Current money: " + money);
        try {
            Thread.sleep(2000); // pausa 2 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // reinterrumpir el hilo
        }
        notifyAll();
    }
}
