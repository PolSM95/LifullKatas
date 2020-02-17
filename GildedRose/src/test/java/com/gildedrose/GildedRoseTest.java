package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void checking_that_sulfuras_quality_never_changes(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }

    @Test
    public void checking_quality_for_an_unknown_and_unexpired_item(){
        Item[] items = new Item[] { new Item("Mango's elixir", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49,app.items[0].quality);
    }




}
