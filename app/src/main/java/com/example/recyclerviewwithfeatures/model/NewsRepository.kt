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
        private var news = arrayOf(
            R.string.news_a,
            R.string.news_b,
            R.string.news_c,
            R.string.news_d,
            R.string.news_e,
            R.string.news_f,
            R.string.news_g,
            R.string.news_h,
            R.string.news_i,
            R.string.news_j
        )

        private val newsImage = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
        )

        fun getHeading(index: Int): String {
            return heading[index]
        }

        fun getNewsString(index: Int): Int {
            return news[index]
        }

        fun getNewsImage(index: Int): Int {
            return newsImage[index]
        }

        fun getNews(): ArrayList<NewsModel> {
            arrayList.add(NewsModel(newsImage[0], heading[0]))
            arrayList.add(NewsModel(newsImage[1], heading[1]))
            arrayList.add(NewsModel(newsImage[2], heading[2]))
            arrayList.add(NewsModel(newsImage[3], heading[3]))
            arrayList.add(NewsModel(newsImage[4], heading[4]))
            arrayList.add(NewsModel(newsImage[5], heading[5]))
            arrayList.add(NewsModel(newsImage[6], heading[6]))
            arrayList.add(NewsModel(newsImage[7], heading[7]))
            arrayList.add(NewsModel(newsImage[8], heading[8]))

            return arrayList
        }
    }
}