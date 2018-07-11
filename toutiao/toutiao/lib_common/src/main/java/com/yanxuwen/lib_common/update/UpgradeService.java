package com.yanxuwen.lib_common.update;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RemoteViews;

import com.yanxuwen.lib_common.R;
import com.yanxuwen.lib_common.TransparentActivity;
import com.yanxuwen.myutils.Utils.SDUtils;
import com.yanxuwen.myutils.Utils.ToastUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpgradeService extends IntentService   {
	String UPDATA_PATH = "";
	private int ID=20;
	public static String INTENT_URL = "intent_url";
	public static String INTENT_VERSION = "intent_version";
	private static final int ACTION_UPGRADE = 1;
	private static final int ACTION_UPGRADE_FINISHED = 2;
	private static final int ACTION_ACTION_UPDATA_ERROR = 3;
	private static final int ACTION_FAIL_CONNECTED = 5;
	private static final int ACTION_SERVER_ERROR = 6;

	private static String ACTION_INSTALL = "application/vnd.android.package-archive";
	private final String SHA_DOWNLOAD_POS = "download";
	private final String SHA_NEW_SIZE = "new_download_size";
	private final String HEAD_range = "range";
	private Notification notify;
	private NotificationManager mNotifyMgr;

	private String url = "";
	private static String version;
	private String newName = "";
	private int borkenLength;
	public Context context;
	private long loadTime=0;
	public interface OnUpdateProgressListener {
		public void onUpdateProgress(int progress);
	};
	public static OnUpdateProgressListener mOnUpdateProgressListener = null;
	public static void  setOnUpdateProgressListener(OnUpdateProgressListener l) {
		mOnUpdateProgressListener = l;
	}

	public UpgradeService() {
		super("upgrade");
	}

	@Override
	public void onCreate() {
		super.onCreate();
		context = this;
		UPDATA_PATH= SDUtils.getApkPath(context);
		mNotifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		notify = null;
		mNotifyMgr = null;
		version = "";
	}

	public UpgradeService(String name) {
		super(name);
	}

	public Handler mHandler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case ACTION_UPGRADE:
				updateDownloadNotify(msg.arg1, msg.arg2);
				break;
			case ACTION_UPGRADE_FINISHED:
//				put(SHA_DOWNLOAD_POS, -1);// 下载完成后把标记断点记为-1
				downloadCompleteNotify();
				break;
			case ACTION_ACTION_UPDATA_ERROR:
				ToastUtil.showToast(context, R.string.common_upgrade_fail);
				stop();
				break;
			case ACTION_FAIL_CONNECTED:
				ToastUtil.showToast(context, R.string.common_link_fail);
				stop();
				break;
			case ACTION_SERVER_ERROR:
				ToastUtil.showToast(context, R.string.common_request_fail);
				stop();
				break;
			default:
				break;
			}
		}
	};

	public String getFielName(String url, String version) {
		return url.substring(url.lastIndexOf("/") + 1) + System.currentTimeMillis() + ".apk";
	}
