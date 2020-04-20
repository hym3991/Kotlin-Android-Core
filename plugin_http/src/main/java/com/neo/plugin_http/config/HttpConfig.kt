package com.neo.plugin_http.config

import android.content.Context
import java.util.*

/**
 *  * Package:com.ttp.http_core
 *  * Author: yhj
 *  * Date: 2017/2/15
 *  * Description: 配置文件 配置各种信息
 */
object HttpConfig {

    var application : Context? = null
    var timeOut = 30f //超时时间
    var isRetry = false
    var baseUrl : String? = null
    fun setIsRetry(isRetry: Boolean) {
        HttpConfig.isRetry = isRetry
    }

    /**
     * 绑定对应service的信息
     *
     * @param name service的包名
     * @param url  服务的url
     * @param host 服务的host
     * @return
     */
    fun createServiceInfo(
        name: String?,
        url: String?,
        host: String?
    ): ServiceInfo {
        val info = ServiceInfo()
        info.serviceName = name
        info.url = url
        info.host = host
        return info
    }

    class Builder {
        private var ApplicationContext : Context? = null
        private var timeOut = 30 //超时时间
        private var isRetry = true

        fun setRetry(retry: Boolean): Builder {
            isRetry = retry
            return this
        }

        fun setApplicationContext(ApplicationContext: Context?): Builder {
            this.ApplicationContext = ApplicationContext
            return this
        }

        fun setTimeOut(timeOut: Int): Builder {
            this.timeOut = timeOut
            return this
        }

        fun build() {
            application = ApplicationContext
            this.timeOut = timeOut
            HttpConfig.isRetry = isRetry
        }
    }

    class ServiceInfo {
        var url: String? = null
        var host: String? = null
        var serviceName: String? = null
    }
}