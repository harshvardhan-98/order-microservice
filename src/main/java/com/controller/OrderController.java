package com.controller;
import com.dao.OrderRepo;
import com.model.OrderModel;
import com.orderException.orderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

    /**
     * Get all the orders
     * @return the product
     */
    @GetMapping(value = "/All")
    public List<OrderModel> getOrder(){
        return orderRepo.findAll();
    }

    /**
     * Create New Order
     * @param orderModel the order Model
     * @return the String
     */
    @PostMapping(value="/create")
    public OrderModel createOrder(@RequestBody OrderModel orderModel){
        return orderRepo.save(orderModel);
    }

    /**
     * find by id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public OrderModel viewOrders(@PathVariable Long id){
        OrderModel orderModel=orderRepo.findById(id).orElseThrow(() -> new orderNotFoundException("ID Not Found" + " " + id));
        return orderModel;
    }

    /**
     * Delete specific ID order
     * @param id
     * @return confirmation message
     */
    @DeleteMapping("/delete/{id}")
    String deleteProduct(@PathVariable Long id){
        try{
            orderRepo.deleteById(id);
        } catch (Exception e){
            throw new orderNotFoundException("ID Not Found" + " " + id);
        }
        return "ID Successfully Deleted";
    }

    @GetMapping("/getProducts")
    public List<OrderModel> getProducts()
    {
        List productModelList= (List) this.restTemplate.getForObject("http://product-service/product/All",List.class);
        return productModelList;
    }
}
