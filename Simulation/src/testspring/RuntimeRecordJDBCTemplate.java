package testspring;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class RuntimeRecordJDBCTemplate implements RuntimeRecordDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		// TODO Auto-generated method stub
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void addRecord(RuntimeRecord record) {
		// TODO Auto-generated method stub
		String SQL = "insert into runtime (startTime, endTime, duration, className, methodName) values (?, ?, ?, ?, ?)";

		System.out.println(jdbcTemplateObject.update(SQL,
				record.getStartTime(), record.getEndTime(),
				record.getDuration(), record.getClassName(),
				record.getMethodName()));

		System.out.println("Stored a Record");
	}

	@Override
	public RuntimeRecord getRecord(Integer id) {
		// TODO Auto-generated method stub
		String SQL = "select * from runtime where id = ?";
		RuntimeRecord record = jdbcTemplateObject.queryForObject(SQL,
				new Object[] { id }, new RuntimeRecordMapper());
		return record;
	}

	@Override
	public List<RuntimeRecord> listRuntimeRecords() {
		// TODO Auto-generated method stub
		String SQL = "select * from runtime";
		List<RuntimeRecord> records = jdbcTemplateObject.query(SQL,
				new RuntimeRecordMapper());
		return records;
	}

	public List<RuntimeRecord> listRuntimeRecordsByStartDate(String start) {
		String SQL = "select * from runtime where DATE(startTime)= ?";
		List<RuntimeRecord> records = jdbcTemplateObject.query(SQL,
				new String[] { start }, new RuntimeRecordMapper());
		return records;
	}

	public List<RuntimeRecord> listRuntimeRecordsByEndDate(String end) {
		String SQL = "select * from runtime where DATE(endTime)= ?";
		List<RuntimeRecord> records = jdbcTemplateObject.query(SQL,
				new String[] { end }, new RuntimeRecordMapper());
		return records;
	}

	public List<RuntimeRecord> listRuntimeRecordsByName(String className,
			String methodName) {
		String SQL = "select * from runtime where className= ? and methodName = ?";
		List<RuntimeRecord> records = jdbcTemplateObject.query(SQL,
				new String[] { className, methodName }, new RuntimeRecordMapper());
		return records;
	}

	public List<RuntimeRecord> listRuntimeRecordsByClassName(String className) {
		String SQL = "select * from runtime where className = ?";
		List<RuntimeRecord> records = jdbcTemplateObject.query(SQL,
				new String[] { className}, new RuntimeRecordMapper());
		return records;
	}

	public List<RuntimeRecord> listRuntimeRecordsByMethodName(String methodName) {
		String SQL = "select * from runtime where methodName = ?";
		List<RuntimeRecord> records = jdbcTemplateObject.query(SQL, new String[] {methodName},
				new RuntimeRecordMapper());
		return records;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
