package sg.edu.nus.iss.csf_day36demo_server.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.csf_day36demo_server.model.Order;

@Repository
public class OrderRepo {
    @Autowired
    private JdbcTemplate template;

    private static final String insertOrderSQL = "insert into orders (order_id, name, email, express) values (?,?,?,?)";
    
    public String createOrder(Order order) {
        // KeyHolder key = new GeneratedKeyHolder();
        
        String orderId = UUID.randomUUID().toString().substring(0,8);

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertOrderSQL, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, orderId);
                ps.setString(2, order.getName());
                ps.setString(3, order.getEmail());
                ps.setBoolean(4, order.getExpress());
                return ps;
            }
            
        };

        template.update(psc);
        return orderId;

    }

}
