package bwie.com.yuekao.tuer.mvp;

import okhttp3.ResponseBody;

/**
 * Created by zld on 2018.06.01.
 */

public class CaipuPp implements CaipuP {
    CaipuM caipuM;
    CaipuV caipuV;

    public CaipuPp() {
        caipuM = new CaipuM(this);
    }

    public void attac(CaipuV caipuV) {

        this.caipuV = caipuV;

    }

    public void dell() {
        if (caipuV != null) {
            caipuV = null;
        }
    }

    public void getDate(String url, String key, String numm) {
        caipuM.doget(url, key, numm);

    }


    @Override
    public void onSuccess(ResponseBody responseBody) {
        caipuV.onSuccess(responseBody);
    }
}
