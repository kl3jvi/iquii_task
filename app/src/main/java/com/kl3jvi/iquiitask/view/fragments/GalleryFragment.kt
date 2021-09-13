package com.kl3jvi.iquiitask.view.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.kl3jvi.iquiitask.R
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
        setHasOptionsMenu(true);
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding!!.rvImageGrid.layoutManager = GridLayoutManager(requireActivity(), 2)
        val imageAdapter = CustomGridItemAdapter(this)
        _binding!!.rvImageGrid.adapter = imageAdapter

        mGalleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)




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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val ourSearchItem: MenuItem = menu.findItem(R.id.action_search)
        val sv: SearchView = ourSearchItem.actionView as SearchView
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                // Not needed on documentation
                mGalleryViewModel.getApiResponse(p0 ?: "test")
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_two -> {
                _binding!!.rvImageGrid.layoutManager = GridLayoutManager(requireActivity(), 2)
            }
            R.id.action_three -> {
                _binding!!.rvImageGrid.layoutManager = GridLayoutManager(requireActivity(), 3)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}