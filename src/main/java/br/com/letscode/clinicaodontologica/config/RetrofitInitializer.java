package br.com.letscode.clinicaodontologica.config;

import com.jakewharton.retrofit2.adapter.reactor.ReactorCallAdapterFactory;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RetrofitInitializer {
    private static Retrofit retrofitInstance;

    public static Retrofit getRetrofit() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder().baseUrl("https://viacep.com.br/ws/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(ReactorCallAdapterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }
}