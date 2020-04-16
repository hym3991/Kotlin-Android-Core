package com.neo.plugin_http.config;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;


/**
 * <li>Package:com.ttp.http_core </li>
 * <li>Author: yhj </li>
 * <li>Date: 2017/2/15 </li>
 * <li>Description: 配置文件 配置各种信息 </li>
 */
public class HttpConfig {
    private static String deviceType = "android_ttp_personal"; //设备类型
    private static String version;//	客户端当前软件版本号 如：1.6.1	必选
    private static String uuUserId;//	移动设备唯一标识 如：356871046400838	必选
    //private static String AppUrl;//app域名
    private static String ExcessUrl;//第三方的域名;
    //    private static boolean isDnsod;//是否是调试模式
    private static String token;//token信息
    private static Context ApplicationContext;//上下文
    private static String username;//账号id 检测师专用
    // private static String host;//请求host
    private static int TIME_OUT = 30;//超时时间
    private static boolean isRetry;
    private static String userId;
    public static HashMap serviceMap = new HashMap();


    //是否是okhttp图片请求
    public static String IS_IMAGE = "is_image";
    //是否是webview的请求
    public static String IS_WEBVIEW = "is_webview";
    public static String IS_PLAINTEXT = "plaintext";//是否明文
    public static int WEBVIEW_SERVICE_CODE = 100;
    //web url
    public static String WEB_URL = "";

    //老版本版本检测接口
    public static int SERVICE_CHECK_VERSION = 1001;
    //友盟推送设备号同步接口
    public static int SERVICE_MAIN_PUSH = 1002;

    public static Map WEB_HEAD_MAP = new HashMap();

    private static String ttpUid;

    public static class Builder {
        private String deviceType; //设备类型
        private String version;//	客户端当前软件版本号 如：1.6.1	必选
        private String uuUserId;//	移动设备唯一标识 如：356871046400838	必选
        // private String AppUrl;//app域名
        private String ExcessUrl;//第三方的域名;
        private String username;//账号id 检测师专用
        private String token;//token
        //        private boolean isDnsod;//是否是调试模式
        private List<ServiceInfo> serviceInfos = new ArrayList<>();
        private Context ApplicationContext;//上下文
        //private String host;//请求host
        private int timeOut = 30;//超时时间
        private boolean isRetry = true;
        private String userId;

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public Builder setDeviceType(String deviceType) {
            this.deviceType = deviceType;
            return this;
        }


        public Builder addServiceInfos(ServiceInfo serviceInfo) {
            serviceInfos.add(serviceInfo);
            return this;
        }

        public Builder setVersion(String version) {
            this.version = version;
            return this;
        }

        public Builder setUuUserId(String uuUserId) {
            this.uuUserId = uuUserId;
            return this;
        }

        public Builder setRetry(boolean retry) {
            isRetry = retry;
            return this;
        }

        /* public Builder setAppUrl(String appUrl) {
            AppUrl = appUrl;
            return this;
        }*/

        public Builder setExcessUrl(String excessUrl) {
            ExcessUrl = excessUrl;
            return this;
        }

        public Builder setApplicationContext(Context ApplicationContext) {
            this.ApplicationContext = ApplicationContext;
            return this;
        }

        /**
         * 不能set""如果
         *
         * @param
         * @return
         */
     /*   public Builder setHost(String host) {
            this.host = host;
            return this;
        }
*/
        public Builder setTimeOut(int timeOut) {
            this.timeOut = timeOut;
            return this;
        }


        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public void build() {
            HttpConfig.deviceType = deviceType;
            HttpConfig.version = version;
            HttpConfig.uuUserId = uuUserId;
            //HttpConfig.AppUrl = AppUrl;
            HttpConfig.ExcessUrl = ExcessUrl;
//            HttpConfig.isDnsod = isDnsod;
            HttpConfig.ApplicationContext = ApplicationContext;
            HttpConfig.token = token;
            //HttpConfig.host=host;
            HttpConfig.TIME_OUT = timeOut;
            HttpConfig.isRetry = isRetry;
            HttpConfig.userId = userId;
            for (ServiceInfo info : serviceInfos) {
                HttpConfig.serviceMap.put(info.serviceName, info);
            }
        }
    }

    /*public static void setAppUrl(String appUrl) {
        AppUrl = appUrl;
    }*/

    public static void setExcessUrl(String excessUrl) {
        ExcessUrl = excessUrl;
    }

  /*  public static String getAppUrl() {
        return AppUrl;
    }*/

    public static String getExcessUrl() {
        return ExcessUrl;
    }

    public static String getDeviceType() {
        return deviceType;
    }

    public static void setDeviceType(String deviceType) {
        HttpConfig.deviceType = deviceType;
    }

    public static String getVersion() {
        return version;
    }

    public static void setVersion(String version) {
        HttpConfig.version = version;
    }

    public static String getUuUserId() {
        return uuUserId;
    }

    public static void setUuUserId(String uuUserId) {
        HttpConfig.uuUserId = uuUserId;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        HttpConfig.token = token;
    }

    public static Context getApplication() {
        return ApplicationContext;
    }

    public static void setApplication(Context application) {
        HttpConfig.ApplicationContext = application;
    }

/*    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        HttpConfig.host = host;
    }*/

    public static int getTimeOut() {
        return TIME_OUT;
    }

    public static void setTimeOut(int timeOut) {
        TIME_OUT = timeOut;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        HttpConfig.username = username;
    }

    public static boolean isRetry() {
        return isRetry;
    }

    public static void setIsRetry(boolean isRetry) {
        HttpConfig.isRetry = isRetry;
    }

    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        HttpConfig.userId = userId;
    }

    public static class ServiceInfo {
        private String url;
        private String host;
        private String serviceName;

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }
    }

    /**
     * 绑定对应service的信息
     *
     * @param name service的包名
     * @param url  服务的url
     * @param host 服务的host
     * @return
     */
    public static ServiceInfo createServiceInfo(String name, String url, String host) {
        ServiceInfo info = new ServiceInfo();
        info.setServiceName(name);
        info.setUrl(url);
        info.setHost(host);
        return info;
    }

    /*
    设置对应api的url
     */
    public static void setUrl(String apiName, String url) {
        ((ServiceInfo) serviceMap.get(apiName)).setUrl(url);
    }

    public static String getTtpUid() {
        return ttpUid;
    }

    public static void setTtpUid(String ttpUid) {
        HttpConfig.ttpUid = ttpUid;
    }
}
