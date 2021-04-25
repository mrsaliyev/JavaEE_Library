package kz.iitu.DAO;

import kz.iitu.BEAN.BookBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public static boolean save(BookBean bean){
        boolean status = false;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?)");
            ps.setString(1,bean.getTitle());
            ps.setString(2,bean.getGenre());
            ps.setString(3,bean.getPublisher());
            ps.setString(4,bean.getAuthor());
            ps.executeUpdate();
            status = true;
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }
    public static int update(BookBean bean){
        int status = 0;
        try{
            Connection con = DB.getCon();
            PreparedStatement ps=con.prepareStatement("update 'book' set title=?, genre=?,publisher=?,author=? where id=?");
            ps.setString(1,bean.getTitle());
            ps.setString(2,bean.getGenre());
            ps.setString(3,bean.getPublisher());
            ps.setString(4,bean.getAuthor());
            ps.setInt(5,bean.getId());
            status = ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }

    public static List<BookBean> view(){
        List<BookBean> list = new ArrayList<BookBean>();
        try{
            Connection con = DB.getCon();
            PreparedStatement ps = con.prepareStatement("select * from 'book'");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BookBean bean = new BookBean();
                bean.setId(rs.getInt("id"));
                bean.setTitle(rs.getString("title"));
                bean.setGenre(rs.getString("genre"));
                bean.setPublisher(rs.getString("publisher"));
                bean.setAuthor(rs.getString("author"));
                list.add(bean);
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return list;
    }
    public static BookBean viewById(int id){
        BookBean bean = new BookBean();
        try{
            Connection con=DB.getCon();
            PreparedStatement ps=con.prepareStatement("select * from book where id=?");
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                bean.setId(rs.getInt(1));
                bean.setTitle(rs.getString(2));
                bean.setGenre(rs.getString(3));
                bean.setPublisher(rs.getString(4));
                bean.setAuthor(rs.getString(5));
            }
            con.close();

        }catch(Exception e){System.out.println(e);}

        return bean;
    }
    public static int delete(int id){
        int status=0;
        try{
            Connection con=DB.getCon();
            PreparedStatement ps=con.prepareStatement("delete from book where id=?");
            ps.setInt(1,id);
            status=ps.executeUpdate();
            con.close();

        }catch(Exception e){System.out.println(e);}

        return status;
    }
}
