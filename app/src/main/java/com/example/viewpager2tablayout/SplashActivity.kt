package com.example.viewpager2tablayout

import android.content.Intent
import android.os.Handler
import com.airbnb.lottie.LottieAnimationView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

//로딩화면
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var loadingImage = findViewById(R.id.loading_image) as LottieAnimationView

        // 애니메이션 시작
        loadingImage.playAnimation()

        val handler: Handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}