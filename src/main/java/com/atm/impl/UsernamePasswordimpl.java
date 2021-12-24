package com.atm.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.atm.connection.Connect;
import com.atm.models.UsernamePasswordModel;

public class UsernamePasswordImpl implements com.atm.dao.UsernamePasswordDao {
	Scanner sc = new Scanner(System.in);

	// Get Role:
	public String getrole(UsernamePasswordModel usernamepasspojo) throws Exception {

		String role = null;
		Connection con = Connect.getConnection();

		String query = "select * from usernamepassword where username in ? and password in ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, usernamepasspojo.getUsername());
		st.setString(2, usernamepasspojo.getPassword());
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			role = rs.getString(5);

		}

		return role;
	}

	// get role1:
	public String getrole1(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "select role from usernamepassword where username in ?";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, usernamepasspojo.getUsername());
		ResultSet rs = st.executeQuery();
		rs.next();
		String res = rs.getString(1);
		return res;
	}

	// password change:
	public int pinchange(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "update usernamepassword set password = ? where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getPassword());
		statement.setString(2, usernamepasspojo.getUsername());
		int i = statement.executeUpdate();

		statement.executeUpdate(query1);
		return i;
	}

	// insert User name password:
	public int insusernamepass(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "insert into usernamepassword(username,password,role) values(?,?,?)";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getUsername());
		statement.setString(2, usernamepasspojo.getPassword());
		statement.setString(3, usernamepasspojo.getRole());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}

	// remove account:
	public int removeuser(UsernamePasswordModel usernamepasspojo) throws Exception {
		Connection con = Connect.getConnection();

		String query = "delete from usernamepassword where username in ?";
		String query1 = "commit";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, usernamepasspojo.getUsername());
		int i = statement.executeUpdate();
		statement.executeUpdate(query1);
		return i;
	}
}
