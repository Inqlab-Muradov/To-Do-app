package com.inqlab.todosroom.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.inqlab.todosroom.viewmodel.HomeViewModel
import com.inqlab.todosroom.adapter.TodosAdapter
import com.inqlab.todosroom.base.BaseFragment
import com.inqlab.todosroom.databinding.FragmentHomeBinding
import com.inqlab.todosroom.utils.invisible
import com.inqlab.todosroom.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()
    private val todosAdapter = TodosAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddFragment())
        }
        viewModel.getAllTodos()
        binding.todosRv.adapter = todosAdapter
        observeData()
        binding.completedButton.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCompletedFragment())
        }
        adapterAction()

    }

    private fun observeData() {
        viewModel.todosList.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                todosAdapter.updateList(it)
                binding.emptyText.visible()
            } else {
                todosAdapter.updateList(it)
                binding.emptyText.invisible()
            }
        }

    }

    private fun adapterAction() {
        todosAdapter.deleteItem = {
            viewModel.deleteTodo(it)
        }
        todosAdapter.updateItem = {
            viewModel.updateTodo(true, it)
        }
        todosAdapter.onClick = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    it
                )
            )
        }
    }

}