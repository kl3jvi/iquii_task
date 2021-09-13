package com.kl3jvi.iquiitask.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.kl3jvi.iquiitask.application.IQUIIApplication
import com.kl3jvi.iquiitask.databinding.FragmentFavoritesBinding
import com.kl3jvi.iquiitask.view.adapters.CustomFavoriteAdapter
import com.kl3jvi.iquiitask.viewmodel.FavImageViewModelFactory
import com.kl3jvi.iquiitask.viewmodel.GalleryViewModel

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val mGalleryViewModel: GalleryViewModel by viewModels {
        FavImageViewModelFactory((requireActivity().application as IQUIIApplication).repository)
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding!!.rvFavImages.layoutManager = GridLayoutManager(requireActivity(), 2)
        val imageAdapter = CustomFavoriteAdapter(this)
        _binding!!.rvFavImages.adapter = imageAdapter

        mGalleryViewModel.favoriteImagesList.observe(viewLifecycleOwner) {
            imageAdapter.imageList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}