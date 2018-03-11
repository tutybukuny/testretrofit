import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface RetrofitAPI {
    @GET("changes/")
    Call<List<Test>> loadChanges(@Query("q") String status);

    @GET("listUsers/")
    Call<List<User>> readString();
}
