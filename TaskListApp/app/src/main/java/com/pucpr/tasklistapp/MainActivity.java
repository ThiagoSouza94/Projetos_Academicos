package com.pucpr.tasklistapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "TaskListAppPrefs";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    private TaskDAO taskDAO;
    private RecyclerView recyclerViewTasks;
    private TaskAdapter taskAdapter;
    private Button buttonAddTask;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check if user is logged in
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);

        if (!isLoggedIn) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else {
            setContentView(R.layout.activity_main);

            taskDAO = new TaskDAO(this);

            recyclerViewTasks = findViewById(R.id.recyclerViewTasks);
            recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));

            buttonAddTask = findViewById(R.id.buttonAddTask);
            buttonAddTask.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                    startActivity(intent);
                }
            });

            buttonLogout = findViewById(R.id.buttonLogout);
            buttonLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    logout();
                }
            });

            loadTasks();
        }
    }

    private void loadTasks() {
        List<Task> tasks = taskDAO.getAllTasks();
        taskAdapter = new TaskAdapter(tasks);
        recyclerViewTasks.setAdapter(taskAdapter);
    }

    private void logout() {
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_IS_LOGGED_IN, false);
        editor.apply();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadTasks();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (taskDAO != null) {
            taskDAO.close();
        }
    }
}
