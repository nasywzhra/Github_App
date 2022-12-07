package com.nasywa.githubapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nasywa.githubapp.databinding.ItemUserBinding


class ListUserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    inner class ListViewHolder(var binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            with(binding) {
                Glide.with(binding.ivUser.context)
                    .load(user.avatar)
                    .apply(RequestOptions().override(60, 60))
                    .into(binding.ivUser)
                binding.ivName.text = user.name
                binding.ivUsername.text = user.username

//                itemView.setOnClickListener {
//                    itemView.context?.startActivity(
//                        itemView.context.intentFor<DetailUserActivity>(
//                            "extra_username" to user
//                        )
//                    )
//                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int = listUser.size

//            private lateinit var onItemClickCallback: OnItemClickCallback

//            interface OnItemClickCallback {
//                fun onItemClick(user: User)
//            }
//
//            fun setOnClickCallback(onItemClickCallback: OnItemClickCallback) {
//                this.onItemClickCallback = onItemClickCallback
//            }
}