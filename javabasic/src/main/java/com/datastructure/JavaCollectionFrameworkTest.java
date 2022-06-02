package com.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class JavaCollectionFrameworkTest {

    public static void main (String[] args){
        List<String> list = new ArrayList<>();
        list = new LinkedList<>();
        list = new Vector<>();
        list = new Stack<>();
        list = new CopyOnWriteArrayList<>();
        Queue<String> test = new PriorityQueue<>();
        Deque<String> test2 = new ArrayDeque<>();

        Set<String> set = new HashSet<>();
        set = new TreeSet<>();
        set = new LinkedHashSet<>();

        Map<String, String> map = new HashMap<>();
        map = new TreeMap<>();
        map = new Hashtable<>();
        map = new LinkedHashMap<>();
    }
}
