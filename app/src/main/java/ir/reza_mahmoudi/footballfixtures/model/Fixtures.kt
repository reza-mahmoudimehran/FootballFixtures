package ir.reza_mahmoudi.footballfixtures.model

import com.google.gson.annotations.SerializedName

data class Fixtures (
    @SerializedName("date")
    val date: String?,
    @SerializedName("leagues")
    val leagues: List<League>)
