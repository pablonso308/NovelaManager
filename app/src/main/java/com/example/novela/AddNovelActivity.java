package com.example.novela;



import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class AddNovelActivity extends AppCompatActivity {

    private EditText editTextTitle, editTextAuthor, editTextYear, editTextSynopsis;
    private Button buttonSave;
    private NovelViewModel novelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_novel);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextAuthor = findViewById(R.id.editTextAuthor);
        editTextYear = findViewById(R.id.editTextYear);
        editTextSynopsis = findViewById(R.id.editTextSynopsis);
        buttonSave = findViewById(R.id.buttonSave);

        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        buttonSave.setOnClickListener(v -> saveNovel());
    }

    private void saveNovel() {
        String title = editTextTitle.getText().toString();
        String author = editTextAuthor.getText().toString();
        String yearString = editTextYear.getText().toString();
        String synopsis = editTextSynopsis.getText().toString();

        if (title.isEmpty() || author.isEmpty() || yearString.isEmpty() || synopsis.isEmpty()) {
            Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        int year = Integer.parseInt(yearString);

        // Crear un nuevo objeto de novela
        Novel novel = new Novel(title, author, year, synopsis);

        // Insertar la novela en la base de datos a través del ViewModel
        novelViewModel.insert(novel);

        // Mostrar mensaje de éxito y cerrar la actividad
        Toast.makeText(this, "Novela agregada", Toast.LENGTH_SHORT).show();
        finish();
    }
}
