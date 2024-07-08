package com.azimjonc.projects.whatsup.di

import com.azimjonc.projects.data.local.user.UserStorage
import com.azimjonc.projects.data.local.user.UserStorageImpl
import com.azimjonc.projects.data.remote.auth.AuthFirebase
import com.azimjonc.projects.data.remote.auth.AuthFirebaseImpl
import com.azimjonc.projects.data.repo.AuthRepositoryImpl
import com.azimjonc.projects.domain.repo.AuthRepository
import com.azimjonc.projects.domain.usecase.auth.SendSmsCodeUseCase
import com.azimjonc.projects.presentation.screens.main.MainViewModel
import com.azimjonc.projects.presentation.screens.phone.PhoneViewModel
import com.github.terrakok.cicerone.Cicerone
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import kotlin.math.sin

private val cicerone = Cicerone.create()

val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
}

val usecaseModule = module {
    single { SendSmsCodeUseCase(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val viewModelModule = module {
    viewModel { PhoneViewModel(get()) }
    viewModel { MainViewModel(get()) }
}