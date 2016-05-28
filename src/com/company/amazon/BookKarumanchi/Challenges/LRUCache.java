package com.company.amazon.BookKarumanchi.Challenges;/*
package Challenges;

*/
/**
 * Created by v-dsindhi on 6/18/15.
 */


import java.util.*;

import java.util.Date;


public class LRUCache {


        private static final int SIZE = 5;
        private Map<String, String> map = new HashMap<String, String>();

        private PriorityQueue<Element> pq = new PriorityQueue<Element>(SIZE, new Comparator() {
            @Override
            public int compare(Object arg0, Object arg1) {
                //Ordering the elements as per timestamp.
                if (!(arg0 instanceof Element) || !(arg1 instanceof Element))
                    return 0;
                Element e1 = (Element) arg0;
                Element e2 = (Element) arg1;
                return e1.getTimestamp().compareTo(e2.getTimestamp());
            }
        });

        private void insert(Element e) {
            System.out.println("Received Element: " + e.getValue());
            pq.offer(e);
        }

        private String remove() {
            Element leastUsed = pq.poll();
            if (leastUsed != null) {
                System.out.println("Removing least used element:" + leastUsed.getValue());
                System.out.println("This element was last used:" + leastUsed.getTimestamp());
                return leastUsed.getValue();
            }
            return "";
        }

        private void update(String mostRecentEleKey) {
            //update priority queue with most recent access.
            //Internal datastructure on PriorityQueue is Heap and it is partially sorted.
            //This means, any update on elements means to delete them and add them again.

            Iterator<Element> pqIterator = pq.iterator();
            while (pqIterator.hasNext()) {
                Element e = pqIterator.next();
                if (e.getValue().equals(mostRecentEleKey)) {
                    pqIterator.remove();
                    break;
                }
            }
            Element mostRecent = new Element();
            mostRecent.setTimestamp(new Date());
            mostRecent.setValue(mostRecentEleKey);
            insert(mostRecent);
        }

        public String get(String key) {
            String value = map.get(key);
            if (value!=null) {
                System.out.println("Updating " + key + " with current timestamp.");
                update(key);
            }
            return value;
        }

        public void put(String key, String value) {
            System.out.println("Before put opertaion, map size:" + map.size());
            if (map.containsKey(key)) {
                System.out.println("Cache hit on key:" + key + ", nothing to insert!");
                update(key);
            } else {
                if (map.size() >= SIZE) {
                    String leastUsedKey = remove();
                    map.remove(leastUsedKey);
                }
                System.out.println("Element not present in Cache: " + key);
                Element e = new Element();
                e.setValue(key);
                e.setTimestamp(new Date());
                insert(e);
                map.put(key, value);
            }
            System.out.println("After put operation, following stats are generated:");
            System.out.println("Least used element:" + pq.peek().getValue() + ", last used at:" + pq.peek().getTimestamp());
            System.out.println("map size:" + map.size());
        }

        public static void main(String[] args) {
            LRUCache cache = new LRUCache();
            cache.put("a", "a");
            cache.put("b", "b");
            cache.put("c", "c");
            cache.put("d", "d");
            cache.put("e", "e");
            cache.put("b", "b");
            cache.put("d", "d");
            cache.put("b", "b");
            cache.put("c", "c");
            cache.put("b", "b");
            cache.put("a", "a");
            cache.put("f", "f");
            cache.get("a");
        }
    }


     class Element {
        private String value;
        private Date timestamp;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Date timestamp) {
            this.timestamp = timestamp;
        }

        public boolean equals(Element e) {
            return value.equals(e.getValue());
        }

        public int hashCode(){
            return value.length() >> 1 >> 4;
        }
}

