package com.example.administrator.newjavabase.ui.main.activity

import android.app.AlertDialog
import android.content.ComponentName
import android.content.DialogInterface
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.axl.android.frameworkbase.ui.BaseBackFragment
import com.axl.android.frameworkbase.view.BackHandledInterface
import com.example.administrator.newjavabase.R
import com.example.administrator.newjavabase.base.app.GlobalApp
import com.example.administrator.newjavabase.base.downapp.DownloadService
import com.example.administrator.newjavabase.ui.main.fragment.HomeTabManager
import com.example.administrator.newjavabase.utils.app.BottomNavigationViewHelper
import com.example.administrator.newjavabase.utils.app.PreferencesUtil
import com.example.administrator.newjavabase.utils.dialog.ToastUtils
import com.whty.xzfpos.base.AppBaseActivity
import kotlinx.android.synthetic.main.activity_main.*


/**
 * User: LiuGuoqing
 * Data: 2018/9/11 0011.
 * 主页
 */
class MainActivity : AppBaseActivity(), BackHandledInterface {

    override fun setSelectedFragment(selectedFragment: BaseBackFragment) {
    }

    private var mDownloadBinder: DownloadService.DownloadBinder? = null
    private var fragmentManager: FragmentManager? = null
    private var mContentFragment: Fragment? = null
    private var exitTime: Long = 0
    private var prefs: PreferencesUtil? = null
    override fun getBundleExtras(extras: Bundle) {}

    override fun getContentViewLayoutID(): Int {
        return R.layout.activity_main
    }

    override fun initViewsAndEvents() {
        BottomNavigationViewHelper.disableShiftMode(navigation)
        navigation!!.setOnNavigationItemSelectedListener(BottomNavOnClickListener())
        prefs = PreferencesUtil(this)
        init()
        initBind()
        //检测更新
        checkUpdate()
    }

    override fun getLoadingTargetView(): View? {
        return null
    }

