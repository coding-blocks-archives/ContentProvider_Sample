package com.codingblocks.providerapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.providerapp.models.Todo;

import java.util.ArrayList;

/**
 * Created by championswimmer on 17/01/18.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoAdapter(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    public void updateTodos (ArrayList<Todo> newTodoList) {
        todos.clear();
        todos.addAll(newTodoList);
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return new TodoViewHolder(li.inflate(
                android.R.layout.simple_list_item_1,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.text1.setText(todo.getTask());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView text1;
        TodoViewHolder(View itemView) {
            super(itemView);
            text1 = itemView.findViewById(android.R.id.text1);
        }
    }
}
