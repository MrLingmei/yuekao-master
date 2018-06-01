package bwie.com.yuekao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import bwie.com.yuekao.tuer.Main2Activity;
import bwie.com.yuekao.tuyi.FlowLayout;
import bwie.com.yuekao.tuyi.dayStep;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit)
    EditText editText;
    @BindView(R.id.tv_sou)
    TextView sou;
    @BindView(R.id.id_flowlayout)
    FlowLayout mFlowLayout;
    @BindView(R.id.clear)
    Button clear;
    private String[] mVals = new String[]{"腊肉", "特产"};
    private LayoutInflater mInflater;
    private TextView tv;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mInflater = LayoutInflater.from(this);
        for (int i = 0; i < mVals.length; i++) {
            tv = (TextView) mInflater.inflate(
                    R.layout.search_label_tv, mFlowLayout, false);
            tv.setText(mVals[i]);
            final String str = tv.getText().toString();
            //点击事件
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, "你点击了" + str, Toast.LENGTH_SHORT).show();
                }
            });
            mFlowLayout.addView(tv);//添加到父View
        }
        //点击搜索加入
        sou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = editText.getText().toString();

                tv = (TextView) mInflater.inflate(
                        R.layout.search_label_tv, mFlowLayout, false);
                tv.setText(s);
                final String str = tv.getText().toString();
                //点击事件
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "你点击了" + str, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        intent.putExtra("menu", str);
                        startActivity(intent);

                    }
                });
                mFlowLayout.addView(tv);
                insert(s.toString());


                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("menu", s);
                startActivity(intent);


            }
        });


        //清空
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFlowLayout.removeAllViews();

            }
        });

    }

    public void insert(String v) {
        String date = v;
        dayStep dayStep = new dayStep(null, date);//第一个是id值，因为是自增长所以不用传入

    }

    @OnClick({R.id.edit, R.id.tv_sou, R.id.id_flowlayout, R.id.clear})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.edit:
                break;
            case R.id.tv_sou:
                break;
            case R.id.id_flowlayout:
                break;
            case R.id.clear:
                break;
        }
    }
}
