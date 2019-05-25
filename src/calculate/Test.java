package calculate;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	public static void Test() {
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
		Date date = new Date();
		String date1 = myFmt.format(date);
		System.out.println(date1);
	}

	public static void main(String[] args) {
		 Test();
	}

}
