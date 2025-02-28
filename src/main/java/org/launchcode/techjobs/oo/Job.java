package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        if (this.name == null && employer == null && location == null && positionType == null && coreCompetency == null) {
            return System.lineSeparator() +
                    "OOPS! This job does not seem to exist." +
                    System.lineSeparator();
        }

        String returnEmployer = employer.getValue();
        String returnLocation = location.getValue();
        String returnPositionType = positionType.getValue();
        String returnCoreCompetency = coreCompetency.getValue();

        if (this.name.isEmpty()) {
            setName("Data not available");
        }

        if (returnEmployer.isEmpty()) {
            returnEmployer = "Data not available";
        }

        if (returnLocation.isEmpty()) {
            returnLocation = "Data not available";
        }

        if (returnPositionType.isEmpty()) {
            returnPositionType = "Data not available";
        }

        if (returnCoreCompetency.isEmpty()) {
            returnCoreCompetency = "Data not available";
        }

        return System.lineSeparator() +
                "ID: " + id + System.lineSeparator() +
                "Name: " + name + System.lineSeparator() +
                "Employer: " + returnEmployer + System.lineSeparator() +
                "Location: " + returnLocation + System.lineSeparator() +
                "Position Type: " + returnPositionType + System.lineSeparator() +
                "Core Competency: " + returnCoreCompetency +
                System.lineSeparator();
    }
}
