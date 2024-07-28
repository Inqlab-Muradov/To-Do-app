package com.inqlab.todosroom.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.inqlab.todosroom.viewmodel.CompletedViewModel
import com.inqlab.todosroom.adapter.TodosCompletedAdapter
import com.inqlab.todosroom.base.BaseFragment
import com.inqlab.todosroom.databinding.FragmentCompletedBinding
import com.inqlab.todosroom.utils.invisible
import com.inqlab.todosroom.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompletedFragment :
    BaseFragment<FragmentCompletedBinding>(FragmentCompletedBinding::inflate) {

    private val viewModel by viewModels<CompletedViewModel>()
    private val completedAdapter = TodosCompletedAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTodosWithFav()
        binding.completedRV.adapter = completedAdapter
        observeData()
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        completedAdapter.deleteItem = {
            viewModel.updateCompletedTodo(false, it)
        }
    }

    private fun observeData() {
        viewModel.completedList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                completedAdapter.updateList(it)
                binding.emptyComp.visible()
            } else {
                completedAdapter.updateList(it)
                binding.emptyComp.invisible()
            }
        }
    }
}