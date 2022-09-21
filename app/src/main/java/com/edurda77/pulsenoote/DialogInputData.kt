package com.edurda77.pulsenoote

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogInputData: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Введите данные")
                .setView(R.layout.dialog_view)
                .setNegativeButton("Отмена") {
                        dialog, id ->  dialog.cancel()
                }
                .setPositiveButton("Ок") {
                        dialog, id ->  dialog.dismiss()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


}
