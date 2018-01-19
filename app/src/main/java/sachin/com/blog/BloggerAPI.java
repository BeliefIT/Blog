package sachin.com.blog;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Lenovo on 19-01-2018.
 */

public class BloggerAPI {
    private static final String key = "AIzaSyDj73SjdEda5JUOorG6LByvQ802iOMAE4E";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/3752995850348112551/posts/";

    public static PostService postService = null;

    public static PostService getService() {
        if (postService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService = retrofit.create(PostService.class);
        }
        return postService;
    }

    public interface PostService {
        @GET("?key=" + key)
        Call<PostList> getPostList();

        // for post by id
        //@GET("{postId}/?key="+key)
        //Call<Item> getPostById(@Path("postId") String id);
    }

}