//
//	public int getBrokenPos(String version) {
//		return SharedPreUtil.getIntValue(context, SHA_DOWNLOAD_POS + version,-1);
//	}
//
//	public void putBrokenPos(String version,int pos) {
//		SharedPreUtil.putIntValue(context, SHA_DOWNLOAD_POS + version,pos);
//	}
//
//	public void put(String tag, int curlength) {
//		SharedPreUtil.putIntValue(context, tag + version, curlength);
//	}



	//开始下载
	public void startDownload(String version){
		showNofity();
//		borkenLength = getBrokenPos(version);
//		if (borkenLength != -1 && borkenLength > 0) {
//			downLoadAnd(version);
//		} else {
			downLoadAll(version);
//		}
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		try {
			url = intent.getStringExtra(INTENT_URL);
			String newVersion = intent.getStringExtra(INTENT_VERSION);

			if (newVersion.equals(version)) {//记录当前下载的版本号，如果存在则跳过
				return;
			}
			version = newVersion;
			newName = getFielName(url, newVersion);

			if (TextUtils.isEmpty(url)) {
				mHandler.sendEmptyMessage(ACTION_FAIL_CONNECTED);
				return;
			}else{
				startDownload(newVersion);
			}
		} catch (Exception e) {
			e.printStackTrace();
//			putBrokenPos(version, -1);
			mHandler.sendEmptyMessage(ACTION_FAIL_CONNECTED);
		}
		return;
	}



	/** 断点续传 */
	public void downLoadAnd(String version) {

//		RandomAccessFile fos = null;
//		BufferedInputStream bis = null;
//		int fileSize = 0;
//		try {
//			HttpURLConnection con = null;
//			URL uurl = new URL(url);
//
//			int newSize = getBrokenPos(version);
//			if (newSize != -1 && newSize > 0) {
//				fileSize = newSize;
//			} else {
//				URLConnection tmp = uurl.openConnection();
//				fileSize = tmp.getContentLength();
//				tmp = null;
//			}
//			if (isExsit(fileSize)) {
//				return;
//			}
//
//			con = (HttpURLConnection) uurl.openConnection();
//			// 设置当前线程下载的起�?
//			con.addRequestProperty(HEAD_range, "bytes=" + borkenLength + "-");
//			DebugUtil.printDebugInfo("updata service responseCode==="+ con.getResponseCode());
//			// 使用java中的RandomAccessFile 对文件进行随机读写操�?
//			fos = new RandomAccessFile(UPDATA_PATH , newName, "rw");
//			// 设置�?��写文件的位置
//			fos.seek(borkenLength);
//			bis = new BufferedInputStream(con.getInputStream());
//
//			byte[] buffer = new byte[1024];
//
//			int len = 0;
//			int time = 0;
//			int loadedLength = 0;
//			while ((len = bis.read(buffer)) != -1) {
//				loadedLength += len;
//				if (time++ % 100 == 0) {
//					Message msg = mHandler.obtainMessage(ACTION_UPGRADE,loadedLength + borkenLength, fileSize);
//					mHandler.sendMessage(msg);
//				}
//				fos.write(buffer, 0, len);
//				put(SHA_DOWNLOAD_POS, loadedLength + borkenLength);
//			}
//
//			Message msg = mHandler.obtainMessage(ACTION_UPGRADE_FINISHED,fileSize, fileSize);
//			mHandler.sendMessage(msg);
//
//		} catch (Exception e) {
//			e.printStackTrace();
////			mHandler.sendEmptyMessage(ACTION_FAIL_CONNECTED);
//			putBrokenPos(version, -1);
//			downLoadAll(version);
//		} finally {
//			if (null != fos) {
//				try {
//					fos.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//					mHandler.sendEmptyMessage(ACTION_ACTION_UPDATA_ERROR);
//				}
//			}
//			if (bis != null) {
//				try {
//					bis.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//					mHandler.sendEmptyMessage(ACTION_ACTION_UPDATA_ERROR);
//				}
//			}
//			put(newName, -1);
//		}
	}

	/** 重新完整的下载一个apk */
	public void downLoadAll(String version) {
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			URL mUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection)mUrl.openConnection();
			conn.connect();
			int fileLength =conn.getContentLength();//获取文件大小
			 is = conn.getInputStream();
