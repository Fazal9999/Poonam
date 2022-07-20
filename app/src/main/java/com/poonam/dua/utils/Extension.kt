package com.poonam.dua.utils

import android.app.Activity
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.poonam.dua.R
import com.poonam.dua.base.*
import java.lang.reflect.ParameterizedType
@Override
fun <V : ViewBinding> Class<*>.getBinding(layoutInflater: LayoutInflater): V {
    return try {
        @Suppress("UNCHECKED_CAST")
        getMethod(
            "inflate",
            LayoutInflater::class.java
        ).invoke(null, layoutInflater) as V
    } catch (ex: Exception) {
        throw RuntimeException("The ViewBinding inflate function has been changed.", ex)
    }
}


internal fun <V : ViewBinding> Class<*>.getBinding(
    layoutInflater: LayoutInflater,
    container: ViewGroup?
): V {
    return try {
        @Suppress("UNCHECKED_CAST")
        getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null, layoutInflater, container, false) as V
    } catch (ex: Exception) {
        throw RuntimeException("The ViewBinding inflate function has been changed.", ex)
    }
}internal fun Class<*>.checkMethod(): Boolean {
    return try {
        getMethod(
            "inflate",
            LayoutInflater::class.java
        )
        true
    } catch (ex: Exception) {
        false
    }
}
internal fun Any.findClass(): Class<*> {
    var javaClass: Class<*> = this.javaClass
    var result: Class<*>? = null
    while (result == null || !result.checkMethod()) {
        result = (javaClass.genericSuperclass as? ParameterizedType)
            ?.actualTypeArguments?.firstOrNull {
                if (it is Class<*>) {
                    it.checkMethod()
                } else {
                    false
                }
            } as? Class<*>
        javaClass = javaClass.superclass
    }
    return result
}

inline fun <reified V : ViewBinding> ViewGroup.toBinding(): V {
    return V::class.java.getMethod(
        "inflate",
        LayoutInflater::class.java,
        ViewGroup::class.java,
        Boolean::class.java
    ).invoke(null, LayoutInflater.from(context), this, false) as V
}

/*Activity*/
internal fun <V : ViewBinding> BindingActivity<V>.getBinding(): V {
    return findClass().getBinding(layoutInflater)
}

/*Fragment*/
internal fun <V : ViewBinding> BindingFragment<V>.getFragmentBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
): V {

    return findClass().getBinding(inflater, container)
}
///*BottomSheet Dialog*/
internal fun <V : ViewBinding> BindingBottomSheetDialog<V>.getBottomBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
): V {
    return findClass().getBinding(inflater, container)
}


///* Dialog*/
internal fun <V : ViewBinding> BindingDialog<V>.getBottomBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
): V {
    return findClass().getBinding(inflater, container)
}

//
/*Binding Component*/
internal fun <V : ViewBinding> BindingComponent<V>.getComponentBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
): V {
    return findClass().getBinding(inflater, container)
}


/*Others*/

fun Activity.snackbar(message: String) =
    Snackbar.make(this.window.decorView.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG).show()

inline fun <reified T : Any> Activity.launchActivity() {
    val intent = Intent(this, T::class.java)
//    if (value != null) {
//        intent.putExtra(key, value)
//        startActivity(intent)
//    } else {
        startActivity(intent)
//    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun Activity.isConnected(): Boolean {
    var status = false
    val conManager = getSystemService(AppCompatActivity.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        if (conManager.activeNetwork != null && conManager.getNetworkCapabilities(
                conManager.activeNetwork
            ) != null
        ) {
            status = true
        }
    } else {
        if (conManager.activeNetwork != null) {
            status = true
        }
    }
    return status
}



