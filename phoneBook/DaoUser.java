/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneBook;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Phuc
 */
public class DaoUser {

    connector connector;
    ResultSet phone;
    public DaoUser() {
        connector = connector.getInstance();
    }

    public ArrayList<User> getUsers() {
        String sql = "SELECT * FROM user";

        try {
            ResultSet rs = connector.getQuery(sql);
            ArrayList<User> users = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Integer status = rs.getInt("status");

                User u = new User(id, username, email, password, status);

                users.add(u);
            }
            return users;
        } catch (Exception e) {
        }

        return null;
    }

    public void printUser() {
        ArrayList<User> Ex = this.getUsers();
        for (User eachUser : Ex) {
            String status1 = "";
            if ( eachUser.getStatus() == 1) {
                status1 = "enable";
            } else {
                status1 = "disable";
            }
            System.out.println("id: " + eachUser.getId() + "  username: " + eachUser.getUsername()
                    + "   email: " + eachUser.getEmail() + "   password: " + eachUser.getPassword() + "   status: " + status1);
        }
    }

    public boolean FindUserByName(String username) {
        String sql = "SELECT *  FROM  phonebook B  "
                + "INNER JOIN user A  ON B.user_id = A.id  " 
                + "WHERE A.username =  '"+username+ "';";
        try {
            this.phone = connector.getQuery(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
//     + "' OR email = '" + user.getEmail() + "'OR id = '"
//                + user.getId();
    public void getPhoneNumber(String name) throws SQLException{
        if(FindUserByName(name)){
            while(phone.next()){
                System.out.println("phone Number of " + name + "  is :"+ phone.getInt("telephone"));
            }
            
        }
    }

}
