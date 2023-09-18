package com.example.kakaobank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class ImageSearchActivity : AppCompatActivity() {

    private lateinit var searchButton: Button
    private lateinit var searchEditText: EditText
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_search)

        // Retrofit 설정
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(DaumSearchService::class.java)

        // 검색 버튼 클릭 시
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            val size = 10 // 가져올 이미지 개수

            // API 호출
            service.searchImages("Bearer YOUR_API_KEY", query, size).enqueue(object : Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    if (response.isSuccessful) {
                        val images = response.body()?.documents ?: emptyList()

                        // 이미지를 Glide를 사용하여 로드하여 이미지뷰에 표시
                        Glide.with(this@ImageSearchActivity)
                            .load(images[0].image_url)
                            .into(imageView)
                    }
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    // 실패 처리
                }
            })
        }
    }
}