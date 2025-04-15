package pro.grino.karateclub.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import pro.grino.karateclub.app.di.appModule
import pro.grino.karateclub.data.di.dataModule
import pro.grino.karateclub.domain.di.domainModule
import pro.grino.karateclub.features.groups.di.groupsModule
import pro.grino.karateclub.features.players.di.playersModule

class KarateClubApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Инициализация Koin
        startKoin {
            androidLogger(Level.ERROR) // Использование Level.ERROR для предотвращения краша на Android API <24
            androidContext(this@KarateClubApplication)
            modules(
                listOf(
                    appModule,

                    // Core модули
                    dataModule,
                    domainModule,

                    // Feature модули
                    playersModule,
                    groupsModule
                )
            )
        }
    }
}