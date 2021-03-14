package kz.iitu.DAO;

import kz.iitu.BEAN.LibrarianBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LibrarianDao {

    public static boolean save(LibrarianBean bean){
        boolean status = false;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?)");
            ps.setInt(1,bean.getId());
            ps.setString(2,bean.getName());
            ps.setString(3,bean.getSurname());
            ps.setString(4,bean.getEmail());
            ps.setString(5,bean.getPassword());
            ps.executeUpdate();
            status = true;
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }
    public static int update(LibrarianBean bean){
        int status = 0;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps=con.prepareStatement("update 'user' set name=?, surname=?,email=?,password=? where id=?");
            ps.setString(1,bean.getName());
            ps.setString(2,bean.getSurname());
            ps.setString(3,bean.getEmail());
            ps.setString(4,bean.getPassword());
            ps.setInt(5,bean.getId());
            status = ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public static List<LibrarianBean> view(){
        List<LibrarianBean> list = new ArrayList<LibrarianBean>();
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from 'user'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LibrarianBean bean = new LibrarianBean();
                bean.setId(rs.getInt("id"));
                bean.setName(rs.getString("name"));
                bean.setSurname(rs.getString("surname"));
                bean.setEmail(rs.getString("email"));
                bean.setPassword(rs.getString("password"));
                list.add(bean);
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return list;
    }
    public static LibrarianBean viewById(int id){
        LibrarianBean bean = new LibrarianBean();
        try{
            Connection con=DB.getCon();
            PreparedStatement ps=con.prepareStatement("select * from user where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                bean.setId(rs.getInt(1));
                bean.setName(rs.getString(2));
                bean.setPassword(rs.getString(3));
                bean.setEmail(rs.getString(4));
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return bean;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection con=DB.getCon();
            PreparedStatement ps=con.prepareStatement("delete from user where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public static boolean authenticate(String email, String password){
        boolean status=false;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from user where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                status = true;
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }
}

