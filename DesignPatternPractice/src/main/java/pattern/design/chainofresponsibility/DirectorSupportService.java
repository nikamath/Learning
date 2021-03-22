package pattern.design.chainofresponsibility;

public class DirectorSupportService implements ISupportService {

    private ISupportService serviceHandler;

    public DirectorSupportService(ISupportService serviceHandler) {
        this.serviceHandler = serviceHandler;
    }

@Override
    public void resolveRequest(ServiceRequest serviceRequest){
        if(serviceRequest.getLevel() == ServiceLevel.LEVEL_FOUR)
            serviceRequest.setResolution("Request resolved at level 4!!");
        else if(serviceHandler != null)
            serviceHandler.resolveRequest(serviceRequest);
        else
            serviceRequest.setResolution("Your Request Cannot be handled!!");
    }
}