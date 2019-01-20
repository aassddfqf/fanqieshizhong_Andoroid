package org.example.fanqietime;

public class CommonUtil {

	public static String SecondsToTimeString(int seconds){		//将多少秒转化为mm:ss格式
		StringBuilder sb = new StringBuilder();
		if(seconds > 0){
			int minutes = seconds / 60;							//分钟位置除法运算可得
			seconds = seconds % 60;								//秒位置取模运算可得
			if(minutes < 10)
				sb.append("0");
			sb.append(minutes);
			sb.append(":");
			if(seconds < 10)
				sb.append("0");
			sb.append(seconds);
		}else 	sb.append("00:00");
		return sb.toString();
	}
	
	public static int MinutesToSeconds(int minutes){
		if(minutes > 0){
			int seconds = minutes * 60;				//一分钟等于60秒
			return seconds;
		}
		return 0;
	}
	
	public static int SecondsToMinutes(int seconds){
		if(seconds > 0){
			int minutes = seconds / 60;				//一分钟等于60秒
			return minutes;
		}
		return 0;
	}

}
