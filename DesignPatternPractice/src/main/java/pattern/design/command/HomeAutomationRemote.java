package pattern.design.command;

public class HomeAutomationRemote {
    private ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
