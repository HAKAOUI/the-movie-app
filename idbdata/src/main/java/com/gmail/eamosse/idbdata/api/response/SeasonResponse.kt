package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Season
import com.google.gson.annotations.SerializedName

internal data class SeasonResponse(
    // changer  par results
    @SerializedName("results")
    val results: List<Season>,
) {
    data class Season(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("poster_path") val image: String,
        @SerializedName("vote_average") val rating: String,
        @SerializedName("first_air_date") val firstAirDate: String,
    )
}

internal fun SeasonResponse.Season.toSeason() = Season(
    id = id,
    name = name,
    image = "https://image.tmdb.org/t/p/w185$image",
    rating = rating,
    firstAirDate = firstAirDate
)
