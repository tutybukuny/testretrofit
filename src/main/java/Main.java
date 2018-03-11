import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        final String BASE_URL = "https://git.eclipse.org/r/";
        final String BASE_URL = "http://localhost:8081/";

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

//        retrofitAPI.loadChanges("status:open").enqueue(new Callback<List<Test>>() {
//            public void onResponse(Call<List<Test>> call, Response<List<Test>> response) {
//                if (response.isSuccessful()) {
//                    List<Test> changesList = response.body();
//                    changesList.forEach(change -> System.out.println(change.getSubject()));
//                } else {
//                    System.out.println(response.errorBody());
//                }
//            }
//
//            public void onFailure(Call<List<Test>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

        retrofitAPI.readString().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    List<User> users = response.body();
                    users.forEach(user -> System.out.println(user.getId()));
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
