package com.rwby.mytask.tasks;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rwby.mytask.R;
import com.rwby.mytask.bean.Task;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TaskViewHolder> {
    private List<Task> tasks;

    private LayoutInflater mInflater;

    private Context mContext;

    public TasksAdapter(List<Task> tasks, Context context) {
        this.tasks = tasks;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);

        Log.i("test", "tasks size:" + tasks.size());
    }

    public void changeData(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.i("test", "viewType:" + viewType);
        View itemView =  mInflater.inflate(R.layout.task_list_view_item, parent, false);
        return new TaskViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Log.i("test", "position task:" + tasks.get(position).title);
        holder.showTask(tasks.get(position));
    }

    @Override
    public int getItemCount() {
        Log.i("test", "tasks.size():" + tasks.size());
        return tasks.size();
    }
}
