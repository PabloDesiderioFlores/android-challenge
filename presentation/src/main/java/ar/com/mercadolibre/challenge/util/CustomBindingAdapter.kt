package ar.com.mercadolibre.challenge.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import ar.com.mercadolibre.challenge.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * Created by Pablo Flores on 01/10/19.
 */
object CustomBindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:image_url")
    fun loadImage(imageView: ImageView, url: String) {
        Glide
            .with(imageView.context)
            .load(url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.ic_broken_image)
            )
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("bind:acceptMercadoPago")
    fun handleBoolean(textView: TextView, it: Boolean) {
        textView.text = if (it) "Acepta Mercado pago" else "No acepta Mercado Pago"
    }
}