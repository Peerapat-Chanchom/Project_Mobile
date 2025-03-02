package com.example.yourapp.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project_mobile.R
import com.example.project_mobile.databinding.FragmentLoginBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            Log.d("LoginFragment", "Login button clicked")
            findNavController().navigate(R.id.action_navigation_login_to_navigation_home)
        }

        // ปุ่ม Facebook Login
        binding.btnFacebookLogin.setOnClickListener {
            showToast("Facebook Login Clicked")
            findNavController().navigate(R.id.action_navigation_login_to_navigation_home)
        }

        // ปุ่ม Google Login
        binding.btnGoogleLogin.setOnClickListener {
            showToast("Google Login Clicked")
            findNavController().navigate(R.id.action_navigation_login_to_navigation_home)
        }

        // ปุ่ม Apple Login
        binding.btnAppleLogin.setOnClickListener {
            showToast("Apple Login Clicked")
            findNavController().navigate(R.id.action_navigation_login_to_navigation_home)
        }

        // ปุ่ม Login
        /*binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                showToast("Please enter email and password")
            } else {
                showToast("Login Clicked: $email")
            }
        }*/

        // ปุ่ม Forgot Password
        binding.tvForgotPassword.setOnClickListener {
            showToast("Forgot Password Clicked")
        }

        // ปุ่ม Sign Up
        binding.tvSignUp.setOnClickListener {
            showToast("Sign Up Clicked")
        }

        // ปุ่ม LINE Chat
        binding.btnChatLine.setOnClickListener {
            showToast("LINE Chat Clicked")
        }
        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_login_to_signUpFragment)
        }
    }


    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}