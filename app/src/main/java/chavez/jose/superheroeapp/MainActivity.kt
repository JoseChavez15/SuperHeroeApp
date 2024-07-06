package chavez.jose.superheroeapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpRecyclerView()
    }

    private fun getSuperheros(): MutableList<Superhero> {
        val superheros = mutableListOf<Superhero>()
        superheros.add(Superhero("Spiderman", "Marvel", "Peter Parker", "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg","Un joven con habilidades arácnidas."))
        superheros.add(Superhero("Daredevil", "Marvel", "Mathew Michael Murdock", "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg","Un abogado ciego con sentidos agudizados."))
        superheros.add(Superhero("Wolverine", "Marvel", "James Howlett", "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg","Es un mutante que posee sentidos afinados a los animales, capacidades físicas mejoradas, poderosa capacidad de regeneración conocida como un factor de curación, y tres garras retráctiles en cada mano."))
        superheros.add(Superhero("Batman", "DC", "Bruce Wayne", "https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg","Batman es un hombre alto, caucásico, tiene una figura oscura e imponente, posee con cabello negro corto y ojos marrones. Él lleva un traje gris oscuro con el símbolo negro de un murciélago, en medio de el pecho. Batman también usa una capucha negra que lo cubre en todo momento para ocultar su identidad."))
        superheros.add(Superhero("Thor", "Marvel", "Thor Odinson", "https://cursokotlin.com/wp-content/uploads/2017/07/thor.jpg","Thor, es un superhéroe y príncipe-guerrero de Asgard, dios del trueno, y protector de la tierra, y de los 9 reinos. Él empuña un martillo, el cual solo podrá ser levantado por alguien que “sea digno de él, el cual obtendrá el poder de thor”. Thor-fis protector de los valores éticos."))
        superheros.add(Superhero("Flash", "DC", "Jay Garrick", "https://cursokotlin.com/wp-content/uploads/2017/07/flash.png","La principal característica de “The Flash” es la súper velocidad, más rápida que la velocidad de la luz. De hecho, “The Flash” es un superhéroe con la capacidad de moverse siete veces más rápido que la luz, yendo más allá de ciertas leyes de la física."))
        superheros.add(Superhero("Green Lantern", "DC", "Alan Scott", "https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg","Green Lantern (Hal Jordan) es miembro de una fuerza policíaca conocida como los Green Lanterns, liderados por Los Guardianes del Universo. Hal Jordan es, en cierta forma, el Linterna Verde más poderoso de todos, pues en el comic Crepúsculo Esmeralda se le ve asesinar a todos los Linternas Verdes e incluso a Siniestro."))
        superheros.add(Superhero("Wonder Woman", "DC", "Princess Diana", "https://cursokotlin.com/wp-content/uploads/2017/07/wonder_woman.jpg","Además de ser la embajadora de las amazonas hacia el resto del mundo, Mujer Maravilla posee estupendas habilidades y dones superhumanos, concedidos a ella por los dioses griegos en su victoria. Entre ellos se incluyen un lazo mágico que obliga a decir la verdad, hace perder la memoria y es indestructible."))
        superheros.add(Superhero("Iron Man", "Marvel", "Tony Stark","https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg","Tony Stark es un genio inventivo cuya experiencia en los campos de las matemáticas, la física, la química y la informática compite con la de Reed Richards, Hank Pym y Bruce Banner, y su experiencia en ingeniería eléctrica e ingeniería mecánica supera a la de ellos."))
        superheros.add(Superhero("Capitán América", "Marvel", "Steven Grant Rogers","https://acorazadobismarck.es/wp-content/uploads/2022/10/2021427125442_1-1080x675.jpg","Sentidos, agilidad, velocidad y fuerza sobrehumanas. Gran habilidad con su escudo. Instinto de liderazgo, gran resistencia, inmune a gases y enfermedades, curación y regeneración acelerada. Genio táctico, artista marcial, acróbata experto."))
        superheros.add(Superhero("Hulk", "Marvel", "Bruce Banner","https://i.pinimg.com/736x/b2/7c/4a/b27c4ad38351e60f8866fcdc5f6f984a.jpg","Hulk es un superhéroe ficticio que apareció por primera vez en los populares cómics de la Marvel en 1962. Siempre se le representa bajo una forma humanoide de piel verde capaz de usar una fuerza, resistencia y velocidad sobrehumanas y casi ilimitadas."))
        superheros.add(Superhero("Black Widow", "Marvel", "Natasha","https://i.pinimg.com/564x/83/d0/92/83d09207fe1dd0c2cbd0f1ba4337817b.jpg","Natasha nació en Stalingrado (ahora Volgogrado), Rusia. La primera y más conocida Viuda Negra, es una agente rusa entrenada como espía, artista marcial y francotiradora, y equipada con un arsenal de armas de alta tecnología, que incluye un par de armas energéticas montadas en la muñeca y apodada Piquete de la Viuda."))
        superheros.add(Superhero("Doctor Strange", "Marvel", "Stephen Vicent Strange","https://estaticos.elmundo.es/assets/multimedia/imagenes/2016/10/28/14776683188057.jpg","Doctor Strange sirve como el Hechicero Supremo, el principal protector de la Tierra contra las amenazas mágicas y místicas. Inspirado en historias de magia negra y Chandu el Mago, Strange fue creado durante la edad de plata de los cómics para traer un tipo diferente de personajes y temas a Marvel."))
        superheros.add(Superhero("Wanda Maximoff", "Marvel", "Scarlet Witch","https://static.wikia.nocookie.net/marvelcinematicuniverse/images/9/97/Scarlet_Witch.jpg/revision/latest/scale-to-width-down/1200?cb=20231021153444","El personaje, presentado en sus inicios en una mutante, posee habilidades para alterar la realidad de formas no especificadas y es, además, una poderosa hechicera. Más tarde, se convertiría en miembro regular de Los Vengadores. Con el tiempo, contraería matrimonio con su compañero de equipo llamado Visión."))
        superheros.add(Superhero("Don Ramón", "La vecindad del Chavo", "Ramón Valdez (El Roro)","https://peru21.pe/resizer/LqSN86gpBXDRk5MJnHa0XWJLwHk=/1200x1200/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/F3C5AMXQRFBRDNQYMTR5YWJVUM.jpg","Don Ramón es un personaje de la serie de televisión de comedia mexicana El Chavo del 8 personificado por el actor mexicano Ramón Valdés. Es un viudo cesante retirado que vive en el departamento n.º 72 de la vecindad del Chavo, propiedad del señor Barriga."))
        superheros.add(Superhero("Dina Balearte", "Presidenta de su casa", "Fusila Peruanos","https://statics.exitosanoticias.pe/2024/04/66108f0e9a9f3.jpg","Una política que siempre está 'trabajando' a favor del Perú, ¡Sí, claro! jaja, ¡la reina del saqueo! Podría ser asi como dijo un querido periodista Curwen"))

        return superheros
    }

    private fun setUpRecyclerView() {
        val myRecyclerView: RecyclerView = findViewById(R.id.rvSuperheroList)
        myRecyclerView.setHasFixedSize(true)
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        val mAdapter = RecyclerAdapter(getSuperheros(), this)
        myRecyclerView.adapter = mAdapter

    }
}

