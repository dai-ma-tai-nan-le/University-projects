package com.ljp.defenceitems.tool;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//网络请求工具类---单例类
public class ServiceFactory {
    private final  static long DEFAULT_TIMEOUT=10;
    public ServiceFactory(){
    }
    private static class SingletonHolder{
        private static final ServiceFactory INSTANCE=new ServiceFactory();
    }
    public static ServiceFactory getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public <T> T createService(Class<T> serviceClass,String baseUrl){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
        return retrofit.create(serviceClass);
    }
    private OkHttpClient getOkHttpClient(){
        //定制的OkHttp
        OkHttpClient.Builder httpClientBuilder=new OkHttpClient.Builder();
        httpClientBuilder.addInterceptor(new LoggingInterceptor());
        //设置超时时间
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        return httpClientBuilder.build();
    }
}
