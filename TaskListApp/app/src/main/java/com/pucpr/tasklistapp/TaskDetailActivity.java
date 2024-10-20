package com.pucpr.tasklistapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {
    private TextView textViewTaskDetailDescription;
    private TextView textViewTaskDetailDate;
    private TaskDAO taskDAO;
    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        textViewTaskDetailDescription = findViewById(R.id.textViewTaskDetailDescription);
        textViewTaskDetailDate = findViewById(R.id.textViewTaskDetailDate);
        Button buttonDeleteTask = findViewById(R.id.buttonDeleteTask);

        taskDAO = new TaskDAO(this);

        Intent intent = getIntent();
        int taskId = intent.getIntExtra("taskId", -1);
        if (taskId != -1) {
            task = getTaskById(taskId);
            textViewTaskDetailDescription.setText(task.getTask());
            textViewTaskDetailDate.setText(task.getDate());
        }

        buttonDeleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskDAO.deleteTask(task.getId());
                Toast.makeText(TaskDetailActivity.this, "Task deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private Task getTaskById(int taskId) {
        Cursor cursor = taskDAO.db.query("tasks", null, "id = ?", new String[]{String.valueOf(taskId)}, null, null, null);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        taskDAO.close();
    }
}
