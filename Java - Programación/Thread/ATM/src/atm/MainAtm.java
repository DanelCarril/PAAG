/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atm;

/**
 *
 * @author carril.danel
 */

public class MainAtm {
    public static void main(String[] args) {
        Atm atm = new Atm(2000);

        Thread dad = new Thread(new Parents("dad", atm));
        Thread mom = new Thread(new Parents("mom", atm));
        Thread c1 = new Thread(new Child("child1", atm));
        Thread c2 = new Thread(new Child("child2", atm));

        dad.start();
        mom.start();
        c1.start();
        c2.start();
    }
}

