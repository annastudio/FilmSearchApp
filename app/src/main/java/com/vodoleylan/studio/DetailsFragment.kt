package com.vodoleylan.studio

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vodoleylan.studio.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    private lateinit var film: Film

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_details, container, false)
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFilmsDetails()

        binding.detailsFabFavorites.setOnClickListener { setFavorites() }
        binding.detailsFabShare.setOnClickListener { shareFilm() }
    }

    private fun setFilmsDetails() {
        //Получаем наш фильм из переданного бандла
        val film = arguments?.get("film") as Film

        //Устанавливаем заголовок
        binding.detailsToolbar.title = film.title
        //Устанавливаем картинку
        binding.detailsPoster.setImageResource(film.poster)
        //Устанавливаем описание
        binding.detailsDescription.text = film.description
    }

    private fun setFavorites() {
        val film = arguments?.get("film") as Film

        if (!film.isInFavorites) {
            binding.detailsFabFavorites.setImageResource(R.drawable.ic_baseline_star)
            film.isInFavorites = true
        } else {
            binding.detailsFabFavorites.setImageResource(R.drawable.ic_baseline_star_border)
            film.isInFavorites = false
        }
    }

    private fun shareFilm() {
        val film = arguments?.get("film") as Film
        //Создаем интент
        val intent = Intent()
        //Указываем action с которым он запускается
        intent.action = Intent.ACTION_SEND
        //Кладем данные о нашем фильме
        intent.putExtra(
            Intent.EXTRA_TEXT,
            "Check out this film: ${film.title} \n\n ${film.description}"
        )
        //Указываем MIME тип, чтобы система знала, какое приложения предложить
        intent.type = "text/plain"
        //Запускаем наше активити
        startActivity(Intent.createChooser(intent, "Share To:"))
    }
}