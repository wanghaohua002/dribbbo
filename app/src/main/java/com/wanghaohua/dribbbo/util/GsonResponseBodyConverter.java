package com.wanghaohua.dribbbo.util;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Converter;

/**
 * 创建时间: 2018/10/12 16:15
 * 作者: wanghaohua
 * 描述:
 */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

  private Gson gson;
  private final TypeAdapter<T> adapter;

  private static final Charset UTF8 = Charset.forName("UTF-8");

  GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
    this.gson = gson;
    this.adapter = adapter;
  }

  @Override public T convert(ResponseBody body) throws IOException {

    JsonReader jsonReader = gson.newJsonReader(body.charStream());
    jsonReader.setLenient(true);
    try {
      return adapter.read(jsonReader);
    } finally {
      Util.closeQuietly(body);
    }
  }

  private T getBody(InputStreamReader reader) throws IOException {
    JsonReader jsonReader = gson.newJsonReader(reader);
    jsonReader.setLenient(true);
    return adapter.read(jsonReader);
  }
}

