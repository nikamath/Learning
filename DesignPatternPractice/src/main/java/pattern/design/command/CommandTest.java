package pattern.design.command;

public class CommandTest {

    public static void main(String[] args){

        Fan fan = new Fan();
        Light light = new Light();
       // ICommand fanOn = new FanOnCommand(fan);
       // ICommand fanOff  = new FanOffCommand(fan);
        //ICommand lightOn = new LightOnCommand(light);
        ICommand lightOff = new LightOffCommand(light);

        HomeAutomationRemote remote = new HomeAutomationRemote();
        remote.setCommand(fan::turnOn); //using method reference - equivalent of FanOnCommand
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