//			put(SHA_NEW_SIZE, fileLength);
//
//			if (isExsit(fileLength)) {
//				return;
//			}
			File file = new File(UPDATA_PATH, newName);
			File file2 = file.getParentFile();
			try {
				if (!file2.exists()) {
					file2.mkdirs();
					file.createNewFile();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				mHandler.sendEmptyMessage(ACTION_FAIL_CONNECTED);
				return;
			}
			fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int times = 0;
			int len = 0;
			int loadedLength = 0;
			while ((len = is.read(buffer)) != -1) {
				loadedLength += len;
				if (times++ % 100 == 0) {
					Message msg = mHandler.obtainMessage(ACTION_UPGRADE,loadedLength, fileLength);
					mHandler.sendMessage(msg);
				}
				fos.write(buffer, 0, len);
//				put(SHA_DOWNLOAD_POS, loadedLength);
			}
			Message msg = mHandler.obtainMessage(ACTION_UPGRADE_FINISHED,fileLength, fileLength);
			mHandler.sendMessage(msg);
		} catch (Exception e) {
			e.printStackTrace();
			mHandler.sendEmptyMessage(ACTION_ACTION_UPDATA_ERROR);
//			put(newName, -1);
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
					mHandler.sendEmptyMessage(ACTION_ACTION_UPDATA_ERROR);
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					mHandler.sendEmptyMessage(ACTION_ACTION_UPDATA_ERROR);
				}
			}
		}
	}


	/** 下载完成 */
	private void downloadCompleteNotify() {
		if(mOnUpdateProgressListener!=null)mOnUpdateProgressListener.onUpdateProgress(100);
		notify = new Notification(R.mipmap.common_ic_launcher,getString(R.string.common_downloaded), System.currentTimeMillis());
		RemoteViews view = new RemoteViews(getPackageName(),R.layout.common_notify_upgrade);
		//更新view
		view.setTextViewText(R.id.textprogress, getString(R.string.app_name));
		view.setViewVisibility(R.id.progressBar1, View.INVISIBLE);
		view.setTextViewText(R.id.download_complete,getString(R.string.common_install));
		view.setProgressBar(R.id.progressBar1, 100, 100, false);

		notify.contentView = view;

		Intent intent = new Intent(Intent.ACTION_VIEW);
		Uri data = Uri.fromFile(new File(UPDATA_PATH , newName));
		intent.setDataAndType(data, ACTION_INSTALL);
		PendingIntent ci = PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
		notify.flags |= Notification.FLAG_AUTO_CANCEL;
		notify.contentIntent = ci;
		mNotifyMgr.notify(ID, notify);

		intentInstall();
	}

	/** 更新notify */
	private void updateDownloadNotify(final int progress, final int fileLength) {
		final RemoteViews view;
		if (notify == null) {
			notify = new Notification(R.mipmap.common_ic_launcher,getString(R.string.common_upgrade), System.currentTimeMillis());
			view = new RemoteViews(getPackageName(), R.layout.common_notify_upgrade);
			notify.contentView = view;
		} else {
			view = notify.contentView;
		}
		new AsyncTask<Void, Void, Void>(){

			@Override
			protected Void doInBackground(Void... params) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected void onPostExecute(Void result) {
				view.setTextViewText(R.id.download_complete, "");
				int downloadProgress =(int)(((float)progress / (float)fileLength)* 100);
				if(downloadProgress>100) downloadProgress = 99;//超过100，则处理为99

				view.setTextViewText(R.id.textprogress, getString(R.string.app_name)+ "(" + downloadProgress+ "%)");
				view.setProgressBar(R.id.progressBar1, fileLength, progress, false);

				if(mOnUpdateProgressListener!=null)mOnUpdateProgressListener.onUpdateProgress(downloadProgress);
                if(mNotifyMgr!=null&&(System.currentTimeMillis()-loadTime)>1000){
                	mNotifyMgr.notify(ID, notify);
                	loadTime=System.currentTimeMillis();
                }

				super.onPostExecute(result);
			}

			}.execute();


	}

	/** 准备升级notify */
	private void showNofity() {
		notify =getNotify(R.string.common_upgrade);
		RemoteViews view = new RemoteViews(getPackageName(),R.layout.common_notify_upgrade);
		view.setTextViewText(R.id.textprogress, getString(R.string.common_download_ready));
		view.setTextViewText(R.id.download_complete, "");
		view.setProgressBar(R.id.progressBar1, 100, 0, false);

		notify.contentView = view;
		Intent intent = new Intent();
		intent.setClass(this, TransparentActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

		PendingIntent ci = PendingIntent.getActivity(this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);
		notify.flags |= Notification.FLAG_AUTO_CANCEL;
		notify.contentIntent = ci;
		mNotifyMgr.notify(ID, notify);
	}

	public Notification getNotify(int title) {
		return new Notification(R.mipmap.common_ic_launcher, getString(title),System.currentTimeMillis());
	}

	public void intentInstall(){
		// 下载完成后弹出安装窗
		File file = new File(UPDATA_PATH , newName);
		Intent intentInstall = new Intent();
		intentInstall.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intentInstall.setAction(Intent.ACTION_VIEW);
		intentInstall.setDataAndType(Uri.fromFile(file), ACTION_INSTALL);
		startActivity(intentInstall);
	}

	// 判断本地文件的size 与服务器同名版本size是否相等
	public boolean isExsit(int netApkSize) {
		File file = new File(UPDATA_PATH,newName);
		if (file.exists()) {
			if (netApkSize == file.length()) {
				mHandler.sendEmptyMessage(ACTION_UPGRADE_FINISHED);
				return true;
			}
		}
		return false;
	}
	public void stop() {
		loadTime=0;
		mNotifyMgr.cancelAll();
		UpgradeService.this.stopSelf();
	}
}
