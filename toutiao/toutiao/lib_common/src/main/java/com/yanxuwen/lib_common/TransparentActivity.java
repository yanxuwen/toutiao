package com.yanxuwen.lib_common;

import android.app.Activity;
import android.os.Bundle;

public class TransparentActivity extends Activity{
  @Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	finish();
}
}
