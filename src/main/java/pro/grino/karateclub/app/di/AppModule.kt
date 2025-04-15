package pro.grino.karateclub.app.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pro.grino.karateclub.features.groups.GroupsViewModel
import pro.grino.karateclub.features.players.PlayersViewModel

val appModule = module {
    // ViewModels
    viewModel { PlayersViewModel(get()) }
    viewModel { GroupsViewModel(get()) }
}