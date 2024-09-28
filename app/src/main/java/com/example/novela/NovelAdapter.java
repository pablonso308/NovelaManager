package com.example.novela;

package com.example.novelmanager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NovelAdapter extends RecyclerView.Adapter<NovelAdapter.NovelViewHolder> {

    private List<Novel> novels = new ArrayList<>();
    private NovelViewModel novelViewModel;
    private Context context;

    // Constructor para recibir el contexto y el ViewModel
    public NovelAdapter(Context context, NovelViewModel novelViewModel) {
        this.context = context;
        this.novelViewModel = novelViewModel;
    }

    @NonNull
    @Override
    public NovelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_novel, parent, false);
        return new NovelViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NovelViewHolder holder, int position) {
        Novel currentNovel = novels.get(position);
        holder.textViewTitle.setText(currentNovel.getTitle());

        // Eliminar novela
        holder.buttonDelete.setOnClickListener(v -> {
            novelViewModel.delete(currentNovel);
            Toast.makeText(context, "Novela eliminada", Toast.LENGTH_SHORT).show();
        });

        // Ver detalles de la novela
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, NovelDetailActivity.class);
            intent.putExtra("novelId", currentNovel.getId());  // Pasar el ID de la novela seleccionada
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return novels.size();
    }

    // Actualizar la lista de novelas
    public void setNovels(List<Novel> novels) {
        this.novels = novels;
        notifyDataSetChanged();
    }

    // Clase interna para gestionar los elementos de la vista (ViewHolder)
    class NovelViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private Button buttonDelete;

        public NovelViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewItemTitle);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
