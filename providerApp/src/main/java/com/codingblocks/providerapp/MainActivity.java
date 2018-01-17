package com.codingblocks.providerapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codingblocks.providerapp.adapters.TodoAdapter;
import com.codingblocks.providerapp.db.TodoDbHelper;
import com.codingblocks.providerapp.db.tables.TodoTable;
import com.codingblocks.providerapp.models.Todo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvTodos;
    ArrayList<Todo> todos;
    TodoDbHelper dbHelper;
    SQLiteDatabase todoDb;
    TodoAdapter todoAdapter;
    EditText etTask;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.etTask);
        btnAdd = findViewById(R.id.btnAdd);


        dbHelper = new TodoDbHelper(this);
        todoDb = dbHelper.getWritableDatabase();

        todos = TodoTable.getAllTodos(todoDb);
        todoAdapter = new TodoAdapter(todos);

        rvTodos = findViewById(R.id.rvTodos);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        rvTodos.setAdapter(todoAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo todo = new Todo(etTask.getText().toString(), false);
                TodoTable.addTodo(todoDb, todo);
                todos = TodoTable.getAllTodos(todoDb);
                todoAdapter.updateTodos(todos);
            }
        });
    }
}
