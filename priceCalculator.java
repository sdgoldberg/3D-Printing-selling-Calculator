public class priceCalculator {
    double spoolPrice, spoolGrams, projectGrams, projectPrice,hours, minutes, totalTime;

    int roundOff;

    public priceCalculator(double sp, double spoolKilograms, double projectGrams, double hours, double minutes) {
        spoolPrice = sp;
        spoolGrams = spoolKilograms*1000;
        this.projectGrams= projectGrams;
        this.hours = hours;
        this.minutes = minutes/60;
        totalTime = hours + this.minutes;



        projectPrice = (((double)(spoolPrice/spoolGrams)*projectGrams) + (5*totalTime));

        roundOff = (int)Math.round(projectPrice*100.0);
    }
    public String toString() {
        return "Your price is: $" + String.format("%8.2f",(roundOff/100.0));
    }
    public static void main(String [] args) {
        priceCalculator price = new priceCalculator(30, 3, 258, 2, 45);
        System.out.println(price);
    }

}