package testspring;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class MeasureTime {

	@Autowired
	private StoreRecord store;

	public void recordStartTime() {
		System.out.println("Record Start Time!");
	}

	public void recordRuntime(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("Before Method");
			long start = System.currentTimeMillis();

			joinpoint.proceed();

			long end = System.currentTimeMillis();
			System.out.println("After Method");
			System.out.println("The performance took " + (end - start)
					+ " milliseconds.");
			// create RunTimeRecord
			DateFormat formatter = new SimpleDateFormat(
					"yyy/MM/dd hh:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(start);
			String startTime = formatter.format(calendar.getTime());
			calendar.setTimeInMillis(end);
			String endTime = formatter.format(calendar.getTime());
			// create RunTimeRecord
			RuntimeRecord record = new RuntimeRecord(startTime, endTime,
					joinpoint.getTarget().getClass().getName(), joinpoint
							.getSignature().getName(), (end-start));
			// SerializeObject serialize = new JSONSerialization();
			System.out.println(record);
			store.doStore(record);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
