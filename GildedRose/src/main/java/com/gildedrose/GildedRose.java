package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            String itemName = items[i].name;
            int itemQuality = items[i].quality;
            int itemSellIn = items[i].sellIn;

            if (!itemName.equals(AGED_BRIE) && !itemName.equals(BACKSTAGE_PASSES)) {
                itemQuality = decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(itemName, itemQuality);
            } else {
                if (itemQuality < 50) {
                    itemQuality++;

                    if (itemName.equals(BACKSTAGE_PASSES)) {
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

            if (!itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                itemSellIn--;
            }

            if (itemSellIn < 0) {
                if (!itemName.equals(AGED_BRIE)) {
                    if (!itemName.equals(BACKSTAGE_PASSES)) {
                        itemQuality = decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(itemName, itemQuality);
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

    private int decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(String itemName, int itemQuality) {
        if (itemQuality > 0 && !itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            itemQuality--;
        }
        return itemQuality;
    }

}