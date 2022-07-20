package com.poonam.dua.fragments.dashboard.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poonam.dua.R
import com.poonam.dua.base.BindingFragment
import com.poonam.dua.databinding.FragmentChatBinding
import com.poonam.dua.databinding.FragmentDashboardBinding
import com.poonam.dua.fragments.dashboard.chat.ChatFragment


class DashboardFragment  : BindingFragment<FragmentDashboardBinding>() {
    companion object {
        val TAG: String = DashboardFragment::class.java.simpleName
        fun newInstance() = DashboardFragment()
    }
}