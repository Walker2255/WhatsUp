package com.azimjonc.projects.whatsup.di

import com.azimjonc.projects.data.local.settings.SettingsRealm
import com.azimjonc.projects.data.local.settings.SettingsStorage
import com.azimjonc.projects.data.local.settings.SettingsStorageImpl
import com.azimjonc.projects.data.local.user.UserStorage
import com.azimjonc.projects.data.local.user.UserStorageImpl
import com.azimjonc.projects.data.remote.auth.AuthFirebase
import com.azimjonc.projects.data.remote.auth.AuthFirebaseImpl
import com.azimjonc.projects.data.remote.users.UsersFirestore
import com.azimjonc.projects.data.remote.users.UsersFirestoreImpl
import com.azimjonc.projects.data.repo.AuthRepositoryImpl
import com.azimjonc.projects.data.repo.ChatRepositoyrImpl
import com.azimjonc.projects.data.repo.SettingsRepositoryImpl
import com.azimjonc.projects.domain.model.ActivityHolder
import com.azimjonc.projects.domain.repo.AuthRepository
import com.azimjonc.projects.domain.repo.ChatRepository
import com.azimjonc.projects.domain.repo.SettingsRepository
import com.azimjonc.projects.domain.usecase.auth.SendSmsCodeUseCase
import com.azimjonc.projects.domain.usecase.auth.VerifyCodeUseCase
import com.azimjonc.projects.domain.usecase.chat.GetChatsUseCase
import com.azimjonc.projects.domain.usecase.settings.GetInitialScreenUseCase
import com.azimjonc.projects.domain.usecase.settings.OnboardedUseCase
import com.azimjonc.projects.presentation.screens.code.CodeViewModel
import com.azimjonc.projects.presentation.screens.home.HomeViewModel
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
    single { ActivityHolder() }
}

val repositoryModule = module {
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }
    single<SettingsRepository> { SettingsRepositoryImpl(get()) }
    single<ChatRepository> { ChatRepositoyrImpl(get()) }
}

val useCaseModule = module {
    single { SendSmsCodeUseCase(get()) }
    single { OnboardedUseCase(get()) }
    single { GetInitialScreenUseCase(get(), get()) }
    single { VerifyCodeUseCase(get()) }
    single { GetChatsUseCase(get()) }
}

val localModule = module {
    single<UserStorage> { UserStorageImpl() }
    single<SettingsStorage> { SettingsStorageImpl(get()) }
}

val remoteModule = module {
    single<AuthFirebase> { AuthFirebaseImpl(get()) }
    single<UsersFirestore> { UsersFirestoreImpl() }
}

val viewModelModule = module {
    viewModel { PhoneViewModel(get(), get()) }
    viewModel { MainViewModel(get(), get()) }
    viewModel { OnboardingViewModel(get(), get()) }
    viewModel { CodeViewModel(get(), get()) }
    viewModel { HomeViewModel(get()) }
}