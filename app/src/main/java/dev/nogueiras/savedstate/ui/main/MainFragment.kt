package dev.nogueiras.savedstate.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dev.nogueiras.savedstate.R
import dev.nogueiras.savedstate.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(R.layout.main_fragment) {

    private val viewModel: MainViewModel by viewModels()
    private var binding: MainFragmentBinding? = null
    private val adapter = MainAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainFragmentBinding.bind(view)
        recycler.adapter = adapter

        viewModel.data.observe(viewLifecycleOwner,
            Observer { data -> adapter.onNewData(data) })

        viewModel.scrollPosition.observe(
            viewLifecycleOwner,
            Observer { position -> onPartialConfigurationRestored(position) })
    }

    private fun onPartialConfigurationRestored(scroll: Scroll) {
        binding?.recycler?.scrollToPosition(scroll.position)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        val manager = binding?.recycler?.layoutManager as LinearLayoutManager
        val configuration = Scroll(
            position = manager.findFirstVisibleItemPosition()
        )
        viewModel.onPause(configuration)
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
