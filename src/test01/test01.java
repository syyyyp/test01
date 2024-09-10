package test01;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class test01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. 드라이버 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		// 2. 계정연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 3. 쿼리 준비
		String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP ";
		PreparedStatement pstm = con.prepareStatement(sql);
		// 4.쿼리 실행 및 리턴
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			System.out.printf("%5d %11s %9s %5d %10s %8.2f %8.2f %2d \n", 
                    rs.getInt(1), rs.getString("ENAME"), rs.getString(3), rs.getInt("MGR"),
					rs.getDate(5), rs.getDouble("SAL"), rs.getDouble(7), rs.getInt("DEPTNO"));
		}
		
		// 5. db종료
		rs.close();
		pstm.close();
		con.close();
	}
	
}

