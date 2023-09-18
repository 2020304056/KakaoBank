package com.example.kakaobank

data class SearchResponse(
    val meta: Meta,
    val documents: List<Document>
)

data class Meta(
    val total_count: Int
)

data class Document(
    val thumbnail_url: String,
    val image_url: String,
    val display_sitename: String
)