public class Home_Makeover_Application {
    public static void main(String[] args)
    {
        String[] homeMakeOvers = {"Bathrooms", "Kitchens ", "Garden\t"};
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN"};
        int[] totals = new int[months.length];
        int[][] homeMakeOverAmounts = {{8, 2, 5},
                {7, 4, 5},
                {5, 5, 2},
                {2, 2, 3},
                {7, 7, 9},
                {7, 8, 5}};
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        System.out.println("HOME MAKEOVER REPORT");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        System.out.print("\t\t");

        for(int i = 0; i < homeMakeOvers.length; i++){
            System.out.print(homeMakeOvers[i] + "\t");
        }
        System.out.println();
        for(int x = 0; x < months.length; x++){
            int itemTotals = 0;
            System.out.println(months[x] + "\t");

            for(int y = 0; y < homeMakeOvers.length; y++){
                System.out.print("\t\t" + homeMakeOverAmounts[x][y] + "\t");
                itemTotals += homeMakeOverAmounts[x][y];
            }
            totals[x] = itemTotals;
            System.out.println();
        }
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        System.out.println("MONTHLY TOTALS");
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
        for(int x = 0; x < months.length; x++){
            String rating = "";
            if(totals[x] >= 15) {
                rating = "***";
            }
            System.out.println(months[x] + "\t\t" + totals[x] + "\t" + rating);
        }
        System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
    }
}