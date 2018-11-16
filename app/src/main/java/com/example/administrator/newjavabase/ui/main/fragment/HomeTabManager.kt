package com.example.administrator.newjavabase.ui.main.fragment
import android.support.v4.app.Fragment
import com.example.administrator.newjavabase.R
import com.example.administrator.newjavabase.ui.gank.fragment.GankFragment
import com.example.administrator.newjavabase.ui.knowledge.fragment.KnowledgeFragment
import com.example.administrator.newjavabase.ui.mine.fragment.MineFragment
import com.example.administrator.newjavabase.ui.project.fragment.ProjectFragment

/**
 * User: LiuGuoqing
 * Data: 2018/9/11 0011.
 */
class HomeTabManager {
    private var homeFragment: HomeFragment? = null
    private var gankFragment: GankFragment? = null
    private var knowledgeFragment: KnowledgeFragment? = null
    private var projectFragment: ProjectFragment? = null
    private var manageFragment: MineFragment? = null

    companion object {
        val instance: HomeTabManager by lazy { HomeTabManager() }
    }
    fun getFragmentByIndex(index: Int): Fragment? {
        var fragment: Fragment? = null
        when (index) {
            R.id.navigation_home -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                }
                fragment = homeFragment
            }
            R.id.navigation_credit -> {
                if (gankFragment == null) {
                    gankFragment = GankFragment()
                }
                fragment = gankFragment
            }
            R.id.navigation_generalize -> {
                if (knowledgeFragment == null) {
                    knowledgeFragment = KnowledgeFragment()
                }
                fragment = knowledgeFragment
            }
            R.id.navigation_project -> {
                if (projectFragment == null) {
                    projectFragment = ProjectFragment()
                }
                fragment = projectFragment
            }
            R.id.navigation_me -> {
                if (manageFragment == null) {
                    manageFragment = MineFragment()
                }
                fragment = manageFragment
            }
        }
        return fragment
    }


    fun destory() {
        homeFragment = null
        gankFragment = null
        knowledgeFragment = null
        projectFragment = null
        manageFragment = null
    }
}