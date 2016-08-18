package com.knoxhack.teslaarsenal.item;

import net.minecraft.item.ItemStack;

public class ItemNetherStarDust extends ItemBase {

    public ItemNetherStarDust()
    {
        super();
        setUnlocalizedName("teslaarsenal.itemnetherstardust");
        setRegistryName("itemnetherstardust");
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}