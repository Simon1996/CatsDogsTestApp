package com.inside.developed.zimadtestproject.feature.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.inside.developed.zimadtestproject.R
import com.inside.developed.zimadtestproject.core.domain.viewmodel.MainViewModel
import com.inside.developed.zimadtestproject.feature.detail.DetailScreen
import com.inside.developed.zimadtestproject.feature.main.AnimalsAdapter
import com.inside.developed.zimadtestproject.util.extensions.initialize
import com.inside.developed.zimadtestproject.util.extensions.observe
import com.inside.developed.zimadtestproject.util.extensions.startActivity
import kotlinx.android.synthetic.main.fragment_dogs.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DogsFragment : Fragment() {
    private val mainViewModel: MainViewModel by viewModel()
    lateinit var adapter: AnimalsAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_dogs, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AnimalsAdapter()
        linearLayoutManager = LinearLayoutManager(requireContext())
        rvAnimals.initialize(adapter, linearLayoutManager)

        adapter.setOnItemClickListener = { model ->
            activity?.startActivity<DetailScreen>(extra = model)
        }

        if (mainViewModel.getRvDogsPos() != null) {
            linearLayoutManager.scrollToPosition(mainViewModel.getRvDogsPos()!!)
        }

        observe(mainViewModel.dogsLiveData) {
            adapter.replace(it!!)
        }
    }

    override fun onDestroyView() {
        mainViewModel.setRvDogPos(linearLayoutManager.findFirstVisibleItemPosition())
        super.onDestroyView()
    }
}