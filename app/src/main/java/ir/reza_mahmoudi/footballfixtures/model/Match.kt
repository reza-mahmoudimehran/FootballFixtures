package ir.reza_mahmoudi.footballfixtures.model

import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("time")
    val time: String?,
    @SerializedName("home")
    val home: Team,
    @SerializedName("away")
    val away: Team,
)