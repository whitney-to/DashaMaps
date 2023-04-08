package com.github.zipcodewilmington;

public class DashaMapThree<K,V> extends DashaMap<K,V>{
    public DashaMapThree(){super();}

    private String HashFunctionThree(String input) {
        if (input.length() > 1) {
            return String.valueOf(input.charAt(0)+input.charAt(1)).toLowerCase();
        }
        return null;
    }

    @Override
    public Integer hashFunction(K input) {
        if(input instanceof String){
            if (((String) input).length() > 1) {
                return (((String) input).toLowerCase().charAt(0)
                        + ((String) input).toLowerCase().charAt(1)) % 'a';
            } else if (((String) input).length() == 1) {
                return ((String) input).toLowerCase().charAt(0) - 'a';
            }
        } else {
            return input.hashCode() % 26;
        }
        return null;
    }
}
