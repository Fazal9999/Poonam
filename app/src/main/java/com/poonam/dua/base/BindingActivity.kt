package com.poonam.dua.base

import android.os.Bundle
import android.transition.Explode
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.poonam.dua.utils.getBinding
import dagger.android.support.DaggerAppCompatActivity

open class BindingActivity<VB : ViewBinding> : DaggerAppCompatActivity() {
    lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    if (::binding.isInitialized.not()) {
        binding = getBinding()
        with(window) {
            requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
            // set an exit transition
            exitTransition = Explode()
        }
        setContentView(binding.root)
    }
}
}