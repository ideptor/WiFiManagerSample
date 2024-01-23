package com.example.wifimanagersample

import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.wifimanagersample.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWiFiStatus.text = "Wifi"
        val wifi = getSystemService(WIFI_SERVICE) as WifiManager

        val builder = StringBuilder()

        builder.append("wifi status:\n")

        builder.append("\nstaConcurrencyForMultiInternetMode:")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            builder.append(wifi.staConcurrencyForMultiInternetMode.toString())
        } else {
            builder.append("N/A")
        }

        builder.append("\nWiFiState: ").append(wifi.wifiState.toString())

        builder.append("\nisBridgedApConcurrencySupported: ")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            builder.append(wifi.isBridgedApConcurrencySupported.toString())
        }else {
            builder.append("N/A")
        }

        builder.append("\nisDualBandSimultaneousSupported: ")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            builder.append(wifi.isDualBandSimultaneousSupported.toString())
        }else {
            builder.append("N/A")
        }

        builder.append("\nisEasyConnectSupported: ")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            builder.append(wifi.isEasyConnectSupported.toString())
        }else {
            builder.append("N/A")
        }

        builder.append("\nisP2pSupported: ").append(wifi.isP2pSupported.toString())

        builder.append("\nisStaApConcurrencySupported: ")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            builder.append(wifi.isStaApConcurrencySupported.toString())
        }else {
            builder.append("N/A")
        }

        builder.append("\nisStaBridgedApConcurrencySupported: ")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            builder.append(wifi.isStaBridgedApConcurrencySupported.toString())
        }else {
            builder.append("N/A")
        }

        builder.append("\nisTlsMinimumVersionSupported: ")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            builder.append(wifi.isTlsMinimumVersionSupported.toString())
        }else {
            builder.append("N/A")
        }

        builder.append("\nisTlsV13Supported: ")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            builder.append(wifi.isTlsV13Supported.toString())
        }else {
            builder.append("N/A")
        }

        binding.tvWiFiStatus.text = builder.toString()
        Log.i("wifi", builder.toString())
    }
}