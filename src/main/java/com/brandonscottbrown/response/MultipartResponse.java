package com.brandonscottbrown.response;

import org.joda.time.DateTime;

public class MultipartResponse {
    private String status;
    private DateTime timestamp;

    public MultipartResponse(String status, DateTime timestamp) {
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {
        this.timestamp = timestamp;
    }
}
