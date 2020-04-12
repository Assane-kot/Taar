package com.jambaar.taar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jambaar.taar.R
import com.jambaar.taar.models.Categorie


class CategorieAdapter(private val context: Context, private val items: List<Categorie>) :
    BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var row = convertView
        val holder: ViewHolderItem

        if (row == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row = inflater.inflate(R.layout.single_gridview_item, parent, false)
            holder = ViewHolderItem(row!!)
            row.tag = holder
        } else {
            holder = row.tag as ViewHolderItem
        }

        val item: Categorie = items[position]
        val imageId = getImage(item.imageName)
        holder.imageView.setImageResource(imageId)
        holder.textView.text = item.title

        return row
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }


    class ViewHolderItem internal constructor(v: View) {
        var imageView: ImageView = v.findViewById(R.id.iv_item)
        var textView: TextView = v.findViewById(R.id.tv_title)

    }

    private fun getImage(imageName: String?): Int {
        return context.resources.getIdentifier(imageName, "drawable", context.packageName)
    }
}