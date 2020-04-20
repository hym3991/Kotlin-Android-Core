package com.hym.kotlin_android_core

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.hym.kotlin_android_core.databinding.ActivityMainBinding
import com.neo.plugin_core.base.BaseCoreActivity
import com.neo.plugin_http.main.Http
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseCoreActivity<ActivityMainBinding>() {

    var mainActivityVM : MainActivityVM = bindVM(BR.viewModel)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding?.apply {
            Log.e("hym","mainActivityVM - >$mainActivityVM")
            mainActivityVM.settext("hahahahahahaha")
        }
        Http.useService<AppService>().login(hashMapOf<String,String>()).enqueue(object : Callback<LoginResult>{
            override fun onFailure(call: Call<LoginResult>, t: Throwable) {

            }

            override fun onResponse(call: Call<LoginResult>, response: Response<LoginResult>) {

            }
        })
    }
    override fun getLayout(): Int = R.layout.activity_main
}
