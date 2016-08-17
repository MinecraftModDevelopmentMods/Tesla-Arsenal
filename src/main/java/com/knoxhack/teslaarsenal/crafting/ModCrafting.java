package com.knoxhack.teslaarsenal.crafting;

import com.knoxhack.teslaarsenal.TeslaArsenal;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModCrafting {

	public static void initCrafting() {

		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.itemteslapickaxe, 1), new Object[] {"###", " I ", " I ", '#', TeslaArsenal.itemteslariumingot, 'I',TeslaArsenal.itemtoolhandle});
		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.itemteslaaxe, 1), new Object[] {"## ", "#I ", " I ", '#', TeslaArsenal.itemteslariumingot, 'I',TeslaArsenal.itemtoolhandle});
		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.itemteslashovel, 1), new Object[] {" # ", " I ", " I ", '#',TeslaArsenal.itemteslariumingot, 'I',TeslaArsenal.itemtoolhandle});
		//GameRegistry.addRecipe(new ItemStack(TeslaArsenal.itemteslasword, 1), new Object[] {" # ", " # ", " I ", '#', TeslaArsenal.itemteslariumingot, 'I',TeslaArsenal.itemironstick});
		//GameRegistry.addRecipe(new ItemStack(TeslaArsenal.itemteslahoe, 1), new Object[] {"## ", " I ", " I ", '#', TeslaArsenal.itemteslariumingot, 'I',TeslaArsenal.itemironstick});

		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.itemtoolhandle, 1), new Object[] {"   ", " I ", " I ",'I', Items.IRON_INGOT});
		GameRegistry.addSmelting(TeslaArsenal.itemteslariumdust, new ItemStack(TeslaArsenal.itemteslariumingot), 1.0F);

		GameRegistry.addShapelessRecipe(new ItemStack(TeslaArsenal.itemnetherstardust , 3), new Object[] {Items.NETHER_STAR});
		GameRegistry.addShapelessRecipe(new ItemStack(TeslaArsenal.itemteslariumdust , 1), new Object[] {TeslaArsenal.itemnetherstardust, Items.ENDER_PEARL});

		
		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.energizedArmorHelmet, 1), new Object[] {"###", "# #", "   ", '#', TeslaArsenal.itemteslariumingot});
		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.energizedArmorChestplate, 1), new Object[] {"# #", "###", "###", '#', TeslaArsenal.itemteslariumingot});
		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.energizedArmorLeggings, 1), new Object[] {"# #", "# #", "###", '#', TeslaArsenal.itemteslariumingot});
		GameRegistry.addRecipe(new ItemStack(TeslaArsenal.energizedArmorBoots, 1), new Object[] {"   ", "# #", "# #", '#', TeslaArsenal.itemteslariumingot});

		
		
		
		
		
		
	}	
	
	}
