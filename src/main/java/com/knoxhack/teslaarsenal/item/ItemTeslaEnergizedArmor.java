package com.knoxhack.teslaarsenal.item;

import com.knoxhack.teslaarsenal.TeslaArsenal;
import com.knoxhack.teslaarsenal.TeslaArsenalTeslaUtilities;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ItemTeslaEnergizedArmor extends ItemTeslaArmor {
	
	
    public long cost = 10;
	public ItemTeslaEnergizedArmor(ArmorMaterial material, EntityEquipmentSlot slot, long maxCapacity, long input, long output) {
		super(material, material.getDamageReductionAmount(slot), slot, maxCapacity, input, output);
		if (slot == EntityEquipmentSlot.HEAD)
			setUnlocalizedName( "teslaarsenal.energizedarmour.helmet");
		if (slot == EntityEquipmentSlot.CHEST)
			setUnlocalizedName( "teslaarsenal.energizedarmour.chestplate");
		if (slot == EntityEquipmentSlot.LEGS)
			setUnlocalizedName( "teslaarsenal.energizedarmour.leggings");
		if (slot == EntityEquipmentSlot.FEET)
			setUnlocalizedName( "teslaarsenal.energizedarmour.boots");
        setCreativeTab(TeslaArsenal.tab);
	
	}

	
	
	@Override
	public String getArmorTexture(ItemStack itemStack, Entity entity, EntityEquipmentSlot slot, String layer)
	{
		if(armorType == EntityEquipmentSlot.LEGS)
		{
			return "teslaarsenal:textures/armor/Tesla_armor_layer_2.png";
		}
		return "teslaarsenal:textures/armor/Tesla_armor_layer_1.png";
	}
	
	
	
    public int getDamage(ItemStack stack)
    {
    	TeslaArsenalTeslaUtilities.usePower(stack, cost);
    	
        return stack.getMaxDamage();
    }
	
	
	
	
	
	
	
	
}
