package com.example.project136.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.project136.Domains.PopularDomain
import com.example.project136.R

class DetailActivity : AppCompatActivity() {
    private var titleTxt: TextView? = null
    private var locationTxt: TextView? = null
    private var bedTxt: TextView? = null
    private var guideTxt: TextView? = null
    private var wifiTxt: TextView? = null
    private var descriptionTxt: TextView? = null
    private var scoreTxt: TextView? = null
    private var item: PopularDomain? = null
    private var picImg: ImageView? = null
    private var backBtn: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Initialize the views
        initView()

        // Set the values to the views
        setVariable()

        // Set the book button listener
        val bookButton = findViewById<Button>(R.id.bookbutton)
        bookButton.setOnClickListener {
            item?.bookingUrl?.let { url ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }

    private fun setVariable() {
        item = intent.getSerializableExtra("object") as? PopularDomain
        item?.let {
            titleTxt?.text = it.title
            scoreTxt?.text = "${it.score}"
            locationTxt?.text = it.location
            bedTxt?.text = "${it.bed} Bed"
            descriptionTxt?.text = it.description
            guideTxt?.text = if (it.isGuide) "Guide" else "No-Guide"
            wifiTxt?.text = if (it.isWifi) "Wifi" else "No-Wifi"

            val drawableResId = resources.getIdentifier(it.pic, "drawable", packageName)
            Glide.with(this).load(drawableResId).into(picImg!!)
            backBtn?.setOnClickListener { finish() }
        }
    }

    private fun initView() {
        titleTxt = findViewById(R.id.titleTxt)
        locationTxt = findViewById(R.id.locationTxt)
        bedTxt = findViewById(R.id.bedTxt)
        guideTxt = findViewById(R.id.guideTxt)
        wifiTxt = findViewById(R.id.wifiTxt)
        descriptionTxt = findViewById(R.id.descriptionTxt)
        scoreTxt = findViewById(R.id.scoreTxt)
        picImg = findViewById(R.id.picImg)
        backBtn = findViewById(R.id.backBtn)
    }
}
