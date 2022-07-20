package com.poonam.dua.fragments.dashboard.profileInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.poonam.dua.R
import com.poonam.dua.base.BindingFragment
import com.poonam.dua.databinding.FragmentDashboardBinding
import com.poonam.dua.databinding.FragmentProfileInfoBinding
import com.poonam.dua.fragments.dashboard.profile.ProfileFragment


class ProfileInfoFragment  : BindingFragment<FragmentProfileInfoBinding>() {
 companion object {
  val TAG: String = ProfileInfoFragment::class.java.simpleName
  fun newInstance() = ProfileInfoFragment()
 }

 lateinit var navController: NavController
 override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
  super.onViewCreated(view, savedInstanceState)
  navController = Navigation.findNavController(view)
  }

 }