//отвечает за математические операции
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("знаменатель не может быть = 0");
            throw new IllegalArgumentException();
        } else if (denominator < 0) {
            this.numerator = -(numerator);
            this.denominator = -(denominator);
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    //строковое представление дроби
    public String toString() {
        return numerator + "/" + denominator;
    }

    //десятичное представление дроби
    public double toDouble() {
        return (double) numerator / (double) denominator;
    }

    //сложение
    public Fraction add(Fraction otherObj) {
        int num;
        int den;
        int del;
        if (this.getDenominator() == otherObj.getDenominator()) {
            num = this.getNumerator() + otherObj.getNumerator();
            den = this.getDenominator();

            del = Fraction.gcd(num, den);
            return Fraction.toLowestTerms(num, den, del);
        } else {
            num = (this.getNumerator() * otherObj.getDenominator()) + (this.getDenominator() * otherObj.getNumerator());
            den = this.getDenominator() * otherObj.getDenominator();
        }
        del = Fraction.gcd(num, den);
        return Fraction.toLowestTerms(num, den, del);
    }

    //вычитание
    public Fraction substruct(Fraction otherObj) {
        int num;
        int den;
        int del;
        if (this.getDenominator() == otherObj.getDenominator()) {
            num = this.getNumerator() - otherObj.getNumerator();
            den = this.getDenominator();

            del = Fraction.gcd(num, den);
            return Fraction.toLowestTerms(num, den, del);
        } else {
            num = (this.getNumerator() * otherObj.getDenominator()) - (this.getDenominator() * otherObj.getNumerator());
            den = this.getDenominator() * otherObj.getDenominator();
        }
        del = Fraction.gcd(num, den);
        return Fraction.toLowestTerms(num, den, del);
    }

    //умножение
    public Fraction multiply(Fraction otherObj) {
        int num = this.getNumerator() * otherObj.getNumerator();
        int den = this.getDenominator() * otherObj.getDenominator();
        int del = Fraction.gcd(num, den);
        return Fraction.toLowestTerms(num, den, del);

    }

    //деление
    public Fraction divide(Fraction otherObj) {
        int num = this.getNumerator() * otherObj.getDenominator();
        int den = this.getDenominator() * otherObj.getNumerator();
        int del = Fraction.gcd(num, den);
        return Fraction.toLowestTerms(num, den, del);
    }

    //сравнение
    public boolean equals(Object otherObj) {
        Fraction otherFraction = (Fraction) otherObj;
        if (otherObj instanceof Fraction)
            return (this.numerator * otherFraction.denominator == otherFraction.numerator * this.denominator);
        else
            return false;
    }

    //сокращает дробь на основе наибольшего общего делителя
    public static Fraction toLowestTerms(int num, int den, int gcd) {
        num /= gcd;
        den /= gcd;
        Fraction result = new Fraction(num, den);
        return result;
    }

    //находит наибольший общий делитель чисел
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}

