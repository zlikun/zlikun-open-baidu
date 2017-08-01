package com.zlikun.open.http;

import com.alibaba.fastjson.JSON;
import com.zlikun.open.api.TokenInfo;
import com.zlikun.open.config.AppConfig;
import okhttp3.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 图片文字识别API测试
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/1 22:15
 */
public class OCRTest {

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(3 , TimeUnit.SECONDS)
            .build() ;

    MediaType contentType = MediaType.parse("application/x-www-form-urlencoded");

//    ParserConfig parserConfig ;
//
//    @Before
//    public void init() {
//        // https://github.com/alibaba/fastjson/wiki/PropertyNamingStrategy_cn
//        // 配置JSON解析器，实现下划线命名转换驼峰命名
//        parserConfig = new ParserConfig();
//        parserConfig.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
//        // 也可以直接修改全局属性命名策略(实际上默认支持驼峰标识与下划线标识转换)
//        SerializeConfig.getGlobalInstance().propertyNamingStrategy = PropertyNamingStrategy.PascalCase;
//    }

    /**
     * 获取 Token 信息
     * @return
     * @throws IOException
     */
    private TokenInfo token() throws IOException {
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .post(RequestBody.create(contentType,"grant_type=client_credentials&client_id=" + AppConfig.CLIENT_ID + "&client_secret=" + AppConfig.CLIENT_SECRET))
                .build() ;

        Response response = client.newCall(request).execute() ;

        Assert.assertTrue(response.isSuccessful());

        String text = response.body().string();

        return JSON.parseObject(text , TokenInfo.class) ;
    }

    /**
     * 通用文字识别
     * @throws IOException
     */
    @Test
    public void general_basic() throws IOException {

        // 获取Token信息
        TokenInfo token = token() ;
        Assert.assertNotNull(token);
        System.out.println(token);

        // 通用文字识别，这里随便从网上找了一张带文字的图片
        String imageUrl = "http://pic33.nipic.com/20130924/13709236_171327643000_2.jpg" ;
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic?access_token=" + token.getAccessToken())
                .post(RequestBody.create(contentType,"url=" + imageUrl))
                .build() ;

        Response response = client.newCall(request).execute() ;

        Assert.assertTrue(response.isSuccessful());

        String text = response.body().string();

        // {"log_id": 2397392541, "words_result_num": 14, "words_result": [{"words": "L口G"}, {"words": "第三届"}, {"words": "秋季运动会盛大召开"}, {"words": "DO画"}, {"words": "我运动"}, {"words": "我健康"}, {"words": "更映、更高、更强"}, {"words": "参与竞争就是成功"}, {"words": "突破自己就是胜利"}, {"words": " LOGO"}, {"words": " LOGO"}, {"words": "退图网"}, {"words": " uuuuluu"}, {"words": "24171327(648000"}]}
        System.out.println(text);

    }

}