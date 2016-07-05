package com.knoxhack.teslaarsenal.client;

import com.knoxhack.teslaarsenal.TeslaArsenal;
import com.knoxhack.teslaarsenal.common.ProxyCommon;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ProxyClient extends ProxyCommon {
    
    @Override
    public void preInit () {
        
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaArsenal.blockCharger), 0, new ModelResourceLocation(TeslaArsenal.blockCharger.getRegistryName(), "inventory"));
      

        
        ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslapickaxe, 0, new ModelResourceLocation(TeslaArsenal.itemteslapickaxe.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslashovel, 0, new ModelResourceLocation(TeslaArsenal.itemteslashovel.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslasword, 0, new ModelResourceLocation(TeslaArsenal.itemteslasword.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslaaxe, 0, new ModelResourceLocation(TeslaArsenal.itemteslaaxe.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslahoe, 0, new ModelResourceLocation(TeslaArsenal.itemteslahoe.getRegistryName(), "inventory"));

        
        
        
        
    }
}
