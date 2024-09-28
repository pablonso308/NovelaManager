package com.example.novela;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class NovelDetailActivity extends AppCompatActivity {

    private TextView textViewTitle, textViewAuthor, textViewYear, textViewSynopsis;
    private Button buttonFavorite;
    private NovelViewModel novelViewModel;
    private Novel novel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel_detail);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewAuthor = findViewById(R.id.textViewAuthor);
        textViewYear = findViewById(R.id.textViewYear);
        textViewSynopsis = findViewById(R.id.textViewSynopsis);
        buttonFavorite = findViewById(R.id.buttonFavorite);

        novelViewModel = new ViewModelProvider(this).get(NovelViewModel.class);

        // Obtener el ID de la novela seleccionada
        int novelId = getIntent().getIntExtra("novelId", -1);
        novel = novelViewModel.getNovelById(novelId);  // Asegúrate de implementar este método en tu ViewModel

        if (novel != null) {
            textViewTitle.setText(novel.getTitle());
            textViewAuthor.setText(novel.getAuthor());
            textViewYear.setText(String.valueOf(novel.getYear()));
            textViewSynopsis.setText(novel.getSynopsis());

            buttonFavorite.setText(novel.isFavorite() ? "Quitar de favoritos" : "Marcar como favorito");

            buttonFavorite.setOnClickListener(v -> {
                novel.setFavorite(!novel.isFavorite());
                novelViewModel.update(novel);  // Asegúrate de implementar este método en tu ViewModel

                String message = novel.isFavorite() ? "Marcada como favorita" : "Quitada de favoritos";
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

                buttonFavorite.setText(novel.isFavorite() ? "Quitar de favoritos" : "Marcar como favorito");
            });
        }
    }
}
