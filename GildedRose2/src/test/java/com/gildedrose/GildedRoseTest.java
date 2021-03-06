package com.gildedrose;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{Item.createItem("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void checking_that_sulfuras_quality_never_changes(){
        Item[] items = new Item[] {Item.createItem("Sulfuras, Hand of Ragnaros", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }

    @Test
    public void checking_quality_for_an_unknown_and_unexpired_item(){
        Item[] items = new Item[] {Item.createItem("Mango's elixir", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49,app.items[0].quality);
    }

    @Test
    public void checking_quality_for_an_unknown_and_expired_item(){
        Item[] items = new Item[] {Item.createItem("Mango's elixir", 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48,app.items[0].quality);
    }

    @Test
    public void checking_AgedBrie_increase_quality_before_is_expired(){
        Item[] items = new Item[] {Item.createItem("Aged Brie", 2, 0 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].quality);
    }

    @Test
    public void checking_Backstage_when_sellig_under_six_and_quality_under_fifty(){
        Item[] items = new Item[] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 30 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(33,app.items[0].quality);
    }

    @Test
    public void checking_Quality_does_not_change_when_it_is_above_Fifty_in_Aged_Brie(){
        Item[] items = new Item[] {Item.createItem("Aged Brie", 5, 56 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(56,app.items[0].quality);
    }
    @Test
    public void checking_that_quality_is_zero_after_the_concert(){
        Item[] items = new Item[] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 0, 30 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }

    @Test
    public void checking_quality_when_AgedBrie_expired(){
        Item[] items = new Item[] {Item.createItem("Aged Brie", 0, 30 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32,app.items[0].quality);
    }

    @Test
    public void checking_Backstage_when_sell_in_is_equal_to_six(){
        Item[] items = new Item[] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 6, 30 )};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(32,app.items[0].quality);
    }






}
