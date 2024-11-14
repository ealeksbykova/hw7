package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GetLeaveOrderUtils {
    public static List<Integer> leaveOrder(int maxUnits, int leaveInterval) {
        List<Integer> unitChain = createUnitChain(maxUnits);
        List<Integer> resultQuery = new ArrayList<>();

        ListIterator<Integer> iterator = unitChain.listIterator();

        while (unitChain.size() > 0) {
            if (!iterator.hasNext()) {
                iterator = unitChain.listIterator();
            }
            for (int i = 0; i < leaveInterval; i++) {
                if (!iterator.hasNext()) {
                    iterator = unitChain.listIterator();
                }
                iterator.next();
            }

            int removedSoldier = iterator.previous();
            resultQuery.add(removedSoldier);
            iterator.remove();

            if (!iterator.hasNext()) {
                iterator = unitChain.listIterator();
            }
        }

        return resultQuery;

    }

    private static List<Integer> createUnitChain(int maxUnits) {

        List<Integer> unitChain = new LinkedList<>();
        for (int i = 1; i <= maxUnits; i++) {
            unitChain.add(i);
        }

        return unitChain;
    }
}
