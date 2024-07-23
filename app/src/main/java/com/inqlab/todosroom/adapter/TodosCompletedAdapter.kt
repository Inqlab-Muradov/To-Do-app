package com.inqlab.todosroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inqlab.todosroom.databinding.FragmentCompletedBinding
import com.inqlab.todosroom.databinding.TodosCompletedItemBinding
import com.inqlab.todosroom.room.Todos

class TodosCompletedAdapter : RecyclerView.Adapter<TodosCompletedAdapter.CompletedViewHolder>() {

    private var completedList = ArrayList<Todos>()
    lateinit var deleteItem:(Int)->Unit

    inner class CompletedViewHolder( val binding:TodosCompletedItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompletedViewHolder {
        val view = TodosCompletedItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CompletedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return completedList.size
    }

    override fun onBindViewHolder(holder: CompletedViewHolder, position: Int) {
        val item = completedList[position]
        holder.binding.todosCompletedItem = item
        holder.binding.deleteComp.setOnClickListener {
            deleteItem(item.id)
        }
    }

     fun updateList(newList:List<Todos>){
         completedList.clear()
         completedList.addAll(newList)
         notifyDataSetChanged()
     }
}