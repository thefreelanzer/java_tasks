package enums;

public enum HttpStatusCode {
    OK(200, "OK"),
    BADREQUEST(400, "Bad Request"),
    FORBIDDEN(403, "Forbidden"),
    INTERNALSERVERERROR(500, "Internal Server Error");

    private int code;
    private String description;

    HttpStatusCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    // Method to get type of day
    public static String getDescription(int code) {
        for (HttpStatusCode status : HttpStatusCode.values()) {
            if (status.code == code) {
                return status.description;
            }
        }
        return "Invalid code"; // If no match is found
    }
}
