package com.poonam.dua.fragments.auth

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.poonam.dua.activities.inter.clicklistner.GetStarted
import com.poonam.dua.activities.main.MainActivity
import com.poonam.dua.activities.preferences.UserPrefActivity
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
        val intent = Intent(requireActivity(), UserPrefActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(
            intent,
            ActivityOptions.makeSceneTransitionAnimation(requireActivity()).toBundle()
        )
        requireActivity().finish()
    }

    override fun getLogin(view: View) {
         val action=FragmentAuthDirections.actionFragmentAuthToLoginFragment()
        navController.navigate(action)
    }
}