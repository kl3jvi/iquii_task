package com.kl3jvi.iquiitask.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kl3jvi.iquiitask.databinding.FragmentGalleryBinding
import com.kl3jvi.iquiitask.view.adapters.CustomGridItemAdapter
import com.kl3jvi.iquiitask.viewmodel.GalleryViewModel

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var mGalleryViewModel: GalleryViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding!!.rvImageGrid.layoutManager = GridLayoutManager(requireActivity(), 2)
        val imageAdapter = CustomGridItemAdapter(this)
        _binding!!.rvImageGrid.adapter = imageAdapter

        mGalleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)



        mGalleryViewModel.getApiResponse("earthporn")
        mGalleryViewModel.subredditResponse.observe(viewLifecycleOwner, { response ->
            response?.let { res ->
                if (res.data.children.isNotEmpty()) {
                    imageAdapter.imageList(res.data.children)
                }

            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}