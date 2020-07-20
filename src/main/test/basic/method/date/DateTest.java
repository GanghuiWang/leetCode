package basic.method.date;


import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date time1=new Date();
        System.out.println(time1);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd:hh-mm-ss");
        System.out.println(sdf.format(time1));
        System.out.println(time1.toString().split(":",-1)[0]);
        String strings[]=time1.toString().split(" ");
        for (int i = 0; i <strings.length ; i++) {
            System.out.print(strings[i]+" ");
        }
    }
}
