import java.util.Scanner;

public class FractionCalculator {
    //запрашивает операцию
    public static String getOperation(Scanner input) {
        String chooseOperation = "";
        boolean correct = false;
        System.out.print("Введите операцию (+, -, *, /, = или Q для выхода): ");
        while (!correct) {
            chooseOperation = input.nextLine();
            switch (chooseOperation) {
                case "+":
                    correct = true;
                    break;
                case "-":
                    correct = true;
                    break;
                case "*":
                    correct = true;
                    break;
                case "/":
                    correct = true;
                    break;
                case "=":
                    correct = true;
                    break;
                case "Q":
                    correct = true;
                    break;
                case "q":
                    correct = true;
                    break;
                default:
                    System.out.print("Неправилное значение,введите (+, -, *, /, = или Q для выхода): ");
                    break;
            }
        }
        System.out.println(chooseOperation);
        return chooseOperation;
    }

    //создаёт дробь
    public static Fraction getFraction(String fract) {
        String fraction = fract;
        String numS;
        String denS;
        int numer;
        int denom;
        if (fraction.contains("/")) {
            int indx = fraction.indexOf("/");

            if (fraction.charAt(0) == '-') {
                fraction = fraction.substring(1, fraction.length());
                indx = fraction.indexOf("/");
                numS = fraction.substring(0, indx);
                denS = fraction.substring(indx + 1, fraction.length());

                numer = (Integer.parseInt(numS)) * (-1);
                denom = Integer.parseInt(denS);
                Fraction result = new Fraction(numer, denom);
                return result;
            } else {
                indx = fraction.indexOf("/");
                numS = fraction.substring(0, indx);
                denS = fraction.substring(indx + 1, fraction.length());

                numer = Integer.parseInt(numS);
                denom = Integer.parseInt(denS);
                Fraction result = new Fraction(numer, denom);
                return result;
            }
        } else {
            if (fraction.charAt(0) == '-') {
                fraction = fraction.substring(1, fraction.length());

                numer = (Integer.parseInt(fraction)) * (-1);
                Fraction result = new Fraction(numer);
                return result;
            } else {
                numer = Integer.parseInt(fraction);
                Fraction result = new Fraction(numer);
                return result;
            }
        }
    }

    //Проверяет правильная ли дробь(можно ли будет её из строки перевести в числа)
    public static boolean validFraction(String input) {
        String fraction = input;
        String numS;
        String denS;
        int numer;
        int denom;
        if (fraction.contains("/")) {
            int indx = fraction.indexOf("/");

            if (fraction.charAt(0) == '-') {
                fraction = fraction.substring(1, fraction.length());
                indx = fraction.indexOf("/");
                numS = fraction.substring(0, indx);
                denS = fraction.substring(indx + 1, fraction.length());

                if (denS.equals("0")) {
                    return false;
                } else if (denS.charAt(0) == '-') {
                    return false;
                } else {
                    try {
                        numer = Integer.parseInt(numS);
                        denom = Integer.parseInt(denS);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }

            } else {
                indx = fraction.indexOf("/");
                numS = fraction.substring(0, indx);
                denS = fraction.substring(indx + 1, fraction.length());

                if (denS.equals("0")) {
                    return false;
                } else if (denS.charAt(0) == '-') {
                    return false;
                } else {
                    try {
                        numer = Integer.parseInt(numS);
                        denom = Integer.parseInt(denS);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
        } else {

            if (fraction.charAt(0) == '-') {
                fraction = fraction.substring(1, fraction.length());

                try {
                    numer = Integer.parseInt(fraction);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            } else {

                try {
                    numer = Integer.parseInt(fraction);
                    return true;
                } catch (Exception e) {
                    return false;
                }

            }
        }
    }

    //выполняет математическую операцию
    public static Fraction doMath(Fraction obj1, Fraction obj2, String operation) {
        Fraction result = null;
        switch (operation) {
            case "+":
                result = obj1.add(obj2);
                break;
            case "-":
                result = obj1.substruct(obj2);
                break;
            case "*":
                result = obj1.multiply(obj2);
                break;
            case "/":
                result = obj1.divide(obj2);
                break;
            default:
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String operation = "";
        String valFraction = "";
        Fraction aFract1 = null;
        Fraction aFract2 = null;
        Fraction result = null;
        boolean equals;

        while (true) {
            operation = getOperation(inp);
            if (operation.equalsIgnoreCase("Q")) {
                break;
            }
            System.out.print("Введите дробь (a/b) или целое число (a), b не может быть = 0 или -b : ");
            while (true) {
                valFraction = inp.nextLine();
                if (!validFraction(valFraction)) {
                    System.out.print("Некорректная дробь. Введите дробь (a/b) или целое число (a),b не может быть = 0 или -b : ");
                } else {
                    aFract1 = getFraction(valFraction);
                    break;
                }
            }
            System.out.print("Введите дробь (a/b) или целое число (a), b не может быть = 0 или -b : ");
            while (true) {
                valFraction = inp.nextLine();
                if (!validFraction(valFraction)) {
                    System.out.print("Некорректная дробь. Введите дробь (a/b) или целое число (a),b не может быть = 0 или -b : ");
                } else {
                    aFract2 = getFraction(valFraction);
                    break;
                }
            }
            if (operation.equals("=")) {
                equals = aFract1.equals(aFract2);
                System.out.println(aFract1.toString() + "=" + aFract2.toString() + " is " + equals);
            } else {
                result = doMath(aFract1, aFract2, operation);
                System.out.println(aFract1.toString() + operation + aFract2.toString() + "=" + result.toString());
            }
        }
    }
}