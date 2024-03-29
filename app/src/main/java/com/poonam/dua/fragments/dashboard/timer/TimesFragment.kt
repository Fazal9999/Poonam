package com.poonam.dua.fragments.dashboard.timer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.poonam.dua.R
import com.poonam.dua.base.BindingFragment
import com.poonam.dua.databinding.FragmentStatisticsBinding
import com.poonam.dua.databinding.FragmentTimesBinding
import com.poonam.dua.fragments.dashboard.statistics.StatisticsFragment


class TimesFragment : BindingFragment<FragmentTimesBinding>()  {
    companion object {
        val TAG: String = TimesFragment::class.java.simpleName
        fun newInstance() = TimesFragment()
    }
}