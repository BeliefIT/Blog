package sachin.com.blog;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by sachin on 19-Jan-18.
 */

public class BloggerAPI {
    
private static final String key="AIzaSyBF5EXNxfVu6l95a2BhLHl1OVLwP2PxkRE";
private static final String url="https://www.googleapis.com/blogger/v3/blogs/8997688359732888175/posts/";


public static PostService postService=null;

public static PostService getService()
{
    if(postService==null)
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postService=retrofit.create(PostService.class);
    }

return postService;
}



public interface PostService
{
    @GET("?key="+key)
    Call<PostList> getPostList();
}


}
