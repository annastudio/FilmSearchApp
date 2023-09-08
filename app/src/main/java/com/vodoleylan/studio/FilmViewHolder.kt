package com.vodoleylan.studio

import androidx.recyclerview.widget.RecyclerView
import com.vodoleylan.studio.databinding.FilmsItemForRvBinding


//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(val binding: FilmsItemForRvBinding) : RecyclerView.ViewHolder(binding.root) {
    //Привязываем View из layout к переменным
    private val title = binding.title
    private val poster = binding.poster
    private val description = binding.description

    //В этом методе кладем данные из Film в наши View
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title
        //Устанавливаем постер
        poster.setImageResource(film.poster)
        //Устанавливаем описание
        description.text = film.description
    }
}