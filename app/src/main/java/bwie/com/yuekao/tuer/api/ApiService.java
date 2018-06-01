package bwie.com.yuekao.tuer.api;


import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by zld on 2018.06.01.
 */

public interface ApiService {
    @GET
    Observable<ResponseBody> doGet(@Url String url, @QueryMap Map<String, String> map);
}
