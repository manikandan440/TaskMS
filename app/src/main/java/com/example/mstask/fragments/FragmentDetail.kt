package com.example.mstask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mstask.R
import com.example.mstask.Response.RepoResponse
import com.example.roomandroidexample.Users

class FragmentDetail(private val users: List<Users>, private val repo: RepoResponse) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //return inflater.inflate(R.layout.fragment_details,container,false)

        val view: View = inflater.inflate(R.layout.fragment_details, container,
            false)

        val tvMovieName: TextView = view.findViewById(R.id.txtView_title)
        val des: TextView = view.findViewById(R.id.txtView_description)
        val cmt: EditText = view.findViewById(R.id.cmt)
        val image: ImageView = view.findViewById(R.id.imgView_icon)

        tvMovieName.text = repo.name
        des.text = repo.description
        Glide.with(view.context!!).load(repo.owner.avatar_url)
            .apply(RequestOptions().centerCrop())
            .placeholder(R.drawable.ic_action_settings)
            .into(image)

        if(users.isNotEmpty()) {
            cmt.setText(users[0].comment)
            //Toast.makeText(context, "" + users[0].comment, Toast.LENGTH_SHORT).show()
        }
        return view
    }
}