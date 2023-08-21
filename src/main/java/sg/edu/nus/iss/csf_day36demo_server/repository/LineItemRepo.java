package sg.edu.nus.iss.csf_day36demo_server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.csf_day36demo_server.model.LineItem;

@Repository
public class LineItemRepo {
    @Autowired
    private JdbcTemplate template; 

    private static final String insertLineItemSQL = "insert into lineitems(order_id, item_name, quantity, unit_price) values(?,?,?,?)";

    public void createLineItem(LineItem lineitem, String orderId) {
        
        template.update(
            insertLineItemSQL,
            orderId,
            lineitem.getName(),
            lineitem.getQuantity(),
            lineitem.getUnitPrice()
        );
    }

}
