package com.rwby.mytask.tasks;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rwby.mytask.R;
import com.rwby.mytask.db.domain.Task;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TaskItemView extends RelativeLayout {

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.iv)
    ImageView iv;

    public TaskItemView(Context context) {
        this(context, null, 0);
    }

    public TaskItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TaskItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void showTask(Task task) {
        if (task == null)
            return;
        tvContent.setText(task.getTitle());
    }
}
