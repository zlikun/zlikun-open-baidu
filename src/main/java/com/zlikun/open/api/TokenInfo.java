package com.zlikun.open.api;

import lombok.Data;
import lombok.ToString;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/8/1 22:18
 */
@Data
@ToString
public class TokenInfo {

    private String accessToken ;
    private String refreshToken ;
    private String sessionKey ;
    private String sessionSecret ;
    private Long expiresIn ;
    private String scope ;

}