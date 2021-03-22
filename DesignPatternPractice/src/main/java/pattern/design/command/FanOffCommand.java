package pattern.design.command;

public class FanOffCommand implements ICommand{
    private Fan fan;

    public FanOffCommand(Fan fan) {
        super();
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }

}
