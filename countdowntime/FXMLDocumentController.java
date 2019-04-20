/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdowntime;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 *
 * @author Phuc
 */
public class FXMLDocumentController implements Initializable {

    boolean stop = true;
    boolean stop2 = true;
    public Button snt1;
    public Button snt2;
    public TextArea snt3;
    public Button cd1;
    public Button cd2;
    public TextArea cd3;

    public void startSNT() {
        this.stop = false;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable update = new Runnable() {
                    @Override
                    public void run() {
                        String str;
                        str = (String) "mathletics-A fond : " + resources.timSoNguyenToTiepTheo();
                        snt3.setText(str);
                    }
                };
                while (!stop) {
                    try {
                        Thread.sleep(2000);
                        Platform.runLater(update);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable update = new Runnable() {
                    @Override
                    public void run() {
                        String str;
                        str = (String) "mathletics-B fond : " + resources.timSoNguyenToTiepTheo();
                        snt3.setText(str);
                    }
                };
                while (!stop) {
                    try {
                        Platform.runLater(update);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread1.setDaemon(true);
        thread1.start();
        thread2.setDaemon(true);
        thread2.start();
    }

    public void stopSNT() {
        this.stop = true;
    }

    public void startCD () {
        stop2 = false;
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Runnable update = new Runnable() {
                    @Override
                    public void run() {
                        cd3.setText(resources.countDown());
                    }
                };
                while (!stop2) {
                    try {
                        Thread.sleep(1000);
                        Platform.runLater(update);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        thread3.setDaemon(true);
        thread3.start();
    }

    public void stopCD () {
        stop2 = true;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
