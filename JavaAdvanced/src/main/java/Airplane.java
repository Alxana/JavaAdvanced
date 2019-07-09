import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.Random;

@Log4j2
@Getter
public class Airplane {
    private boolean autoPilotOn = false;
    private AirplaneColor airplaneColor;

    public Airplane(AirplaneColor color){
        this.airplaneColor = color;
    }

    private void setAutoPilotOn(){
        autoPilotOn = true;
        log.info("Autopilot is on");
    }

    @Getter(AccessLevel.PROTECTED)
    private abstract class Position {
        private int position;

        protected void setPosition(int pos){
            if (pos>=1 && pos<=4){
                this.position = pos;
                log.info("Set position " + this.position);
            } else System.out.println("Position cannot be less than 1 or greater than 4. Got: " + pos);
        }

    }

    @Getter
    public class Ailerons extends Position {
        private AirplaneColor aileronColor = airplaneColor;
        public void changePosition(){
            if (getPosition() > 2){
                setPosition(getPosition() - 2);
            } else setPosition(getPosition() + 1);
            log.info("Position of Ailerons is changed to " + getPosition());
            setAutoPilotOn();
        }
    }

    @Getter
    public class Elevators extends Position{
        private AirplaneColor elevatorColor = airplaneColor;
        public void changePosition(){
            if (getPosition() < 2){
                setPosition(getPosition() + 2);
            } else setPosition(getPosition() - 1);
            log.info("Position of Elevators is changed to " + getPosition());
            setAutoPilotOn();
        }
    }

    public static class Engine<T extends Exception> {
        private boolean engineActivate = false;
        private T engineException;

        public Engine(T t){
            engineException = t;
        }

        @SneakyThrows
        public void engineOn() {
            if(new Random().nextInt(10) >= 7){
                log.error("Engine Exception!");
                throw engineException;
            }
            engineActivate = true;
            log.info("Engine is on");
        }

        @SneakyThrows
        public void engineOff() {
            if(new Random().nextInt(10) >= 7) {
                log.error("Engine Exception!");
                throw engineException;
            }
            engineActivate = false;
            log.info("Engine is off");
        }
    }
}
