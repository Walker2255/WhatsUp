package com.azimjonc.projects.presentation.screens.code

import android.os.Bundle
import android.view.View
import com.azimjonc.projects.presentation.R
import com.azimjonc.projects.presentation.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.azimjonc.projects.presentation.databinding.FragmentCodeBinding
import com.azimjonc.projects.presentation.screens.code.CodeViewModel.Effect
import com.azimjonc.projects.presentation.screens.code.CodeViewModel.Input

class CodeFragment(
    private val phone: String
) : BaseFragment<FragmentCodeBinding>(FragmentCodeBinding::inflate) {


    private val viewModel: CodeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        viewModel.effects.subscribe(::handleEffects)
    }

    private fun handleEffects(effect: Effect) {
        when (effect) {
            Effect.Error -> snackbar(R.string.code_error)
        }
    }

    private fun initUI() = with(binding) {

        verify.setOnClickListener {
            val otp = otp.otp?.takeIf { it.length == 6 } ?: return@setOnClickListener
            viewModel.proccesInput(Input.Verify(otp))
        }

        title.text = getString(R.string.fragment_code_sent_to, phone)
    }
}