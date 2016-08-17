package com.knoxhack.teslaarsenal.item;

import java.util.List;

import com.knoxhack.teslaarsenal.BaseTeslaArsenalTeslaContainerProvider;
import com.knoxhack.teslaarsenal.TeslaArsenalTeslaUtilities;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.lib.TeslaUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

public class ItemTeslaArmor extends ItemArmor {

	private long maxCapacity;
	private long output;
	private long input;
	
	
	
	public ItemTeslaArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, long maxCapacity, long input, long output) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		setMaxStackSize(1);
		this.maxCapacity = maxCapacity;
		this.output = output;
		this.input = input;
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	@Override public boolean isRepairable()
	{
		return false;
	}
	
	
	@Override public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
	{
		ItemStack powered = TeslaArsenalTeslaUtilities.createChargedStack(new ItemStack(itemIn));
		ItemStack unpowered = new ItemStack(itemIn);
		subItems.add(powered);
		subItems.add(unpowered);
	}
	
	
	
	@Override public double getDurabilityForDisplay(ItemStack stack)
	{
		return (1 - (double) TeslaArsenalTeslaUtilities.getStoredPower(stack) / (double) TeslaArsenalTeslaUtilities.getMaxCapacity(stack));
}

	@Override public boolean showDurabilityBar(ItemStack stack)
	{
		return true;
	}

    @Override
    public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        
        TeslaUtils.createTooltip(stack, tooltip);
    }
	
	@Override public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt)
	{
		return new BaseTeslaArsenalTeslaContainerProvider(new BaseTeslaContainer(), maxCapacity, output, input);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
