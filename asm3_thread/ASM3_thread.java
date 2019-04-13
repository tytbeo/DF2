/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm3_thread;

/**
 *
 * @author Phuc
 */
public class ASM3_thread {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread1 Thread1 = new Thread1();
        Thread1.start();
        runa runnable = new runa();
        Thread Thread2 = new Thread(runnable);
        Thread2.start();
        Thread Thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =1;i<50;i++){
                    try {
                        System.out.println(" Thread 3: "+i);
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }

                }
            }
        });
        Thread3.start();
        
    }
    
}
