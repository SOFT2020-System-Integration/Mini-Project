package miniproject.rest.exceptions;

import java.util.Date;

public class CustomError {
    private Date timeStamp;
    private String message;
    private String details;

    public CustomError(Date timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
