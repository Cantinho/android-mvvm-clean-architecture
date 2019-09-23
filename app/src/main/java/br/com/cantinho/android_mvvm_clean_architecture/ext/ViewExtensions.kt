package br.com.cantinho.android_mvvm_clean_architecture.ext

import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.toInt(): Int {
    return this.text.toString().toInt()
}