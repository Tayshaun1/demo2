package com.example.tx.teststudy.text;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.tx.teststudy.R;

public class VerticalScrollTextActivity extends Activity {

	private String TAG=this.getClass().getSimpleName();

	VerticalScrollTextView mSampleView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vertocal);
//		mSampleView = (VerticalScrollTextView) findViewById(R.id.sampleView1);
//		List lst=new ArrayList<Sentence>();
//		for(int i=0;i<30;i++){
//			if(i%2==0){
//				Sentence sen=new Sentence(i,i+"、金球奖三甲揭晓 C罗梅西哈维入围 ");
//				lst.add(i, sen);
//			}else{
//				Sentence sen=new Sentence(i,i+"、公牛欲用三大主力换魔兽？？？？");
//				lst.add(i, sen);
//			}
//		}
//		//给View传递数据
//		mSampleView.setList(lst);
//		//更新View
//		mSampleView.updateUI();

		TextSwitchView tsv = (TextSwitchView) findViewById(R.id.tsv);
		String [] res={
				"静夜思",
				"床前明月光","疑是地上霜",
				"举头望明月",
				"低头思故乡"
		};
		tsv.setResources(res);
		tsv.setTextStillTime(3000);

		Intent i_getvalue = getIntent();
		String action = i_getvalue.getAction();

		if(Intent.ACTION_VIEW.equals(action)){
			Uri uri = i_getvalue.getData();
			if(uri != null){
				String name = uri.getQueryParameter("name");
				String age= uri.getQueryParameter("age");
				Log.e(TAG,name+"----"+age);
			}
		}
	}	
}