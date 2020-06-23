package jp.wings.daisuzuki829.omikuji

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class OmikujiPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(android.R.id.content, OmikujiPreferenceFragment())
        fragmentTransaction.commit()
    }
}