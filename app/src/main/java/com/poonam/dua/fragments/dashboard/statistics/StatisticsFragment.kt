package com.poonam.dua.fragments.dashboard.statistics

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poonam.dua.R
import com.poonam.dua.base.BindingFragment
import com.poonam.dua.databinding.FragmentStatisticsBinding
import com.poonam.dua.fragments.dashboard.profile.ProfileFragment

class StatisticsFragment : BindingFragment<FragmentStatisticsBinding>()  {
    companion object {
        val TAG: String = StatisticsFragment::class.java.simpleName
        fun newInstance() = StatisticsFragment()
    }
}