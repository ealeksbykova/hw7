package org.example;

import org.example.lib.Treap;

import java.util.ArrayList;
import java.util.List;

public class GetDoorNumbersUtil {
    public static void validateInput(int maxDoors, List<Action> actionList) {
        if (maxDoors < 1 || maxDoors > 1000000000) {
            throw new IllegalArgumentException("Max doors must be between 1 and 1000000000");
        }

        if (actionList == null || actionList.isEmpty() || actionList.size() > 100000) {
            throw new IllegalArgumentException("Action list must not be null, empty or more than 100000");
        }

        if (actionList.size() > 10000) {
            throw new IllegalArgumentException("Too much destroy. Even He-Who-Must-Not-Be-Named is not so bloodthirsty!");
        }

        if (actionList.size() > maxDoors) {
            throw new IllegalArgumentException("Action number must be less than " + maxDoors);
        }
    }

    public static List<Integer> makeHarryGrateAgain(int maxDoors, List<Action> actionList) {
        Treap<Integer> originalTreap = createTreap(maxDoors);

        List<Integer> result = new ArrayList<>();

        for (Action action : actionList) {
            Treap.Node<Integer> nodeByIndex = originalTreap.getNodeByIndex(action.doorNumber - 1);
            if (action.isLook) result.add(nodeByIndex.getKey());
            else originalTreap.removeNode(nodeByIndex);
        }

        return result;
    }

    private static Treap<Integer> createTreap(int maxDoors) {
        Treap<Integer> treap = new Treap<>();

        for (int i = 1; i <= maxDoors; i++) {
            treap.add(i);
        }

        treap.print();

        return treap;
    }

    //tmp
    public static void main(String[] args) {
        createTreap(20);
    }
}
