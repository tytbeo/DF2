/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadlesson;

/**
 *
 * @author Phuc
 */
public class CountDown extends Thread {
    @Override
    public void run(){
        for(int i=10;i>0;i--){
            try {
                System.out.println(i + "  left");
                if(i==1){
                    Thread.sleep(1000);
                    System.out.println("bum bum pew pew");
                }
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
