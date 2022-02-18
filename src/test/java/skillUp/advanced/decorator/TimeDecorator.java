package skillUp.advanced.decorator;

public class TimeDecorator implements Component {
    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    public String operation() {
        long startTime = System.currentTimeMillis();
        // 비지니스 로직 종료
        String ret = component.operation();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        return ret;
    }

}
