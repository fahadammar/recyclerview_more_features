package com.example.recyclerviewwithfeatures.model

import com.example.recyclerviewwithfeatures.R

class NewsRepository {
    companion object {
        private var arrayList = ArrayList<NewsModel>()
        fun getNews(): ArrayList<NewsModel> {
            arrayList.add(NewsModel(R.drawable.a, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.b, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.c, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.d, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.e, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.f, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.g, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.h, "This Happens because .....!!"))
            arrayList.add(NewsModel(R.drawable.i, "This Happens because .....!!"))

            return arrayList
        }
    }
}