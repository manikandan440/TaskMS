package com.example.mstask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.com.retrofitwithrecyclerviewkotlin.OnRepoClickListener
import app.com.retrofitwithrecyclerviewkotlin.RecyclerAdapter
import com.example.mstask.R
import com.example.mstask.Response.RepoResponse
import com.example.mstask.Retro.ApiInterface
import com.example.roomandroidexample.UserRepository
import com.example.roomandroidexample.Users
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Fragment1 : Fragment(){

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter
    var user: Users? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(
            R.layout.fragment1, container,
            false
        )

        val repo = UserRepository(view.context!!)
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerAdapter = RecyclerAdapter(object : OnRepoClickListener {
            override fun onItemClick(adapterPosition: RepoResponse) {

                val allUsers = repo.getuser(adapterPosition.id)
                loadFragment(FragmentDetail(allUsers,adapterPosition))

            }

            override fun onCommentSend(repoid: Int, comment: String) {
               val user = Users(user?.userId,repoid,comment)
                    repo.insertUser(user)
            }


        }, view.context)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = recyclerAdapter



        val apiInterface = ApiInterface.create().getRepos()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue(object : Callback<List<RepoResponse>> {
            override fun onResponse(
                call: Call<List<RepoResponse>>?,
                response: Response<List<RepoResponse>>?
            ) {

                if (response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<RepoResponse>>?, t: Throwable?) {

                Toast.makeText(context, "" + t.toString(), Toast.LENGTH_SHORT).show()
            }
        })

        return view
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = parentFragmentManager.beginTransaction()
        //transaction.replace(R.id.container, fragment)
//        transaction.hide(Fragment1())
//        transaction.hide(Fragment2())
//        transaction.hide(Fragment3())
        transaction.add(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}