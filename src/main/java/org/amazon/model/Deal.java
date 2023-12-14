package org.amazon.model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Deal extends BaseModel{

    private Long id;
    private Date startTime;
    private Date endTime;
    private int itemCount;

    private Long productId;

    private  long price;

    AtomicLong atomicLong = new AtomicLong();

    public Deal(Date startTime, Date endTime, int itemCount, Long productId, long price) {
        super();
        this.id = atomicLong.getAndIncrement();
        this.startTime = startTime;
        this.endTime = endTime;
        this.itemCount = itemCount;
        this.productId = productId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", itemCount=" + itemCount +
                ", productId=" + productId +
                ", price=" + price +
                '}';
    }
}
