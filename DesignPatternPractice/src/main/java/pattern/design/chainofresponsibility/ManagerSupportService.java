package pattern.design.chainofresponsibility;

public class ManagerSupportService implements ISupportService {

    private ISupportService serviceHandler;

    public ManagerSupportService(ISupportService serviceHandler) {
        this.serviceHandler = serviceHandler;
    }


    public void resolveRequest(ServiceRequest serviceRequest){
        if(serviceRequest.getLevel() == ServiceLevel.LEVEL_THREE)
            serviceRequest.setResolution("Request resolved at level 3!!");
        else if(serviceHandler != null)
            serviceHandler.resolveRequest(serviceRequest);
        else
           throw new IllegalArgumentException("Invalid Request!!");
    }
}