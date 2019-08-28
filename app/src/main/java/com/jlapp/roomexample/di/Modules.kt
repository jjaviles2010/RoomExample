package com.jlapp.roomexample.di

import androidx.room.Room
import com.jlapp.roomexample.MainViewModel
import com.jlapp.roomexample.WordListAdapter
import com.jlapp.roomexample.dao.WordRoomDatabase
import com.jlapp.roomexample.repository.WordRepository
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single {
        WordRepository(get())
    }
}
val dbModule = module {
    single {
        Room.databaseBuilder(
            get(),
            WordRoomDatabase::class.java,
            "Word_database"
        ).build()
    }

    single {
        get<WordRoomDatabase>().wordDao()
    }
}
val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
}

val uiModule = module {
    factory { WordListAdapter(get()) }
}
