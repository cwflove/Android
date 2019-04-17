package git.example.dell.androidcode.presenter;


import git.example.dell.androidcode.contract.Contract;
import git.example.dell.androidcode.model.Model;

/**
 * @author 陈伟飞
 * @date 2019/1/22.
 * @function Presenter做为Model与View交互的桥梁
 */
public class Presenter implements Contract.Presenter {

    private Contract.View mView;
    private final Model mModel;

    public Presenter (Contract.View view){
        mView = view;
        mModel = new Model(this);
    }

    /**
     * 通过Presenter把从View中获取的参数给Model
     * @param cityNumber
     */
    @Override
    public void getWeather(String cityNumber) {
        mModel.getWeather(cityNumber);
    }

    /**
     * 请求接口成功返回json串，通过P层把数据Model数据给View
     * @param jsonString
     */
    @Override
    public void onSuccess(String jsonString) {
        mView.onSuccess(jsonString);
    }

    @Override
    public void onError() {
        mView.onError();
    }
}
