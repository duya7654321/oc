package cn.xx.oc.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class HelloController {

    private static final OkHttpClient client = new OkHttpClient();

    @GetMapping("/test")
    public String hello() {
        Request build = new Request.Builder()
                .url("https://search.mcmod.cn/s?key=tconstruct+edible")
                .build();

        try (Response response = client.newCall(build).execute()){
            if (response.body() != null) {

                String s = response.body().string();
                int i = s.indexOf("tconstruct:edible");
                System.out.println(s.substring(i - 100, i + 100));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Hello World";
    }

}
