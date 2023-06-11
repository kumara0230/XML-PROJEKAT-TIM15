package xml.a1.dto;

public class ReportResult {
    private int allRequestsCount;
    private int acceptedCount;
    private int deniedCount;

    public ReportResult() {
    }

    public ReportResult(int allRequest, int acc, int den) {
        this.allRequestsCount = allRequest;
        this.acceptedCount = acc;
        this.deniedCount = den;
    }

    public int getAllRequestsCount() {
        return allRequestsCount;
    }

    public void setAllRequestsCount(int allRequestsCount) {
        this.allRequestsCount = allRequestsCount;
    }

    public int getAcceptedCount() {
        return acceptedCount;
    }

    public void setAcceptedCount(int acceptedCount) {
        this.acceptedCount = acceptedCount;
    }

    public int getDeniedCount() {
        return deniedCount;
    }

    public void setDeniedCount(int deniedCount) {
        this.deniedCount = deniedCount;
    }
}
