package com.artikov.modul_5_lesson_8_1

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.ilhomjon.dialogs.MyDialogFragent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog.view.*
import kotlinx.android.synthetic.main.custom_bottom_sheet_dialog.*
import kotlinx.android.synthetic.main.custom_dialog_view.*
import kotlinx.android.synthetic.main.custom_dialog_view.view.*
import kotlinx.android.synthetic.main.custom_dialog_view.view.text_custom
import kotlinx.android.synthetic.main.custom_new_dialog.view.*
import kotlinx.android.synthetic.main.fragment_my_dialog.*

class MainActivity : AppCompatActivity() {

/*
    alert, custom, fragment dialoglarni dizayniga e'tibor bering, real applarda ishlatilgan dialoglarni yasab ko'ring
* */

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        alertDialog.setOnClickListener {

            val view = View.inflate(this, R.layout.alert_dialog, null)

            val builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            dialog.setCancelable(false)

            view.btn_confirm.setOnClickListener {
                Toast.makeText(this, "Confirmar", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

        }

        customDialog.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            val create = builder.create()

            val dialogView = layoutInflater.inflate(R.layout.custom_new_dialog, null, false)
            create.setView(dialogView)

            create.setCancelable(false)

            dialogView.newDialogBack.setBackgroundColor(Color.TRANSPARENT)

                dialogView.dialogLoginBtn.setOnClickListener {
                    Toast.makeText(this, "${dialogView.dialogNameEt.text}\n${dialogView.dialogEmailEt.text}\n${dialogView.dialogPasswEt.text}", Toast.LENGTH_SHORT).show()
                    create.dismiss()
                }
                dialogView.dialogCancelBtn.setOnClickListener {
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                    create.dismiss()
                }

            create.show()
        }

        fragmentDialog.setOnClickListener {

            val myDialogFragment = MyDialogFragent.newInstance("birNarsa", "ikkinchiNarsa")
            myDialogFragment.show(supportFragmentManager.beginTransaction(), "keylar")

        }

        dateDialog.setOnClickListener {

            val datePickerDialog = DatePickerDialog(this)

            datePickerDialog.updateDate(1999,0,10)
            datePickerDialog.setOnDateSetListener { datePicker, i, i2, i3 ->
                Toast.makeText(this, "$i.${i2 + 1}.$i3", Toast.LENGTH_SHORT).show()
            }

            datePickerDialog.show()

        }

        timePickerDialog.setOnClickListener {

            val timePickerDialog = TimePickerDialog(this,
                { p0, p1, p2 -> Toast.makeText(this, "Hour:$p1\nMinute:$p2", Toast.LENGTH_SHORT).show() },24,60,true)

            timePickerDialog.show()

        }

        bottomSheetDialog.setOnClickListener {

            val btnsheet = layoutInflater.inflate(R.layout.custom_bottom_sheet_dialog, null)
            val dialog = BottomSheetDialog(this)
            dialog.setContentView(btnsheet)
            btnsheet.setOnClickListener {
                dialog.dismiss()
            }
            dialog.loginbtn.setOnClickListener {
                Toast.makeText(this, "${dialog.email.text.toString()}", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            dialog.black.setOnClickListener {
                Toast.makeText(this, "Black", Toast.LENGTH_SHORT).show()
            }

            dialog.blue.setOnClickListener {
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
            }

            dialog.red.setOnClickListener {
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show()
            }

            dialog.orange.setOnClickListener {
                Toast.makeText(this, "Orange", Toast.LENGTH_SHORT).show()
            }

            dialog.show()

        }

        snackbar.setOnClickListener {
            val snackbar = Snackbar.make(
                it,
                "Assalomu aleykum",
                5000,
            )

            snackbar.setAction("5 sec"
            ) { Toast.makeText(this@MainActivity, "Stop time", Toast.LENGTH_SHORT).show() }

            snackbar.setActionTextColor(Color.GREEN)
            snackbar.setTextColor(Color.RED)
            snackbar.setBackgroundTint(Color.BLUE)

            snackbar.show()
        }

    }
}