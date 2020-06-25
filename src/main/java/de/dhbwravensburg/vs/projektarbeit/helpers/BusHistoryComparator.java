package de.dhbwravensburg.vs.projektarbeit.helpers;

import de.dhbwravensburg.vs.projektarbeit.entities.BusHistory;

import java.util.Comparator;

public class BusHistoryComparator implements Comparator<BusHistory> {

    @Override
    public int compare(BusHistory o1, BusHistory o2) {
        return o1.getAnkunftszeit().compareTo(o2.getAnkunftszeit());
    }
}
