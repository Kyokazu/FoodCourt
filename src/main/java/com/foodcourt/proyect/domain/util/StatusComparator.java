package com.foodcourt.proyect.domain.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StatusComparator implements Comparator<String> {
    private static final Map<String, Integer> priorityMap = new HashMap<>();

    static {
        priorityMap.put("PENDING", 1);
        priorityMap.put("ON_PREPARATION", 2);
        priorityMap.put("READY", 3);
        priorityMap.put("DELIVERED", 4);
        priorityMap.put("CANCELED", 5);
    }

    @Override
    public int compare(String status1, String status2) {
        return Integer.compare(priorityMap.get(status1), priorityMap.get(status2));
    }
}