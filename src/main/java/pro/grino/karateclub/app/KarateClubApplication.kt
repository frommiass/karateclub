package pro.grino.karateclub.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class KarateClubApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Инициализация Koin
        startKoin {
            androidLogger(Level.ERROR) // Использование Level.ERROR для предотвращения краша на Android API <24
            androidContext(this@KarateClubApplication)
            modules(appModules)
        }
    }

    // Список временных модулей для начальной работы приложения
    private val appModules = listOf(
        module {
            // Временные зависимости для работы приложения
            // Позже этот список будет заменен на реальные модули из других пакетов
        }
    )
}