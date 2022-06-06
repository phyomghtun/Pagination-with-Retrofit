package pm.retrofit_pagination.test.Service;

public class ApiUti {
    public static String url= "https://phyotest.000webhostapp.com/";

    public static MovieJson mMovie(){
        return RetrofitClient.getClient(url).create(MovieJson.class);
    }
}
