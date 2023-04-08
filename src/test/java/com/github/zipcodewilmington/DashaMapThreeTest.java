package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

public class DashaMapThreeTest {
    @Test
    public void constructorTest(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();
        Integer expectedSize  = 26;

        // When
        Integer actualSize = map1.getList().length;

        // Then
        Assert.assertNotNull(map1.getList());
        Assert.assertEquals(expectedSize,actualSize);

        // test for list containing all 26 lower case letter
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(char c = 'a'; c <= 'z'; c++){
            String expected = sb.append(c).toString();
            Assert.assertEquals(expected,map1.getList()[count].k);
            count++;
            sb.delete(0,1);
        }
    }

    @Test
    public void setTest(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();
        String expectedKey = "apple";
        Integer expectedVal = 5;

        // When
        map1.set("Adam",8);
        map1.set(expectedKey,expectedVal);
        map1.set("Adoodoo",10);
        Integer actual = map1.get(expectedKey);

        // Then
        Assert.assertEquals(expectedVal,actual);
    }

    @Test
    public void getTestNull(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();

        // When
        // Then
        Assert.assertNull(map1.get("Apple"));
    }

    @Test
    public void bucketSizeTest(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();
        Integer expected = 1;

        // When
        map1.set("Adam",8);
        map1.set("Abc",8);
        map1.set("acc",8);
        Integer actual = map1.bucketSize("d");

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void sizeTest(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();
        Long expected = 5l;

        // When
        map1.set("Adam",8);
        map1.set("Abc",8);
        map1.set("bcc",8);
        map1.set("fcc",8);
        map1.set("gcc",8);

        Long actual = map1.size();

        // Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isEmptyTest(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();

        // When
        map1.set("Adam",8);

        // Then
        Assert.assertFalse(map1.isEmpty());
    }

    @Test
    public void isEmptyTest2(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();

        // When
        // Then
        Assert.assertTrue(map1.isEmpty());
    }

    @Test
    public void deleteTest(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();
        Long expectedSizeBefore = 5l;
        Long expectedSizeAfter = 4l;


        // When
        map1.set("Ada1",8);
        map1.set("Ada2",8);
        map1.set("Ada3",8);
        map1.set("Ada4",8);
        map1.set("Ada5",8);
        Long actualBefore = map1.size();
        Assert.assertEquals(expectedSizeBefore,actualBefore);
        map1.delete("Ada3");
        Long actualAfter = map1.size();

        // Then
        Assert.assertEquals(expectedSizeAfter,actualAfter);
        Assert.assertNull(map1.get("Ada3"));
    }

    @Test
    public void deleteTest1(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();
        Long expectedSizeBefore = 5l;
        Long expectedSizeAfter = 4l;


        // When
        map1.set("Ada1",8);
        map1.set("Ada2",8);
        map1.set("Ada3",8);
        map1.set("Ada4",8);
        map1.set("Ada5",8);
        Long actualBefore = map1.size();
        Assert.assertEquals(expectedSizeBefore,actualBefore);
        map1.delete("Ada5");
        Long actualAfter = map1.size();

        // Then
        Assert.assertEquals(expectedSizeAfter,actualAfter);
        Assert.assertNull(map1.get("Ada5"));
    }

    @Test
    public void deleteTest2(){
        // Given
        DashaMapThree<String,Integer> map1 = new DashaMapThree<>();

        // When
        String key = map1.delete("Ada3");

        // Then
        Assert.assertNull(key);
    }

}
