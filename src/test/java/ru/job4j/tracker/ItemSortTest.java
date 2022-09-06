package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemSortTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(new Item("Third"), new Item("First"), new Item("Second"));
        items.sort(new ItemAscByName());
        List<Item> expect = List.of(new Item("First"), new Item("Second"), new Item("Third"));
        assertThat(items).isEqualTo(expect);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(new Item("Third"), new Item("First"), new Item("Second"));
        items.sort(new ItemDescByName());
        List<Item> expect = List.of(new Item("Third"), new Item("Second"), new Item("First"));
        assertThat(items).isEqualTo(expect);
    }
}