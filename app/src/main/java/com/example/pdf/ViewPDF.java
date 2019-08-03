package com.example.pdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class ViewPDF extends AppCompatActivity {
    private PDFView pdfView;
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);
        pdfView= findViewById(R.id.pdfview);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            file=new File(bundle.getString("path",""));

        }
        pdfView.fromFile(file).enableSwipe(true).swipeHorizontal(false)
                .enableDoubletap(true)
                .enableAntialiasing(true)
                .load();
    }
}
