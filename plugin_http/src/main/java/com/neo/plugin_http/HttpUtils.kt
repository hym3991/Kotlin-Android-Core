package com.neo.plugin_http

import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager

/**
 * Created by Neo on 2020/4/16.
 * Description :
 */
object HttpUtils {
    fun getX509TrustManager() : X509TrustManager{
        return object : X509TrustManager {
            override fun checkClientTrusted(
                chain: Array<X509Certificate>,
                authType: String
            ) {}

            override fun checkServerTrusted(
                chain: Array<X509Certificate>,
                authType: String
            ) {}

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                return arrayOf()
            }
        }
    }

}