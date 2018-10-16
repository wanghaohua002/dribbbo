package com.wanghaohua.dribbbo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;

/**
 * 创建时间: 2018/10/12 15:43
 * 作者: wanghaohua
 * 描述:
 */
public class HttpUtil {

  private static final String URL_BASE = "https://api.dribbble.com/v2/";


  private static Gson gson;

  private static Retrofit retrofit;

  public static void initRetrofit() {
    gson = new GsonBuilder()
        .setDateFormat("YYYY-MM-DDTHH:MM:SSZ")
        .create();
    retrofit = new Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .baseUrl(URL_BASE)
        .build();
  }

  public static <T> T createService(Class<T> serviceClass) {
    return retrofit == null ? null : retrofit.create(serviceClass);
  }
}
