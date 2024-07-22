package com.azimjonc.projects.presentation.navigation

import com.azimjonc.projects.presentation.screens.code.CodeFragment
import com.azimjonc.projects.presentation.screens.home.HomeFragment
import com.azimjonc.projects.presentation.screens.onboarding.OnboardingFragment
import com.azimjonc.projects.presentation.screens.phone.PhoneFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun PhoneScreen() = FragmentScreen { PhoneFragment() }
    fun OnboardingScreen() = FragmentScreen { OnboardingFragment() }
    fun CodeScreen(phone: String) = FragmentScreen { CodeFragment(phone) }
    fun HomeScreen() = FragmentScreen { HomeFragment() }
}