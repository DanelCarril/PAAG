/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cajero;

/**
 *
 * @author carril.danel
 */
public class Cajero {
    private final boolean[] ocupados;
    private int libres;
    
    public Cajero (int size) {
        this.ocupados = new boolean[size];
        this.libres = size;
    }
    
    public synchronized int entrar(int id) throws InterruptedException {
        while (true) {
            for (int i = 0; i < ocupados.length; i++) {
                if(!ocupados[i]) {
                    ocupados[i] = true;
                    System.out.println("Cliente " + id + " usando cajero");
                    return i;
                }
            }
            System.out.println("Cliente " + id + " esperando");
            wait();
        }
    }
    
    public synchronized void salir(int id, int sitio) {
        ocupados[sitio] = false;
        System.out.println("Cliente " + id + " se va");
        notifyAll();
    }
}
