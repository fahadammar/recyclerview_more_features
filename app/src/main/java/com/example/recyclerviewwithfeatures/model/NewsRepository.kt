package com.example.recyclerviewwithfeatures.model

import com.example.recyclerviewwithfeatures.R

class NewsRepository {
    companion object {
        private var arrayList = ArrayList<NewsModel>()
        private var heading = arrayOf(
            "Biden aims to expand vaccines for adults and children",
            "Just got my first shot, helping the world to be a safer place",
            "Local trains to be suspended in Bengal from tomorrow in view of covid-19",
            "MHA asks states,UTs to ensure there are no fires in hospitals",
            "Australian citizen sues PM Morrison over flight ban from india",
            "Former India hockey coach Kaushik hospitalised after testing positive for COVID",
            "Delhi records 20,960 fresh covid-19 infections, positivity rate at 26.37%",
            "Barcelona church offers open-air space for Ramadan",
            "Trillions of cicadas set to emerge in the US, here's why",
            "Homemaker, economist: Candidates from all walks of life in Bengal assembly"
        )
        fun getNews(): ArrayList<NewsModel> {
            arrayList.add(NewsModel(R.drawable.a, heading[0]))
            arrayList.add(NewsModel(R.drawable.b, heading[1]))
            arrayList.add(NewsModel(R.drawable.c, heading[2]))
            arrayList.add(NewsModel(R.drawable.d, heading[3]))
            arrayList.add(NewsModel(R.drawable.e, heading[4]))
            arrayList.add(NewsModel(R.drawable.f, heading[5]))
            arrayList.add(NewsModel(R.drawable.g, heading[6]))
            arrayList.add(NewsModel(R.drawable.h, heading[7]))
            arrayList.add(NewsModel(R.drawable.i, heading[8]))

            return arrayList
        }
    }
}