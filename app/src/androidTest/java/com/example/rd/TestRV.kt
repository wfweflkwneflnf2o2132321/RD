package com.example.rd

import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher


fun clickChildViewWithId(id: Int): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View>? {
            return null
        }
        override fun getDescription(): String {
            return "НАЖМИТЕ НА ДОЧЕРНИЙ ВИД С ОПРЕДЕЛЁННЫМ ИНДЕФИКАТОРОМ"
        }
        override fun perform(
            uiController: UiController,
            view: View
        ) {
            val v = view.findViewById<View>(id)
            v.performClick()
        }
    }
}

fun setTextInTextView(value: String): ViewAction {
    return object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return CoreMatchers.allOf(
                ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(
                TextView::class.java))
        }

        override fun perform(uiController: UiController, view: View) {
            (view as TextView).text = value
        }

        override fun getDescription(): String {
            return "ПОВТОРИТЕ ТЕКСТ"
        }
    }
}