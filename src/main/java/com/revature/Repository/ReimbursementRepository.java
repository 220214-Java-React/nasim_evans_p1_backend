package com.revature.Repository;

import com.revature.Model.Enums.ReimbursementStatus;
import com.revature.Model.Enums.ReimbursementType;
import com.revature.Model.Reimbursement;
import com.revature.Tools.ConnectionFactory;
import com.revature.Tools.Log;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ReimbursementRepository {

    public void createReimbursement(Reimbursement reimb) {
        Connection connection;

        try {
            connection = ConnectionFactory.getConnection();

            String sqlString = "insert into ers_reimbursements(amount, submitted, description, receipt, author_id, status_id, type_id) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sqlString);

            statement.setDouble(1, reimb.getAmount());
            statement.setTimestamp(2, Timestamp.valueOf(reimb.getTimeSubmitted()));
            statement.setString(3, reimb.getDescription());
            statement.setBytes(4, reimb.getReceipt());
            statement.setInt(5, reimb.getUserId());
            statement.setInt(6, reimb.getStatus().ordinal());
            statement.setInt(7, reimb.getType().ordinal());

            statement.executeUpdate();

        }catch (SQLException e) {
            Log.setupLogger();
            Log.logMessage("warn", e.getMessage());
        }
    }

    public void deleteRequestById(int reimbursementId) {
        Connection connection;

        try {
            connection = ConnectionFactory.getConnection();

            String sqlString = "delete from ers_reimbursements where reimb_id = ?";
            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.setInt(1, reimbursementId);

            statement.executeUpdate();

        }catch (SQLException e) {
            Log.setupLogger();
            Log.logMessage("warn", e.getMessage());
        }
    }


    public ArrayList<Reimbursement> getAllByUserId (int userId) {
        Connection connection;
        ArrayList<Reimbursement> reimbList = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();

            String sqlString = "select * from ers_reimbursements where author_id = ? and status_id = '0'";

            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //int reimbursementId, double amount, Timestamp timeSubmitted, Timestamp timeResolved, String description, byte[] receipt, int userId, int managerId, ReimbursementStatus status, ReimbursementTypetype
                reimbList.add(new Reimbursement(resultSet.getInt("reimb_id"),
                        resultSet.getDouble("amount"),
                        String.valueOf(resultSet.getTimestamp("submitted")),
                        String.valueOf(resultSet.getTimestamp("resolved")),
                        resultSet.getString("description"),
                        resultSet.getBytes("receipt"),
                        resultSet.getInt("author_id"),
                        resultSet.getInt("resolver_id"),
                        ReimbursementStatus.values()[resultSet.getInt("status_id")],
                        ReimbursementType.values()[resultSet.getInt("type_id")]));
            }


        } catch (SQLException e) {
            Log.setupLogger();
            Log.logMessage("warn", e.getMessage());
        }

        return reimbList;
    }

    public ArrayList<Reimbursement> getAllHistoryByUserId (int userId) {
        Connection connection;
        ArrayList<Reimbursement> reimbList = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();

            String sqlString = "select * from ers_reimbursements where author_id = ? and (status_id = '1' or status_id = '2')";

            PreparedStatement statement = connection.prepareStatement(sqlString);
            statement.setInt(1, userId);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                //int reimbursementId, double amount, Timestamp timeSubmitted, Timestamp timeResolved, String description, byte[] receipt, int userId, int managerId, ReimbursementStatus status, ReimbursementTypetype
                reimbList.add(new Reimbursement(resultSet.getInt("reimb_id"),
                        resultSet.getDouble("amount"),
                        String.valueOf(resultSet.getTimestamp("submitted")),
                        String.valueOf(resultSet.getTimestamp("resolved")),
                        resultSet.getString("description"),
                        resultSet.getBytes("receipt"),
                        resultSet.getInt("author_id"),
                        resultSet.getInt("resolver_id"),
                        ReimbursementStatus.values()[resultSet.getInt("status_id")],
                        ReimbursementType.values()[resultSet.getInt("type_id")]));
            }
        } catch (SQLException e) {
            Log.setupLogger();
            Log.logMessage("warn", e.getMessage());
        }

        return reimbList;
    }




}
