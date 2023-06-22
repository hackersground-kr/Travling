package com.traveling.presentation.wiget

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.traveling.presentation.R

class MyService : Service(), SensorEventListener {

    var sensorManager: SensorManager? = null
    var stepCountSensor: Sensor? = null
    private val CHANNEL_ID = "MARU_SERVICE"
    private val NOTIFICATION_ID = 133
    private var mReceiver: ScreenReceiver? = null
    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private val LOG = "LOG"
    var currentSteps: Int = if (MaruApplication.prefs.walkCount == "") { 0 } else {  MaruApplication.prefs.walkCount.toInt()}
    override fun onCreate() {
        super.onCreate()
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        stepCountSensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)
        if (stepCountSensor == null) {
            Toast.makeText(this, "No Step Sensor", Toast.LENGTH_SHORT).show()
        }
        handler = Handler()
        mReceiver = ScreenReceiver()
        val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
        registerReceiver(mReceiver, filter)
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        showNotification()
        if (stepCountSensor != null) {
            // 센서 속도 설정
            // * 옵션
            // - SENSOR_DELAY_NORMAL: 20,000 초 딜레이
            // - SENSOR_DELAY_UI: 6,000 초 딜레이
            // - SENSOR_DELAY_GAME: 20,000 초 딜레이
            // - SENSOR_DELAY_FASTEST: 딜레이 없음
            //
            sensorManager!!.registerListener(
                this,
                stepCountSensor,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }
        // 일정 시간마다 알림을 띄우기 위해 5초마다 실행되는 Runnable 설정
        runnable = object : Runnable {
            override fun run() {
//                showNotification()
                if (intent != null) {
                    if (intent.action == null) {
//                        Log.d("LOG", "run: ss ${currentSteps}")
                        if (mReceiver == null) {
                            Log.d("LOG", "run: dd")
                            mReceiver = ScreenReceiver()
                            val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
                            registerReceiver(mReceiver, filter)

                        }
                    }
                }
                MaruApplication.prefs.walkCount = currentSteps.toString()
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
//        handler.removeCallbacks(runnable)
        if (mReceiver != null) {
            unregisterReceiver(mReceiver)
        }
        sensorManager?.unregisterListener(this)
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
            .setContentText("앱이 정보를 수집하고 있습니다.")
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
    override fun onSensorChanged(event: SensorEvent) {
        // 걸음 센서 이벤트 발생시
        if (event.sensor.type == Sensor.TYPE_STEP_DETECTOR) {
            if (event.values[0] == 1.0f) {
                // 센서 이벤트가 발생할때 마다 걸음수 증가
                currentSteps++
                MaruApplication.prefs

                Log.d("LOGS", "onSensorChanged: $currentSteps")
//                stepCountView!!.text = currentSteps.toString()
//                updateNotification()
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}

//    private fun updateNotification() {
//        val notificationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setSmallIcon(R.drawable.ic_app)
//            .setContentTitle("마루앱")
//            .setContentText("앱이 정보를 수집하고 있습니다.\n오늘의 걸음 ")
//            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//            .setAutoCancel(false)
//            .setOngoing(true)
//        with(NotificationManagerCompat.from(this)) {
//            if (ActivityCompat.checkSelfPermission(
//                    applicationContext,
//                    Manifest.permission.POST_NOTIFICATIONS
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                return
//            }
//            notify(NOTIFICATION_ID, notificationBuilder.build())
//        }
//    }
}
