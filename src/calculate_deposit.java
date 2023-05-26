import java.util.Scanner;

public class DepositCalculator {
    double CalculateComplexPercent(double a, double y, int d) {
        double pay = a * Math.pow((1 + y / 12), 12 * d);
        return roundAmount(pay, 2);
    }

    double CalculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return roundAmount(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double roundAmount(double value, int places) {
        double Scale = Math.pow(10, places);
        return Math.round(value * Scale) / Scale;
    }

    void printResult() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double simplePercent = 0;
        if (action == 1) {
            simplePercent = CalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            simplePercent = CalculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + simplePercent);
    }

    public static void main(String[] args) {
        new DepositCalculator().printResult();
    }

}
