package org.example.fanqietime;

public class CommonUtil {

	public static String SecondsToTimeString(int seconds){		//��������ת��Ϊmm:ss��ʽ
		StringBuilder sb = new StringBuilder();
		if(seconds > 0){
			int minutes = seconds / 60;							//����λ�ó�������ɵ�
			seconds = seconds % 60;								//��λ��ȡģ����ɵ�
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
			int seconds = minutes * 60;				//һ���ӵ���60��
			return seconds;
		}
		return 0;
	}
	
	public static int SecondsToMinutes(int seconds){
		if(seconds > 0){
			int minutes = seconds / 60;				//һ���ӵ���60��
			return minutes;
		}
		return 0;
	}

}
