package kz.orkenniet.home.presentation.model

data class Book(
    var Image: Int = 1,
    val Author: String? = null,
    val Description: String? = null,
    val Genre: String? = null,
    val Language: String? = null,
    val Likes: String? = null,
    val Names: String? = null,
    val Pages: String? = null,
) : ListItem
