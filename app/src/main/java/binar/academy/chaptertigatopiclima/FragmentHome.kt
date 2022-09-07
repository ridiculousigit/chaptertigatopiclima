package binar.academy.chaptertigatopiclima

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_home.*

class FragmentHome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Re-call data username from LoginFragment
        super.onViewCreated(view, savedInstanceState)
        val getUsername = arguments?.getString("loginname")
        yourName.text = getUsername
        val gotUsername = yourName.text.toString()

        Toast.makeText(context, "Profil User : $gotUsername", Toast.LENGTH_SHORT).show()

        // Home Option to go back to LoginFragment
        opHome.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentLogin)
        }

        // Profile Option to navigate to ProfileFragment
        opProfile.setOnClickListener {
            /*val yourProfile = Bundle()
            yourProfile.putString("userpro", gotUsername)*/

            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentProfile)
        }

        // Hitung Button to calculate User Age
        btnHitung.setOnClickListener {
            val getYear = inTahun.text.toString().toInt()
            val getAge = (2022 - getYear).toString()
            val yourAge = Bundle()
            yourAge.putString("userage", gotUsername)
            yourAge.putString("age", getAge)

            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentUmur, yourAge)
        }
    }
}