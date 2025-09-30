package service;

public class DepositBox {
    private Long boxId;
    private String boxDetails;
    private Customer customer; 
    public DepositBox(Long boxId, String boxDetails, Customer customer) {
        this.boxId = boxId;
        this.boxDetails = boxDetails;
        this.customer = customer;
    }

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    public String getBoxDetails() {
        return boxDetails;
    }

    public void setBoxDetails(String boxDetails) {
        this.boxDetails = boxDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "DepositBox{" +
                "boxId=" + boxId +
                ", boxDetails='" + boxDetails + '\'' +
                ", customer=" + customer +
                '}';
    }
}
