package com.example.contactauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.contactauth.adapter.CategoryAdapter
import com.example.contactauth.databinding.ActivityCategoryBinding
import com.example.contactauth.models.Category

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Category"
        intent?.let {
            Toast.makeText(this, "Welcome ${it.getStringExtra("name")}", Toast.LENGTH_LONG).show()
        }
        setupCategory(binding)
    }

    private fun setupCategory(binding: ActivityCategoryBinding) {
        val categories = listOf(
            Category("F", "Family"),
            Category("B", "Business"),
            Category("F", "Friends"),
            Category("C", "Colleagues"),
            Category("T", "Tutors"),
            Category("P", "Private"),
            Category("V", "VIP")
        )
        val adapter = CategoryAdapter(categories)
        binding.categoryRv.adapter = adapter
        binding.categoryRv.layoutManager = GridLayoutManager(this, 2)
        binding.categoryRv.setHasFixedSize(true)
    }
}