import java.util.Random;

public class U901Main <T extends Number> {
    T[] arrNums;

    public U901Main(T[] numP) {
        arrNums = numP;
    }

    public double sum() {
        double doubleWork = 0;
        for (int i = 0; i < arrNums.length; i++) {
            doubleWork += arrNums[i].doubleValue();
        }
        return doubleWork;
    }

    public static void main(String[] args) {
        Integer[] intArr = new Integer[]{10, 20, 15};
        Float[] floatArr = new Float[15];
        Random random = new Random();
        for (int i = 0; i < floatArr.length; i++) {
            floatArr[i] = random.nextFloat();
        }
        U901Main<Integer> insWorkArrayInt = new U901Main<>(intArr);
        U901Main<Float> insWorkArrayFloat = new U901Main<>(floatArr);
        System.out.println(insWorkArrayFloat.sum());
        System.out.println(insWorkArrayInt.sum());
    }
}
