package pattern.design.chainofresponsibility;

public class SupportService implements ISupportService {

    private ISupportService serviceHandler;

    public SupportService(ISupportService serviceHandler) {
        this.serviceHandler = serviceHandler;
    }

    public void resolveRequest(ServiceRequest serviceRequest){
       serviceHandler.resolveRequest(serviceRequest);
    }
}