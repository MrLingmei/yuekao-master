package bwie.com.yuekao.tusan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import bwie.com.yuekao.R;

public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.main3_banner)
    Banner banner;
    @BindView(R.id.main3_textview)
    TextView main3_textview;
    private ArrayList<String> string;
    private ArrayList<String> string2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ButterKnife.bind(this);


        string = getIntent().getStringArrayListExtra("string");
        Log.d("Main3Activity", string.toString());

        string2 = getIntent().getStringArrayListExtra("strings2");
        Log.d("Main3Activity", string2.toString());
        banner.setImageLoader(new MImage());
        banner.setImages(string);//图片集合    list
        banner.isAutoPlay(true);//是否自动轮播
        banner.setDelayTime(3000);//时间
        banner.start();//开始
        int size = string2.size();
        String sss="";
        for (int i=0;i<size;i++){
            String s = string2.get(i);
            sss=sss+"\t" +
                    "\n"+s;
        }

         main3_textview.setText(sss);
        banner.setOnBannerListener(new OnBannerListener() {

            private String s;

            @Override
            public void OnBannerClick(int position) {
                s=""+string2.get(position);
                Toast.makeText(Main3Activity.this, s, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
