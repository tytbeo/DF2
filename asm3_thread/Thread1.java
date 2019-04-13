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
public class Thread1 extends Thread{
    @Override
    public void run(){
        for(int i =1;i<50;i++){
            try {
                System.out.println(" Thread 1: "+i);
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            
        }
    }
}
