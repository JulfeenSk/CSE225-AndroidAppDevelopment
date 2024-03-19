package com.examples.unit2


import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class JobScheduler : AppCompatActivity() {
    var jobScheduler:JobScheduler?=null

    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_scheduler)
        val stopJob=findViewById<Button>(R.id.stopJob)
        val startJob=findViewById<Button>(R.id.startJob)

        startJob.setOnClickListener{
            jobScheduler= getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName=ComponentName(this,MyJobService::class.java)
            val builder=JobInfo.Builder(123,componentName)
            builder.setMinimumLatency(3000)
            builder.setOverrideDeadline(5000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())

        }
        stopJob.setOnClickListener {
            if(jobScheduler!=null){
                jobScheduler!!.cancel(123)
                jobScheduler=null
                Toast.makeText(this,"Job Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}