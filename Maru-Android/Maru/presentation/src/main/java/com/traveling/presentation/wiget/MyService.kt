package com.traveling.presentation.wiget

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.traveling.presentation.R

class MyService : Service() {

    private val CHANNEL_ID = "MARU_SERVICE"
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
                "Maru Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_app)
            .setContentTitle("마루앱")
            .setContentText("앱이 정보를 표기하고 있습니다.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(false)
            .setOngoing(true)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    applicationContext,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }
            notify(NOTIFICATION_ID, notificationBuilder.build())
        }
    }
}
