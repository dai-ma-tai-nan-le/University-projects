package com.ljp.defenceitems;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ljp.defenceitems.api.ApiData;
import com.ljp.defenceitems.entity.policy.City;
import com.ljp.defenceitems.entity.policy.Citys;
import com.ljp.defenceitems.entity.policy.PolicyReason;
import com.ljp.defenceitems.entity.policy.Province;
import com.ljp.defenceitems.tool.Common;
import com.ljp.defenceitems.tool.ServiceFactory;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//2022出行防疫政策指南的界面
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //下拉单
    private Spinner mFromProvince;
    private Spinner mFromCity;
    private Spinner mToProvince;
    private Spinner mToCity;
    //按钮
    private Button mBtnQuery;
    //出发城市及政策
    private TextView mTvFrom;
    private TextView mTvFromPolicy;
    //目的城市及政策
    private TextView mTvTo;
    private TextView mTvToPolicy;
    //视图列
    private View mViewLine;
    //出发城市名及id
    private String mFromCityName;
    private String mFromCityId;
    //目的城市名及id
    private String mToCityName;
    private String mToCityId;
    //引用网络请求工具类
    private ServiceFactory mService;
    //跳转按钮
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化视图
        init();
        //实例化ServiceFactory
        mService=ServiceFactory.getInstance();
        //加载城市列表
        loadCityList();
    }

    //该方法用于加载城市列表的数据，进行网络请求
    private void loadCityList() {
        ApiData apiData = mService.createService(ApiData.class, Common.CityListUrl);
        //网络接口请求对象
        Call<Citys> call = apiData.getCityList(Common.FANGYI_KEY);
        //执行请求,进入到等待队列，准备执行
        //两种结果：1.成功，2.失败
        call.enqueue(new Callback<Citys>() {
            @Override
            public void onResponse(Call<Citys> call, Response<Citys> response) {
                //将城市列表设置到下拉框中
                queryCitySuccess(response.body());
            }

            @Override
            public void onFailure(Call<Citys> call, Throwable t) {
                Toast.makeText(MainActivity.this, "城市列表获取失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //这个方法把城市列表设置到下拉框中
    private void queryCitySuccess(Citys citys) {
        if(citys.getError_code()!=0){
            //没有获取到数据
            return;
        }
        //设置出发城市的省份和城市的适配器
        setProvincesData(mFromProvince,citys.getResult());
        setCityData(mFromCity,citys.getResult().get(0).getCitys());
        //设置出发城市的省份和城市的适配器
        setProvincesData(mToProvince,citys.getResult());
        setCityData(mToCity,citys.getResult().get(0).getCitys());
    }

    //这个方法是在选择了一个省份时，加载对应的城市信息
    private void setCityData(final Spinner spinner, final List<City> citys) {
        if(citys==null){
            //没有获取到数据
            return;
        }
        String[] cityArray=new String[citys.size()];
        for (int i=0;i<citys.size();i++){
            cityArray[i]=citys.get(i).getCity();
        }
        //设置数组的适配器
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.spinner_dropdown,cityArray);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //对下拉框进行监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getId()){
                    case R.id.sp_from_city:
                        mFromCityName=citys.get(position).getCity();
                        mFromCityId=citys.get(position).getCity_id();
                        break;
                    case R.id.sp_to_city:
                        mToCityName=citys.get(position).getCity();
                        mToCityId=citys.get(position).getCity_id();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "没有获取到任何数据", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //将省份下拉框和城市下拉框的数据进行级联
    private void setProvincesData(final Spinner spinner, final List<Province> provinceList) {
        if(provinceList==null){
            //没有获取到数据
            return;
        }
        String[] provinceArray=new String[provinceList.size()];
        for (int i=0;i<provinceList.size();i++){
            provinceArray[i]=provinceList.get(i).getProvince();
        }
        //设置数组的适配器
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.spinner_dropdown,provinceArray);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //对下拉框进行监听
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (spinner.getId()){
                    case R.id.sp_from_province:
                        setCityData(mFromCity,provinceList.get(position).getCitys());
                        break;
                    case R.id.sp_to_province:
                        setCityData(mToCity,provinceList.get(position).getCitys());
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "没有获取到任何数据", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //这个方法用于初始化视图
    private void init(){
        mFromProvince=findViewById(R.id.sp_from_province);
        mFromCity=findViewById(R.id.sp_from_city);
        mToProvince=findViewById(R.id.sp_to_province);
        mToCity=findViewById(R.id.sp_to_city);
        mBtnQuery=findViewById(R.id.btn_query);
        mTvFrom=findViewById(R.id.tv_from);
        mTvFromPolicy=findViewById(R.id.tv_from_policy);
        mTvTo=findViewById(R.id.tv_to);
        mTvToPolicy=findViewById(R.id.tv_to_policy);
        mViewLine=findViewById(R.id.view_line);
        //按钮的监听事件
        mBtnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查询地区政策
                queryPolicy();
            }
        });
        button1 = findViewById(R.id.fyzn2022Activity);
        button2 = findViewById(R.id.weatherActivity);
        button3 = findViewById(R.id.startsActivity);
        //跳转监听
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    //这个方法用来发起网络请求，查询政策信息
    private void queryPolicy() {
        //网络请求
        ApiData apiData=mService.createService(ApiData.class,Common.TirpUrl);
        //强制类型转换
        int fromId=Integer.parseInt(mFromCityId);
        int toId=Integer.parseInt(mToCityId);
        Call<PolicyReason> call=apiData.getCityPolicy(Common.FANGYI_KEY,fromId,toId);
        //执行请求
        call.enqueue(new Callback<PolicyReason>() {
            @Override
            public void onResponse(Call<PolicyReason> call, Response<PolicyReason> response) {
                //显示数据
                queryPolicySuccess(response.body());
            }

            @Override
            public void onFailure(Call<PolicyReason> call, Throwable t) {
                Toast.makeText(MainActivity.this, "请求数据失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //显示政策
    private void queryPolicySuccess(PolicyReason reason) {
        if(reason.getError_code()!=0){
            return;
        }
        mTvFrom.setText(mFromCityName+"的出行政策为：");
        mTvFromPolicy.setText(reason.getResult().getFrom_info().getOut_desc());
        mViewLine.setVisibility(View.VISIBLE);
        mTvTo.setText(mToCityName+"的进入政策为：");
        mTvToPolicy.setText(reason.getResult().getTo_info().getLow_in_desc());
    }

    //进行三个页面跳转
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
