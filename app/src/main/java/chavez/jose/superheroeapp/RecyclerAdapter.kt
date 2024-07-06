package chavez.jose.superheroeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val superheros: MutableList<Superhero>, private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val superheroName = view.findViewById<TextView>(R.id.tvSuperhero)
        private val realName = view.findViewById<TextView>(R.id.tvRealName)
        private val publisher = view.findViewById<TextView>(R.id.tvPublisher)
        private val avatar = view.findViewById<ImageView>(R.id.ivAvatar)

        fun bind(superhero: Superhero, context: Context) {
            superheroName.text = superhero.superhero
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            avatar.loadUrl(superhero.photo)

            itemView.setOnClickListener {
                val intent = Intent(context, HeroDetailsActivity::class.java).apply {
                    putExtra("superheroName", superhero.superhero)
                    putExtra("realName", superhero.realName)
                    putExtra("publisher", superhero.publisher)
                    putExtra("photo", superhero.photo)
                    putExtra("description", superhero.description)
                }
                context.startActivity(intent)
            }
            avatar.loadUrl(superhero.photo)
        }

        private fun ImageView.loadUrl(url: String) {
            Picasso.get().load(url).into(this)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros[position]
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero_list, parent, false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }
}
