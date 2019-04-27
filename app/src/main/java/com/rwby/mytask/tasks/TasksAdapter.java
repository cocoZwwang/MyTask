package com.rwby.mytask.tasks;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rwby.mytask.R;
import com.rwby.mytask.db.domain.Task;
import com.rwby.mytask.log.Logger;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TaskViewHolder> implements TaskViewHolder.OnItemViewClickListener {
    private List<Task> tasks;

    private LayoutInflater mInflater;

    TasksAdapter(List<Task> tasks, Context context) {
        this.tasks = tasks;
        this.mInflater = LayoutInflater.from(context);

        Logger.i("tasks size:" + tasks.size());
    }

    void changeData(List<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Logger.i("viewType:" + viewType);
        View itemView = mInflater.inflate(R.layout.task_list_view_item, parent, false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(itemView);
        taskViewHolder.setListener(this);
        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Logger.i("position task:" + tasks.get(position).getTitle());
        holder.showTask(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        Logger.i("tasks.size():" + tasks.size());
        return tasks.size();
    }

    @Override
    public void onItemViewClick(Task task, TaskItemView itemView) {

    }
}
