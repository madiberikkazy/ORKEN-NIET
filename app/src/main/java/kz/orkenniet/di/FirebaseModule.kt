package kz.orkenniet.di

import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

val firebaseModule = module {

    single {
        FirebaseAuth.getInstance()
    }
}