/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savedata;

import java.util.ArrayList;

/**
 *
 * @author Phuc
 */
public class PersonModel <E> {
    ArrayList<human> danhSachN = new ArrayList<>();
    public void add(human e){
        danhSachN.add(e);
    }
    public void printOut(){
        for(human item : danhSachN){
            item.toStringg();
        }
    }
}
