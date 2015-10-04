package com.dvd.rili;

import java.util.Calendar;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	private int mYear; 
	private int mMonth; 
	private int mDay;
	private int mWeek;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act);
        Calendar c = Calendar.getInstance(); 
        mYear = c.get(Calendar.YEAR); //获取当前年份 
        mMonth = c.get(Calendar.MONTH);//获取当前月份 
        mDay = c.get(Calendar.DAY_OF_MONTH);//获取当前月份的日期号码 
        mWeek = c.get(Calendar.DAY_OF_WEEK);//获取当前的星期 	
        long mTime=c.getTimeInMillis();
        
        TextView text1=(TextView)super.findViewById(R.id.yearmonth);
        TextView text2=(TextView)super.findViewById(R.id.date);
        TextView text3=(TextView)super.findViewById(R.id.week);
        TextView text4=(TextView)super.findViewById(R.id.nongli);
        TextView text5=(TextView)super.findViewById(R.id.shift1);
        TextView text6=(TextView)super.findViewById(R.id.shift2);
        TextView text7=(TextView)super.findViewById(R.id.shift3);
        TextView text8=(TextView)super.findViewById(R.id.shift4);

        String mmYear = Integer.toString(mYear);

        String[] mmMonths = {"一","二","三","四","五","六","七","八","九","十","十一","十二"};
        String mmMonth=mmMonths[mMonth];
                
        String mmDay = Integer.toString(mDay);

        String[] mmWeeks = {"日","一","二","三","四","五","六"};
        String mmWeek=mmWeeks[mWeek-1];
        
        text1.setText(mmYear+"年"+mmMonth+"月");
        text2.setText(mmDay);
        text3.setText("星期"+mmWeek);
        
        if(mWeek==1 || mWeek==7){
        	text1.setTextColor(0xFFFF0000);
        	text2.setTextColor(0xFFFF0000);
        	text3.setTextColor(0xFFFF0000);
        	
        }
        
        String[] sDetail = {"第一天白班","第二天白班","第一天夜班","第二天夜班","第一天休息","第二天休息","第三天休息","第四天休息"};
        int[] sColor={0xFF0000FF,0xFF0000FF,0xFF000000,0xFF000000,0xFFFF0000,0xFFFF0000,0xFFFF0000,0xFFFF0000};
        int tmp= (int) (mTime/(1000*60*60*24)%8)+7;
     //   text4.setText(mTime/(1000*60*60*24)%8+"---"+tmp+"--"+mWeek);
        text4.setText("");
                
        text5.setText("一班:"+sDetail[tmp%8]);      //一班
        text5.setTextColor(sColor[(tmp%8)]);  // 0x是代表颜色整数的标  FF是表示透明度，0000FF表示颜色
        
        text6.setText("二班:"+sDetail[(tmp+6)%8]);  //2
        text6.setTextColor(sColor[(tmp+6)%8]); 
        
        text7.setText("三班:"+sDetail[(tmp+4)%8]);  //3
        text7.setTextColor(sColor[(tmp+4)%8]); 
        
        text8.setText("四班:"+sDetail[(tmp+2)%8]);  //4
        text8.setTextColor(sColor[(tmp+2)%8]); 
       

        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
