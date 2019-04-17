/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutual_Exclusive;

/**
 *
 * @author Phuc
 */
public class ThreadFindSNT extends Thread{
    String nameThread;
    int timeSleep;
    /**
     * this method has 3 required parameter, see more:
     * @param nameThread
     *  need to pass parameter nameThread, name of thread
     * @param timeSleep 
     *  need to pass parameter timeSleep, time sleep of thread
     */
    public ThreadFindSNT(String nameThread, int timeSleep) {
        this.nameThread = nameThread;
        this.timeSleep = timeSleep;
    }
    
    
    @Override
    public void run(){
        
        for(int i = 0; i<10;i++){
                try {
                        Thread.sleep(timeSleep);
                        
                    } catch (InterruptedException e) {
                    }
                System.out.println(nameThread + " : " + resources.timSoNguyenToTiepTheo());
                
            }
        
    }
}
