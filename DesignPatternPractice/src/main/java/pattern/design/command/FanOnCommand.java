package pattern.design.command;

public class FanOnCommand implements ICommand{
private Fan fan;

    public FanOnCommand(Fan fan) {
        super();
        this.fan = fan;
    }

    @Override
    public void execute() {
fan.turnOn();
    }
}
