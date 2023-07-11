package com.ljp.defenceitems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ljp.defenceitems.api.ApiData;
import com.ljp.defenceitems.entity.Weather.WeatherReason;
import com.ljp.defenceitems.tool.Common;
import com.ljp.defenceitems.tool.ServiceFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    //输入框
    private EditText etInputCity;
    //按钮
    private Button mBtnQuery;
    //跳转按钮
    private Button button1, button2, button3;
    //视图列
    private View mViewLine;
    //城市名称及天气
    private TextView mCityName;
    private TextView mWeather;
    //引用网络请求工具类
    private ServiceFactory mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //初始化控件
        init();
        //实例化ServiceFactory
        mService= ServiceFactory.getInstance();
    }
    //这个方法对控件进行初始化
    private void init(){
        etInputCity=findViewById(R.id.input_city);
        mBtnQuery=findViewById(R.id.btn_query);
        mViewLine=findViewById(R.id.view_line);
        mWeather=findViewById(R.id.tv_weather);
        mCityName=findViewById(R.id.tv_city);
        button1 = findViewById(R.id.fyzn2022Activity);
        button2 = findViewById(R.id.weatherActivity);
        button3 = findViewById(R.id.startsActivity);
        //监听查询按钮
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查询天气情况
                queryWeather();
            }
        });
        //页面跳转监听
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    //该方法进行网络请求，进行天气查询
    private void queryWeather() {
        //网络请求
        ApiData api= mService.createService(ApiData.class, Common.CityQueryUrl);
        //获取输入的城市名称
        String cityName=etInputCity.getText().toString();
        Call<WeatherReason> call= api.getCityWeather(cityName,Common.TIANQI_KEY);
        //执行请求
        call.enqueue(new Callback<WeatherReason>() {
            @Override
            public void onResponse(Call<WeatherReason> call, Response<WeatherReason> response) {
                //显示城市天气
                queryWeatherSuccess(response.body(),cityName);
            }

            @Override
            public void onFailure(Call<WeatherReason> call, Throwable t) {
                Toast.makeText(SecondActivity.this, "城市天气获取失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //该方法显示城市天气数据
    private void queryWeatherSuccess(WeatherReason reason,String cityName) {
        if(reason.getError_code()!=0){
            return;
        }
        mCityName.setText(cityName+"的天气情况为：");
        mWeather.setText(reason.getResult().getRealtime().toString());
        mViewLine.setVisibility(View.VISIBLE);
    }

    //该方法进行页面跳转
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weatherActivity:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.startsActivity:
                startActivity(new Intent(this, ThirdActivity.class));
                break;
            case R.id.fyzn2022Activity:
                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                break;
        }
    }
}