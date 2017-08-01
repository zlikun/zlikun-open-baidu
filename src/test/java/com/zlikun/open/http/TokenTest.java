package com.zlikun.open.http;

import com.zlikun.open.config.AppConfig;
import okhttp3.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/1 21:21
 */
public class TokenTest {

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(3 , TimeUnit.SECONDS)
            .build() ;

    MediaType contentType = MediaType.parse("application/x-www-form-urlencoded");



    @Test
    public void token() throws IOException {

        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .post(RequestBody.create(contentType,"grant_type=client_credentials&client_id=" + AppConfig.CLIENT_ID + "&client_secret=" + AppConfig.CLIENT_SECRET))
                .build() ;

        Response response = client.newCall(request).execute() ;

        Assert.assertTrue(response.isSuccessful());

        // 输出响应
        // {"access_token":"24.69974168ec3b8b734a3b4efadb3b50a3.2592000.1504186664.282335-9958224","session_key":"9mzdDc8t4jAfzc8Zfh3pxoMIsRw1sDaTVgd5VkDHLGO\/92vfLsmA8NoKW3cmnWTi+6jugKZvCgwmR6q2lSxUQmrCrotf","scope":"public vis-faceverify_faceverify vis-ocr_ocr vis-faceattribute_faceattribute vis-antiporn_antiporn_v2 brain_ocr_scope vis-faceverify_faceverify_v2 brain_gif_antiporn brain_ocr_general brain_ocr_general_basic brain_ocr_general_enhanced brain_ocr_webimage brain_all_scope solution_face brain_ocr_idcard brain_ocr_driving_license brain_ocr_vehicle_license brain_antiporn vis-ocr_plate_number brain_politician brain_imgquality_general brain_kg_pie_task brain_solution brain_ocr_plate_number brain_ocr_accurate brain_ocr_accurate_basic wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian wangrantest_test wangrantest_test1 bnstest_test1 bnstest_test2 vis-classify_flower","refresh_token":"25.ef2cce6529a446c48a2ca8bcae2724b3.315360000.1816954664.282335-9958224","session_secret":"ecb3b864418e89bc3c21b9ae4027e01b","expires_in":2592000}
        System.out.println(response.body().string());

    }

}