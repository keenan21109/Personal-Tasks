public abstract class Fine implements iFine {
    private String person;
    private int speed;
    private double finePayable =0.0;
    public Fine(String person, int speed)
    {
        this.person = person;
        this.speed = speed;
    }
    public void CalculateFine() {
        if(this.speed >= 120) {
            this.finePayable = (this.speed * 10.20);
        }
        else {
            this.finePayable = 0;
        }
    }
    public String getPerson() {
        return this.person;
    }
    public int getSpeed() {
        return this.speed;
    }
    public double getFinePayable() {
        return this.finePayable;
    }
}
