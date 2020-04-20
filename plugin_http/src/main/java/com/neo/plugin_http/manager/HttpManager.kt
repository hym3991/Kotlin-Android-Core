package com.neo.plugin_http.manager

import com.neo.plugin_http.HttpUtils
import com.neo.plugin_http.config.HttpConfig
import com.neo.plugin_http.config.SSLSocketFactoryCompat
import com.neo.plugin_http.config.KJsonConverter
import com.neo.plugin_http.interceptor.HttpTnterceptor
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import okhttp3.internal.Util
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Neo on 2020/4/16.
 * Description :
 */
object HttpManager {

    fun <T> createService(className : Class<T>) : T {
        val ioScheduler = Schedulers.io()
        val rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.createWithScheduler(ioScheduler)
        val retrofit = Retrofit.Builder().client(initOkHttpClient(className.name)).baseUrl(HttpConfig.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .build()
        return retrofit.create(className)
    }

    private fun initOkHttpClient(serviceName : String) : OkHttpClient{
        val builder  = OkHttpClient.Builder()
        builder.connectTimeout(HttpConfig.timeOut.toLong(),TimeUnit.SECONDS)
        builder.readTimeout((HttpConfig.timeOut + 5).toLong(),TimeUnit.SECONDS)
        val x509TrustManager = HttpUtils.getX509TrustManager()
        builder.sslSocketFactory(SSLSocketFactoryCompat(x509TrustManager),x509TrustManager)
        val APPROVED_CIPHER_SUITES = listOf<CipherSuite>(
            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
            CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384,
            CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,
            CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256,
            CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256,
            CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,
            CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,
            CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256,
            CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384,
            CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA,
            CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA,
            CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA,
            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,
            CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA
        )
        val spec = ConnectionSpec.Builder(ConnectionSpec.CLEARTEXT)
            .tlsVersions(TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0)
            .cipherSuites(APPROVED_CIPHER_SUITES.toString())
            .build()
        builder.connectionSpecs(Util.immutableList(spec, ConnectionSpec.CLEARTEXT))
        builder.addInterceptor(HttpTnterceptor(serviceName))
        return builder.build()
    }

}