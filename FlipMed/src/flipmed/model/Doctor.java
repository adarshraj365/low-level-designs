package flipmed.model;

import flipmed.enums.Speciality;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Slot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<Slot> slotList) {
        this.slotList = slotList;
    }

    private int id;
    private String name;
    private Speciality speciality;
    private List<Slot> slotList;

    public Doctor(int id, String name, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.slotList = new ArrayList<>();
    }

    public void addSlot(Slot slot) {
        this.slotList.add(slot);
    }

    public List<Slot> getSlots() {
        return this.slotList;
    }
}
