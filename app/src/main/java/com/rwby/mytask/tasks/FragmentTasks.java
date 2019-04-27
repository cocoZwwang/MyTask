package com.rwby.mytask.tasks;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rwby.mytask.R;
import com.rwby.mytask.db.domain.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 任务标题列表
 * Created by ZWWang on 2018/5/15.
 */
public class FragmentTasks extends Fragment implements TasksContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private TasksContract.Presenter presenter;

    private TasksAdapter tasksAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_show_tasks, container, false);
        ButterKnife.bind(this, root);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(TasksContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showTasks(List<Task> tasks) {
        if (tasksAdapter == null) {
            tasksAdapter = new TasksAdapter(tasks, getActivity().getApplicationContext());
            recyclerView.setAdapter(tasksAdapter);
            return;
        }

        tasksAdapter.changeData(tasks);
        tasksAdapter.notifyDataSetChanged();
    }
}
