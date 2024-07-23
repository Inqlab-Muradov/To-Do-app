package com.inqlab.todosroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inqlab.todosroom.databinding.TodosItemBinding
import com.inqlab.todosroom.room.Todos

class TodosAdapter : RecyclerView.Adapter<TodosAdapter.TodosViewHolder>(){

    private val todosList = ArrayList<Todos>()
    lateinit var deleteItem : (Int)->Unit
    lateinit var updateItem : (Int)->Unit
    lateinit var onClick : (id:Int)->Unit

    inner class TodosViewHolder(val binding:TodosItemBinding): RecyclerView.ViewHolder((binding.root))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodosViewHolder {
        val view = TodosItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodosViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  todosList.size
    }

    override fun onBindViewHolder(holder: TodosViewHolder, position: Int) {
       val item = todosList[position]
        holder.binding.todoItem = item
        holder.binding.delete.setOnClickListener {
            deleteItem(item.id)
        }
        holder.binding.update.setOnClickListener {
           updateItem(item.id)
        }
        holder.binding.materialCard.setOnClickListener {
            onClick(item.id)
        }
    }

    fun updateList(newList:List<Todos>){
        todosList.clear()
        todosList.addAll(newList)
        notifyDataSetChanged()
    }
}