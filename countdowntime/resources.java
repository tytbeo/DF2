/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdowntime;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 *
 * @author Phuc
 */
public class resources {

    static int currentNum = 1;
    static LocalDate dateCount;
    static ZonedDateTime now = ZonedDateTime.now();
    static ZonedDateTime oldDate = now.minusMinutes(10);
    static Duration duration = Duration.between(oldDate, now);
    static long diff = duration.toMillis();

    

    static boolean isSoNguyenTo(int x) {
        int count = 0;
        for (int i = 1; i <= x; i++) {

            if (x % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    static synchronized int timSoNguyenToTiepTheo() {

        for (int i = resources.currentNum + 1;; i++) {

            if (resources.isSoNguyenTo(i)) {
                resources.currentNum = i;
                break;
            }
        }
        return resources.currentNum;
    }

    static String countDown() {
        diff -= 1000;
        String dateString = new SimpleDateFormat("mm:ss").format(new Date(diff));
        return dateString;
    }

}
