package com.example.rd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rd.databinding.ActivityEditContactBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditContactActivity: AppCompatActivity() {

    private lateinit var binding: ActivityEditContactBinding

//    private val presenter: Presenter by inject()
      private val viewModel by viewModel<MainViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etName.requestFocus()
        val idContactToEdit:String = intent.getStringExtra("id").toString()

        binding.etName.setText(viewModel.getContactWithId(idContactToEdit)?.name)
        binding.etSurname.setText(viewModel.getContactWithId(idContactToEdit)?.surname)
        binding.etNumber.setText(viewModel.getContactWithId(idContactToEdit)?.number)

        binding.btnDelete.setOnClickListener {
            viewModel.deleteContact(idContactToEdit)
            startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
            finish()

        }

        binding.btnSave1.setOnClickListener {
            viewModel.editContact(
                name = binding.etName.text.toString(),
                surname = binding.etSurname.text.toString(),
                number = binding.etNumber.text.toString(),
                idContactToEdit)
            startActivity(Intent(this@EditContactActivity, MainActivity::class.java))
            finish()
        }
    }
}
