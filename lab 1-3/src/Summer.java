public class Summer<T extends Number> {
    T[] arrNums;

    public Summer(T[] numP) {
        arrNums = numP;
    }

    public double sum() {
        double doubleWork = 0;
        for (int i = 0; i < arrNums.length; i++) {
            doubleWork += (double)arrNums[i];
        }
        return doubleWork;
    }
}
