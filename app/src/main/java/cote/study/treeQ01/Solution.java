package cote.study.treeQ01;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private final static Map<String, List<String>> dependencyMap = new HashMap<>();

    public String[] solution(String[] dependencies, String targetService) {
        List<String> result = new ArrayList<>();

        for(String dependency : dependencies) {
            String[] dependencyArr = dependency.split(" ");
            updateDependencyMap(dependencyArr[1], dependencyArr[0]);
        }

        Deque<String> searchStack = new ArrayDeque<>();
        searchStack.add(targetService);

        while(searchStack.isEmpty() == false) {
            String service = searchStack.pop();
            result.add(service);
            addDependenciesToStack(searchStack, service);
        }

        return result.stream().sorted(Comparator.naturalOrder()).toArray(String[]::new);
    }

    private void addDependenciesToStack(Deque<String> searchStack, String service) {
        if (dependencyMap.containsKey(service)) {
            List<String> dependencyList = dependencyMap.get(service);
            for(String dependency : dependencyList) {
                searchStack.add(dependency);
            }
        }
    }

    private void updateDependencyMap(String dependencyA, String dependencyB) {
        if(dependencyMap.containsKey(dependencyA)) {
            dependencyMap.get(dependencyA).add(dependencyB);
        } else {
            List<String> list = new ArrayList<>();
            list.add(dependencyB);
            dependencyMap.put(dependencyA, list);
        }
    }
}
