package cn.sharesdk.share.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;

public class DerectShareWithoutEditActivity extends Activity implements OnClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_derect_share);

		LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout1);
		Platform[] platforms = ShareSDK.getPlatformList();
		for (Platform p : platforms) {
			Button btn = new Button(this);
			btn.setText(p.getName());
			btn.setTag(p);
            Log.d("DeBugShow","循环打印出名字"+p.getName());
            btn.setOnClickListener(this);
			layout.addView(btn, new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		}
	}

	public void onClick(View v) {
		Object tag = v.getTag();
		if (tag != null) {
			Platform platform = (Platform) tag;
			MainActivity.showShare(this, platform.getName(), false);
            Log.d("点击了按钮  实现具体的分享",platform.getName());
		}
	}
}
