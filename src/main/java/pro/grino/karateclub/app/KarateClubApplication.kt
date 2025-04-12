package pro.grino.karateclub.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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

    // Список модулей Koin (будут импортированы из других модулей)
    private val appModules = listOf(
        // coreModule, будет добавлен позже
        // dataModule, будет добавлен позже
        // domainModule, будет добавлен позже
        // и т.д.
    )
}