package ru.jaguardesign.testnav.EIntarface;

/**
 * Created by x on 19.01.2017.
 */
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
//import ru.jaguardesign.krok1.ZClass.Image;
//import ru.jaguardesign.krok1.ZClass.Ot;

public interface NewApi {
    @GET("/z_diet/1_.php")
    Call<String> getfauth(@Query("tokenid") String tokenid, @Query("act") String actName);

    @GET("/z_diet/1_.php")
    Call<String> gettable(@Query("la") String la, @Query("act") String actName);

    @GET("/z_krok/1_.php")
    Call<String> getData(@Query("act") String actName);

    @GET("/z_krok/1_.php")
    Call<String> ses(@Query("id") String id, @Query("sl") String s, @Query("pass") String pass, @Query("act") String actName);//отправка слова
  /*  @GET("/z_krok/1_.php")
    Call<List<Ot>> sesn(@Query("id") String id, @Query("sl") String s, @Query("pass") String pass, @Query("act") String actName);//отправка слова


    @GET("/z_krok/1_.php")
    Call<List<Image>> getImages(@Query("pass") String pass, @Query("act") String actName);
    @GET("/z_krok/1_.php")
    Call<List<Image>> getImages_(@Query("act") String actName);*/

    @Multipart
    @POST("/z_krok/11_.php")
    Call<String> set(@Part("foto") RequestBody file, @Part("title") RequestBody title, @Part("act") RequestBody actName);

    @Multipart
    @POST("/z_krok/11_.php")
    Call<String> set_(@Part("pass") RequestBody pass, @Part("uid") RequestBody uid, @Part("iid") RequestBody iid, @Part MultipartBody.Part file, @Part("title") RequestBody title, @Part("act") RequestBody actName);

    @Multipart
    @POST("/z_krok/11_.php")
    Call<String> set__(@Part("uid") RequestBody uid, @Part("iid") RequestBody iid, @Part MultipartBody.Part file, @Part("title") RequestBody title, @Part("act") RequestBody actName);

    @Multipart
    @POST("/z_krok/11_.php")
    Call<String> set1(@Part("title") RequestBody title, @Part("act") RequestBody actName);

    @POST("/z_krok/11_.php")
    Call<String> setq(@Query("title") String title, @Query("act") String actName);

    @GET("/z_krok/1_.php")
    Call<String> getData1(@Query("act") String actName);

    @GET("/z_krok/1_.php")
    Call<String> setData(@Query("act") String actName);
}
