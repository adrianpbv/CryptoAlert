package com.example.android.cryptoalert.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.skydoves.whatif.whatIfNotNull
import javax.inject.Inject

/**
 * Base Fragment to observe on the common LiveData objects
 */

abstract class BaseFragment: Fragment() {

    abstract val viewModel: BaseViewModel

    override fun onStart() {
        super.onStart()
        viewModel.navigation.observe(this) { command ->
            command.getContentIfNotHandled()?.whatIfNotNull {
                when (it) {
                    is NavigationCommand.To -> findNavController().navigate(it.directions)
                    is NavigationCommand.Back -> findNavController().popBackStack()
                    is NavigationCommand.BackTo -> findNavController().popBackStack(
                        it.destinationId,
                        false
                    )
                }
            }
        }

        viewModel.showSnackBar.observe(this){
            it.getContentIfNotHandled()?.whatIfNotNull { intResource ->
                Snackbar.make(this.requireView(), intResource, Snackbar.LENGTH_LONG).show()
            }
        }

        viewModel.showToast.observe(this){
            it.getContentIfNotHandled()?.whatIfNotNull {  intResource ->
                Toast.makeText(context, intResource, Toast.LENGTH_LONG).show()
            }
        }
    }
}