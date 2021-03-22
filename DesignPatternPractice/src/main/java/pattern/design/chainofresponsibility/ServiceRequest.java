package pattern.design.chainofresponsibility;

public class ServiceRequest {
    private ServiceLevel level;
    private String resolution;

    public ServiceLevel getLevel() {
        return level;
    }

    public void setLevel(ServiceLevel level) {
        this.level = level;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
}