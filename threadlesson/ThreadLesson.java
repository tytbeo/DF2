/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadlesson;

import java.util.ArrayList;

/**
 *
 * @author Phuc
 */
public class ThreadLesson {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread subThread = new Thread(new Runnable() {
            boolean isSoNguyenTo(int x){
            int count = 0;
            for (int i = 1;i <= x; i++){

                if (x%i==0){
                        count++;
                    }
            }
            if (count == 2){
                    return true;
                }
                else {
                    return false;
                }
        }
        ArrayList<Integer> SNT = new ArrayList<>();
            @Override
            public void run() {
                for(int i = 0 ; SNT.size()<11 ;i++){
                    try {
                        if(isSoNguyenTo(i)){
                            SNT.add(i);
                            System.out.println("snt: "+i);
                            Thread.sleep(1500);
                        }
                        
                    } catch (Exception e) {
                    }
                    
                }
            }
        });
        subThread.setName("myJavaThread ");
        System.out.println(subThread.getName());
        CountDown count = new CountDown();
        count.start();
        subThread.start();
        
        
    }
    
}
