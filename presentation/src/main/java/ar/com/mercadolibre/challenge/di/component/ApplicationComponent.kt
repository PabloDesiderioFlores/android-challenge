package ar.com.mercadolibre.challenge.di.component

import android.app.Application
import ar.com.mercadolibre.challenge.AndroidApplication
import ar.com.mercadolibre.challenge.di.builder.ContextModule
import ar.com.mercadolibre.challenge.di.module.ActivityBindingModule
import ar.com.mercadolibre.challenge.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Pablo Flores on 28/09/19.
 */
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, ApplicationModule::class,
        ActivityBindingModule::class, ContextModule::class]
)
interface ApplicationComponent : AndroidInjector<AndroidApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}