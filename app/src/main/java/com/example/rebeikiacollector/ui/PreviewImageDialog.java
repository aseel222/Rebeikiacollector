package com.example.rebeikiacollector.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;

import com.example.rebeikiacollector.R;
import com.example.rebeikiacollector.databinding.DialogPreviewImageBinding;

import java.io.File;

public class PreviewImageDialog extends DialogFragment {

    private DialogPreviewImageBinding binding;

    public static PreviewImageDialog newInstance(String url){
        PreviewImageDialog fragment = new PreviewImageDialog();
        fragment.setStyle(STYLE_NORMAL, R.style.FullScreenDialogTheme);
        Bundle args = new  Bundle();
        args.putString("image_url", url);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_preview_image, container, false);
        String image = getArguments().getString("image_url");
        File file = new File(image);
        binding.ivPreview.setImageURI(Uri.fromFile(file));
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
    }
}
