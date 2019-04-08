package trum;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Phuc
 */
public class SNTController  {
    public Button conform;
    public TextField inputText;
    public TextArea panee;
    public Integer a;
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
    public void submit(){
        String ccc= "hãy nhập 1 số lớn hơn 1";
          if(inputText.getText().isEmpty()){
              panee.setText(ccc);
              return;
          }
          else{
            String str ="";
            String input;
            input =  inputText.getText().trim();
            try {
                a = Integer.parseInt(input);
            }
            catch(NumberFormatException e){
                panee.setText("chỉ được nhập số, không được nhập kí tự");
                return;
            }
            for(int i=2;i<=a;i++){
                if(this.isSoNguyenTo(i)){
                    str += i +"\n";
                }
             }
            panee.setText(str);
          }
            
            
    }
        
        

}
