package com.pucpr.tasklistapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {
    public SQLiteDatabase db;
    private final TaskDatabaseHelper dbHelper;

    public TaskDAO(Context context) {
        dbHelper = new TaskDatabaseHelper(context);
        try {
            open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void addTask(Task task) {
        ContentValues values = new ContentValues();
        values.put("task", task.getTask());
        values.put("date", task.getDate());

        db.insert("tasks", null, values);
    }

    public void deleteTask(int taskId) {
        db.delete("tasks", "id = ?", new String[]{String.valueOf(taskId)});
    }

    public Task getTaskById(int taskId) {
        Cursor cursor = db.query("tasks", null, "id = ?", new String[]{String.valueOf(taskId)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            String task = cursor.getString(cursor.getColumnIndexOrThrow("task"));
            String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
            cursor.close();
            return new Task(id, task, date);
        }
        return null;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        Cursor cursor = db.query("tasks", null, null, null, null, null, "date ASC");
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String task = cursor.getString(cursor.getColumnIndexOrThrow("task"));
                String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                tasks.add(new Task(id, task, date));
            }
            cursor.close();
        }
        return tasks;
    }

    private static class TaskDatabaseHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "tasks.db";
        private static final int DATABASE_VERSION = 1;
        private static final String TABLE_CREATE =
                "CREATE TABLE tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "task TEXT NOT NULL, date TEXT NOT NULL);";

        public TaskDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS tasks");
            onCreate(db);
        }
    }
}
