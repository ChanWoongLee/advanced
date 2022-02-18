package skillUp.advanced.decorator;

public class RealComponent implements Component {

    @Override
    public String operation() {
        return "data";
    }
}
