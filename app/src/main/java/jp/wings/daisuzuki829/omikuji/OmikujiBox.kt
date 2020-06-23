package jp.wings.daisuzuki829.omikuji

import android.hardware.SensorEvent
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.RotateAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import kotlinx.android.synthetic.main.omikuji.*
import java.util.*

class OmikujiBox: Animation.AnimationListener {

    var beforeTime = 0L
    var beforeValue = 0F

    lateinit var omikujiView: ImageView
    var finish = false

    // プロパティ：クラスのデータ部分
    // インスタンス変数の宣言と初期化
    val number : Int
    // アクセサリ：プロパティの参照や設定時の処理
    get() {
        val rnd = Random()
        return rnd.nextInt(20)
    }

    fun shake() {
        val translate = TranslateAnimation(0f, 0f, 0f, -200f)
        translate.repeatMode = Animation.REVERSE
        translate.repeatCount = 5
        translate.duration = 100

        val rotate = RotateAnimation(0f, -36f, omikujiView.width/2f, omikujiView.height/2f)
        rotate.duration = 200
        val set = AnimationSet(true)
        set.addAnimation(rotate)
        set.addAnimation(translate)

        set.setAnimationListener(this)

        omikujiView.startAnimation(set)

        finish = true
    }

    override fun onAnimationRepeat(animation: Animation?) {
    }

    override fun onAnimationEnd(animation: Animation?) {
        omikujiView.setImageResource(R.drawable.omikuji2)
    }

    override fun onAnimationStart(animation: Animation?) {
    }

    fun chkShake(event: SensorEvent?): Boolean {
        val nowtime = System.currentTimeMillis()
        val difftime: Long = nowtime - beforeTime
        val nowvalue: Float = (event?.values?.get(0) ?: 0F) + (event?.values?.get(1) ?: 0F)

        if (1500 < difftime) {
            val speed = Math.abs(nowvalue - beforeValue) / difftime * 10000
            beforeTime = nowtime
            beforeValue = nowvalue

            if (50 < speed) {
                return true
            }
        }
        return false
    }


}