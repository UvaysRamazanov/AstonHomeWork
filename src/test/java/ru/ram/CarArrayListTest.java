package ru.ram;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarArrayListTest {

    CarArrayList list = new CarArrayList();
    final static int constantNumber = 1000;
    final static int fixPrice = 1000; // Для удобства назначения цен на авто в тестах

    @Test
    void addedCars() {
        assertTrue(list.isEmpty());
        for (int i = 0; i < constantNumber; i++) {
            list.add(i, new Car("Car " + i, fixPrice));
            assertEquals(i + 1, list.getSize());
            assertFalse(list.isEmpty());
        }
        assertEquals(constantNumber, list.getSize());
        assertFalse(list.isEmpty());
    }

    @Test
    void clear() {
        list.clear();
        assertEquals(0, list.getSize());
        assertTrue(list.isEmpty());
    }

    @Test
    void added10Cars() {
        assertTrue(list.isEmpty());
        for (int i = 0; i < 10; i++) {
            list.add(i, new Car("Car " + i, fixPrice));
            assertEquals(i + 1, list.getSize());
        }
        assertEquals(10, list.getSize());
        assertFalse(list.isEmpty());
    }

    @Test
    void addAll() {
        list.clear();
        assertTrue(list.isEmpty());
        ArrayList<Car> carsToAdd  = new ArrayList<>();
        assertTrue(true);
        for (int i = 0; i < constantNumber; i++) {
            carsToAdd.add(i, new Car("Car " + i, fixPrice));
            assertFalse(false);
            assertEquals(i + 1, carsToAdd.size());
        }
        assertFalse(carsToAdd.isEmpty());
        assertEquals(constantNumber, carsToAdd.size());
        list.addAll(carsToAdd);
        assertEquals(list.isEmpty(), false);
        assertEquals(constantNumber, list.getSize());
        list.clear();
        assertEquals(list.isEmpty(), true);
    }


    @Test
    void get() {
        Car car1 = new Car("Car 1", fixPrice);
        Car car2 = new Car("Car 2", fixPrice);

        list.add(0, car1);
        assertEquals(list.isEmpty(), false);
        list.add(1, car2);
        assertEquals(list.isEmpty(), false);

        assertEquals(car1, list.get(0));
        assertEquals(car2, list.get(1));

        list.clear();
        assertEquals(list.isEmpty(), true);
    }

    @Test
    void removeCar() {
        Car car1 = new Car("Car 1", fixPrice);
        list.add(0, car1);
        assertEquals(list.isEmpty(), false);
        assertEquals(car1, list.get(0));
        list.removeCar(car1);
        assertEquals(list.isEmpty(), true);
    }

    @Test
    void testCarMergeSorter() {
        Car car1 = new Car("Toyota", 20000);
        Car car2 = new Car("Honda", 25000);
        Car car3 = new Car("Ford", 18000);

        CarArrayList carArrayList = new CarArrayList();
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(car1, car2, car3));
        Comparator<Car> priceComparator = Comparator.comparingInt(Car::getPrice);

        carArrayList.sort(priceComparator);

        List<Car> expected = Arrays.asList(car3, car1, car2);
        assertArrayEquals(cars.toArray(), expected.toArray());
    } // Почему-то не выполнился
}