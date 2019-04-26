package com.cogni.smart_shop.dao;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;
import com.cogni.smart_shop.bean.ProductBean;
import com.cogni.smart_shop.util.DBConnect;


public class ProductDaoImpl implements ProductDao{

	@Override
	public boolean addProduct(ProductBean pb) {
		Connection con=null;
		PreparedStatement ps=null;
		
		String pname=pb.getProduct_name();
		InputStream Product_Image = pb.getProduct_image();
		
		int item=pb.getNoi();
		Date dom=pb.getDom();
		java.sql.Date sqlDate = new java.sql.Date(dom.getTime());
		Date doe=pb.getDoe();
		java.sql.Date sqlDate1 = new java.sql.Date(doe.getTime());
		int price=pb.getPrice();
		String loc=pb.getLocation();
		float rating=pb.getRating();
		
		
		try {
			con=DBConnect.getConnection();
			String query="insert into product1(product_name,product_image,number_of_items,date_of_man,date_of_expiry,price,location,rating) values (?,?,?,?,?,?,?,?)";
			
			ps=con.prepareStatement(query);
			ps.setString(1, pname);
			 ps.setBinaryStream(2, Product_Image);
			ps.setInt(3, item);
			ps.setDate(4,sqlDate);
			ps.setDate(5, sqlDate1);
			ps.setInt(6, price);
			ps.setString(7, loc);
			ps.setFloat(8, rating);
			int i=ps.executeUpdate();
			if(i!=0)
				return true;
			else
				return false;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	
		
	}

	@Override
	public boolean deleteProduct(ProductBean pb,String name) {
		Connection con=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		//String pname=pb.getProduct_name();
	
		try {
			con=DBConnect.getConnection();
			String query="delete from product1 where product_name=?";
			
			ps=con.prepareStatement(query);
			ps.setString(1, name);
			
			int i=ps.executeUpdate();
			if(i!=0)
				return true;
			else
				return false;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateProduct(String name,int item) {
		
		
		
		Connection con=null;
		PreparedStatement ps=null;
		//ResultSet rs=null;
		String pname=name;
		
		int ite=item;

		
		try {
			con=DBConnect.getConnection();
			String query="update product1 set number_of_items=? where product_name=?";
			
			ps=con.prepareStatement(query);
			
			
			ps.setInt(1, ite);
			ps.setString(2, pname);
			
			int i=ps.executeUpdate();
			if(i!=0)
				return true;
			else
				return false;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<ProductBean> getAllProductBean() {
		Connection con=null;
		PreparedStatement ps=null;
		ArrayList<ProductBean> pa=new ArrayList<>();
		
		
		
		try {
			con=DBConnect.getConnection();
			String query="select * from product1";
			ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
		    ProductBean pb=new ProductBean();
		    String pname=rs.getString(1);
		    pb.setProduct_name(pname);
		    System.out.println(pname);
			//pb.setProduct_name(rs.getString("PRODUCT_NAME"));
			//System.out.println(rs.getString("PRODUCT_NAME")+rs.getInt("NUMBER_OF_ITEMS")+(java.util.Date)(rs.getDate("DATE_OF_MAN"))+(java.util.Date)(rs.getDate("DATE_OF_EXPIRY"))+rs.getInt("PRICE")+rs.getString("LOCATION")+rs.getFloat("RATING")+rs.getBlob("PRODUCT_IMAGE").getBinaryStream());
			pb.setProduct_image(rs.getBlob("PRODUCT_IMAGE").getBinaryStream());
			pb.setNoi(rs.getInt("NUMBER_OF_ITEMS"));
			//String fromDbDt=rs.getString(4);
			java.sql.Date fromDbDt=rs.getDate(4);  
			System.out.println(fromDbDt);       
			             long millTime=fromDbDt.getTime();
			             java.util.Date utilDate= new Date(millTime);
			             java.sql.Date fromDbEx=rs.getDate("DATE_OF_EXPIRY");  
			             long millTime1=fromDbEx.getTime();
			             java.util.Date utilDate1= new Date(millTime1);
		//	java.util.Date utilDate = new java.util.Date(rs.getDate("DATE_OF_MAN").getTime());
			//long d1=rs.getDate("DATE_OF_MAN").getTime();
			
			//long d2=rs.getDate("DATE_OF_EXPIRY").getTime();
			//Date d=new Date(d1);
			//Date d3=new Date(d2);
			//java.util.Date utilDate1 = new java.util.Date(rs.getDate("DATE_OF_EXPIRY").getTime());
			//System.out.println(utilDate + " "+ utilDate1);
        	pb.setDom(utilDate);
        	pb.setDoe(utilDate1);
        	pb.setPrice(rs.getInt("PRICE"));
        	pb.setLocation(rs.getString("LOCATION"));
        	pb.setRating(rs.getFloat("RATING"));
        	pa.add(pb);
        	
        }
			for(ProductBean pr:pa)
			{
				System.out.println(pr.getProduct_name()+pr.getPrice()+pr.getNoi()+pr.getLocation()+pr.getDom()+pr.getDoe()+pr.getRating());
			}
			
     return pa;
    
			
			}
			
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
		
		
		
		
		
		
	
		return null;
	}



	@Override
	public List<ProductBean> sortProducts(String query) {
		Connection con = null;
		PreparedStatement ps = null;
		List<ProductBean> productBeanList=new ArrayList<ProductBean>();
		String query2 = new String();
		if("name".equals(query))
			query2="select * from product1 order by PRODUCT_NAME";
		if("price".equals(query))
			query2="select * from product1 order by PRICE";
		if("availability".equals(query))
			query2="select * from product1 order by NUMBER_OF_ITEMS";
		if("popularity".equals(query))
			query2="select * from product1 order by RATING";
		try
		{
			con = DBConnect.getConnection();
			
			
			ps = con.prepareStatement(query2); 
			ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	ProductBean pb=new ProductBean();
    			pb.setProduct_name(rs.getString("PRODUCT_NAME"));
    			pb.setProduct_image(rs.getBlob("PRODUCT_IMAGE").getBinaryStream());
    			pb.setNoi(rs.getInt("NUMBER_OF_ITEMS"));
            	pb.setDom(rs.getDate("DATE_OF_MAN"));
            	pb.setDoe(rs.getDate("DATE_OF_EXPIRY"));
            	pb.setPrice(rs.getInt("PRICE"));
            	pb.setLocation(rs.getString("LOCATION"));
            	pb.setRating(rs.getFloat("RATING"));
            	productBeanList.add(pb);
            	
            }
         return productBeanList;
		}
     	
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    			
            }
		return null;
	}

	@Override
	public List<ProductBean> searchProducts(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		List<ProductBean> productBeanList=new ArrayList<ProductBean>();
		try
		{
			con = DBConnect.getConnection();
			
			String query = "select * from product1 where Product_Name=?";
			con.setAutoCommit(true);
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			 while(rs.next())
	            {
				 ProductBean pb=new ProductBean();
	    			pb.setProduct_name(rs.getString("PRODUCT_NAME"));
	    			pb.setProduct_image(rs.getBlob("PRODUCT_IMAGE").getBinaryStream());
	    			pb.setNoi(rs.getInt("NUMBER_OF_ITEMS"));
	            	pb.setDom(rs.getDate("DATE_OF_MAN"));
	            	pb.setDoe(rs.getDate("DATE_OF_EXPIRY"));
	            	pb.setPrice(rs.getInt("PRICE"));
	            	pb.setLocation(rs.getString("LOCATION"));
	            	pb.setRating(rs.getFloat("RATING"));
	            	productBeanList.add(pb);
	            	
	            }
	         return productBeanList;
			}
	     	
				
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    			
	            }
			return null;
	}

/*public static void main(String args[]){
	
	
    ProductDaoImpl pm	= new ProductDaoImpl();
	List<ProductBean> plist=pm.getAllProductBean();
	 for(ProductBean P:plist){
		 System.out.println(P.getProduct_name()+" "+P.getDom()+" "+P.getDoe());
	 }

*/
	//}
	


}
