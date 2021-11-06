package com.yuk.fuckpowerkeeper

import de.robv.android.xposed.*
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
                        override fun afterHookedMethod(param: MethodHookParam) {
                            param.result = false
                            XposedBridge.log("屏蔽云控刷新率成功")
                        }
                    })
            }
            else -> {
                return
            }
        }
    }
}