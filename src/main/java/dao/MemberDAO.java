package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnection;
import dto.MemberDTO;

public class MemberDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<MemberDTO> getMemberList() {
        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        String debugMethod = new Object() {}.getClass().getEnclosingMethod().getName();

        String query = "SELECT id, name, area, age \r\n"+
        "FROM h02_member \r\n"+
        "ORDER BY id DESC";
        runQuery(query, debugMethod, 0);
        try{
            while(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String area = rs.getString("area");
                int age = rs.getInt("age");

                list.add(new MemberDTO(id, name, area, age));
            }
        } catch(SQLException e) {
            errAtResultSet(debugMethod);
        } finally {
            DBConnection.closeDB(con, ps, rs);
        }


        return list;
    }

    private int runQuery(String query, String debugMethod, int type) {
        int result = 0;

        try{
            con = DBConnection.getConnection();
            ps = con.prepareStatement(query);
            switch(type){
                case 0: rs = ps.executeQuery(); result+=1; break;
                case 1: result = ps.executeUpdate(); break;
            }
        } catch(SQLException e) {
            System.out.println("\r\n--------------------------");
            System.out.println(debugMethod+"메소드에서 오류가 발생했습니다.");
            System.out.println("--------------------------\r\n");
        }

        return result;
    }

    private String errAtResultSet(String debugMethod) {
        return debugMethod+" 메소드에서 ResultSet에서 오류가 발생했습니다.";
    }
}
