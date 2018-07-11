package com.yanxuwen.lib_common.update;

import android.app.Activity;
import android.content.Intent;

import com.yanxuwen.lib_common.R;
import com.yanxuwen.mydialog.widget.update.MyUpdateDailog;
import com.yanxuwen.myutils.Utils.SDUtils;
import com.yanxuwen.myutils.Utils.ToastUtil;

import java.io.File;

/**
 * @Path com.bbx.taxi.client.UpdateChecker.ui.MyUpdateLoad.java
 * @Author 严旭文
 * @Date 2016-4-27 下午5:00:54
 * @Description
 */
public class MyUpdateLoad implements UpgradeService.OnUpdateProgressListener {
	public enum UpdateType{
		TYPE_QIDONG,TYPE_SET
	}
	private Activity context;
	private File apkFile;
	private String apkUrl;
	private String pathSavedDir;
	private String apkName ;
	 MyUpdateDailog dialog;
	public void downloadApk(Activity context,boolean Forced,UpdateType noupdatetype,final String apkUrl,String versiton) {
		this.apkUrl=apkUrl;
		this.pathSavedDir= SDUtils.getApkPath(context);
		this.context=context;
		Intent intent = new Intent(context, UpgradeService.class);
		intent.putExtra(UpgradeService.INTENT_URL,apkUrl);
		intent.putExtra(UpgradeService.INTENT_VERSION,versiton);
		context.startService(intent);
		ToastUtil.showToast(context, R.string.common_downloading);
		if(Forced||noupdatetype== UpdateType.TYPE_SET){
			dialog=new MyUpdateDailog(context);
			dialog.show();
		    UpgradeService.setOnUpdateProgressListener(this);
			if(Forced){
				dialog.setCancelable(false);
			}
		}

	}
	public MyUpdateDailog getDialog(){
		return dialog;
	}

	@Override
	public void onUpdateProgress(int progress) {
		getDialog().setProgress(progress);
       if(progress>=100){
    	   if(dialog!=null)dialog.dismiss();
          }

	}

}
