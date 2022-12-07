package com.nasywa.githubapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nasywa.githubapp.databinding.ActivityDetailUserActivityBinding

class DetailUserActivity : AppCompatActivity(){
    companion object{
        private  var EXTRA_USERNAME = "extra_username"
    }

    private  lateinit var  detailBinding: ActivityDetailUserActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailUserActivityBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        supportActionBar?.hide()

        var user = intent.getParcelableExtra<User>(EXTRA_USERNAME) as User
        Glide.with(this).load(user.avatar).into(detailBinding.ivProfileDetail)
        detailBinding.tvDetailName.text = user.name
        detailBinding.tvDetailUsername.text = user.username
        detailBinding.tvDetailCompany.text = user.company
        detailBinding.tvDetailLocation.text = user.location.toString()
        detailBinding.tvRepository.text = user.repository
        detailBinding.tvFollowers.text = user.followers
        detailBinding.tvFollowing.text = user.following
    }
}