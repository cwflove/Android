package git.example.dell.androidcode.asynctaskutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author 陈伟飞
 * @date 2019/1/23.
 * @function
 */
public class StreamToString {
    public static String streamTostr(InputStream inputStream, String chartSet){
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String con;
        try {
            while((con=reader.readLine())!=null){
                StringBuilder append = builder.append(con);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
