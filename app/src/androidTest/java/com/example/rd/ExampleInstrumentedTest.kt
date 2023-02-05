package com.example.rd

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun checkAllComponentIsVisible_isSuccess() {
        Espresso.onView(withId(R.id.fabAddContact))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        val name = "A"

        Espresso.onView(withId(R.id.etName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(name))
            .check(ViewAssertions.matches(ViewMatchers.withText(name)))// ПРОВЕРКА НА СОХРАНЕНИЯ КОНТАКТА

        val surname = "K"

        Espresso.onView(withId(R.id.etSurname))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(surname))
            .check(ViewAssertions.matches(ViewMatchers.withText(surname)))

        val phone = "+744445555799"

        Espresso.onView(withId(R.id.etNumber))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(phone))
            .check(ViewAssertions.matches(ViewMatchers.withText(phone)))

        Espresso.onView(withId(R.id.btnSave))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())



        Espresso.onView(withId(R.id.rvContacts))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1,
                clickChildViewWithId(R.id.ivEdit)))


        val newName2 = "5"

        Espresso.onView(withId(R.id.etName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(setTextInTextView(newName2))
            .check(ViewAssertions.matches(ViewMatchers.withText(newName2)))// ПРОВЕРКА РЕДАКТИРОВАНИЯ

        val newSurname2 = "5"

        Espresso.onView(withId(R.id.etSurname))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(setTextInTextView(newSurname2))
            .check(ViewAssertions.matches(ViewMatchers.withText(newSurname2)))

        val newPhone2 = "777"

        Espresso.onView(withId(R.id.etNumber))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(setTextInTextView(newPhone2))
            .check(ViewAssertions.matches(ViewMatchers.withText(newPhone2)))

        Espresso.onView(withId(R.id.btnSave1))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.fabAddContact))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        val nameToAdd = "ARTEM"

        Espresso.onView(withId(R.id.etName))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(nameToAdd))
            .check(ViewAssertions.matches(ViewMatchers.withText(nameToAdd)))// ПРОЕРКА НА ДОБАВЛЕНИЕ КОНТАКТА С ПОЛНЫМ ИМЕНЕМ

        val surnameToAdd = "KUTUZOV"

        Espresso.onView(withId(R.id.etSurname))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(surnameToAdd))
            .check(ViewAssertions.matches(ViewMatchers.withText(surnameToAdd)))

        val phoneToAdd = "+555555555555"

        Espresso.onView(withId(R.id.etNumber))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.typeText(phoneToAdd))
            .check(ViewAssertions.matches(ViewMatchers.withText(phoneToAdd)))

        Espresso.onView(withId(R.id.btnSave))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.rvContacts))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2,
                clickChildViewWithId(R.id.ivEdit)))

        // ТЕСТ ЭКРАНА РЕДОКТИРОВАНИЯ
        Espresso.onView(withId(R.id.btnDelete))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .perform(ViewActions.click())

        Espresso.onView(withId(R.id.rvContacts))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

}