package chavez.jose.superheroeapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class HeroDetailsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_hero)

        val tvSuperheroName = findViewById<TextView>(R.id.tvSuperheroName)
        val tvRealName = findViewById<TextView>(R.id.tvRealName)
        val tvPublisher = findViewById<TextView>(R.id.tvPublisher)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val ivSuperheroPhoto = findViewById<ImageView>(R.id.ivSuperheroPhoto)

        val superheroName = intent.getStringExtra("superheroName")
        val realName = intent.getStringExtra("realName")
        val publisher = intent.getStringExtra("publisher")
        val description = intent.getStringExtra("description")
        val photo = intent.getStringExtra("photo")

        tvSuperheroName.text = superheroName
        tvRealName.text = realName
        tvPublisher.text = publisher
        tvDescription.text = description
        Picasso.get().load(photo).into(ivSuperheroPhoto)
    }

}