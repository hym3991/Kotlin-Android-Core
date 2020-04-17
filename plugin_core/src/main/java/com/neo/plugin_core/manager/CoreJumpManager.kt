package com.neo.plugin_core.manager

import android.content.Intent
import com.neo.plugin_core.base.BaseCoreActivity
import com.neo.plugin_core.base.BaseCoreFragment
import com.neo.plugin_core.base.BaseCoreViewModel

/**
 * Created by Neo on 2020/4/16.
 * Description :跳转
 */
//BaseCoreActivity 跳转
inline fun <reified A : BaseCoreActivity<*>> BaseCoreActivity<*>.jump(){
    startActivity(Intent(this,A::class.java))
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreActivity<*>.jump(configIntent : Intent.() -> Unit = {}){
    startActivity(Intent(this,A::class.java).apply(configIntent))
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreActivity<*>.jump(resultCode : Int){
    startActivityForResult(Intent(this,A::class.java),resultCode)
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreActivity<*>.jump(resultCode : Int,configIntent : Intent.() -> Unit = {}){
    startActivityForResult(Intent(this,A::class.java).apply(configIntent),resultCode)
}

//BaseCoreFragment 跳转
inline fun <reified A : BaseCoreActivity<*>> BaseCoreFragment<*>.jump(){
    startActivity(Intent(activity,A::class.java))
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreFragment<*>.jump(configIntent : Intent.() -> Unit = {}){
    startActivity(Intent(activity,A::class.java).apply(configIntent))
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreFragment<*>.jump(resultCode : Int){
    startActivityForResult(Intent(activity,A::class.java),resultCode)
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreFragment<*>.jump(resultCode : Int,configIntent : Intent.() -> Unit = {}){
    startActivityForResult(Intent(activity,A::class.java).apply (configIntent),resultCode)
}

data class VMJumpModel(val formActivity: BaseCoreActivity<*>?,val toClass: Class<out BaseCoreActivity<*>>){
    var resultCode : Int? = null
    var configIntent : Intent.() -> Unit = {}
}

//BaseCoreViewModel 跳转
fun BaseCoreActivity<*>.jump(model: VMJumpModel){
    val intent = Intent(this,model.toClass)
    intent.apply(model.configIntent)
    if (model.resultCode != null){
        startActivityForResult(intent,model.resultCode!!)
    }else{
        startActivity(intent)
    }
}

fun BaseCoreFragment<*>.jump(model: VMJumpModel){
    val intent = Intent(activity,model.toClass)
    intent.apply(model.configIntent)
    if (model.resultCode != null){
        startActivityForResult(intent,model.resultCode!!)
    }else{
        startActivity(intent)
    }
}

inline fun <reified A : BaseCoreActivity<*>> BaseCoreViewModel<*>.jump(){
    val model = VMJumpModel(null,A::class.java)
    jump.postValue(model)
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreViewModel<*>.jump(noinline copnfigIntent : Intent.() -> Unit = {}){
    val model = VMJumpModel(null,A::class.java)
    model.configIntent = copnfigIntent
    jump.postValue(model)
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreViewModel<*>.jump(resultCode : Int){
    val model = VMJumpModel(null,A::class.java)
    model.resultCode = resultCode
    jump.postValue(model)
}
inline fun <reified A : BaseCoreActivity<*>> BaseCoreViewModel<*>.jump(resultCode : Int, noinline copnfigIntent : Intent.() -> Unit = {}){
    val model = VMJumpModel(null,A::class.java)
    model.configIntent = copnfigIntent
    model.resultCode = resultCode
    jump.postValue(model)
}

