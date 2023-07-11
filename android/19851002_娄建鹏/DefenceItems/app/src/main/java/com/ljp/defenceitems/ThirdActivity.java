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
import com.ljp.defenceitems.entity.constellation.constellation;
import com.ljp.defenceitems.entity.constellation.constellation_month;
import com.ljp.defenceitems.entity.constellation.constellation_week;
import com.ljp.defenceitems.entity.constellation.constellation_year;
import com.ljp.defenceitems.tool.Common;
import com.ljp.defenceitems.tool.ServiceFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    //输入框
    private EditText etInputConstellation;
    private EditText etInputHoroscope;
    //按钮
    private Button mBtnQuery;
    //页面跳转按钮
    private Button button1, button2, button3;
    //视图列
    private View mViewLine;
    //星座名称及运势
    private TextView mConstellation;
    private TextView mHoroscope;
    //引用网络请求工具类
    private ServiceFactory mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //初始化控件
        init();
        //实例化ServiceFactory
        mService= ServiceFactory.getInstance();
    }

    //初始化控件
    private void init(){
        etInputConstellation=findViewById(R.id.input_constellation);
        etInputHoroscope=findViewById(R.id.horoscope_temp);
        mBtnQuery=findViewById(R.id.btn_query);
        mViewLine=findViewById(R.id.view_line);
        mConstellation=findViewById(R.id.tv_constellation);
        mHoroscope=findViewById(R.id.tv_hor);
        button1 = findViewById(R.id.fyzn2022Activity);
        button2 = findViewById(R.id.weatherActivity);
        button3 = findViewById(R.id.startsActivity);
        //监听查询按钮
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查询星座运势
                //获取运势类别
                String type=etInputHoroscope.getText().toString();
                switch (type){
                    case "today":
                    case "tomorrow":
                        queryConstellationToday();
                        break;
                    case "week":
                        queryConstellationWeek();
                        break;
                    case "month":
                        queryConstellationMonth();
                        break;
                    case "year":
                        queryConstellationYear();
                        break;
                    default:
                        break;
                }
            }
        });
        //页面跳转监听
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    //该方法进行year网络请求，进行查询星座运势
    private void queryConstellationYear() {
        //网络请求
        ApiData api= mService.createService(ApiData.class, Common.HoroscopeQueryUrl);
        String consName=etInputConstellation.getText().toString();
        String type=etInputHoroscope.getText().toString();
        //执行year请求
        Call<constellation_year> call3 = api.getHoroscopeQueryYear(Common.XINGZUO_KEY, consName, type);
        call3.enqueue(new Callback<constellation_year>() {
            @Override
            public void onResponse(Call<constellation_year> call, Response<constellation_year> Response) {
                //显示year运势
                Toast.makeText(ThirdActivity.this,consName+type, Toast.LENGTH_SHORT).show();
                queryConstellationYear(Response.body(),consName,type);

            }

            @Override
            public void onFailure(Call<constellation_year> call, Throwable t) {
                Toast.makeText(ThirdActivity.this, "星座运势查询失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //该方法进行month网络请求，进行查询星座运势
    private void queryConstellationMonth() {
        //网络请求
        ApiData api= mService.createService(ApiData.class, Common.HoroscopeQueryUrl);
        String consName=etInputConstellation.getText().toString();
        String type=etInputHoroscope.getText().toString();
        //执行month请求
        Call<constellation_month> call2 = api.getHoroscopeQueryMonth(Common.XINGZUO_KEY, consName, type);
        call2.enqueue(new Callback<constellation_month>() {
            @Override
            public void onResponse(Call<constellation_month> call, Response<constellation_month> response) {
                //显示星座运势信息
                queryConstellationSuccessMonth(response.body(), consName, type);
            }

            @Override
            public void onFailure(Call<constellation_month> call, Throwable t) {
                Toast.makeText(ThirdActivity.this, "星座运势查询失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //该方法进行week网络请求，进行查询星座运势
    private void queryConstellationWeek() {
        //网络请求
        ApiData api= mService.createService(ApiData.class, Common.HoroscopeQueryUrl);
        String consName=etInputConstellation.getText().toString();
        String type=etInputHoroscope.getText().toString();
        //执行week请求
        Call<constellation_week> call1 = api.getHoroscopeQueryWeek(Common.XINGZUO_KEY, consName, type);
        call1.enqueue(new Callback<constellation_week>() {
            @Override
            public void onResponse(Call<constellation_week> call, Response<constellation_week> response) {
                //显示星座运势信息
                queryConstellationSuccessWeek(response.body(), consName, type);
            }

            @Override
            public void onFailure(Call<constellation_week> call, Throwable t) {
                Toast.makeText(ThirdActivity.this, "星座运势查询失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //该方法进行today网络请求，进行查询星座运势
    private void queryConstellationToday() {
        //网络请求
        ApiData api= mService.createService(ApiData.class, Common.HoroscopeQueryUrl);
        String consName=etInputConstellation.getText().toString();
        String type=etInputHoroscope.getText().toString();
        Call<constellation> call = api.getHoroscopeQueryToday(Common.XINGZUO_KEY, consName, type);
        //执行today，tomorrow请求
        call.enqueue(new Callback<constellation>() {
            @Override
            public void onResponse(Call<constellation> call, Response<constellation> response) {
                //显示星座运势信息
                queryConstellationSuccessToday(response.body(), consName, type);
            }

            @Override
            public void onFailure(Call<constellation> call, Throwable t) {
                Toast.makeText(ThirdActivity.this, "星座运势查询失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //该方法显示year的星座运势信息
    private void queryConstellationYear(constellation_year reason, String consName, String type) {
        if(reason.getError_code()!=0){
            return;
        }
        mConstellation.setText(consName+type+"的运势为：");
        mHoroscope.setText(reason.toString());
        mViewLine.setVisibility(View.VISIBLE);
    }

    //该方法显示month的星座运势信息
    private void queryConstellationSuccessMonth(constellation_month reason, String consName, String type) {
        if(reason.getError_code()!=0){
            return;
        }
        mConstellation.setText(consName+type+"的运势为：");
        mHoroscope.setText(reason.toString());
        mViewLine.setVisibility(View.VISIBLE);
    }

    //该方法显示week的星座运势信息
    private void queryConstellationSuccessWeek(constellation_week reason, String consName, String type) {
        if(reason.getError_code()!=0){
            return;
        }
        mConstellation.setText(consName+type+"的运势为：");
        mHoroscope.setText(reason.toString());
        mViewLine.setVisibility(View.VISIBLE);
    }

    //该方法显示today，tomorrow的星座运势信息
    private void queryConstellationSuccessToday(constellation reason, String consName, String type) {
        if(reason.getError_code()!=0){
            return;
        }
        mConstellation.setText(consName+type+"的运势为：");
        mHoroscope.setText(reason.toString());
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