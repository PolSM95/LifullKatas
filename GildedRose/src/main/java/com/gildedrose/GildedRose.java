package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            String itemName = items[i].name;
            int itemQuality = items[i].quality;
            int itemSellIn = items[i].sellIn;

            if (!itemName.equals("Aged Brie")
                    && !itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (itemQuality > 0) {
                    if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                        itemQuality--;
                    }
                }
            } else {
                if (itemQuality < 50) {
                    itemQuality++;

                    if (itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemSellIn < 11) {
                            if (itemQuality < 50) {
                                itemQuality++;
                            }
                        }


                        if (itemSellIn < 6) {
                            if (itemQuality < 50) {
                                itemQuality++;
                            }
                        }
                    }
                }
            }

            if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                itemSellIn--;
            }

            if (itemSellIn < 0) {
                if (!itemName.equals("Aged Brie")) {
                    if (!itemName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemQuality > 0) {
                            if (!itemName.equals("Sulfuras, Hand of Ragnaros")) {
                                itemQuality--;
                            }
                        }
                    } else {
                        itemQuality = 0;
                    }
                } else {
                    if (itemQuality < 50) {
                        itemQuality++;
                    }
                }
            }
            items[i].quality = itemQuality;
            items[i].sellIn = itemSellIn;
        }
    }

}