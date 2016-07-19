package com.knoxhack.teslaarsenal;

import com.knoxhack.teslaarsenal.common.ProxyCommon;
import com.knoxhack.teslaarsenal.crafting.ModCrafting;
import com.knoxhack.teslaarsenal.creativetab.CreativeTabTeslaArsenal;
import com.knoxhack.teslaarsenal.item.ItemIronStick;
import com.knoxhack.teslaarsenal.item.ItemNetherStarDust;
import com.knoxhack.teslaarsenal.item.ItemTeslaAxe;
import com.knoxhack.teslaarsenal.item.ItemTeslaHoe;
import com.knoxhack.teslaarsenal.item.ItemTeslaPickaxe;
import com.knoxhack.teslaarsenal.item.ItemTeslaShovel;
import com.knoxhack.teslaarsenal.item.ItemTeslaSword;
import com.knoxhack.teslaarsenal.item.ItemTeslariumDust;
import com.knoxhack.teslaarsenal.item.ItemTeslariumIngot;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "teslaarsenal", name = "Tesla Arsenal", version = "1.0")
public class TeslaArsenal {
    
    @SidedProxy(serverSide = "com.knoxhack.teslaarsenal.common.ProxyCommon", clientSide = "com.knoxhack.teslaarsenal.client.ProxyClient")
    public static ProxyCommon proxy;
    
    @Mod.Instance("teslaarsenal")
    public static TeslaArsenal instance;
    public static CreativeTabs tab;
    public static Item itemteslahoe,itemteslaaxe,itemteslashovel,itemteslapickaxe,itemteslasword, itemnetherstardust,itemteslariumdust,itemteslariumingot,itemironstick;
	public static TeslaArsenal MODID;

    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
      
        tab = new CreativeTabTeslaArsenal();
        itemteslapickaxe = registerItem(new ItemTeslaPickaxe());
        itemteslaaxe = registerItem(new ItemTeslaAxe());
        itemteslashovel = registerItem(new ItemTeslaShovel());
        itemteslahoe = registerItem(new ItemTeslaHoe());
        itemteslasword = registerItem(new ItemTeslaSword());
        
        itemnetherstardust = registerItem(new ItemNetherStarDust());
        itemteslariumdust = registerItem(new ItemTeslariumDust());
        itemteslariumingot = registerItem(new ItemTeslariumIngot());
        itemironstick = registerItem(new ItemIronStick());
        
        proxy.preInit();
    }
    


	public static Item registerItem (Item item) {
        GameRegistry.register(item);
        return item;
    }
    
    public static boolean hasTesla() {
        return Loader.isModLoaded("Tesla");
    }
    
    @EventHandler
    public void init(FMLInitializationEvent e) {
    	
        ModCrafting.initCrafting();

    }
    }
