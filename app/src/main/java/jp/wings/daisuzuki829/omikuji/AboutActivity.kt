package jp.wings.daisuzuki829.omikuji

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.about.*

class AboutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.about)

        val info = packageManager.getPackageInfo(packageName, 0)
        textView2.text = "Version " + info.versionName
    }
}