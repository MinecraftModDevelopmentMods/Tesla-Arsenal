package com.knoxhack.teslaarsenal.common;

import com.knoxhack.teslaarsenal.TeslaArsenal;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ProxyCommon {
    
    public void preInit () {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaArsenal.blockCharger), 0, new ModelResourceLocation(TeslaArsenal.blockCharger.getRegistryName(), "inventory"));
    }
}
