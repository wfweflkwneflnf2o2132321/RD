package com.example.rd

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rd.databinding.ItemContactBinding



class ContactsAdapter( private val onContactClicked: (Int) -> Unit ) :
    ListAdapter<Contact, ContactsAdapter.MyViewHolder>(MyDiffUtil) {


    object MyDiffUtil : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.id == newItem.id
        }
    }

    inner class MyViewHolder(private val binding: ItemContactBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact?) {
            binding.tvNameAndSurname.text = "${contact?.name} ${contact?.surname}"
            binding.tvNumber.text = contact?.number



//            binding.ivEdit.setOnClickListener {
//                if (contact != null) {
//                    onEditClicked.invoke(contact)
//                }
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )
    }




    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note)
        holder.itemView.findViewById<ImageView>(R.id.ivEdit).setOnClickListener { onContactClicked (position)}
    }



    fun setData(allContacts: List<Contact>) {
        this.submitList(allContacts)
        notifyDataSetChanged()
        
    }
}


