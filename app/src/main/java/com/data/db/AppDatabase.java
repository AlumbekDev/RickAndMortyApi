package com.data.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.data.db.daos.CharacterDao;
import com.model.CharacterModel;

@Database(entities = {CharacterModel.class}, version = 2)
abstract class AppDatabase extends RoomDatabase {

    public abstract CharacterDao characterDao();
}