package com.cursosant.inventory.addModule.view

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.cursosant.inventory.R
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class AddProductFragmentTest{
    @Test
    fun createDialog_notNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment{ fragment ->
            MatcherAssert.assertThat(fragment.dialog, Matchers.`is`(Matchers.notNullValue()))
        }
    }

    @Test
    fun cancelDialog_isNullTest(){
        val scenario = launchFragment<AddProductFragment>(themeResId = R.style.Theme_Inventory)
        scenario.moveToState(Lifecycle.State.RESUMED)
        scenario.onFragment{ fragment ->
            (fragment.dialog as? AlertDialog)?.let {
                it.getButton(DialogInterface.BUTTON_NEGATIVE).performClick()
                MatcherAssert.assertThat(fragment.dialog, Matchers.`is`(Matchers.nullValue()))
            }
        }
    }
}