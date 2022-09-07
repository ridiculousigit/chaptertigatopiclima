package binar.academy.chaptertigatopiclima

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_register.*

class FragmentRegister : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Register Button for User Registration
        btnRegister.setOnClickListener {
            val username = inUsername2.text.toString()
            val nama = inName.text.toString()
            val password = inPassword2.text.toString()
            val register = Bundle()
            register.putString("regisname", username)
            register.putString("regisnama", nama)
            register.putString("regispass", password)

            // When the button is clicked it will navigate to LoginFragment
            Navigation.findNavController(view).navigate(R.id.action_fragmentRegister_to_fragmentLogin, register)
        }
    }
}