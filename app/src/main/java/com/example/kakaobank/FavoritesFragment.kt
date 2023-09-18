package com.example.kakaobank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FavoritesFragment : Fragment() {
    private lateinit var favoritesRecyclerView: RecyclerView
    private lateinit var favoritesAdapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_favorites, container, false)

        favoritesRecyclerView = view.findViewById(R.id.favoritesRecyclerView)

        // 데이터를 초기화 (예: 빈 리스트로 초기화)
        val data: List<String> = mutableListOf()

        favoritesAdapter = FavoritesAdapter(data)

        favoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        favoritesRecyclerView.adapter = favoritesAdapter

        return view
    }
}