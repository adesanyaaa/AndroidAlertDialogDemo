package com.adesoftware.androidalertdialogdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.adesoftware.androidalertdialogdemo.databinding.ActivityAndroidAlertDialogBinding

class AndroidAlertDialogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAndroidAlertDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAndroidAlertDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Joe Block to your contacts list?")
            .setIcon(R.drawable.ic_person_add)
            .setPositiveButton("Yes") { dialogInterface, i ->
                Toast.makeText(this, "You added Joe Block to your contacts list", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { dialogInterface, i ->
                Toast.makeText(this, "You did not added Joe Block to your contacts list",
                    Toast.LENGTH_SHORT).show()
            }.create()

        binding.btnDialogOne.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("ACCEPT") { dialogInterface, i ->
                Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("DECLINE") { dialogInterface, i ->
                Toast.makeText(this, "You decline the SingleChoiceDialog",
                    Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialogTwo.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) { dialogInterface, i, isChecked ->
                if(isChecked) {
                    Toast.makeText(this, "You checked on ${options[i]}", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You unchecked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }

            }
            .setPositiveButton("ACCEPT") { dialogInterface, i ->
                Toast.makeText(this, "You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("DECLINE") { dialogInterface, i ->
                Toast.makeText(this, "You decline the MultiChoiceDialog",
                    Toast.LENGTH_SHORT).show()
            }.create()
        binding.btnDialogThree.setOnClickListener {
            multiChoiceDialog.show()
        }


    }

}