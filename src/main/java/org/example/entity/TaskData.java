package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;


    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String person) {
        switch (person.toLowerCase()) {
            case "ann":
                return annsTasks;
            case "bob":
                return bobsTasks;
            case "carol":
                return carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default:
                throw new IllegalArgumentException("Invalid person: " + person);
        }
    }


    public Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> set : sets) {
            union.addAll(set);
        }
        return union;
    }


    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }


    public Set<Task> getDifferences(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }
}
