package com.example.templete.presentation.feature.main

import android.Manifest
import android.app.KeyguardManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.templete.R
import com.example.templete.presentation.feature.back.OnAlarmActivity

class MyService : Service() {

    private val CHANNEL_ID = "my_channel"
    private val NOTIFICATION_ID = 123
    private var mReceiver: ScreenReceiver? = null
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val LOG = "LOG"

    override fun onCreate() {
        super.onCreate()
        handler = Handler()
        mReceiver = ScreenReceiver()
        val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
        registerReceiver(mReceiver, filter)
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()

        // 일정 시간마다 알림을 띄우기 위해 5초마다 실행되는 Runnable 설정
        runnable = object : Runnable {
            override fun run() {
//                showNotification()
                if (intent != null) {
                    Log.d("LOG", "run: rr")
                    if (intent.action == null) {
                        Log.d("LOG", "run: ss")
                        if (mReceiver == null) {
                            Log.d("LOG", "run: dd")
                            mReceiver = ScreenReceiver()
                            val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
                            registerReceiver(mReceiver, filter)
                        }
                    }
                }
//                Log.d("LOG", "run: 임")
//                val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
//                if (keyguardManager.isKeyguardLocked) {
//                    Log.d("LOG", "run: 임2")
//                    val intent = Intent(this@MyService, OnAlarmActivity::class.java)
//                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//
//                    startActivity(intent)
//                }
//                val s = OnAlarmActivity()
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
//
//                    s.setShowWhenLocked(true)
//                    s.setTurnScreenOn(true)
//                    (getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager).apply {
//                        requestDismissKeyguard(OnAlarmActivity(), null)
//                    }
//                } else {
//                    s.window.addFlags(
//                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
//                                WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
//                                WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
//                    )
//                }
                handler.postDelayed(this, 2000)
            }
        }

        // 5초마다 Runnable 실행
        handler.postDelayed(runnable, 2000)

        // START_STICKY를 반환하여 시스템이 서비스를 강제로 종료한 후에도 서비스를 재시작합니다.
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        // 서비스가 종료될 때 Runnable도 함께 제거합니다.
        handler.removeCallbacks(runnable)
        if (mReceiver != null) {
            unregisterReceiver(mReceiver)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "My Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("알림")
            .setContentText("앱이 실행 중입니다.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(false)
            .setOngoing(true)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }
}
