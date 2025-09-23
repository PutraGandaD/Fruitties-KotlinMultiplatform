package com.example.fruitties.kmptutorial.shared.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FruittiesResponseDto(
    @SerialName("currentPage")
    val currentPage: Int,
    @SerialName("feed")
    val feed: List<Feed>,
    @SerialName("totalPages")
    val totalPages: Int
) {
    @Serializable
    data class Feed(
        @SerialName("calories")
        val calories: String,
        @SerialName("full_name")
        val fullName: String,
        @SerialName("id")
        val id: Int,
        @SerialName("name")
        val name: String
    )
}