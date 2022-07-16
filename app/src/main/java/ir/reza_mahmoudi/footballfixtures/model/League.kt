package ir.reza_mahmoudi.footballfixtures.model

import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("name")
    val name: String?,
    @SerializedName("matches")
    val matches: List<Match>)