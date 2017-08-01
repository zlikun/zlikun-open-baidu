# zlikun-open-baidu

百度云API调研

#### 官网
- <http://ai.baidu.com/>

#### 文档
- [鉴权认证机制](https://ai.baidu.com/docs#/Auth/top)

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
```