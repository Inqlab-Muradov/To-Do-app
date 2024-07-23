package com.inqlab.todosroom.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.inqlab.todosroom.ViewModel.AddViewModel
import com.inqlab.todosroom.base.BaseFragment
import com.inqlab.todosroom.databinding.FragmentAddBinding
import com.inqlab.todosroom.room.Todos
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>(FragmentAddBinding::inflate) {

    private val viewModel by viewModels<AddViewModel> ()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.close.setOnClickListener {
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToHomeFragment())
        }

        binding.createTaskButton.setOnClickListener {
            val task = binding.taskText.text.trim().toString()
            val description = binding.descriptionText.text.trim().toString()
            val date = binding.dateText.text.trim().toString()
            viewModel.addTodo(Todos(task = task, description = description, date = date, isFav = false))
            findNavController().navigate(AddFragmentDirections.actionAddFragmentToHomeFragment())
        }
    }

}