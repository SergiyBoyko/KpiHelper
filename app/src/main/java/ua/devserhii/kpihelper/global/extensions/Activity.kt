package ua.devserhii.kpihelper.global.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by Serhii Boiko on 28.06.2019.
 */

fun AppCompatActivity.replaceFragment(container: Int, fragment: Fragment) {
    val fm = supportFragmentManager.beginTransaction()
    fm.replace(container, fragment)
    fm.commit()
}

fun AppCompatActivity.addFragment(container: Int, fragment: Fragment) {
    val fm = supportFragmentManager.beginTransaction()
    fm.replace(container, fragment)
    fm.addToBackStack(fragment.javaClass.name)
    fm.commitAllowingStateLoss()
}