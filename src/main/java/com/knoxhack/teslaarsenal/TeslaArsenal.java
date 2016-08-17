package com.knoxhack.teslaarsenal;

import com.knoxhack.teslaarsenal.common.ProxyCommon;
import com.knoxhack.teslaarsenal.crafting.ModCrafting;
import com.knoxhack.teslaarsenal.creativetab.CreativeTabTeslaArsenal;
import com.knoxhack.teslaarsenal.item.*;

import net.minecraft.item.ItemArmor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.inventory.EntityEquipmentSlot;



@Mod(modid = "teslaarsenal", name = "Tesla Arsenal", version = "1.3")
public class TeslaArsenal {
    
    @SidedProxy(serverSide = "com.knoxhack.teslaarsenal.common.ProxyCommon", clientSide = "com.knoxhack.teslaarsenal.client.ProxyClient")
    public static ProxyCommon proxy;
    
    @Mod.Instance("teslaarsenal")
    public static TeslaArsenal instance;
    public static CreativeTabs tab;
    public static Item itemteslawrench,itemteslahoe,itemteslaaxe,itemteslashovel,itemteslapickaxe,itemteslasword, itemnetherstardust,itemteslariumdust,itemteslariumingot,itemtoolhandle;
	public static TeslaArsenal MODID;
	ToolMaterial WOODTOOL;
	
	
	public static Item energizedArmorHelmet;
	public static Item energizedArmorChestplate;
	public static Item energizedArmorLeggings;
	public static Item energizedArmorBoots;
	
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
      
        tab = new CreativeTabTeslaArsenal();
        itemteslapickaxe = registerItem(new ItemTeslaPickaxe());
        itemteslaaxe = registerItem(new ItemTeslaAxe());
        itemteslashovel = registerItem(new ItemTeslaShovel());
        itemteslahoe = registerItem(new ItemTeslaHoe());
        
        
        
        
        itemteslasword = registerItem(new ItemTeslaSword(WOODTOOL.DIAMOND));
        
        itemnetherstardust = registerItem(new ItemNetherStarDust());
        itemteslariumdust = registerItem(new ItemTeslariumDust());
        itemteslariumingot = registerItem(new ItemTeslariumIngot());
        itemtoolhandle = registerItem(new ItemToolHandle());
        itemteslawrench = registerItem(new ItemToolWrench());

        
        
        energizedArmorHelmet = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.HEAD, 10000, 200,
				200).setRegistryName("energizedarmour.helmet");
		GameRegistry.register(energizedArmorHelmet);

		energizedArmorChestplate = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.CHEST, 10000,
				200, 200).setRegistryName("energizedarmour.chestplate");
		GameRegistry.register(energizedArmorChestplate);

		energizedArmorLeggings = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.LEGS, 10000,
				200, 200).setRegistryName("energizedarmour.leggings");
		GameRegistry.register(energizedArmorLeggings);

		energizedArmorBoots = new ItemTeslaEnergizedArmor(ItemArmor.ArmorMaterial.DIAMOND, EntityEquipmentSlot.FEET, 10000, 200,
				200).setRegistryName("energizedarmour.boots");
		GameRegistry.register(energizedArmorBoots);
        
        
        
        
        
        
        
        
        
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
