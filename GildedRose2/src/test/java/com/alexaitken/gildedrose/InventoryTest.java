package com.alexaitken.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alexaitken.gildedrose.Inventory;
import com.alexaitken.gildedrose.Item;


public class InventoryTest {

    private Inventory createInventory(Item... items) {
        return new Inventory(items);
    }

    @Test // P1
    public void should_increase_the_quality_of_aged_brie_as_it_gets_older() {
        Item agedBrie = new Item("Aged Brie", 10, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(26, agedBrie.getQuality());
    }

    @Test // P1b
    public void should_not_increase_the_quality_of_aged_brie_over_50() {
        Item agedBrie = new Item("Aged Brie", 10, 50);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }

    @Test // P2
    public void p2() {
        Item agedBrie = new Item("Aged Brie", -8, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(27, agedBrie.getQuality());
    }

    @Test // P2b
    public void p2b() {
        Item agedBrie = new Item("Aged Brie", -8, 50);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }

    @Test // P2c
    public void p2c() {
        Item agedBrie = new Item("Aged Brie", -8, 49);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(50, agedBrie.getQuality());
    }

    @Test // P2d
    public void p2d() {
        Item agedBrie = new Item("Aged Brie", 0, 25);
        Inventory inventory = createInventory(agedBrie);
        inventory.updateQuality();
        assertEquals(27, agedBrie.getQuality());
    }

    @Test // P3
    public void should_never_changes_quailty_of_Sulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Inventory inventory = createInventory(sulfuras);
        inventory.updateQuality();
        assertEquals(80, sulfuras.getQuality());
    }

    @Test // P3
    public void should_never_changes_sellIn_of_Sulfuras() {
        Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Inventory inventory = createInventory(sulfuras);
        inventory.updateQuality();
        assertEquals(0, sulfuras.getSellIn());
    }

    @Test // P4
    public void should_increase_backstage_passes_quality_by_1_when_the_concert_is_more_than_10_days_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(21, backStagePass.getQuality());
    }

    @Test // P4b
    public void should_not_increase_backstage_passes_above_a_quality_of_50() {
        Item backStagePassMoreThan10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 50);
        Inventory inventory = createInventory(backStagePassMoreThan10DaysAway);
        inventory.updateQuality();
        assertEquals(50, backStagePassMoreThan10DaysAway.getQuality());
    }

    @Test // P5
    public void should_increase_backstage_passes_quality_by_2_when_the_concert_is_10_days_or_less_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 27);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(29, backStagePass.getQuality());
    }

    @Test // P5b
    public void p5b() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P5c
    public void p5c() {
        Item backStagePass10DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        Inventory inventory = createInventory(backStagePass10DaysAway);
        inventory.updateQuality();
        assertEquals(50, backStagePass10DaysAway.getQuality());
    }

    @Test // P5d
    public void p5d() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(27, backStagePass.getQuality());
    }

    @Test // P5e
    public void p5e() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P5f
    public void p5f() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P6
    public void should_increase_backstage_passes_quality_by_3_when_the_concert_is_5_days_or_less_away() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 44);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(47, backStagePass.getQuality());
    }

    @Test // P6b
    public void p6b() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P6c
    public void p6c() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P6d
    public void p6d() {
        Item backStagePass5DaysAway = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48);
        Inventory inventory = createInventory(backStagePass5DaysAway);
        inventory.updateQuality();
        assertEquals(50, backStagePass5DaysAway.getQuality());
    }

    @Test // P6e
    public void p6e() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(28, backStagePass.getQuality());
    }

    @Test // P6f
    public void p6f() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P6g
    public void p6g() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P6h
    public void p6h() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 48);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(50, backStagePass.getQuality());
    }

    @Test // P7
    public void p7() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 25);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(0, backStagePass.getQuality());
    }

    @Test // P8
    public void should_lower_backstage_passes_to_zero_quality_once_concert_has_happened() {
        Item backStagePass = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
        Inventory inventory = createInventory(backStagePass);
        inventory.updateQuality();
        assertEquals(0, backStagePass.getQuality());
    }

    @Test // P9
    public void should_lower_the_sellIn_by_one_for_normal_items() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(9, normalItem.getSellIn());
    }

    @Test // P9
    public void should_lower_the_quality_by_one_for_normal_items() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 20);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(19, normalItem.getQuality());
    }

    @Test // P9b
    public void should_not_lower_the_quality_below_zero() {
        Item normalItem = new Item("+5 Dexterity Vest", 10, 0);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
    }

    @Test // P10
    public void should_lower_the_quality_twice_as_fast_once_the_sell_in_date_has_passed() {
        Item normalItem = new Item("+5 Dexterity Vest", -1, 25);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(23, normalItem.getQuality());
    }

    @Test // P10b
    public void p10b() {
        Item normalItem = new Item("+5 Dexterity Vest", -8, 1);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
    }

    @Test // P10c
    public void p10c() {
        Item normalItem = new Item("+5 Dexterity Vest", -8, 0);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(0, normalItem.getQuality());
    }

    @Test // P10d
    public void p10d() {
        Item normalItem = new Item("+5 Dexterity Vest", 0, 25);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(23, normalItem.getQuality());
    }

    @Test // P11
    public void p11() {
        Item normalItem = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Inventory inventory = createInventory(normalItem);
        inventory.updateQuality();
        assertEquals(80, normalItem.getQuality());
    }
}