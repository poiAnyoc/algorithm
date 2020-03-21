package com.sxb.algorithm.sort;

/**
 * @desc:
 * @author: poi
 * @date: 2020/3/21 20:57
 * @version: v1.0
 */
public class User implements Comparable<User> {
    private int score;
    private int age;
    private String name;

    public User(int score, int age, String name) {
        this.score = score;
        this.age = age;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(User o) {
        return age - o.age;
    }
}
