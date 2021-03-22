package pattern.design.chainofresponsibility;

public class FrontDeskSupportService implements ISupportService {

    private ISupportService serviceHandler;

    public FrontDeskSupportService(ISupportService serviceHandler) {
        this.serviceHandler = serviceHandler;
    }


    public void resolveRequest(ServiceRequest serviceRequest){
        if(serviceRequest.getLevel() == ServiceLevel.LEVEL_ONE)
            serviceRequest.setResolution("Request resolved at level 1!!");
        else if(serviceHandler != null)
            serviceHandler.resolveRequest(serviceRequest);
        else
            throw new IllegalArgumentException("Invalid Request!!");
    }
}