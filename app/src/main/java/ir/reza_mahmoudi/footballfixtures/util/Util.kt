package ir.reza_mahmoudi.footballfixtures.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.request.RequestOptions
import ir.reza_mahmoudi.footballfixtures.R


fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

fun ImageView.loadImage(uri: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_damaged_image)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}

fun String.refactorDate(): String{
    return if (this.length == 8) {
        this.substring(0, 4) + " " + this.substring(4, 6) + " " + this.substring(6, 8)
    } else {
        this
    }
}