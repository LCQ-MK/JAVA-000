package com.jike.java.jvm.week02;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientUtil {

    public static void main(String[] args) {

        try {
            httpClientGet("http://localhost:8801");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            okHttpGet("http://localhost:8801");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void httpClientGet(String url) throws IOException {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            response = httpClient.execute(new HttpGet(url));
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                System.out.println(EntityUtils.toString(response.getEntity(), "UTF-8"));
            }
        } finally {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        }
    }

    public static void okHttpGet(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());;
        }
    }
}
