package com.inqlab.todosroom.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.inqlab.todosroom.viewmodel.DetailViewModel
import com.inqlab.todosroom.base.BaseFragment
import com.inqlab.todosroom.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    val args: DetailFragmentArgs by navArgs()
    private val viewModel by viewModels<DetailViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDetailTodo(args.id)
        observeData()
        binding.backToHome.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeData() {
        viewModel.detailTodoList.observe(viewLifecycleOwner) {
            with(binding) {
                taskDetail.text = it.task
                descriptionDetail.text = it.description
                dateDetail.text = it.date
            }
        }
    }
}