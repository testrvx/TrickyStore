package io.github.a13e300.tricky_store

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES
import java.io.File
import java.security.MessageDigest
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    Logger.i("Welcome to TrickyStore!")
    if(SDK_INT == VERSION_CODES.Q || SDK_INT == VERSION_CODES.R){
        while (true) {
            if (!KeystoreInterceptor.tryRunKeystoreInterceptor()) {
                Thread.sleep(1000)
                continue
            }
            Config.initialize()
            while (true) {
                Thread.sleep(1000000)
            }
        }
    } else if(SDK_INT >= VERSION_CODES.S){
        while (true) {
            if (!Keystore2Interceptor.tryRunKeystoreInterceptor()) {
                Thread.sleep(1000)
                continue
            }
            Config.initialize()
            while (true) {
                Thread.sleep(1000000)
            }
        }
    }
}