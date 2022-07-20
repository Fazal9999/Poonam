package com.poonam.dua.fragments.login

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.poonam.dua.inter.clicklistner.Auth
import com.poonam.dua.inter.clicklistner.GoBack
import com.poonam.dua.base.BindingFragment
import com.poonam.dua.databinding.FragmentLoginBinding
import com.poonam.dua.databinding.HeaderBinding

class LoginFragment : BindingFragment<FragmentLoginBinding>(), Auth,GoBack {
    lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        val header:HeaderBinding=binding.header
          header.goBack=this
          binding.auth=this
    }

    override fun Login(view: View) {

    }

    override fun Forgot(view: View) {
        val action=LoginFragmentDirections.actionLoginFragmentToForgotDialog()
        navController.navigate(action)
    }

    override fun goBack(view: View) {
             navController.popBackStack()
    }
}