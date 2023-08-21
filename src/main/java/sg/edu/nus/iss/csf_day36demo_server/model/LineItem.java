package sg.edu.nus.iss.csf_day36demo_server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LineItem {
    // private Integer item_id; ----> since auto incremented dont need to provide it
    private String orderId;
    private String name;
    private Integer quantity;
    private Integer unitPrice;
}
