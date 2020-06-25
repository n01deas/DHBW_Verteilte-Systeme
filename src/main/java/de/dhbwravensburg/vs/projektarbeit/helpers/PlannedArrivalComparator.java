package de.dhbwravensburg.vs.projektarbeit.helpers;

import de.dhbwravensburg.vs.projektarbeit.entities.PlannedArrival;

import java.util.Comparator;

public class PlannedArrivalComparator implements Comparator<PlannedArrival> {

    @Override
    public int compare(PlannedArrival o1, PlannedArrival o2) {
        return o1.getArrivalTime().compareTo(o2.getArrivalTime());
    }
}
