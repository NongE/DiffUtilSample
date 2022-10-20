package com.project.diffutilsample

import androidx.recyclerview.widget.DiffUtil

class BookDiffUtil(
    private val oldData: MutableList<BookData>,
    private val newData: MutableList<BookData>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldData.size

    override fun getNewListSize(): Int = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition].bookName == newData[newItemPosition].bookName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldData[oldItemPosition] == newData[newItemPosition]
    }
}