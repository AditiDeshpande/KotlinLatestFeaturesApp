package com.example.kotlinlatestfeaturesapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinlatestfeaturesapp.Model.Post
import com.example.kotlinlatestfeaturesapp.databinding.EachRowBinding

/*
Will be using ViewBinding
 */
class PostAdapter(private var postList: List<Post> )
    : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    /*
    xml file name is each_row so that's why binding name is EachRowBinding
     */
    private lateinit var binding : EachRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        binding = EachRowBinding.inflate(
            LayoutInflater.from(parent.context)
            ,parent
            ,false)
        return PostViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        binding.tasks.text = postList[position].body    }

    override fun getItemCount(): Int = postList.size

    //Inner class
    class PostViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    fun setData(postList: List<Post>){
        this.postList = postList
        notifyDataSetChanged()
    }
}