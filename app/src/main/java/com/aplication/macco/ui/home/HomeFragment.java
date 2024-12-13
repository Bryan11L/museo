package com.aplication.macco.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.aplication.macco.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        WebView webView = binding.webView;
        webView.setWebViewClient(new WebViewClient()); // Para abrir enlaces dentro del WebView
        webView.getSettings().setJavaScriptEnabled(true); // Habilitar JavaScript

        // Cargar el video de YouTube
        String videoId = "2aG34x6Giig"; // Reemplaza con el ID de tu video
        String videoUrl = "https://www.youtube.com/embed/" + videoId;
        webView.loadUrl(videoUrl);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}