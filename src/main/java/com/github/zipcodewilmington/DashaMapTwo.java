package com.github.zipcodewilmington;

public class DashaMapTwo<K,V> extends DashaMap<K,V> {
    public DashaMapTwo(){
        super();
    }

    @Override
    public Integer hashFunction(K input) {
        if(input instanceof String){
            if (((String) input).length() > 1) {
                return ((String) input).toLowerCase().charAt(1) - 'a';
            } else if (((String) input).length() == 1) {
                return ((String) input).toLowerCase().charAt(0) - 'a';
            }
        } else {
            return input.hashCode() % 26;
        }
        return null;
    }

}
