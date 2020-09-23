package com.beka.calculator_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {

        if(isNewOp)
            editText.setText("")
        isNewOp=false

        var buttonClick = editText.text.toString()
        var buttonSelect = view as Button
        when(buttonSelect.id){
            buttonOne.id ->{buttonClick += '1'}
            buttonTwo.id ->{buttonClick += '2'}
            buttonThree.id ->{buttonClick += '3'}
            buttonFour.id ->{buttonClick += '4'}
            buttonFive.id ->{buttonClick += '5'}
            buttonSix.id ->{buttonClick += '6'}
            buttonSeven.id ->{buttonClick += '7'}
            buttonEight.id ->{buttonClick += '8'}
            buttonNine.id ->{buttonClick += '9'}
            buttonZero.id ->{buttonClick += '0'}
            buttonDot.id ->{buttonClick += '.'}
            buttonPlusMinus.id ->{buttonClick = "-$buttonClick"}
            buttonPlus.id ->{buttonClick += '.'}
            buttonDot.id ->{buttonClick += '.'}
        }
        editText.setText(buttonClick)
    }

    fun operatorEvent(view: View) {
        isNewOp = true
        oldNumber = editText.text.toString()
        var buttonSelect = view as Button
        when(buttonSelect.id){
            buttonMultiply.id->{op = "*"}
            buttonPlus.id->{op = "+"}
            buttonMinus.id->{op = "-"}
            buttonDevide.id->{op = "/"}
        }
    }

    fun equalEvent(view: View){
        var newnumber = editText.text.toString()
        var result = 0.0
        when(op){
            "+" -> {result = oldNumber.toDouble() + newnumber.toDouble()}
            "*" -> {result = oldNumber.toDouble() * newnumber.toDouble()}
            "/" -> {result = oldNumber.toDouble() / newnumber.toDouble()}
            "-" -> {result = oldNumber.toDouble() - newnumber.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun acEvent(view: View){
        editText.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View){
        var no = editText.text.toString().toDouble()/100
        editText.setText((no.toString()))
        isNewOp = true
    }
}
