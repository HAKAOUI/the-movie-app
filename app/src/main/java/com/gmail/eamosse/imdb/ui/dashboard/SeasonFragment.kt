package com.gmail.eamosse.imdb.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.gmail.eamosse.imdb.databinding.FragmentSeasonBinding
import com.gmail.eamosse.imdb.ui.home.HomeViewModel
import com.gmail.eamosse.imdb.ui.home.SeasonAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SeasonFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var binding: FragmentSeasonBinding
    private val args: SeasonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeasonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = args.myCattv
        with(homeViewModel) {
            token.observe(
                viewLifecycleOwner,
                Observer {
                    // récupérer les catégories
                    getSeason(args.catIdtv)
                }
            )

            season.observe(
                viewLifecycleOwner,
                Observer {
                    binding.seasonList.adapter = SeasonAdapter(it)
                }
            )

            error.observe(
                viewLifecycleOwner,
                Observer {
                    // afficher l'erreur
                }
            )
        }
    }
}
