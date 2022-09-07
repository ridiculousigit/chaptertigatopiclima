package binar.academy.chaptertigatopiclima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*

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

        val getUsername = arguments?.getString("regisname")
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
            val login = Bundle()
            login.putString("loginname", username)

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

}