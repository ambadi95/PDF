package com.example.pdf;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] header = {"id", "nombre", "apellid"};
    private String shortText = "hello";
    private String longText = "hkjf ";
    private TemplatePDF templatePDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            TemplatePDF templatePDF = new TemplatePDF(getApplicationContext());
            templatePDF.openDocument();
            templatePDF.addMetaData("Clienr", "Ventas", "Maries");
            templatePDF.addTitles("Neway1", "neway2", "6/12/1002");
            templatePDF.addParagraph(shortText);
            templatePDF.addParagraph(longText);
            templatePDF.createtTable(header, getClients());
            templatePDF.CloseDocument();
        }catch (Exception e){
            Log.e("hello",e.toString());
        }
    }
        public void pdfView (View view){
            templatePDF.viewPDF();

        }

        private ArrayList<String[]> getClients () {
            ArrayList<String[]> rows = new ArrayList<>();

            rows.add(new String[]{"1", "Sree Ganapathy", "Salem"});
            rows.add(new String[]{"2", "Jeea", "Tiruvalluyr"});
            rows.add(new String[]{"3", "Ganapathy", "T pakkam"});
         //   rows.add(new String[]{"4", "Sree tradees", "Thiruninaur"});
            return rows;
        }
    }

