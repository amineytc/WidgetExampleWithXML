package com.amineaytac.widgetexamplewithxml.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.amineaytac.widgetexamplewithxml.databinding.FragmentHomeBinding
import com.amineaytac.widgetexamplewithxml.util.gone
import com.amineaytac.widgetexamplewithxml.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getSentence()
        observeUi()

        binding.iwButton.setOnClickListener {
            viewModel.getNewSentence()
        }
    }

    private fun observeUi() = with(binding) {
        viewModel.screenUiState.observe(viewLifecycleOwner) { state ->
            if (state.sentence.affirmation.isNotEmpty()) {
                pbSentence.gone()
                tvSentence.text = state.sentence.affirmation
            } else {
                pbSentence.visible()
            }
        }
    }
}