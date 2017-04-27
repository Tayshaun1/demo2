package com.example.tx.teststudy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TestButterKnife extends AppCompatActivity {
    @BindView(R.id.tv_name0)
    TextView tvName0;
    @BindView(R.id.tv_name1)
    TextView tvName1;
    @BindView(R.id.tv_name2)
    TextView tvName2;
    @BindView(R.id.tv_name3)
    TextView tvName3;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.activity_test_butter_knife)
    LinearLayout activityTestButterKnife;
//
//    @BindViews({R.id.tv_name0, R.id.tv_name1, R.id.tv_name2})
//    List<TextView> tvNames;
//    @BindView(R.id.tv_name3)
//    TextView tvName3;
//    @BindView(R.id.btn)
//    Button btn;
//    @BindView(R.id.et)
//    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_butter_knife);
        ButterKnife.bind(this);
//        for (TextView tv :
//                tvNames) {
//            tv.setText("haha");
//        }
        tvName3.setText("tvName3");
    }

    @OnClick(R.id.btn)
    void btnClick(Button bt) {
        bt.setText("click");
    }
}
