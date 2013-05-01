package testspring;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

public interface RuntimeRecordDAO {
   
   public void setDataSource(DataSource ds);
   public void addRecord(RuntimeRecord record);
   public RuntimeRecord getRecord(Integer id);
   public List<RuntimeRecord> listRuntimeRecords();
   public List<RuntimeRecord> listRuntimeRecordsByStartDate(String start);
   public List<RuntimeRecord> listRuntimeRecordsByEndDate(String start);
   public List<RuntimeRecord> listRuntimeRecordsByName(String className, String methodName);
   public List<RuntimeRecord> listRuntimeRecordsByClassName(String className);
   public List<RuntimeRecord> listRuntimeRecordsByMethodName(String methodName);
   public void delete(Integer id);
}