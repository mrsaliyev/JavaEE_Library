package kz.iitu.DAO;

import kz.iitu.BEAN.LibrarianBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LibrarianDao {

    public static int save(LibrarianBean bean){
        System.out.println("Creating User");
        int status = 0;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("insert into users(id,name, surname, email, password) values(5,?,?,?,?)");
            ps.setString(1,bean.getName());
            ps.setString(2,bean.getSurname());
            ps.setString(3,bean.getEmail());
            ps.setString(4,bean.getPassword());

            status = ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }
    public static int update(LibrarianBean bean){
        int status = 0;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps=con.prepareStatement("update users set name=?, surname=?,email=?,password=? where id=?");
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
            PreparedStatement ps = con.prepareStatement("select * from users");
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
            PreparedStatement ps=con.prepareStatement("select * from users where id=?");
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
            PreparedStatement ps=con.prepareStatement("delete from users where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public static LibrarianBean authenticate(String email, String password){
        LibrarianBean librarianBean = null;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from users where email=? and password=?");
            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                librarianBean = new LibrarianBean();
                librarianBean.setEmail(rs.getString("email"));
                librarianBean.setPassword(password);
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return librarianBean;
    }
}

