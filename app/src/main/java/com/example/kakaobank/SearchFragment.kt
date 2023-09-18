package com.example.kakaobank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchFragment : Fragment() {
    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var searchAdapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)

        searchRecyclerView = view.findViewById(R.id.searchRecyclerView)

        // 데이터를 초기화 (예: 빈 리스트로 초기화)
        val data: List<String> = mutableListOf()

        searchAdapter = SearchAdapter(data)

        searchRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        searchRecyclerView.adapter = searchAdapter

        return view
    }
}