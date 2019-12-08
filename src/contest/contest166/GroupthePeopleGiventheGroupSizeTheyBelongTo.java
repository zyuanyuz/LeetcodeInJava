package contest.contest166;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        label: for (int i = 0; i < groupSizes.length; i++) {
            int num = groupSizes[i];
            if (null == map.get(num)) {
                map.put(num, new ArrayList<>());
            }
            for (List<Integer> list : map.get(num)) {
                if (list.size() < num) {
                    list.add(i);
                    continue label;
                }
            }
            List<Integer> list = new ArrayList<>();
            list.add(i);
            map.get(num).add(list);
        }
        for (List<List<Integer>> values : map.values()) {
            for (List<Integer> list : values) {
                result.add(list);
            }
        }
        return result;
    }
}