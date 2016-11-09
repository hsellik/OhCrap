package controllers;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Taavi on 30.10.2016.
 */
@RestController
public class AccountController {
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public AccountController(DataSource dataSource2) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("admin");
        dataSource.setPassword("admin");
        dataSource.setDatabaseName("toilet_locations");
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @RequestMapping(value = "getUsers")
    public List<Account> getUsers() {
        return jdbcTemplate.query("select * from userdata", new AccountMapper());
    }

    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public void createUser(@RequestBody Account request) {
        HashMap hashMap = new HashMap();
        hashMap.put("username", request.getUsername());
        hashMap.put("password", request.getPassword());
        jdbcTemplate.update("insert into userdata (username, password) VALUES(:username, :password)", hashMap);
    }

    private static class AccountMapper implements RowMapper<Account> {
        public Account mapRow(ResultSet res, int rowNum) throws SQLException {
            Account account = new Account();
            account.setId(res.getInt("id"));
            account.setUsername(res.getString("username"));
            account.setPassword(res.getString("password"));
            return account;
        }

    }
}
