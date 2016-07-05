package com.knoxhack.teslaarsenal.creativetab;

import com.knoxhack.teslaarsenal.TeslaArsenal;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTeslaArsenal extends CreativeTabs {
    
    public CreativeTabTeslaArsenal() {
        
        super("teslaarsenal");
    }
    
    @Override
    public Item getTabIconItem () {
        
        return Item.getItemFromBlock(TeslaArsenal.blockCharger);
    }
}