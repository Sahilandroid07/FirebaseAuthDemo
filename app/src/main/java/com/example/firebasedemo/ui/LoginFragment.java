package com.example.firebasedemo.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.firebasedemo.R;
import com.example.firebasedemo.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setup();
    }

    private void setup() {
        binding.btnLogin.setOnClickListener(v -> {
            String mobileNumber = binding.etMobile.getText().toString();
            if (mobileNumber.length() == 10) {
                NavHostFragment.findNavController(this).navigate(LoginFragmentDirections
                        .actionLoginFragmentToOtpFragment(mobileNumber));
            }else {
                Toast.makeText(requireContext(), "Please enter mobile number", Toast.LENGTH_SHORT).show();
            }
        });
    }
}