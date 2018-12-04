package com.dao;

/**
 * The implementation class of DAO interface class
 */
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;*/
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.model.Flight;
import com.model.Login;
import com.model.Seat;
import com.model.SecurityQue;
import com.model.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * @return to the login page after particular user registered on website
	 */
	public int register(User u) {
		String query = "insert into gr14_passengers(gp_title,gp_fname,gp_lname,gp_email,gp_password,gp_phone) values('"
				+ u.getTitle() + "','" + u.getFname() + "','" + u.getLname() + "','" + u.getEmail() + "','"
				+ u.getPassword() + "','" + u.getPhone() + "')";
		return jdbcTemplate.update(query);
	}

	/**
	 * @param Username:username
	 *            of particular user and Password:password of particular user
	 * @return to the index page or adminlogin page
	 */
	public User validateUser(Login login) {
		String sql = "select * from gr14_passengers where gp_email='" + login.getEmail() + "' and gp_password='"
				+ login.getPassword() + "'";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		return users.size() > 0 ? users.get(0) : null;
	}

	/**
	 * @param flight
	 *            f:The particular flight data to update
	 */
	public int add(Flight flight) {

		String query = "insert into gr14_flights(gf_flightnumber,gf_source,gf_destination,gf_depart,gf_arrive,gf_duration,gf_price,gf_flydate) values('"
				+ flight.getFlightnumber() + "','" + flight.getSource() + "','" + flight.getDestination() + "','"
				+ flight.getDepart() + "','" + flight.getArrive() + "','" + flight.getDuration() + "','"
				+ flight.getPrice() + "'," + "TO_DATE('" + flight.getFlydate() + "','yyyy-mm-dd')" + ")";
		System.out.println("add=" + flight.getFlydate());
		return jdbcTemplate.update(query);
	}

	/**
	 * @return list:The list of all the flights added by admin
	 */
	public List<Flight> list() {

		String sql = "select * from gr14_flights";
		List<Flight> listFlight = jdbcTemplate.query(sql, new RowMapper<Flight>() {
			public Flight mapRow(ResultSet rs, int arg1) throws SQLException {
				Flight aFlight = new Flight();
				aFlight.setFlightnumber(rs.getString("gf_flightnumber"));
				aFlight.setSource(rs.getString("gf_source"));
				aFlight.setDestination(rs.getString("gf_destination"));
				aFlight.setDepart(rs.getString("gf_depart"));
				aFlight.setArrive(rs.getString("gf_arrive"));
				aFlight.setDuration(rs.getString("gf_duration"));
				aFlight.setPrice(rs.getString("gf_price"));
				aFlight.setFlydate(rs.getDate("gf_flydate"));
				return aFlight;
			}
		});
		return listFlight;
	}

	/**
	 * @return the flights details to user
	 */
	public List<Flight> searchFlight(Flight flight) {
		// DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		String sql = "select * from gr14_flights where gf_source='" + flight.getSource() + "' And gf_destination='"
				+ flight.getDestination() + "'and gf_flydate>=" + "TO_DATE('" + flight.getFlydate() + "','yyyy-mm-dd' "
				+ ")";
		/*
		 * String sql = "select * from gr14_flights where gf_source='" +
		 * flight.getSource() + "' And gf_destination='" + flight.getDestination() +
		 * "'and gf_flydate>="+"TO_CHAR('29-NOV-18')";
		 */
		//System.out.println("flight=" + flight.getFlydate() + "\t" + flight.getDestination());
		List<Flight> users = jdbcTemplate.query(sql, new FlightMapper());
		// System.out.println("flight: "+df.format(flight.getFlydate()));
		return users;
	}

	class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int arg1) throws SQLException {
			User user = new User();
			user.setFname(rs.getString("gp_fname"));
			user.setPassword(rs.getString("gp_password"));
			/*
			 * user.setFirstname(rs.getString("firstname"));
			 * user.setLastname(rs.getString("lastname"));
			 * user.setEmail(rs.getString("email"));
			 * user.setAddress(rs.getString("address")); user.setPhone(rs.getInt("phone"));
			 */
			return user;
		}
	}

	class FlightMapper implements RowMapper<Flight> {
		public Flight mapRow(ResultSet rs, int arg1) throws SQLException {
			Flight flight = new Flight();
			flight.setFlightnumber(rs.getString("gf_flightnumber"));
			flight.setSource(rs.getString("gf_source"));
			flight.setDestination(rs.getString("gf_destination"));
			flight.setDepart(rs.getString("gf_depart"));
			flight.setArrive(rs.getString("gf_arrive"));
			flight.setDuration(rs.getString("gf_duration"));
			flight.setPrice(rs.getString("gf_price"));
			flight.setFlydate(rs.getDate("gf_flydate"));
			return flight;
		}
	}

	public int verify(SecurityQue sq) {
		String sql="select count(*) from gr14_passengers where gp_fname= ? and gp_ans= ?";
		Integer count = this.jdbcTemplate.queryForObject(
                sql, new Object[] { sq.getUsername(),sq.getAns() }, Integer.class);
		/*String sql="select count(*) from gr14_passengers where gp_fname= '"+sq.getUsername() + "' and gp_ans= '"+sq.getAns() +"' "; 
		int count = getJdbcTemplate().queryForObject(sql, new Object[] { sq.getAns() }, Integer.class);*/
		 if(count>0)
		  return 1;
		 else
	     return 0;
	}
	public int book(String no,String flightnumber) {
		//System.out.println(no);
		
		List<String> items = Arrays.asList(no.split("\\s*,\\s*"));
		int j=0;
		for(int i=0;i<items.size();i++)
		{
			String query = "update gr14_seats set gs_status=1 where gf_flightnumber='"+flightnumber+"' AND gs_seatnumber='"+items.get(i)+"'";	
			j=jdbcTemplate.update(query);
		}
		return j;
		}

	public List<Seat> retri() {
		String query = "select * from gr14_seats where gs_status=1";
		List<Seat> al1 = jdbcTemplate.query(query, new RowMapper<Seat>() {
			public Seat mapRow(ResultSet rs, int arg1) throws SQLException {
				Seat seat=new Seat();
				/*while(rs.next())
				//flight.setFlightnumber(rs.getString("gf_flightnumber"));
				{*/
					seat.setChkbx(rs.getString("gs_seatnumber"));
				/*}*/
					return seat;
			}});
		System.out.println("data:"+al1);
		return al1;
	}
	/*class SeatMapper implements RowMapper<Seat> {
		public Seat mapRow(ResultSet rs, int arg1) throws SQLException {
			Seat seat=new Seat();
			while(rs.next())
			//flight.setFlightnumber(rs.getString("gf_flightnumber"));
			{
				seat.setChkbx(rs.getInt("gs_seatnumber"));
			}
				return seat;
		}
	}*/
}
