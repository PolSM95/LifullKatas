package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        CombinationApprovals.verifyAllCombinations(this::doUpdateQuality,
                new String[]{
                        "foo",
                        "Aged Brie",
                        "Backstage passes to a TAFKAL80ETC concert",
                        "Sulfuras, Hand of Ragnaros"
                },
                new Integer[]{-1,0,1,5,6,10,11,12},new Integer[]{0,1,30,49,50,51,60});
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item[] items = new Item[] { new Item(name, sellIn, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        return app.items[0].toString();
    }


}
