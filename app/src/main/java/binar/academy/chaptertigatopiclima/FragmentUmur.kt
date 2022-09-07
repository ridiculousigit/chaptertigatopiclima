package binar.academy.chaptertigatopiclima

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_umur.*

class FragmentUmur : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_umur, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Re-call value data username and their ages
        val getUsername = arguments?.getString("userage")
        val getUserage = arguments?.getString("age")
        yourName3.text = getUsername
        hasilUmur.text = "$getUserage tahun"

        Toast.makeText(context, getUserage, Toast.LENGTH_SHORT).show()
    }
}