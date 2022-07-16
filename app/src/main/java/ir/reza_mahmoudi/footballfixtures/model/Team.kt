package ir.reza_mahmoudi.footballfixtures.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("longName")
    val name: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("score")
    val score: Int)