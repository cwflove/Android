package git.example.dell.mvp.asynctaskutils;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 陈伟飞
 * @date 2019/1/23.
 * @function
 */
public class AsyncTaskUtils extends AsyncTask<String,Void,String> {
    //申请一个接口类对象
    private Icallbacks icallbacks;
    //将无参构造设置成私有的，使之在外部不能够调用
    private AsyncTaskUtils(){}
    //定义有参构造方法
    public AsyncTaskUtils(Icallbacks icallbacks){
            this.icallbacks=icallbacks;
            }
    @Override
    protected String doInBackground(String...params){
        String str="";
            try{
                //使用HttpUrlConnection
                URL url=new URL(params[0]);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                int code=connection.getResponseCode();
                if(code==200){
                    InputStream stream=connection.getInputStream();
                    //调用工具类中的静态方法
                    str= StreamToString.streamTostr(stream,"utf-8");
                }
            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
            return str;
    }
    @Override
    protected void onPostExecute(String s){
        super.onPostExecute(s);
        //解析，封装到bean，更新UI组件
        icallbacks.updataUiByjson(s);
    }

    //定义一个接口
    public interface Icallbacks {
        //根据回传的json字符串，解析并更新页面组件
        void updataUiByjson(String jsonstr);
    }

}


