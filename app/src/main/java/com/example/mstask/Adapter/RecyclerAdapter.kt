package app.com.retrofitwithrecyclerviewkotlin

import android.content.Context
import android.text.Editable
import android.text.TextWatcher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mstask.R
import com.example.mstask.Response.RepoResponse

interface OnRepoClickListener {
    fun onItemClick(adapterPosition: RepoResponse)
    fun onCommentSend(repoid: Int,comment: String)
}
class RecyclerAdapter(private val listener: OnRepoClickListener,val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var movieList : List<RepoResponse> = listOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)



        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = movieList.get(position).name
        holder.des.text = movieList.get(position).description
        Glide.with(context).load(movieList.get(position).owner.avatar_url)
                .apply(RequestOptions().centerCrop())
                .placeholder(R.drawable.ic_action_settings)
                .into(holder.image)

        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.onItemClick(movieList.get(position))
        })


        holder.cmt.setOnEditorActionListener { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_SEND){
                if(holder.cmt.text.isNotEmpty()) {
                    listener.onCommentSend(movieList[position].id, holder.cmt.text.toString())
                    Toast.makeText(context, "comments saved successfully..!!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "Write a valid comments..!!", Toast.LENGTH_SHORT).show()
                }
                true
            } else {
                false
            }
        }

    }

    fun setMovieListItems(movieList: List<RepoResponse>){
        this.movieList = movieList
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val tvMovieName: TextView = itemView!!.findViewById(R.id.txtView_title)
        val des: TextView = itemView!!.findViewById(R.id.txtView_description)
        val cmt: EditText = itemView!!.findViewById(R.id.cmt)
        val image: ImageView = itemView!!.findViewById(R.id.imgView_icon)

    }
}