package mybatis.services;

import mybatis.mappers.UserMapper;
import mybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by tanerali on 24/07/2017.
 */
@Service
public class UserService {

    @Autowired
    UserMapper mapper;

//
//    private Connection connection = null;
//    private Statement statement = null;
//    private PreparedStatement preparedStatement = null;
//    private ResultSet resultSet = null;


    //get all users using mybatis
    public ArrayList<User> getAlls (){
        return mapper.getAlls();
    }

    //get user by id
    public User getById(int id){
        return mapper.getByID(id);
    }

    //add new user
    public User addNew(User u ) {
        mapper.insert(u);
        return mapper.getByName(u.getFirst_name());
    }

    //update  by its id
    public User updateById( User u) {
        mapper.update(u);
        return mapper.getByName(u.getFirst_name());
    }

    //delete
    public User deleteById(int id) {
        mapper.delete(id);
        return mapper.getByID(id);
    }



//    //get all users manually
//    public ArrayList<User> getAllsManually() {
//
//        //do everything necessary to get resutls from DB and turn them into objects
//        //in arraylist and return to controller
//
//        ArrayList<User> users = null;
//        try {
//
//            users = new ArrayList<>();
//
//            System.out.println("creating connection");
//
//            // This will load the MySQL driver, each DB has its own driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            // Setup the connection with the DB
//            connection = DriverManager.getConnection("jdbc:mysql://localhost/mybatis-test?" +
//                    "=root&password=CodingNomadsFoEva!&useSSL=false");
//
//            System.out.println("connection succeeded");
//
//
//            // Statements allow to issue SQL queries to the database
//            statement = connection.createStatement();
//
//            // execute query and assign it to resulSet
//            resultSet = statement.executeQuery("select * from users");
//
//            // iterates through the result set
//            while (resultSet.next()) {
//
//                 User u = new User();
//
//                // set the instance vars of the  pojo to the resultSet values
//                u.setId(resultSet.getInt("id"));
//                u.setFirst_name(resultSet.getString("first_name"));
//                u.setLast_name(resultSet.getString("last_name"));
//                u.setIsActive(resultSet.getInt("isActive"));
//
//                // adding the newly set pojo to the ArrayList
//                users.add(u);
//            }
//
//
//        } catch (ClassNotFoundException cnf) {
//            cnf.printStackTrace();
//        } catch (SQLException se) {
//            se.printStackTrace();
//        }
//
//        return users;
//    }

}
