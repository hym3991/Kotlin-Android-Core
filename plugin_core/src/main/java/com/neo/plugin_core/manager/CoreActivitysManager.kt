package com.neo.plugin_core.manager

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.neo.plugin_core.base.BaseCoreApplication

/**
 * @author: hongyaming
 * @date: Create in 2:31 PM 2020/4/15
 * @description: please add a description here
 */
class CoreActivitysManager {
    private object CoreActivitysManagerHolder{
        var holder = CoreActivitysManager()
    }
    companion object{
        val instance = CoreActivitysManagerHolder.holder
    }
    private var activitys = arrayListOf<Activity>()

    /**
     * 注册Activity监听
     */
    fun init(application: BaseCoreApplication?){
        application?.registerActivityLifecycleCallbacks(object :
            CoreActivityLifecycleCallbacks() {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                addActivity(activity)
            }

            override fun onActivityDestroyed(activity: Activity) {
                removeActivity(activity)
            }
        })
    }

    private fun addActivity(activity: Activity?){
        activity?.addInList()
    }

    private fun removeActivity(activity: Activity?){
        activity?.removeInList()
    }

    /**
     * 获取栈顶Activity
     */
    fun <T : Activity> getTopActivity():T = activitys.last() as T

    /**
     * 关闭栈顶Activity
     */
    fun finishTopActivity(){
        if (activitys.isNotEmpty()) activitys.last().finish() else return
    }

    /**
     * 关闭所有Activity
     */
    fun finishAllActivity(){
        if (activitys.isNotEmpty()){
            activitys.forEach { value ->
                value.finish()
            }
        }
    }

    private fun Activity.addInList(){
        activitys.add(this)
    }

    private fun Activity.removeInList(){
        activitys.remove(this)
    }

    abstract class CoreActivityLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity) {
        }

        override fun onActivityStarted(activity: Activity) {
        }

        override fun onActivityDestroyed(activity: Activity) {
        }

        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        }

        override fun onActivityStopped(activity: Activity) {
        }

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        }

        override fun onActivityResumed(activity: Activity) {
        }
    }
}