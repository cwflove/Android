package git.example.dell.androidcode.view;

import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import git.example.dell.androidcode.R;
import git.example.dell.androidcode.contract.Contract;
import git.example.dell.androidcode.presenter.Presenter;

/**
 * @author 陈伟飞
 * @date 2019/1/23
 * @function View显示界面
 */
public class MainActivity extends AppCompatActivity implements Contract.View, View.OnClickListener{

    private Presenter mPresenter;
    private EditText mEditText;
    private LinearLayout mWeatherLayout;
    private TextView mCityText;
    private TextView mCityIdText;
    private TextView mTempText;
    private TextView mWdText;
    private TextView mWsText;
    private TextView mSdText;
    private TextView mNjdText;
    private TextView mWseText;
    private TextView mTimeText;
    private TextView mSmText;
    private TextView mIsRadarText;
    private TextView mRadarText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化布局
        initView();
        //创建Presenter
        mPresenter = new Presenter(this);
    }

    private void initView() {
        mEditText = findViewById(R.id.ed_text);
        Button mButton = findViewById(R.id.but);
        mButton.setOnClickListener(this);

        mWeatherLayout = findViewById(R.id.weather_layout);
        mCityText = findViewById(R.id.city_text);
        mCityIdText = findViewById(R.id.city_id_text);
        mTempText = findViewById(R.id.temp_text);
        mWdText = findViewById(R.id.wd_text);
        mWsText = findViewById(R.id.ws_text);
        mSdText = findViewById(R.id.sd_text);
        mNjdText = findViewById(R.id.njd_text);
        mWseText = findViewById(R.id.wse_text);
        mTimeText = findViewById(R.id.time_text);
        mSmText = findViewById(R.id.sm_text);
        mIsRadarText = findViewById(R.id.isRadar_text);
        mRadarText = findViewById(R.id.radar_text);
    }

    /**
     * 在View中把参数给Presenter 实现与V与P交互
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.but){
            mPresenter.getWeather(mEditText.getText().toString().trim());
        }
    }

    /**
     * 接口请求成功 给相应控件赋值
     * @param jsonString
     */
    @Override
    public void onSuccess(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject weatherinfo = jsonObject.getJSONObject("weatherinfo");
            mCityText.setText("city :"+weatherinfo.getString("city"));
            mCityIdText.setText("cityid :"+weatherinfo.getString("cityid"));
            mTempText.setText("temp :"+weatherinfo.getString("temp"));
            mWdText.setText("WD :"+weatherinfo.getString("WD"));
            mWsText.setText("WS :"+weatherinfo.getString("WS"));
            mSdText.setText("SD :"+weatherinfo.getString("SD"));
            mNjdText.setText("njd :"+weatherinfo.getString("njd"));
            mWseText.setText("WSE :"+weatherinfo.getString("WSE"));
            mTimeText.setText("time :"+weatherinfo.getString("time"));
            mSmText.setText("sm :"+weatherinfo.getString("sm"));
            mIsRadarText.setText("isRadar :"+weatherinfo.getString("isRadar"));
            mRadarText.setText("Radar :"+weatherinfo.getString("Radar"));

            mWeatherLayout.setVisibility(View.VISIBLE);
            InputMethodManager imm = (InputMethodManager)getSystemService(Service.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError() {
        Toast.makeText(this, "请求数据异常", Toast.LENGTH_SHORT).show();
    }
}