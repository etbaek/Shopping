package com.lsis.shopping.ordersapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class OrderClient {
    private String ordersUrl;
    private RestOperations restOperations;

    public OrderClient(String ordersUrl, RestOperations restOperations) {
        this.ordersUrl = ordersUrl;
        this.restOperations = restOperations;
    }

    public void addOrder(OrderInfo order) {
        restOperations.postForEntity(ordersUrl, order, OrderInfo.class);
    }

    public OrderInfo find(long id) {
        return restOperations.getForEntity(ordersUrl + "?id=" + id, OrderInfo.class).getBody();
    }

    public List<OrderInfo> getOrder() {
        ParameterizedTypeReference<List<OrderInfo>> orderListType = new ParameterizedTypeReference<List<OrderInfo>>() {
        };

        return restOperations.exchange(ordersUrl, GET, null, orderListType).getBody();
    }

    public List<OrderInfo> getOrderByCustomerId(String customerId) {
        ParameterizedTypeReference<List<OrderInfo>> orderListType = new ParameterizedTypeReference<List<OrderInfo>>() {
        };

        return restOperations.exchange(ordersUrl+"?customerId="+customerId, GET, null, orderListType).getBody();
    }
}