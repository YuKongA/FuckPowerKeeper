package com.yuk.fuckMiuiFps

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class XposedInit : IXposedHookLoadPackage {

    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        when (lpparam.packageName) {
            "com.miui.powerkeeper" -> {
                XposedHelpers.findAndHookMethod(
                    "com.miui.powerkeeper.statemachine.DisplayFrameSetting",
                    lpparam.classLoader,
                    "isFeatureOn",
                    object : XC_MethodHook() {
                        override fun beforeHookedMethod(param: MethodHookParam) {
                            param.result = false
                        }
                    })
                XposedHelpers.findAndHookMethod(
                    "com.miui.powerkeeper.statemachine.DisplayFrameSetting",
                    lpparam.classLoader,
                    "setScreenEffect",
                    String::class.java,
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType,
                    object : XC_MethodHook() {
                        override fun beforeHookedMethod(param: MethodHookParam) {
                            param.result = null
                        }
                    })
                XposedHelpers.findAndHookMethod(
                    "com.miui.powerkeeper.statemachine.DisplayFrameSetting",
                    lpparam.classLoader,
                    "setScreenEffectInternal",
                    Int::class.javaPrimitiveType,
                    Int::class.javaPrimitiveType,
                    String::class.java,
                    object : XC_MethodHook() {
                        override fun beforeHookedMethod(param: MethodHookParam) {
                            param.result = null
                        }
                    })
            }
            
            else -> return
        }
    }
}