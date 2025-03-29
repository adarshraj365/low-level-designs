package flipmed.model;

public class Slot {
    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    private String startTime;
    private String endTime;
    private boolean isAvailable;


    public Slot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.isAvailable = true;
    }

    public void bookCurrentSlot() {
        this.isAvailable = false;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
