package jp.wings.nikkeibp.omikuji

import android.os.Bundle
import android.preference.PreferenceFragment

class OmikujiPreferenceFragment: PreferenceFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.preference)
    }
}