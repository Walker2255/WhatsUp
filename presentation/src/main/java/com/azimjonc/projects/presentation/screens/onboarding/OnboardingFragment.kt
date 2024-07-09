package com.azimjonc.projects.presentation.screens.onboarding

import android.os.Bundle
import android.view.View
import com.azimjonc.projects.presentation.base.BaseFragment
import com.azimjonc.projects.presentation.databinding.FragmentOnboardingBinding
import com.azimjonc.projects.presentation.screens.onboarding.OnboardingViewModel.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    private val viewModel: OnboardingViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()


    }

    private fun initUI() = with(binding) {
        next.setOnClickListener {
            viewModel.proccesInput(Input.Onboarded)
        }
    }
}