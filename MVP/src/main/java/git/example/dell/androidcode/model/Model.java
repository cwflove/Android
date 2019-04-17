package git.example.dell.mvp.model;

import android.util.Log;

import git.example.dell.mvp.contract.Contract;
import git.example.dell.mvp.asynctaskutils.AsyncTaskUtils;

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
