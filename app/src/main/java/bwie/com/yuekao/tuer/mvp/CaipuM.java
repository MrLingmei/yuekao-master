package bwie.com.yuekao.tuer.mvp;

import java.util.HashMap;
import java.util.Map;

import bwie.com.yuekao.tuer.api.Api;
import bwie.com.yuekao.tuer.api.RetrofitHelper;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;


/**
 * Created by zld on 2018.06.01.
 */

public class CaipuM {
    CaipuP caipuP;

    public CaipuM(CaipuP caipuP) {
        this.caipuP = caipuP;
    }
    public void doget(String url,String key,String menu){
        Map<String ,String > map=new HashMap<>();
//http://apis.juhe.cn/cook/query?key=928b5f0d147e9eeac163721548c94f34&menu=%E8%A5%BF%E7%BA%A2%E6%9F%BF&rn=10&pn=3
        map.put("key",key);
        map.put("menu",menu);
        RetrofitHelper.getApiService(Api.URL).doGet(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        caipuP.onSuccess(responseBody);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


}
