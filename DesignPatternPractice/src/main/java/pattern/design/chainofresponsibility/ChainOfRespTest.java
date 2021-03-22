package pattern.design.chainofresponsibility;

public class ChainOfRespTest {

    public static void main(String[] args){
        ISupportService directorService = new DirectorSupportService(null);
        ISupportService managerService = new ManagerSupportService(directorService);
        ISupportService supervisorService = new SupervisorSupportService(managerService);
        ISupportService frontDeskService = new FrontDeskSupportService(supervisorService);
        ISupportService service = new SupportService(frontDeskService);

        ServiceRequest sr1 = new ServiceRequest();
        sr1.setLevel(ServiceLevel.LEVEL_ONE);
        service.resolveRequest(sr1);
        System.out.println("Resolution :" + sr1.getResolution());

        ServiceRequest sr2 = new ServiceRequest();
        sr2.setLevel(ServiceLevel.LEVEL_THREE);
        service.resolveRequest(sr2);
        System.out.println("Resolution :" + sr2.getResolution());

        ServiceRequest sr3 = new ServiceRequest();
        sr3.setLevel(ServiceLevel.INVALID_REQUEST);
        service.resolveRequest(sr3);
        System.out.println("Resolution :" + sr3.getResolution());
    }
}