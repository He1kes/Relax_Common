package com.rent.order_consumer.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2088102181469772";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCH46cqjLavFOfmFU5Cz02wq9wikTeUhTwil5h0QxPW+tZDj8PNqUo9cLM0F4cOr1ixbMT8QVNUmBPvQemZHzVUHxhPSkWPeIRaB7Xy5rQPeDStAdJ/OkU5kE/3OPKUCV3pnxh2RoxiyXjfPtE7usUWq4zObb7ejxq3BvSn1ctYT3+fjXCdZnBIjKXLcb2l/uVa/nApNNwxQfoZI3Y/yf25/Z8tMqQxGbD8JahkwVS8Ni5ue4IyBinLOY8WtmgxT62mAYWafi/abSqip9YzBDd4LBy9RTon638GBs/nE3coyOdnYBS/JAifM08hTK1ztZE6WbfQhHQ/k3FyCnMthE/ZAgMBAAECggEALPPyaPEDvgd8b3C84v0RBlDUEdtYN5mbuxXLKSrHdWalWtREQdSu6oRNw/3Ef+chwA/rWkeB+YoVjiCP1kesrJdcw14ehMepgN7sId6P0k5BnrnrmIr+O3yx92avWKmAl7g5r2bHKibcBX4SWV//svAtNFy5t4Y/oCx84sim7B9e9OGxn8n2y40wPwfBt/Q8H7PUka5KWPj7DJWCKIStgcfdkpMp4SyB6SbIG9G+q/+FjVmiBA11OYwipPYPYA+QmD1BLBfdZ9vfJxNlGc+NlI1hrIcqLILo8PYeg+Eook2jtT8rkAA7LdvLlPtxOWhaF34aAlkbZur5w36u+MQcwQKBgQD+xzxrGYx/wp7EUb3kfEBtWSeGXpcVMhyijglnim/dnTd91uiSf9CF3YRoiDCh4RexMY1tfcbxCexyI+ARrbF4YAUd/7KB+xfVbRNxAKG7hvvL1/dqLzyII0oHu1boVfZbta3KST35BYJwYoXvTkvxQwU99A6gltsjILew7TCXkwKBgQCIing9/NGMg51yPYdAgtk/qNqkMz/tEyIVKcva9wTYzz/PB38zRVTYfY8Y6UvN5kmMAvAqpbSgZRZeTi0xyhnzDkbrvsZG6KuXTMm3+ymHaxumLM3T5UITjqy6o4We13i7pfLlNDNj4rlzC8bbwDjW8lIw7c4VaAfWXYEEekrGYwKBgQDXtFsk2eaoLGA7GnHJRqFNcxQRoXgMi/bOca7oqL55RKg8tH0Hu4sSKy/1SIjUJTzn2mpA7yJF5P74zALjNMlyfukWMuwxPCM7oTO6kqxblrcMKHbiwcdgA3CkBypXXqBLmQ/gmg4MDWwYNnHq38FQLEv93emccNxra0HaW5auXQKBgB/K/kyQvcpWKycapI+k6CkmjCKHvG7bcagz3z/RHNPPDjCKsleh4Su3sMZALGJ5KM7tMDb99p0SbK7wzR02zewGewURmuGP88R7IM0yMm1Rx1JeRF7+lvAu3JFo2ggua/JlpbUw/nZXqI7dQySQEawbKIA0HzRk0M5dX1lHkHm5AoGBAPnkaqUKl5GpOPy8aCBkOGA+aq4DEe/NLWweE/v1HRHzGaNyL889F14mNNITroWvflQkPbhGkvLU83AevgOGE3C/oLt5PNw2xtsAN/hBXhlcyknpD4TJxx387ykL/n6Ok9sZHXf1IYYmdq5uoTetZmzUfg3QZxY6vk3D/BTzjQCV";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjIqeHFXkyvhMBavP01m55kdEpD1SAxxSQWshV1Sd7TWtROoQDYV8TPUk2N5bhGJCrOdEIVOB+4TPN9ShNK7XKf6lmh1VniWGWH/h+byasID8/LaKortE5mw7WX6/K5cwzlE4A+riTF1a8Hw6yirkMHG61MVEpQZIxedgImOC/FyFy++DHQoDXgUyqCraXoEen7ZMrDbA5Pw5fddDAuWdWDsNOASAUxk2OacjwzI3/Om4i7/JEHL4I2052g/es8+LJ+SH+O2opqwMJxlPhbuDwEZB9BK1tgha5iUJY06CH7FlaiWtHMHsKtam8cYobFtpq9uQzmcI6VdBLtHmlcgjfQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://kqcrad.natappfree.cc/alipay/doNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://kqcrad.natappfree.cc/alipay/doReturn";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 日志记录目录
	public static String log_path = "F:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

