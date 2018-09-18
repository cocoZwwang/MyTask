package com.rwby.mytask.tasks;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.rwby.mytask.MyApp;
import com.rwby.mytask.R;
import javax.inject.Inject;

public class TasksActivity extends AppCompatActivity {

    @Inject
    TasksPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_layout);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTasks fragment = (FragmentTasks) fragmentManager.findFragmentById(R.id.container);
        if (fragment == null) {
            fragment = new FragmentTasks();
            fragmentManager.beginTransaction().add(R.id.container, fragment).commit();
        }

        DaggerTasksComponent
                .builder()
                .tasksMoudle(new TasksMoudle(fragment))
                .dependenciesComponent(MyApp.getInstance().getDependenciesComponent())
                .build()
                .inject(this);
    }
}
