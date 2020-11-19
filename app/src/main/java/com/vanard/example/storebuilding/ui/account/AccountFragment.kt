package com.vanard.example.storebuilding.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.vanard.example.storebuilding.R
import de.hdodenhof.circleimageview.CircleImageView

class AccountFragment : Fragment() {

    private lateinit var accountViewModel: AccountViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        accountViewModel =
                ViewModelProvider(this).get(AccountViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_account, container, false)
        val textView: TextView = root.findViewById(R.id.user_name_text)
        accountViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        val cardView: CardView = root.findViewById(R.id.action_card)
        cardView.setOnClickListener {
            Toast.makeText(requireContext(), "Card clicked!", Toast.LENGTH_SHORT).show()
        }

        val signOut: ConstraintLayout = root.findViewById(R.id.action_sign_out)
        signOut.setOnClickListener {
            Toast.makeText(requireContext(), "Sign out clicked!", Toast.LENGTH_SHORT).show()
        }

        val profileImage: CircleImageView = root.findViewById(R.id.profile_image)
        profileImage.load("https://avatars3.githubusercontent.com/u/25784574?s=460&u=52c2d751418056a96156cbac35a28a24461f6e8f&v=4")
//        {
//            crossfade(true)
//            crossfade(500)
//        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}