//package com.zhengchen.weight.QRcode;
//
//import android.Manifest;
//import android.content.ContentResolver;
//import android.content.Intent;
//import android.graphics.Bitmap;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//import android.view.View;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.tbruyelle.rxpermissions.RxPermissions;
//import com.yanxuwen.myutils.Utils.ToastUtil;
//import com.zhengchen.R;
//import com.zhengchen.Utils.ImageUtil;
//
//import rx.functions.Action1;
//
///**
// * Initial the camera
// * <p>
// * 默认的二维码扫描Activity
// */
//public class CaptureActivity extends AppCompatActivity  {
//    public static final int REQUEST_IMAGE=10000;
//    public  boolean isOpen = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.camera);
//        CaptureFragment captureFragment = new CaptureFragment();
//        captureFragment.setAnalyzeCallback(analyzeCallback);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_zxing_container, captureFragment).commit();
//        captureFragment.setCameraInitCallBack(new CaptureFragment.CameraInitCallBack() {
//            @Override
//            public void callBack(Exception e) {
//                if (e == null) {
//                } else {
//                    Log.e("TAG", "callBack: ", e);
//                }
//            }
//        });
//
//        ((LinearLayout)findViewById(R.id.ll_photo)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //权限请求
//                RxPermissions.getInstance(CaptureActivity.this)
//                        .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                        .subscribe(new Action1<Boolean>() {
//                            @Override
//                            public void call(Boolean granted) {
//                                if (granted) {
//                                    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                                    intent.addCategory(Intent.CATEGORY_OPENABLE);
//                                    intent.setType("image/*");
//                                    startActivityForResult(intent, REQUEST_IMAGE);
//                                } else {
//                                    ToastUtil.showToast(CaptureActivity.this,"请打开读写权限");
//                                }
//                            }
//                        });
//
//            }
//        });
//        ((LinearLayout)findViewById(R.id.ll_flash)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!isOpen) {
//                    QRcodeUtils.isLightEnable(true);
//                    isOpen = true;
//                } else {
//                    QRcodeUtils.isLightEnable(false);
//                    isOpen = false;
//                }
//            }
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_IMAGE) {
//            if (data != null) {
//                Uri uri = data.getData();
////                ContentResolver cr = getContentResolver();
//                try {
////                    Bitmap mBitmap = MediaStore.Images.Media.getBitmap(cr, uri);//显得到bitmap图片
//
//                    QRcodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, uri), new QRcodeUtils.AnalyzeCallback() {
//                        @Override
//                        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
//                            onSuccess(result);
//                        }
//
//                        @Override
//                        public void onAnalyzeFailed() {
//                            onFailed();
//                        }
//                    });
//
////                    if (mBitmap != null) {
////                        mBitmap.recycle();
////                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * 二维码解析回调函数
//     */
//    QRcodeUtils.AnalyzeCallback analyzeCallback = new QRcodeUtils.AnalyzeCallback() {
//        @Override
//        public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
//            onSuccess(result);
//        }
//
//        @Override
//        public void onAnalyzeFailed() {
//            onFailed();
//        }
//    };
//
//    /**
//     * 成功
//     */
//    public void onSuccess(String result){
//        Intent resultIntent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putInt(QRcodeUtils.RESULT_TYPE, QRcodeUtils.RESULT_SUCCESS);
//        bundle.putString(QRcodeUtils.RESULT_STRING, result);
//        resultIntent.putExtras(bundle);
//        CaptureActivity.this.setResult(RESULT_OK, resultIntent);
//        CaptureActivity.this.finish();
//    }
//
//    /**
//     * 失败
//     */
//    public void onFailed(){
//        Intent resultIntent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putInt(QRcodeUtils.RESULT_TYPE, QRcodeUtils.RESULT_FAILED);
//        bundle.putString(QRcodeUtils.RESULT_STRING, "");
//        resultIntent.putExtras(bundle);
//        CaptureActivity.this.setResult(RESULT_OK, resultIntent);
//        CaptureActivity.this.finish();
//    }
//
//
//}