package com.azimjonc.projects.presentation.navigation

import com.azimjonc.projects.presentation.screens.phone.PhoneFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun Phone() = FragmentScreen { PhoneFragment() }
}