package com.example.novela;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NovelDao {
    @Insert
    void insert(Novel novel);

    @Delete
    void delete(Novel novel);

    @Query("SELECT * FROM novel_table ORDER BY title ASC")
    LiveData<List<Novel>> getAllNovels();
}