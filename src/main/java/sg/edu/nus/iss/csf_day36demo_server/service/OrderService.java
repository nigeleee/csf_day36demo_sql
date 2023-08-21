package sg.edu.nus.iss.csf_day36demo_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.csf_day36demo_server.model.LineItem;
import sg.edu.nus.iss.csf_day36demo_server.model.Order;
import sg.edu.nus.iss.csf_day36demo_server.repository.LineItemRepo;
import sg.edu.nus.iss.csf_day36demo_server.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private LineItemRepo lineItemsRepo;

    @Transactional(rollbackFor = OrderException.class)
    public String insertNewOrder(Order order) throws OrderException {

        String orderId = orderRepo.createOrder(order);

        try {
            if (order.getLineItems().isEmpty()) {
                throw new OrderException("No line items");
            }

            for (LineItem li : order.getLineItems()) {
                lineItemsRepo.createLineItem(li, orderId);
            }

        } catch (DataAccessException e) {
            throw new OrderException(e.getMessage());
        }

        return orderId;
    }

}
