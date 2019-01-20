package org.example.fanqietime;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	//��ʼ����ر���
	private ImageButton start;
	private EditText workName;
	private ImageButton buttonLeft;
	private RelativeLayout rlayout1,rlayout2,rlayout3;
	private Button homeTab2,homeTab3,homeTab4;
	private TextView workTime1,workTime2,workTime3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ʼ����ť������
		createOnClickListener();
		start = (ImageButton) findViewById(R.id.work_start);
		start.setOnClickListener(listener);
		//��ʼ���������
		buttonLeft = (ImageButton) findViewById(R.id.top_button_left);
		buttonLeft.setOnClickListener(listener);

		rlayout1 = (RelativeLayout) findViewById(R.id.linearlayou_center_relative1);
		rlayout2 = (RelativeLayout) findViewById(R.id.linearlayou_center_relative2);
		rlayout3 = (RelativeLayout) findViewById(R.id.linearlayou_center_relative3);
		rlayout1.setOnClickListener(listener);
		rlayout2.setOnClickListener(listener);
		rlayout3.setOnClickListener(listener);

		homeTab2 = (Button) findViewById(R.id.home_tab2);
		homeTab3 = (Button) findViewById(R.id.home_tab3);
		homeTab4 = (Button) findViewById(R.id.home_tab4);
		homeTab2.setOnClickListener(listener);
		homeTab3.setOnClickListener(listener);
		homeTab4.setOnClickListener(listener);

		workName = (EditText) findViewById(R.id.work_name);
		workTime1 = (TextView) findViewById(R.id.work_time1);
		workTime2 = (TextView) findViewById(R.id.work_time2);
		workTime3 = (TextView) findViewById(R.id.work_time3);
		//��ʼ������
		workTime1.setText(AppApplication.getInstances().getWork().getWorklong() + "����");
		workTime2.setText(AppApplication.getInstances().getWork().getFoodlong() + "����");
		workTime3.setText(AppApplication.getInstances().getWork().getGamelong() + "����");
	}

	//��ť������
	private OnClickListener listener = null;
	//��ť�¼�����
	public void createOnClickListener(){
		listener = new OnClickListener() {
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Dispenser(view.getId());
			}
		};
	}

	//�¼��ַ�������
	public void  Dispenser(int id){
		if(id == R.id.work_start){
			startWork();
		}else if(id == R.id.top_button_left){
			toSettingActivity();
		}else if(id == R.id.linearlayou_center_relative1 || id == R.id.home_tab2 
				|| id == R.id.linearlayou_center_relative2 || id == R.id.home_tab3 
				|| id == R.id.linearlayou_center_relative3 || id == R.id.home_tab4){
			createAlertDialog();
		}
	}

	private AlertDialog alertDialog = null;
	@SuppressLint("InflateParams")
	public void createAlertDialog(){
		alertDialog = DialogDefault.createAlertDialog(MainActivity.this, 
				"���÷���ʱ��", R.layout.activity_main_dialog, 
				yeslistener, nolistener);
		SeekBar seekbar1 = (SeekBar) alertDialog.findViewById(R.id.seekbar1);
		SeekBar seekbar2 = (SeekBar) alertDialog.findViewById(R.id.seekbar2);
		SeekBar seekbar3 = (SeekBar) alertDialog.findViewById(R.id.seekbar3);
		seekbar1.setProgress(CommonUtil.SecondsToMinutes(AppApplication.getInstances().getWork().getWorklong()));
		seekbar2.setProgress(CommonUtil.SecondsToMinutes(AppApplication.getInstances().getWork().getFoodlong()));
		seekbar3.setProgress(CommonUtil.SecondsToMinutes(AppApplication.getInstances().getWork().getGamelong()));
	}

	final OnClickListener yeslistener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			SeekBar seekbar1 = (SeekBar) alertDialog.findViewById(R.id.seekbar1);
			SeekBar seekbar2 = (SeekBar) alertDialog.findViewById(R.id.seekbar2);
			SeekBar seekbar3 = (SeekBar) alertDialog.findViewById(R.id.seekbar3);

			int worklong = seekbar1.getProgress();
			int foodlong = seekbar2.getProgress();
			int gamelong = seekbar3.getProgress();

			AppApplication.getInstances().getWork().setFoodlong(CommonUtil.MinutesToSeconds(foodlong));
			AppApplication.getInstances().getWork().setGamelong(CommonUtil.MinutesToSeconds(gamelong));
			AppApplication.getInstances().getWork().setWorklong(CommonUtil.MinutesToSeconds(worklong));
			
			workTime1.setText(worklong + "����");
			workTime2.setText(foodlong + "����");
			workTime3.setText(gamelong + "����");
			alertDialog.cancel();
		}
	};

	final OnClickListener nolistener = new OnClickListener() {
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			alertDialog.cancel();
		}
	};

	//������ʼ������ť
	public void startWork(){
		String workname = workName.getText().toString().trim();
		if(workname != null && !"".equals(workname)){
			AppApplication.getInstances().getWork().setWorkname(workname);
		}
		//��ת����һ��Activity
		Intent intent = new Intent(MainActivity.this, SecordActivity.class);
		startActivity(intent);
		MainActivity.this.finish();
	}

	//��ת�����ý���
	public void toSettingActivity(){
		Intent intent = new Intent();
		startActivity(intent);
	}


}
