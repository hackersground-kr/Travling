package com.traveling.presentation.wiget

import android.app.AlarmManager
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.traveling.presentation.R
import com.traveling.presentation.features.main.MainActivity
import java.text.SimpleDateFormat
import java.util.*

class AlarmScheduler(private val context: Context) {

    companion object {
        private const val CHANNEL_ID = "AlarmChannel"
        private const val NOTIFICATION_ID = 30000
    }

    private val alarmManager: AlarmManager =
        context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    fun scheduleAlarms(alarmTimes: List<String>) {
        for (time in alarmTimes) {
            val calendar = Calendar.getInstance()
            val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
            val date = formatter.parse(time)
            calendar.time = date

            // 현재 날짜와 시간을 가져옴
            val now = Calendar.getInstance()
            if (now.after(calendar)) {
                // 현재 시간보다 이전인 경우 알람을 내일로 설정
                calendar.add(Calendar.DATE, 1)
            }

            val intent = Intent(context, AlarmReceiver::class.java)
            val pendingIntent =
                PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            // 알람 설정
            alarmManager.setExact(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }

    fun cancelAlarms() {
        val intent = Intent(context, AlarmReceiver::class.java)
        val pendingIntent =
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        alarmManager.cancel(pendingIntent)
    }

    class AlarmReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            // 알람이 울리면 실행되는 코드
            showNotification(context)
            playAlarmSound(context)
        }

        private fun showNotification(context: Context) {
            createNotificationChannel(context)

            val contentIntent = PendingIntent.getActivity(
                context,
                0,
                Intent(context, MainActivity::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            val notificationBuilder = NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("알림")
                .setContentText("알람이 울립니다!")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build())
        }

        private fun createNotificationChannel(context: Context) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(
                    CHANNEL_ID,
                    "알림 채널",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
                val notificationManager =
                    context.getSystemService(NotificationManager::class.java)
                notificationManager.createNotificationChannel(channel)
            }
        }

        private fun playAlarmSound(context: Context) {
            val alarmSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            val ringtone = RingtoneManager.getRingtone(context, alarmSoundUri)
            ringtone.play()
        }
    }
}
