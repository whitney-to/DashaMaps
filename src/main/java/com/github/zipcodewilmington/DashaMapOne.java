package com.github.zipcodewilmington;

public class DashaMapOne<K,V> extends DashaMap<K,V>{
    public DashaMapOne(){
        super();
    }
    @Override
    public Integer hashFunction(K input) {
        if(input instanceof String){
            if (((String) input).length() > 0) {
                return ((String) input).toLowerCase().charAt(0) - 'a';
            }
        } else {
            return input.hashCode() % 26;
        }
        return null;
    }

//    @Override
//    public void set(String key, Integer value) {
//        String keyHash = HashFunctionOne(key);
//        Node node = new Node(key,value);
//        try {
//            Node head = super.getList()[keyHash.charAt(0) - 'a'];
//            if (head.next != null) {
//                while (head.next != null) {
//                    head = head.next;
//                }
//            }
//            head.next = node;
//        } catch (NullPointerException e){
//            System.out.println("Invalid word input!");
//        }
//    }
//
//    @Override
//    public String delete(String key) {
//        return null;
//    }
//
//    @Override
//    public String get(String key) {
//
//        return null;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    @Override
//    public long size() {
//        return 0;
//    }
//
//    @Override
//    public boolean bucketSize(String key) {
//        return false;
//    }

//    private String HashFunctionOne(String input) {
//        if (input.length() > 0) {
//            return String.valueOf(input.charAt(0)).toLowerCase();
//        }
//        return null;
//    }
}
