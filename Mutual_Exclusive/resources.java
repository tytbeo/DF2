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
public class resources {
    static int currentNum = 1;
    static boolean isSoNguyenTo(int x){
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
    static synchronized int timSoNguyenToTiepTheo(){
        

        for ( int i = resources.currentNum+ 1 ; ; i++){
        
            if ( resources.isSoNguyenTo(i) ){
                    resources.currentNum = i;
                    break;
                }
        }
        return resources.currentNum;
    }
}
