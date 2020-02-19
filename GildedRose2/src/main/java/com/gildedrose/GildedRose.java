package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
<<<<<<< HEAD
            final Item item = items[i];

            if (item.name.equals("Aged Brie")) {
                if(item.quality < 50){
                    item.quality = item.quality + 1;

                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

            }

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if(item.quality < 50){
                        item.quality = item.quality + 1;

                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                    item.sellIn = item.sellIn - 1;
                    if(item.sellIn < 0){
                        item.quality = item.quality - item.quality;
                    }


            }

            if (item.name.equals("Sulfuras, Hand of Ragnaros")){ }

            //Default
            if(!item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert") && !item.name.equals("Sulfuras, Hand of Ragnaros")){
                item.sellIn = item.sellIn - 1;
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                if(item.sellIn < 0){
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }

            }
        }
    }
}
=======
            Item item = items[i];
            item.updateQualityItem();
        }
    }

}
>>>>>>> 25f092e6b02cfe96ea532874026100393f238ea5
