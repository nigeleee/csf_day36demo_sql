package sg.edu.nus.iss.csf_day36demo_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.csf_day36demo_server.model.Order;
import sg.edu.nus.iss.csf_day36demo_server.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        try {
            String orderId = orderService.insertNewOrder(order);
            return ResponseEntity.ok("Order created with ID: " + orderId);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Error creating order: " + ex.getMessage());
        }
    }

}    
