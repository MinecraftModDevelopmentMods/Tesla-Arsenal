package com.knoxhack.teslaarsenal;

import com.knoxhack.teslaarsenal.block.BlockCharger;
import com.knoxhack.teslaarsenal.common.ProxyCommon;
import com.knoxhack.teslaarsenal.creativetab.CreativeTabTeslaArsenal;
import com.knoxhack.teslaarsenal.item.ItemTeslaAxe;
import com.knoxhack.teslaarsenal.item.ItemTeslaHoe;
import com.knoxhack.teslaarsenal.item.ItemTeslaPickaxe;
import com.knoxhack.teslaarsenal.item.ItemTeslaShovel;
import com.knoxhack.teslaarsenal.item.ItemTeslaSword;
import com.knoxhack.teslaarsenal.tileentity.TileEntityCharger;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = "teslaarsenal", name = "Tesla Arsenal", version = "1.0")
public class TeslaArsenal {
    
    @SidedProxy(serverSide = "com.knoxhack.teslaarsenal.common.ProxyCommon", clientSide = "com.knoxhack.teslaarsenal.client.ProxyClient")
    public static ProxyCommon proxy;
    
    @Mod.Instance("teslaarsenal")
    public static TeslaArsenal instance;
    
    public static CreativeTabs tab;
    
    public static Block blockCharger;

    
    public static Item itemteslasword;
    public static Item itemteslapickaxe;
    public static Item itemteslashovel;
    public static Item itemteslaaxe;
    public static Item itemteslahoe;

	public static ToolMaterial ModToolMaterial = net.minecraftforge.common.util.EnumHelper.addToolMaterial("ModToolMaterial", 3, 1000, 15.0F, 4.0F, 30);


    
    
    @EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        tab = new CreativeTabTeslaArsenal();
        
        
        


        blockCharger = registerBlock(new BlockCharger(), TileEntityCharger.class, "charger");

       itemteslapickaxe = registerItem(new ItemTeslaPickaxe(ModToolMaterial), "itemteslapickaxe");
        itemteslashovel = registerItem(new ItemTeslaShovel(ModToolMaterial), "itemteslashovel");
        itemteslaaxe = registerItem(new ItemTeslaAxe(ModToolMaterial), "itemteslaaxe");
        itemteslasword = registerItem(new ItemTeslaSword(ModToolMaterial), "itemteslasword");
        itemteslahoe = registerItem(new ItemTeslaHoe(ModToolMaterial), "itemteslahoe");

        
        
        
        
        proxy.preInit();
    }
    
    public static Block registerBlock (Block block, Class<? extends TileEntity> tileEntityClass, String name) {
        
        block.setRegistryName(name);
        GameRegistry.register(block);
        GameRegistry.register(new ItemBlock(block), block.getRegistryName());
        GameRegistry.registerTileEntity(tileEntityClass, block.getRegistryName().toString());
        return block;
    }
    
    public static Item registerItem (Item item, String name) {
        
        item.setRegistryName(name);
        GameRegistry.register(item);
        return item;
    }
    
    
    public static boolean hasTesla() {
        return Loader.isModLoaded("Tesla");
    }

    }
    
    
    
