package de.nkono.models


import java.util.concurrent.atomic.AtomicInteger

class News
private constructor(val id: Int, var title: String, var body: String) {
    companion object {
        private val idCounter = AtomicInteger()
        fun newEntry(title: String, body: String) = News(idCounter.getAndIncrement(), title, body)
    }
}

val news = mutableListOf(News.newEntry(
    "The drive to develop!",
    "...it's what keeps me going."
))