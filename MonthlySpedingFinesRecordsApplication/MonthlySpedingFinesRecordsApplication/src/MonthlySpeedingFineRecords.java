public class MonthlySpeedingFineRecords {
    private static int highestSpeed = 0;
    private static int lowestSpeed = 0;

    public static void main(String[] args)
    {

        String[] strTowns = {"JHB\t", "DBN\t", "CTN\t", "PE\t"};
        int[][] speed = {{128, 135, 139},
                {155, 129, 175},
                {129, 130, 185},
                {195, 155, 221}};
        System.out.println("*************************************************************");
        System.out.println("SPEEDING FINES REPORT");
        System.out.println("*************************************************************");
        System.out.println("\t\t\t JAN\t\t FEB\t\t MAR");
        SetDefaults(speed[0][0]);
        for(int x = 0; x < 4; x++)
        {
            System.out.print(strTowns[x] + "\t");
            for(int y = 0; y < 3; y++){
                System.out.print("\t " + speed[x][y] + "km\t");
                HighestFine(speed[x][y]);
            }
            System.out.println();
        }
        System.out.println("*************************************************************");
        System.out.println("SPEEDING FINES STATISTICS");
        System.out.println("*************************************************************");
        StatsReport();
        System.out.println("*************************************************************");
    }
    private static void SetDefaults(int defaultValue)
    {
        highestSpeed = defaultValue;
        lowestSpeed = defaultValue;
    }
    private static void HighestFine(int speedCaptured)
    {
        if(speedCaptured > highestSpeed){
            highestSpeed = speedCaptured;
        }
        if(speedCaptured < lowestSpeed) {
            lowestSpeed = speedCaptured;
        }
    }
    private static void StatsReport()
    {
        System.out.println("Maximum speed captured: " + highestSpeed + "km");
        System.out.println("Minimum speed captured: " + lowestSpeed + "km");
    }
}
