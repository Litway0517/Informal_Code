package com.demo.litway.http;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

/**
 * @author Litway
 * @version 1.0
 */
@SpringBootTest
public class HttpTest {

    private String url = "http://172.31.151.142/dev-api/system/user/list?pageNum=1&pageSize=10";

    private String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyX2lkIjoxLCJ1c2VyX2tleSI6ImNlZTg1N2M2LTI5OTktNGY3Zi1hNTg3LTMxNTcwZjY2MTMwYiIsInVzZXJuYW1lIjoiYWRtaW4ifQ.7Z4EhyrqWB-4yobrHoY8LGu0oH9Y4RGfD0aC0XV7vZPNiTrBihZmQMEvkjRJkv_4-7hEIb5yM0gYjWRi9paeoA";

    private String ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36";

    @Test
    public void testHttp() {
        HashMap<String, Object> query = new HashMap<>();
        query.put("pageNum", 1);
        query.put("pageSize", 10);

        String body = HttpRequest.get(url)
                .header("Authorization", token)
                .header("User-Agent", ua)
                .execute().body();

        System.out.println(JSONUtil.toJsonPrettyStr(body));
    }

}
