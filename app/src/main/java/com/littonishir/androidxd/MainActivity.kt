package com.littonishir.androidxd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.littonishir.androidxd.java.SnapHelperActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_name.setOnClickListener {
            val intent = Intent(this, SnapHelperActivity::class.java)
            startActivity(intent)
            println()
        }
    }
}
