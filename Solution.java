package com.company;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Student, School> matching;
    private Problem problem;

    public Solution(Problem problem) {
        this.problem = problem;
        this.matching = new HashMap<>();
    }

    public Map<Student, School> getMatching() {
        return matching;
    }

    public void setMatching(Map<Student, School> matching) {
        this.matching = matching;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
