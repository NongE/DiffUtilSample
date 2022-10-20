package com.project.diffutilsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.diffutilsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookList = mutableListOf<BookData>(
            BookData("A Book", "1000", "A Publisher")
        )

        val adapter = BookAdaptor(bookList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.addItem.setOnClickListener {
            val new = mutableListOf<BookData>()
            new.addAll(bookList)
            new.add(0, BookData("BookName - ${(0..100).random()}", "${(10000..50000).random()}원", "BookName - ${(0..10).random()}"))

            adapter.updateData(new)
            binding.recyclerView.smoothScrollToPosition(0)
        }
    }
}