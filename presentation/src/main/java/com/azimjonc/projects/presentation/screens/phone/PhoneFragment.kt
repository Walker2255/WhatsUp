package com.azimjonc.projects.presentation.screens.phone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.azimjonc.projects.domain.model.User
import com.azimjonc.projects.presentation.base.BaseFragment
import com.azimjonc.projects.presentation.databinding.FragmentPhoneBinding
import com.azimjonc.projects.presentation.screens.phone.PhoneViewModel.Effect

class PhoneFragment : BaseFragment<FragmentPhoneBinding>(FragmentPhoneBinding::inflate) {

    private lateinit var viewModel: PhoneViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(::renderUser) { it.user!! }
        viewModel.effects.doOnNext(::handleEffects)
    }

    private fun renderUser(user: User?) {

    }

    private fun handleEffects(effect: Effect) {

    }
}