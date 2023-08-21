package sg.edu.nus.iss.csf_day36demo_server.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private String order_id;
    private String name;
    private String email;
    private Boolean express;
    private List<LineItem> lineItems;
}
