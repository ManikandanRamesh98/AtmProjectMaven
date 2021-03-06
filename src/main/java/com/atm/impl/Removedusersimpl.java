package com.atm.impl;

import java.sql.*;

import com.atm.connection.Connect;
import com.atm.dao.RemovedUsersDao;
import com.atm.models.RemovedUsersModel;


public class RemovedUsersImpl implements RemovedUsersDao {
	// Insert data into removed users:
	public int insremoveusers(RemovedUsersModel removedusersmodel) throws Exception {
		Connection con = Connect.getConnection();

//		String query = "insert into removedusers(user_acc_no,username,last_balance,mob_no,user_pin) values(?,?,?,?,?)";
//		String query1 = "commit";
//		PreparedStatement statement = con.prepareStatement(query);
//		statement.setLong(1, removedusersmodel.getUseraccno());
//		statement.setString(2, removedusersmodel.getUsername());
//		statement.setInt(3, removedusersmodel.getLastbalance());
//		statement.setLong(4, removedusersmodel.getMobno());
//		statement.setInt(5, removedusersmodel.getUserpin());
//		int i = statement.executeUpdate();
//		statement.executeUpdate(query1);
//		return i;
		String query = "{call bank.insertremovedusers(?,?,?,?,?,?)}";

		CallableStatement statement = con.prepareCall(query);
		statement.setLong(1, removedusersmodel.getUseraccno());
		statement.setString(2, removedusersmodel.getUsername());
		statement.setInt(3, removedusersmodel.getLastbalance());
		statement.setLong(4, removedusersmodel.getMobno());
		statement.setInt(5, removedusersmodel.getUserpin());
		statement.registerOutParameter(6, Types.INTEGER);
		statement.execute();
		int res = statement.getInt(6);
		return res;
	}

//fetch user:

	public ResultSet fetchremoveusers() throws Exception {
		Connection con = Connect.getConnection();

		String query = "select * from removedusers";
		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}
}
