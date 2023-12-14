package org.amazon.model;

import java.util.concurrent.atomic.AtomicLong;

public class UserDealMap {

    private Long id;
    private Long userId;
    private Long dealId;

    AtomicLong atomicLong = new AtomicLong();

    public UserDealMap(Long userId, Long dealId) {
        id = atomicLong.getAndIncrement();
        this.userId = userId;
        this.dealId = dealId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    @Override
    public String toString() {
        return "UserDealMap{" +
                "id=" + id +
                ", userId=" + userId +
                ", dealId=" + dealId +
                '}';
    }
}
