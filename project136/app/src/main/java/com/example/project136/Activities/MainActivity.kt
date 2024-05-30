package com.example.project136.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project136.Adapters.CategoryAdapter
import com.example.project136.Adapters.PupolarAdapter
import com.example.project136.Domains.CategoryDomain
import com.example.project136.Domains.PopularDomain
import com.example.project136.R
import android.util.Log
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    private var adapterPopular: RecyclerView.Adapter<*>? = null
    private var adapterCat: RecyclerView.Adapter<*>? = null
    private var recyclerViewPopular: RecyclerView? = null
    private var recyclerViewCategory: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("is_logged_in", false)
        Log.d("SharedPreferences", "is_logged_in: $isLoggedIn")
        if (!isLoggedIn) {
            val intent = Intent(this, EditProfile::class.java)
            startActivity(intent)
            finish()
            return
        }

        // edit profile
        setContentView(R.layout.activity_main)
        initRecyclerView()

        val profileImageView = findViewById<ImageView>(R.id.profile)
        profileImageView.setOnClickListener {
            startActivity(Intent(this, EditProfile::class.java))

        }
    }

    private fun initRecyclerView() {
        val items = ArrayList<PopularDomain>()
        items.add(
            PopularDomain(
                "The Greek Abode",
                "Oia, Greece",
                "This 3 bed /2 bath stunning retreat offers " +
                        " unparalleled panoramic views of the surrounding landscape. " +
                        " This exquisite residence boasts floor-to-ceiling" +
                        " windows that frame breathtaking vistas," +
                        " allowing you to immerse yourself in the beauty of nature from" +
                        " the comfort of your living room. ",
                3,
                true,
                4.8,
                "pic2",
                true,
                1000,
                "https://www.booking.com/Share-8kE5duI"



            )
        )
        items.add(
            PopularDomain(
                "Katamaran Resort",
                "Bali, Indonesia",
                "This 3 bed /2 bath stunning retreat offers " +
                        " unparalleled panoramic views of the surrounding landscape. " +
                        " This exquisite residence boasts floor-to-ceiling" +
                        " windows that frame breathtaking vistas," +
                        " allowing you to immerse yourself in the beauty of nature from" +
                        " the comfort of your living room. ",
                1,
                false,
                5.0,
                "pic1",
                false,
                2500,
                "https://www.booking.com/Share-oYofaV"
            )
        )
        items.add(
            PopularDomain(
                "Therasia Borgo",
                "Venice, Italy",
                "This 3 bed /2 bath stunning retreat offers " +
                        " unparalleled panoramic views of the surrounding landscape. " +
                        " This exquisite residence boasts floor-to-ceiling" +
                        " windows that frame breathtaking vistas," +
                        " allowing you to immerse yourself in the beauty of nature from" +
                        " the comfort of your living room. ",
                3,
                true,
                4.3,
                "pic3",
                true,
                30000,
                "https://www.booking.com/Share-B0aNIy"
            )
        )
        recyclerViewPopular = findViewById(R.id.view_pop)
        recyclerViewPopular?.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        adapterPopular = PupolarAdapter(items)
        recyclerViewPopular?.setAdapter(adapterPopular)
        val catsList = ArrayList<CategoryDomain>()
        catsList.add(CategoryDomain("Beachside", "beachside"))
        catsList.add(CategoryDomain("Homestay", "house"))
        catsList.add(CategoryDomain("Airbnb", "airbnb"))
        catsList.add(CategoryDomain("Hotel", "hotel"))
        catsList.add(CategoryDomain("Resorts", "resort"))

        recyclerViewCategory = findViewById(R.id.view_cat)
        recyclerViewCategory?.setLayoutManager(
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        )
        adapterCat = CategoryAdapter(catsList)
        recyclerViewCategory?.setAdapter(adapterCat)
    }
}