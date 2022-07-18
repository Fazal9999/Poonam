package com.poonam.dua.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.poonam.dua.utils.getBottomBinding

open class BindingDialog<VB : ViewBinding> : DialogFragment() {
    private var _binding: VB? = null
    protected val binding: VB
        get() = _binding
            ?: throw RuntimeException("Should only use binding after onCreateView and before onDestroyView")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = getBottomBinding(inflater, container)
        return binding.root
    }
    override
    fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}