import java.io.NotActiveException;

public class Main {
    public static void main(String[] args) {
        Airplane myPlane = new Airplane(AirplaneColor.WHITE);
        System.out.println("My plane color is " + myPlane.getAirplaneColor());
        System.out.println("Is autopilot turned on for my plane? - " + myPlane.isAutoPilotOn());

        Airplane.Ailerons ailerons = myPlane.new Ailerons();
        System.out.println("Ailerons color is " + ailerons.getAileronColor());
        ailerons.setPosition(5);
        ailerons.setPosition(3);
        ailerons.changePosition();

        Airplane.Elevators elevators = myPlane.new Elevators();
        System.out.println("Elevators color is " + elevators.getElevatorColor());
        elevators.setPosition(0);
        elevators.setPosition(3);
        elevators.changePosition();

        System.out.println("Ailerons position: " + ailerons.getPosition());
        System.out.println("Elevators position: " + elevators.getPosition());
        System.out.println("Is autopilot turned on for my plane? - " + myPlane.isAutoPilotOn());

        System.out.println("My plane RGB color is " + myPlane.getAirplaneColor().getColorRGB());
        System.out.println("My plane color is faded by " + myPlane.getAirplaneColor().getFadePercent() + "%");
        myPlane.getAirplaneColor().fade();
        System.out.println("My plane color is faded by " + myPlane.getAirplaneColor().getFadePercent() + "%");

        System.out.println("Black color fade % is " + AirplaneColor.BLACK.getFadePercent());
        AirplaneColor.BLACK.fade();
        System.out.println("Black color fade % is now " + AirplaneColor.BLACK.getFadePercent());


        System.out.println("Is #00FF00 a valid rgb color? - " + AirplaneColor.validateRGB("#00FF00"));
        System.out.println("Is abc a valid rgb color? - " + AirplaneColor.validateRGB("abc"));

        Airplane.Engine<NotActiveException> engine = new Airplane.Engine<NotActiveException>(new NotActiveException("Engine is not active"));
        int i=0;
        while(++i < 5){
            engine.engineOn();
            engine.engineOff();
        }
    }
}
