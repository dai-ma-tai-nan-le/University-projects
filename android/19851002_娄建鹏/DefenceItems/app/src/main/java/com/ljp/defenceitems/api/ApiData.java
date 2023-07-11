package com.ljp.defenceitems.api;

import com.ljp.defenceitems.entity.Weather.WeatherReason;
import com.ljp.defenceitems.entity.constellation.constellation;
import com.ljp.defenceitems.entity.constellation.constellation_month;
import com.ljp.defenceitems.entity.constellation.constellation_week;
import com.ljp.defenceitems.entity.constellation.constellation_year;
import com.ljp.defenceitems.entity.policy.Citys;
import com.ljp.defenceitems.entity.policy.PolicyReason;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiData {
    //2022出行防疫政策指南的城市列表的请求
    @GET("citys")
    Call<Citys> getCityList(@Query("key")String key);
    //2022出行防疫政策指南的政策的请求
    @GET("query")
    Call<PolicyReason> getCityPolicy(@Query("key")String key, @Query("from")int from, @Query("to")int to);

    //天气预报的城市查询天气请求
    @GET("query")
    Call<WeatherReason> getCityWeather(@Query("city")String city, @Query("key")String key);

    //星座运势的运势查询请求
    //1.today
    @GET("getAll")
    Call<constellation> getHoroscopeQueryToday(@Query("key")String key, @Query("consName")String consName, @Query("type")String type);
    //2.week
    @GET("getAll")
    Call<constellation_week> getHoroscopeQueryWeek(@Query("key")String key, @Query("consName")String consName, @Query("type")String type);
    //3.month
    @GET("getAll")
    Call<constellation_month> getHoroscopeQueryMonth(@Query("key")String key, @Query("consName")String consName, @Query("type")String type);
    //4.year
    @GET("getAll")
    Call<constellation_year> getHoroscopeQueryYear(@Query("key")String key, @Query("consName")String consName, @Query("type")String type);

}
