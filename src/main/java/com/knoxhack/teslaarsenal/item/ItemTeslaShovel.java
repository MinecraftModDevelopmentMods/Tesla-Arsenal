package com.knoxhack.teslaarsenal.item;

import java.util.List;

import com.knoxhack.teslaarsenal.TeslaArsenal;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.ICapabilityProvider;


public class ItemTeslaShovel extends ItemPickaxe {

	
	

	public ItemTeslaShovel(ToolMaterial material) {
		super(material);
		
		
	
        this.setCreativeTab(TeslaArsenal.tab);
        this.setUnlocalizedName("teslaarsenal.itemteslashovel");
        this.setMaxStackSize(1);
        
        
        
        
	}
    

	   @Override
	    public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	        
	        super.addInformation(stack, playerIn, tooltip, advanced);
	        final BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
	        
	        tooltip.add(I18n.format("tooltip.teslaarsenal.itemteslashovel.normal", container.getStoredPower(), container.getCapacity()));
	    }
	    
	    @Override
	    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) {
	        
	        return new BaseTeslaContainerProvider(new BaseTeslaContainer());
	    }
	
	
	
}
