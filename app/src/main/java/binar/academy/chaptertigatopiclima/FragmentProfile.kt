package binar.academy.chaptertigatopiclima

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_profile.*

class FragmentProfile : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Re-call data username from HomeFragment
        val gotProfile = arguments?.getString("userpro")
        yourName2.text = gotProfile

        // Keluar Button to go back to HomeFragment
        btnKeluar.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentProfile_to_fragmentHome)
        }
    }
}