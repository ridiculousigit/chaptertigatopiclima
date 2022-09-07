package binar.academy.chaptertigatopiclima

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*
import java.util.*

class FragmentLogin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Recall data username, nama, and password from RegisterFragment
        val getUsername = arguments?.getString("regisname")
        val getNama = arguments?.getString("regisnama")
        val getPassword = arguments?.getString("regispass")

        // Register Option to navigate to RegisterFragment
        opRegister.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentRegister)
        }

        // Forgotten Option to navigate to LupaFragment
        opForget.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentLupa)
        }

        // Login Button to navigate to HomeFragment
        btnLogin.setOnClickListener {
            val username = inUsername.text.toString()
            val password = inPassword.text.toString()
            val nama = getNama.toString().capitalizeWords()
            val login = Bundle()
            login.putString("loginname", username)
            login.putString("loginnama", nama)

            if (username == getUsername && password == getPassword) {
                Toast.makeText(context, "Selamat Datang !", Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentHome, login)
            } else {
                Toast.makeText(context, "Username & Password TIDAK TERDAFTAR !", Toast.LENGTH_SHORT).show()
            }
        }

        // Chat Option to navigate to ChatsFragment
        opChat.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentChats)
        }

        // Help Option to navigate to ChatsFragment
        opAsk.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentLogin_to_fragmentHelp)
        }
    }

    // Method for Capitalize Each Word of Nama
    @SuppressLint("DefaultLocale")
    fun String.capitalizeWords(): String =
        split(" ").joinToString(" ") { it ->
            it.lowercase(Locale.getDefault())
            .replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
        }
}