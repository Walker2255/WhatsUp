package com.azimjonc.projects.whatsup.di

import com.azimjonc.projects.data.local.settings.SettingsRealm
import com.azimjonc.projects.data.local.settings.SettingsStorage
import com.azimjonc.projects.data.local.settings.SettingsStorageImpl
import com.azimjonc.projects.data.local.user.UserStorage
import com.azimjonc.projects.data.local.user.UserStorageImpl
import com.azimjonc.projects.data.remote.auth.AuthFirebase
import com.azimjonc.projects.data.remote.auth.AuthFirebaseImpl
import com.azimjonc.projects.data.repo.AuthRepositoryImpl
import com.azimjonc.projects.data.repo.SettingsRepositoryImpl
import com.azimjonc.projects.domain.repo.AuthRepository
import com.azimjonc.projects.domain.repo.SettingsRepository
import com.azimjonc.projects.domain.usecase.auth.SendSmsCodeUseCase
import com.azimjonc.projects.domain.usecase.settings.GetOnboardedUseCase
import com.azimjonc.projects.domain.usecase.settings.OnboardedUseCase
import com.azimjonc.projects.presentation.screens.main.MainViewModel
import com.azimjonc.projects.presentation.screens.onboarding.OnboardingViewModel
import com.azimjonc.projects.presentation.screens.phone.PhoneViewModel
import com.github.terrakok.cicerone.Cicerone
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val cicerone = Cicerone.create()

val config = RealmConfiguration.Builder(schema = setOf(SettingsRealm::class)).build()


val appModule = module {
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }
    single { Realm.open(config) }
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
}

val useCaseModule = module {
    single { SendSmsCodeUseCase(get()) }
    single { OnboardedUseCase(get()) }
    single { GetOnboardedUseCase(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
    single<SettingsStorage> { SettingsStorageImpl(get()) }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl() }
}

val viewModelModule = module {
    viewModel { PhoneViewModel(get()) }
    viewModel { MainViewModel(get(), get()) }
    viewModel { OnboardingViewModel(get(), get()) }
}