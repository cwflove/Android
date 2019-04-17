package git.example.dell.mvp.contract;

/**
 * @author 陈伟飞
 * @date 2019/1/22.
 * @function Contract 管理Presenter与View的接口
 */
public class Contract {
    public interface View{

        void onSuccess(String jsonString);

        void onError();

    }

    public interface Presenter{

        void getWeather(String cityNumber);

        void onSuccess(String jsonString);

        void onError();
    }
}
