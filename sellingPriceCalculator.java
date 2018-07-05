public class sellingPriceCalculator {
    double spoolPrice, spoolGrams, projectGrams, projectPrice, hours,  minutes, totalTime, margin, sellingPrice;
    int roundOff;

    public sellingPriceCalculator(double sp, double spoolKilograms, double projectGrams, double hours, double minutes, double m) {
        spoolPrice = sp;
        spoolGrams = spoolKilograms*1000;
        this.projectGrams= projectGrams;
        this.hours = hours;
        this.minutes = minutes/60;
        totalTime = hours + this.minutes;
        margin = m;




        projectPrice = (((double)(spoolPrice/spoolGrams)*projectGrams) + (5*totalTime));
        sellingPrice = (((double)projectPrice)*(m/100)+ projectPrice);
        roundOff = (int)Math.round(sellingPrice*100.0);
    }
    public String toString() {
        return "Sell your product for $" + String.format("%8.2f",(roundOff/100.0));
    }
  /*  public static void main(String [] args) {
        sellingPriceCalculator price = new sellingPriceCalculator(30, 4, 2, 20);
        System.out.println(price);
    }
*/
}