package cn.itrock.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {


    public Date convert(String source) {


        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {

            System.out.println(1);
            return format.parse(source);
        } catch (ParseException e) {
            System.out.println(2);
           format=new SimpleDateFormat("yyyy-MM-dd HH:mm");

            try {
                System.out.println(3);
                return format.parse(source);
            } catch (ParseException e1) {
                System.out.println(4);
                e1.printStackTrace();
            }
        }

        return null;
    }
}
