package com.project.diffutilsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.diffutilsample.databinding.ItemRecyclerViewBinding

class BookAdaptor(private val bookData: MutableList<BookData>) :
    RecyclerView.Adapter<BookAdaptor.BookViewHolder>() {

    inner class BookViewHolder(private val binding: ItemRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(bookData: BookData) {
            binding.bookPublisherText.text = bookData.publisher
            binding.bookNameText.text = bookData.bookName
            binding.bookPriceText.text = bookData.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookData[position])
    }

    override fun getItemCount(): Int {
        return bookData.size
    }

    fun updateData(newData: MutableList<BookData>) {
        val bookDiffUtil = BookDiffUtil(bookData, newData)
        val result = DiffUtil.calculateDiff(bookDiffUtil)

        bookData.clear()
        bookData.addAll(newData)
        result.dispatchUpdatesTo(this)
    }
}