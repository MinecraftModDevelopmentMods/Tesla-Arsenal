package com.knoxhack.teslaarsenal.client;

import com.knoxhack.teslaarsenal.TeslaArsenal;
import com.knoxhack.teslaarsenal.common.ProxyCommon;
import com.knoxhack.teslaarsenal.crafting.ModCrafting;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ProxyClient extends ProxyCommon {
    
    @Override
    public void preInit () {
        
       // ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(TeslaArsenal.blockCharger), 0, new ModelResourceLocation(TeslaArsenal.blockCharger.getRegistryName(), "inventory"));
      

        
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslapickaxe, 0, new ModelResourceLocation(TeslaArsenal.itemteslapickaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslashovel, 0, new ModelResourceLocation(TeslaArsenal.itemteslashovel.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslasword, 0, new ModelResourceLocation(TeslaArsenal.itemteslasword.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslaaxe, 0, new ModelResourceLocation(TeslaArsenal.itemteslaaxe.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslahoe, 0, new ModelResourceLocation(TeslaArsenal.itemteslahoe.getRegistryName(), "inventory"));

    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemnetherstardust, 0, new ModelResourceLocation(TeslaArsenal.itemnetherstardust.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslariumdust, 0, new ModelResourceLocation(TeslaArsenal.itemteslariumdust.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemteslariumingot, 0, new ModelResourceLocation(TeslaArsenal.itemteslariumingot.getRegistryName(), "inventory"));
    ModelLoader.setCustomModelResourceLocation(TeslaArsenal.itemironstick, 0, new ModelResourceLocation(TeslaArsenal.itemironstick.getRegistryName(), "inventory"));

    
    
    
    
    
    }
    
    

    
    
    
    
    
    
    
}
