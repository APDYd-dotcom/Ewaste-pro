package bi.clubtechlac.ewaste.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

  @Provides
  @Singleton
  fun provideHttpClient(): HttpClient {
    val client = HttpClient(CIO) {
      install(ContentNegotiation) {
        json(Json {
          ignoreUnknownKeys = true
          isLenient = true
          prettyPrint = true
        })
      }

    }
    return client
  }

}

