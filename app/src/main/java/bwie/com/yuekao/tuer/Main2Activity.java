package bwie.com.yuekao.tuer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.yuekao.R;
import bwie.com.yuekao.tuer.api.Api;
import bwie.com.yuekao.tuer.itemdianji.OnitemClickListener;
import bwie.com.yuekao.tuer.mvp.CaipuPp;
import bwie.com.yuekao.tuer.mvp.CaipuV;
import bwie.com.yuekao.tusan.Main3Activity;
import okhttp3.ResponseBody;

public class Main2Activity extends AppCompatActivity implements CaipuV {
    @BindView(R.id.main2_recycler)
    RecyclerView main2_recycler;
    private CaipuPp caipuPp;
    private List<CaipuBean.ResultBean.DataBean> data;
    private String string;

    //http://apis.juhe.cn/cook/query?key=928b5f0d147e9eeac163721548c94f34&menu=西红柿&rn=10&pn=3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        String menu = getIntent().getStringExtra("menu");
        caipuPp = new CaipuPp();
        caipuPp.attac(this);
        caipuPp.getDate(Api.URL_CAIDAN, "928b5f0d147e9eeac163721548c94f34", menu);

    }


    @Override
    public void onSuccess(ResponseBody responseBody) {
        try {
            string = responseBody.string();
            CaipuBean caipuBean = new Gson().fromJson(string, CaipuBean.class);
            data = caipuBean.getResult().getData();
            Log.d("Main2Activity", "data:" + data.toString());
            MyAdapter myAdapter = new MyAdapter(this, data);
            main2_recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            main2_recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

            main2_recycler.setAdapter(myAdapter);



            final ArrayList<String > strings=new ArrayList<>();
            final ArrayList<String > strings2=new ArrayList<>();

            myAdapter.setOnitemClickListener(new OnitemClickListener() {
                @Override
                public void onClick(int position) {

                    List<CaipuBean.ResultBean.DataBean.StepsBean> steps = data.get(position).getSteps();
                    int size = steps.size();
                    for (int i=0;i<size;i++){
                        String img = steps.get(i).getImg();
                        strings.add(img);
                        String step = steps.get(i).getStep();
                        strings2.add(step);
                    }
                    Intent intent=new Intent(Main2Activity.this, Main3Activity.class);
                    intent.putStringArrayListExtra("string", strings);
                    intent.putStringArrayListExtra("strings2", strings2);

                    startActivity(intent);


                }

                @Override
                public void onLongClick(int position) {

                }
            });





        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (caipuPp != null) {
            caipuPp = null;
        }

    }
}
