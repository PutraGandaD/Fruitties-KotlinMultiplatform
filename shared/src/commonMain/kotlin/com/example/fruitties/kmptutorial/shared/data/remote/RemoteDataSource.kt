package com.example.fruitties.kmptutorial.shared.data.remote

import com.example.fruitties.kmptutorial.shared.data.remote.dto.FruittiesResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlin.coroutines.cancellation.CancellationException

private const val BASE_URL = "https://android.github.io/kotlin-multiplatform-samples/fruitties-api"

interface RemoteDataSource {
    suspend fun getData(pageNumber: Int = 0): FruittiesResponseDto
}

class KtorRemoteDataSource(
    private val client: HttpClient
) : RemoteDataSource {
    override suspend fun getData(pageNumber: Int): FruittiesResponseDto {
        val url = "${BASE_URL}/$pageNumber.json"
        return try {
            client.get(url).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()

            FruittiesResponseDto(0, emptyList(), 0)
        }
    }
}