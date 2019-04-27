package com.rwby.mytask.tasks;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rwby.mytask.db.domain.Task;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private TaskItemView itemView;

    private Task task;

    private OnItemViewClickListener listener;

    TaskViewHolder(View itemView) {
        super(itemView);
        this.itemView = (TaskItemView) itemView;
        itemView.setOnClickListener(v -> {
            if(listener != null)
                listener.onItemViewClick(task, (TaskItemView) v);
        });
    }

    void showTask(Task task) {
        this.task = task;
        itemView.showTask(task);
    }

    public Task getTask() {
        return task;
    }

    public void setListener(OnItemViewClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemViewClickListener{
        void onItemViewClick(Task task,TaskItemView itemView);
    }
}