    private val mConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            mDownloadBinder = service as DownloadService.DownloadBinder
        }

        override fun onServiceDisconnected(name: ComponentName) {
            mDownloadBinder = null
        }
    }

    /**
     * 进入页面绑定服务
     */
    private fun initBind() {
        val intent = Intent(this, DownloadService::class.java)
        startService(intent)
        bindService(intent, mConnection, BIND_AUTO_CREATE)//绑定服务
    }

    private fun init() {
        fragmentManager = supportFragmentManager
        val mFragmentTransaction = fragmentManager!!.beginTransaction().setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
        mContentFragment = HomeTabManager.instance.getFragmentByIndex(R.id.navigation_home)
        mFragmentTransaction.add(R.id.main_page_fragment_replace_layout, mContentFragment)
        mFragmentTransaction.commitAllowingStateLoss()
    }

    inner class BottomNavOnClickListener : BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.navigation_home -> {
                    switchFragment(HomeTabManager.instance.getFragmentByIndex(R.id.navigation_home))
                    return true
                }
                R.id.navigation_credit -> {
                    switchFragment(HomeTabManager.instance.getFragmentByIndex(R.id.navigation_credit))
                    return true
                }
                R.id.navigation_generalize -> {
                    switchFragment(HomeTabManager.instance.getFragmentByIndex(R.id.navigation_generalize))
                    return true
                }
                R.id.navigation_project -> {
                    switchFragment(HomeTabManager.instance.getFragmentByIndex(R.id.navigation_project))
                    return true
                }
                R.id.navigation_me -> {
                    switchFragment(HomeTabManager.instance.getFragmentByIndex(R.id.navigation_me))
                    return true
                }
                else -> return false
            }

        }
    }

    private fun switchFragment(to: Fragment?) {
        if (mContentFragment !== to) {
            val mFragmentTransaction = fragmentManager!!.beginTransaction()
            if (!to!!.isAdded) {    // 先判断是否被add过
                mFragmentTransaction.hide(mContentFragment).add(R.id.main_page_fragment_replace_layout, to).commitAllowingStateLoss() // 隐藏当前的fragment，add下一个到Activity中
            } else {
                mFragmentTransaction.hide(mContentFragment).show(to).commitAllowingStateLoss() // 隐藏当前的fragment，显示下一个
            }
            mContentFragment = to
        }
    }

    private fun checkUpdate() {
        /*val map = TreeMap<String, String>()
        map["platform"] = "android"
        HomeImpl.checkUpdate(TransMapToBeanUtils.mapToBean(map, CheckUpdateReqModel::class.java) as CheckUpdateReqModel)
                .subscribe(object : ProgressSubscriber<CheckUpdateRepModel>(mContext) {
                    override fun _onNext(checkUpdateRepModel: CheckUpdateRepModel) {
                        if (checkUpdateRepModel.isOk) {
                            val versionNumber = checkUpdateRepModel.data.lastVersion
                            val version = getVersion()
                            val url = checkUpdateRepModel.data.appUrl
                            if (TextUtils.isEmpty(version)) {
                                return
                            }
                            var localVersion = 0
                            var serviceNumVersion = 0
                            try {
                                localVersion = Integer.parseInt(version.replace(".", ""))
                                serviceNumVersion = Integer.parseInt(versionNumber.replace(".", ""))
                            } catch (e: NumberFormatException) {
                                Logger.e(e.message)
                            }
                            if (localVersion < serviceNumVersion && checkUpdateRepModel.data.forceUpdate.equals("1")) {
                                //走强制更新
                                forcedDownLoad(url)
                            } else if (localVersion < serviceNumVersion && checkUpdateRepModel.data.forceUpdate.equals("0")) {
                                //非强制更新
                                DownLoad(url)
                            }
                        } else {
                            ToastUtils.showLong(checkUpdateRepModel.returnMsg)
                        }
                    }

                    override fun _onError(message: String?) {
                        ToastUtils.showLong(message)
                    }
                })*/
    }

    private fun DownLoad(url: String?) {
        val mDialog = AlertDialog.Builder(this)
        mDialog.setTitle(getString(R.string.text_check_update))
        mDialog.setMessage(getString(R.string.text_introduction_update))
        mDialog.setPositiveButton(R.string.text_update_now, { dialog, which ->
            if (mDownloadBinder != null) {
                mDownloadBinder!!.startDownload(url)
                ToastUtils.showShort(getString(R.string.text_notification_check) + "")
                dialog.dismiss()
            }
        })
        mDialog.setNegativeButton(R.string.text_update_note, { dialogInterface, i ->
            dialogInterface.dismiss()
        })
        mDialog.setCancelable(false)
        mDialog.create().show()
    }

    private fun forcedDownLoad(url: String?) {
        val mDialog = AlertDialog.Builder(this)
        mDialog.setTitle(getString(R.string.text_check_update))
        mDialog.setMessage(getString(R.string.text_introduction_update))
        mDialog.setPositiveButton(R.string.text_update_now, DialogInterface.OnClickListener { dialog, which ->
            if (mDownloadBinder != null) {
                mDownloadBinder!!.startDownload(url)
                ToastUtils.showShort(getString(R.string.text_notification_check) + "")
                dialog.dismiss()
            }
        }).setCancelable(false).create().show()
    }

    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    fun getVersion(): String {
        try {
            val manager = mContext!!.packageManager
            val info = manager.getPackageInfo(mContext!!.packageName, 0)
            return info.versionName
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        HomeTabManager.instance.destory()
        unbindService(mConnection)
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            Toast.makeText(applicationContext, getString(R.string.exit_tip),
                    Toast.LENGTH_SHORT).show()
            exitTime = System.currentTimeMillis()
        } else {
            super.onBackPressed()
            GlobalApp.removeAllActivity()
            System.exit(0)
        }
    }
}
