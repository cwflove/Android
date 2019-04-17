package git.example.dell.androidcode.model;

import android.util.Log;

import git.example.dell.androidcode.asynctaskutils.AsyncTaskUtils;
import git.example.dell.androidcode.contract.Contract;


/**
 * @author 陈伟飞
 * @date 2019/1/22.
 * @function Model请求网络数据
 */
public class Model {
    private Contract.Presenter mPresenter;
    public Model(Contract.Presenter presenter){
        mPresenter = presenter;
    }
    public void getWeather(String cityNumber){
        String url ="http://www.weather.com.cn/data/sk/" + cityNumber + ".html";
        new AsyncTaskUtils(new AsyncTaskUtils.Icallbacks() {
            @Override
            public void updataUiByjson(String jsonstr) {
                if (jsonstr != null) {
                    mPresenter.onSuccess(jsonstr);
                } else {
                    mPresenter.onError();
                }
                Log.d("chenweifeimvp", "updataUiByjson: +++++++++"+jsonstr);
            }
        }).execute(url);
    }
}
