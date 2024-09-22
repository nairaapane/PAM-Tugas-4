package com.example.tugas4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Data> dataList = new ArrayList<>();
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        EditText editTextNama = findViewById(R.id.editTextNama);
        EditText editTextNim = findViewById(R.id.editTextNim);
        Button buttonAdd = findViewById(R.id.buttonAdd);

        dataList.add(new Data("Naira Oktarini Pane", "225150407111040"));
        dataList.add(new Data("Anna", "225150400111016"));

        adapter = new DataAdapter(dataList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = editTextNama.getText().toString();
                String nim = editTextNim.getText().toString();

                if (!nama.isEmpty() && !nim.isEmpty()) {
                    dataList.add(new Data(nama, nim));
                    adapter.notifyItemInserted(dataList.size() - 1);
                    editTextNama.setText("");
                    editTextNim.setText("");
                }
            }
        });
    }
}