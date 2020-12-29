package com.heikes.rent_common.utils;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class PhoneCodeUtils {
	
	public CommonResponse sendCode(String phone, String smsCode, String param) {
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G1jxXdXhmEZQiE8rBEc", "i5c8qzDQv3nbkAjBoaWhYCuO7YwVZI");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        //接收短信的手机号码。
        request.putQueryParameter("PhoneNumbers", phone);
        //短信签名名称。请在控制台国内消息或国际/港澳台消息页面中的签名管理页签下签名名称一列查看。
        request.putQueryParameter("SignName", "轻松短租");
        //短信模板ID。请在控制台国内消息或国际/港澳台消息页面中的模板管理页签下模板CODE一列查看。
        request.putQueryParameter("TemplateCode", smsCode);
        //短信模板变量对应的实际值，JSON格式。
        request.putQueryParameter("TemplateParam", "{\"code\":\""+param+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return response;
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
		return null;
	}
}
