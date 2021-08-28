package com.data.db;

import android.content.Context;

import androidx.room.Room;

import com.data.db.daos.CharacterDao;

public class RoomClient {

   public AppDatabase provideDatabase(Context context){
        return Room
                .databaseBuilder(context, AppDatabase.class, "rick-and-morty_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

   public CharacterDao provideCharacterDao(
            AppDatabase database
    ){
        return database.characterDao();
    }
}