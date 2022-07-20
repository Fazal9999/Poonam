package com.poonam.dua.fragments.auth

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.poonam.dua.inter.clicklistner.GetStarted
import com.poonam.dua.base.BindingFragment
import com.poonam.dua.databinding.FragmentAuthBinding
 
 class FragmentAuth:BindingFragment<FragmentAuthBinding>(),GetStarted {

    lateinit var navController: NavController



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         navController = Navigation.findNavController(view)
         binding.getStarted=this
    }

    override fun getStarted(view: View) {
      val action=FragmentAuthDirections.actionFragmentAuthToUserPrefActivity()
        navController.navigate(action)
    }

    override fun getLogin(view: View) {
         val action=FragmentAuthDirections.actionFragmentAuthToLoginFragment()
        navController.navigate(action)
    }
}