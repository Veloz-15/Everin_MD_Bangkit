package com.dicoding.myapplication.view.Main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dicoding.myapplication.R
import com.dicoding.myapplication.view.Main.changeprofile.ChangeProfileActivity
import com.dicoding.myapplication.view.ViewModelFactory
import com.dicoding.myapplication.view.login.LoginActivity
import com.dicoding.myapplication.view.login.LoginViewModel

class ProfileFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val signOutButton: Button = view.findViewById(R.id.signupbutton)
        signOutButton.setOnClickListener {
            viewModel.logout()
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        val changePasswordTextView: TextView = view.findViewById(R.id.change_password)
        changePasswordTextView.setOnClickListener {
            val intent = Intent(activity, ChangeProfileActivity::class.java)
            startActivity(intent)
        }

        return view
    }
}