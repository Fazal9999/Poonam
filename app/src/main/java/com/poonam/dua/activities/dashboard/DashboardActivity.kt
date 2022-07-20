package com.poonam.dua.activities.dashboard

 import android.os.Bundle
 import android.view.View
 import androidx.navigation.NavController
 import androidx.navigation.NavDestination
 import androidx.navigation.fragment.NavHostFragment
 import androidx.navigation.ui.NavigationUI.setupWithNavController
 import com.poonam.dua.R
 import com.poonam.dua.base.BindingActivity
 import com.poonam.dua.databinding.ActivityDashboardBinding


class DashboardActivity: BindingActivity<ActivityDashboardBinding>()

{
    lateinit var navController: NavController
    private val navSectionsStateKeeper by lazy {
        NavigationBottomBarSectionsStateKeeperWorkaround(
            activity = this,
            navHostContainerID = R.id.main_nav_container,
            navGraphIds = listOf(
                R.navigation.dash_graph
//                R.navigation.nav_section2,
//                R.navigation.nav_section3
            ),
            bottomNavigationViewID = R.id.bottom_navigation
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
//       navController = navHostFragment.navController
//       binding.bottomNavigation.setupWithNavController(navController)
        //setSupportActionBar(toolbar)
//        supportActionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//            setDisplayShowHomeEnabled(true)
//        }
        setupBottomNavigation()
        navSectionsStateKeeper.onCreate(savedInstanceState)

//        binding.bottomNavigation.setOnItemSelectedListener { item: MenuItem ->
//
//        }

}


    fun showBottomSheet(){
        binding.bottomNavigation.visibility= View.VISIBLE
    }
    fun hideBottomSheet(){
        binding.bottomNavigation.visibility= View.GONE
    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()

    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        navSectionsStateKeeper.onRestoreInstanceState(savedInstanceState)
    }

    override fun onSupportNavigateUp() =
        navSectionsStateKeeper.onSupportNavigateUp()

    override fun onBackPressed() {
        if (!navSectionsStateKeeper.onSupportNavigateUp())
            super.onBackPressed()
    }
    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById( R.id.fragment_container_view) as NavHostFragment?
        if (navHostFragment != null) {
            navController = navHostFragment
                .navController
            setupWithNavController(
                binding.bottomNavigation, navController
            )
            initDestinationListener()
        }
    }

    private fun initDestinationListener() {
        navController.addOnDestinationChangedListener { controller: NavController?, destination: NavDestination, bundle: Bundle? ->
            when (destination.id) {
                R.id.dashboardFragment -> {
                    showBottomSheet()

                }
                R.id.statisticsFragment->{
                    showBottomSheet()

                }
                R.id.timesFragment->{


                }
                R.id.chatFragment->{
                    showBottomSheet()

                }
                R.id.profileFragment->{
                    showBottomSheet()

                }

                else ->{
                    hideBottomSheet()

                }

            }
        }
    }
}