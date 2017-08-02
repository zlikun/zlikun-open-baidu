# zlikun-open-baidu

百度云API调研

#### 官网
- <http://ai.baidu.com/>

#### API
- [鉴权认证机制](https://ai.baidu.com/docs#/Auth/top)
```
$ curl -i -X POST "https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=MIRpoF3oMNKfS1toXIoMwoMi&client_secret="
HTTP/1.1 200 OK
Cache-Control: no-store
Connection: keep-alive
Content-Type: application/json
Date: Tue, 01 Aug 2017 13:44:29 GMT
P3p: CP=" OTI DSP COR IVA OUR IND COM "
Server: Apache
Set-Cookie: BAIDUID=F2D4BA216059B7E81C664A8C2F250B71:FG=1; expires=Thu, 31-Dec-37 23:55:55 GMT; max-age=2145916555; path=/; domain=.baidu.com; version=1
Vary: Accept-Encoding
Transfer-Encoding: chunked

{"access_token":"24.a612ec5834e873546206fee31042556c.2592000.1504187069.282335-9958224","session_key":"9mzdWuq8kCyH81Py90+Z2ApGk4JSKjjyL7657zJAf17gAeJpfK0IXbLF+L55FkYRmjl30DU8lOSzfHeXsSQBjfF9ZHON","scope":"public vis-faceverify_faceverify vis-ocr_ocr vis-faceattribute_faceattribute vis-antiporn_antiporn_v2 brain_ocr_scope vis-faceverify_faceverify_v2 brain_gif_antiporn brain_ocr_general brain_ocr_general_basic brain_ocr_general_enhanced brain_ocr_webimage brain_all_scope solution_face brain_ocr_idcard brain_ocr_driving_license brain_ocr_vehicle_license brain_antiporn vis-ocr_plate_number brain_politician brain_imgquality_general brain_kg_pie_task brain_solution brain_ocr_plate_number brain_ocr_accurate brain_ocr_accurate_basic wise_adapt lebo_resource_base lightservice_public hetu_basic lightcms_map_poi kaidian_kaidian wangrantest_test wangrantest_test1 bnstest_test1 bnstest_test2 vis-classify_flower","refresh_token":"25.b5f470432db966f9df808c0cb5b42dc8.315360000.1816955069.282335-9958224","session_secret":"76e70896e16df6cf50fbc67aaeee06b8","expires_in":2592000}

# 正确响应
# access_token 要获取的Access Token
# expires_in Access Token的有效期(秒为单位，一般为1个月)

# 错误响应
# error 错误码；关于错误码的详细信息请参考下方鉴权认证错误码
# error_description 错误描述信息，帮助理解和解决发生的错误
```
- [文字识别](https://ai.baidu.com/docs#/OCR-API/top)
> log_id 唯一的log id，用于问题定位  
> words_result_num 识别结果数，表示words_result的元素个数  
> words_result 识别结果数组

```
{
    "log_id": 2397392541,
    "words_result_num": 14,
    "words_result": [
        {
            "words": "第三届"
        },
        {
            "words": "秋季运动会盛大召开"
        },
        {
            "words": "我运动"
        },
        {
            "words": "我健康"
        },
        {
            "words": "更映、更高、更强"
        },
        {
            "words": "参与竞争就是成功"
        },
        {
            "words": "突破自己就是胜利"
        },
        ... ...
        {
            "words": "24171327(648000"
        }
    ]
}
```

##### [人脸识别](http://ai.baidu.com/docs?castk=LTE%3D#/Face-API/top)