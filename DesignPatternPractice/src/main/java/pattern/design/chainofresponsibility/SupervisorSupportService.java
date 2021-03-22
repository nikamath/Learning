package pattern.design.chainofresponsibility;

public class SupervisorSupportService implements ISupportService {

    private ISupportService serviceHandler;

    public SupervisorSupportService(ISupportService serviceHandler) {
        this.serviceHandler = serviceHandler;
    }


    public void resolveRequest(ServiceRequest serviceRequest){
        if(serviceRequest.getLevel() == ServiceLevel.LEVEL_TWO)
            serviceRequest.setResolution("Request resolved at level 2!!");
        else if(this.serviceHandler != null)
            this.serviceHandler.resolveRequest(serviceRequest);
        else
           throw new IllegalArgumentException("Invalid Request!!");
    }
}