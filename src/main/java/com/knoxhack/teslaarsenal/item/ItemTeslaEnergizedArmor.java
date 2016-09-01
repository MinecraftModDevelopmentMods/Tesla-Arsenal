package com.knoxhack.teslaarsenal.item;

import com.knoxhack.teslaarsenal.TeslaArsenal;
import com.knoxhack.teslaarsenal.TeslaArsenalTeslaUtilities;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

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
	
	
    @Override
    public void onArmorTick(World world, EntityPlayer player,ItemStack stack ){
    		if (TeslaArsenalTeslaUtilities.getStoredPower(stack) > cost)
    		if (stack.getItem()== TeslaArsenal.energizedArmorChestplate){
    		  if (world.isRemote) {
    			  if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown()){
    				  player.motionY += 0.1;
    				  player.motionY = Math.min(( player.motionY), (1));
    				  
    				  player.motionY *= 1.1;
    				  player.motionY = Math.min(( player.motionX), (1));
    				  
    				  player.motionY *= 1.1;
    				  player.motionY = Math.min(( player.motionZ), (1));
    				      			  
    				  world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY, player.posZ, 0, 0, 0, 0);

    			  
    			  }
    		  }   else {
    			  player.fallDistance = -(float)player.motionY * 4;
    		  }
    	
    		
    		}
    }
    		
    		
    
    
    
	
	
	
	
	
}
