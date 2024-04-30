package fernanda.hernandez.registrofirebaseferrr

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

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
        //1 mandar a llamar a todos los elementos de la vista
        val txtcorreo = findViewById<EditText>(R.id.txtcorreo)
        val txtcontra = findViewById<EditText>(R.id.txtcontra)
        val btnregistrarme = findViewById<Button>(R.id.btnregistrarme)

        fun limpiar(){
            txtcorreo.setText("")
            txtcontra.setText("")
            txtcorreo.clearFocus()
            txtcontra.clearFocus()
        }

        //2 programar el boton
        btnregistrarme.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(txtcorreo.text.toString(), txtcontra.text.toString())
            limpiar()
            Toast.makeText(this, "Usuario registrado", Toast.LENGTH_LONG).show()


        }
    }
}