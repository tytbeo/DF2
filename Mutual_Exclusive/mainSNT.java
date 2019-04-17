/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mutual_Exclusive;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Phuc
 */
public class mainSNT {
    
    
    public static void main(String[] args) {
        ThreadFindSNT thread1 = new ThreadFindSNT("thread1",1000);
        thread1.start();
        ThreadFindSNT thread2 = new ThreadFindSNT("thread2",1100);
        thread2.start();
    }
}
