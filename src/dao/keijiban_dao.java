package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.keijiban_bean;

public class keijiban_dao {
	private static final String url = "jdbc:mysql://localhost:3306/keijiban?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "Fuyuki1213";
	public static ArrayList<keijiban_bean> AllComment(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection(url, user, pw);
			String sql = "SELECT * FROM rireki";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<keijiban_bean> list = new ArrayList<keijiban_bean>();
			while( rs.next() ){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String comment = rs.getString("comment");
				String time = rs.getString("time");
				keijiban_bean result = new keijiban_bean(id,name,mail,comment,time);
				list.add(result);
			}
			return list;

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void insertComment(keijiban_bean s){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "INSERT INTO rireki(name,mail,comment,time) VALUES(?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setString(2, s.getMail());
			pstmt.setString(3, s.getComment());
			int result = pstmt.executeUpdate();
			System.out.println(result + "件登録されました。");
		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
	public static void deleteComment(String id){
		Connection con = null;
		PreparedStatement pstmt = null;

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pw);
			String sql = "DELETE FROM rireki WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			System.out.println(result + "件削除されました。");

		}  catch (SQLException e){
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("DBアクセスに失敗しました。");
			e.printStackTrace();
		} finally {
			try {
				if( pstmt != null){
					pstmt.close();
				}
			} catch(SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}

			try {
				if( con != null){
					con.close();
				}
			} catch (SQLException e){
				System.out.println("DB切断時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
}
