package com.poonam.dua.dialog

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.poonam.dua.activities.inter.clicklistner.Forgot
import com.poonam.dua.base.BindingDialog
import com.poonam.dua.databinding.DialogInputBinding


class ForgotDialog : BindingDialog<DialogInputBinding>(),Forgot {

    lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        binding.forgotOk=this

    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val width = resources.getDimensionPixelSize(300)
//        val height = resources.getDimensionPixelSize(300)
//        dialog!!.window!!.setLayout(width, height)
//    }
    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }
    override fun forgotOk(view: View) {
         navController.popBackStack()
    }


}