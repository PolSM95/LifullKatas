package com.gildedrose;

class GildedRose {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    private static final int ITEM_QUALITY_MAX = 50;
    private static final int ITEM_SELLIN_INCREASE_QUALITY_BY_TWO = 11;
    private static final int ITEM_SELLIN_INCREASE_QUALITY_BY_THREE = 6;
    private static final int ITEM_EXPIRED_DATE = 0;
    private static final int ITEM_QUALITY_MIN = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int index = 0; index < items.length; index++) {

            String itemName = items[index].name;
            int itemQuality = items[index].quality;
            int itemSellIn = items[index].sellIn;

            if (!itemName.equals(AGED_BRIE) && !itemName.equals(BACKSTAGE_PASSES)) {
                itemQuality = decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(itemName, itemQuality);
            } else {
                if (itemQuality < ITEM_QUALITY_MAX) {
                    itemQuality++;

                    if (itemName.equals(BACKSTAGE_PASSES)) {
                        if (itemSellIn < ITEM_SELLIN_INCREASE_QUALITY_BY_TWO) {
                            if (itemQuality < ITEM_QUALITY_MAX) {
                                itemQuality++;
                            }
                        }
                        if (itemSellIn < ITEM_SELLIN_INCREASE_QUALITY_BY_THREE) {
                            if (itemQuality < ITEM_QUALITY_MAX) {
                                itemQuality++;
                            }
                        }
                    }
                }
            }

            if (!itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                itemSellIn--;
            }

            if (itemSellIn < ITEM_EXPIRED_DATE) {
                if (!itemName.equals(AGED_BRIE)) {
                    if (!itemName.equals(BACKSTAGE_PASSES)) {
                        itemQuality = decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(itemName, itemQuality);
                    } else {
                        itemQuality = ITEM_QUALITY_MIN;
                    }
                } else {
                    if (itemQuality < ITEM_QUALITY_MAX) {
                        itemQuality++;
                    }
                }
            }
            items[index].quality = itemQuality;
            items[index].sellIn = itemSellIn;
        }
    }

    private int decrease_quality_when_is_not_sulfuras_and_quality_more_than_zero(String itemName, int itemQuality) {
        if (itemQuality > ITEM_QUALITY_MIN && !itemName.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            itemQuality--;
        }
        return itemQuality;
    }

}