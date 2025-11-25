/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bicicletas;

/**
 *
 * @author carril.danel
 */
public class Cliente implements Runnable {
    int id;
    Bicicletas bicicletas;
    
    public Cliente (int id, Bicicletas bicicletas) {
        this.id = id;
        this.bicicletas = bicicletas;
    }
    
    public void run() {
        int miBici = -1;
        
        try {
            miBici = bicicletas.entra(id);
            if (miBici != -1) {
                System.out.println("Cliente " + id + " esta usando la bici");
            
                int tiempo = (int) (1000 + Math.random()*3000);
                Thread.sleep(tiempo);

                bicicletas.sale(id, miBici);
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
