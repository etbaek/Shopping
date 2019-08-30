package com.lsis.shopping.orders;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="Orders")
public class Order implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private String itemName;
    private String price;
    private String receiverName;
    private String receiverAddress;
    private String receiverPhone;

    public Order() {
    }

    public Order(String customerId, String itemName, String price, String receiverName, String receiverAddress, String receiverPhone) {
        this.customerId = customerId;
        this.itemName = itemName;
        this.price = price;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.receiverPhone = receiverPhone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                customerId.equals(order.customerId) &&
                Objects.equals(itemName, order.itemName) &&
                Objects.equals(price, order.price) &&
                Objects.equals(receiverName, order.receiverName) &&
                Objects.equals(receiverAddress, order.receiverAddress) &&
                Objects.equals(receiverPhone, order.receiverPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, itemName, price, receiverName, receiverAddress, receiverPhone);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price='" + price + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                '}';
    }
}
