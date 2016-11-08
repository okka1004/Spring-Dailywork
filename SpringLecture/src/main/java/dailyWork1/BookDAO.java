package dailyWork1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

	public class BookDAO {
		
		public ArrayList<BookEntity> selectAll(String keyword) {
				
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			ResultSet rs2=null;
			ArrayList<BookEntity> list=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				String url="jdbc:mysql://localhost:3306/library";
				String id="jQuery";
				String pw="jQuery";
				con=DriverManager.getConnection(url, id, pw);
				System.out.println(keyword);
				String sql="select bisbn, btitle, bauthor, bprice "
						+ "from book "
						+ "where btitle like ? ";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, "%"+keyword+"%");
				
				rs=pstmt.executeQuery();
				
				list=new ArrayList<BookEntity>();
				//System.out.println("들어와?");
				while(rs.next()){
					
					BookEntity entity=new BookEntity();
					entity.setBisbn(rs.getString("bisbn"));
					entity.setBtitle(rs.getString("btitle"));
					entity.setBauthor(rs.getString("bauthor"));
					entity.setBprice(rs.getString("bprice"));
					
					
					String sql2="select c.ctext "
								+"from book b "
								+"inner join book_comment c "
								+"where b.bisbn=c.bisbn "
								+"AND b.btitle =?";

					
					pstmt = con.prepareStatement(sql2);
					pstmt.setString(1, rs.getString("btitle"));
					
					rs2=pstmt.executeQuery();
					
					ArrayList commentList=new ArrayList();
					while(rs2.next()){
						commentList.add(rs2.getString("c.ctext"));

					}
					
					System.out.println("comment"+commentList);
					
					entity.setCtext(commentList);

					list.add(entity);
					
				}
				
				
				
				
			} catch (Exception e) {
				System.out.println(e);
			}finally{
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			return list;
		}

	

}
