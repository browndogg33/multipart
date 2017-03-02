package com.brandonscottbrown.response;

import java.util.Date;

public class MultipartResponse {
    private String status;
    private Date timestamp;

    public MultipartResponse(String status, Date timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
