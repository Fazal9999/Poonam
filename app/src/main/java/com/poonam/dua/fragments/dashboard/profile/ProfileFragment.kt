package com.poonam.dua.fragments.dashboard.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.poonam.dua.R
import com.poonam.dua.base.BindingFragment
import com.poonam.dua.databinding.FragmentChatBinding
import com.poonam.dua.databinding.FragmentProfileBinding
import com.poonam.dua.fragments.dashboard.dashboard.DashboardFragment
import com.poonam.dua.inter.clicklistner.profile.ProfileClick


class ProfileFragment : BindingFragment<FragmentProfileBinding>(), ProfileClick {
  companion object {
   val TAG: String = ProfileFragment::class.java.simpleName
   fun newInstance() = ProfileFragment()
  }

  lateinit var navController: NavController

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
   super.onViewCreated(view, savedInstanceState)
   navController = Navigation.findNavController(view)
   binding.profileclicks=this
  }

 override fun gotoSettings(view: View) {

 }

 override fun gotoProfile(view: View) {
 val action=ProfileFragmentDirections.actionProfileFragmentToProfileInfoFragment()
 navController.navigate(action)
 }
}