package com.fighter.superframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fighter.superframe.Network.Network;
import com.fighter.superframe.info.ImageInfo;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bt_gank1)
    Button btGank1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.bt_gank1, R.id.bt_gank2,R.id.bt_gank3})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.bt_gank1:
                Network.getGankApi()
                        .getFuli1("100", "1")
                        .enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                try {
                                    Log.d("MainActivity", response.body().string());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Log.d("MainActivity", "chenggong");
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                                Log.d("MainActivity", throwable.toString());
                            }
                        });
                break;
            case R.id.bt_gank2:
                Network.getGankApi()
                        .getFuliWithGson("10","1")
                        .enqueue(new Callback<ImageInfo>() {
                            @Override
                            public void onResponse(Call<ImageInfo> call, Response<ImageInfo> response) {
                                ImageInfo body = response.body();
                                Log.d("MainActivity", "body.getResults().size():" + body.getResults().size());
                                Log.d("MainActivity", body.toString());
                            }

                            @Override
                            public void onFailure(Call<ImageInfo> call, Throwable throwable) {
                                Log.d("MainActivity", throwable.toString());
                            }
                        });
                break;

            case R.id.bt_gank3:
                break;
        }
    }
}
