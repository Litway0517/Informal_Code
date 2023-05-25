package com.demo.litway.pojo;

import lombok.Data;

/**
 * @author Litway
 * @version 1.0
 */
@Data
public class LoginResponse {

    private String Message;

    private String MessageCode;

    private Integer LoginResultType;

    private Object Context;

    private String KDSVCSessionId;

    private String FormId;

    private String RedirectFormParam;

    private String FormInputObject;

    private String ErrorStackTrace;

    private Integer Lcid;

    private String AccessToken;

    private Object CustomParam;

    private String KdAccessResult;

    private String IsSuccessByAPI;

}
