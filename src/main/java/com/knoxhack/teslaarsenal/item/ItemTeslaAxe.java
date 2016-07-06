package com.knoxhack.teslaarsenal.item;

import java.util.List;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemAxe;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

import com.knoxhack.teslaarsenal.TeslaArsenal;


public class ItemTeslaAxe extends ItemAxe {

	





	private EntityPlayer stack;
	private float attackDamageempty = 0.0F;
	private float attackDamagecharged = 8.0F;





	private float attackDamage;
	
	

	public ItemTeslaAxe(ToolMaterial material) {
		super(material);

        this.setCreativeTab(TeslaArsenal.tab);
        this.setUnlocalizedName("teslaarsenal.itemteslaaxe");
        this.setMaxStackSize(1);
        this.attackDamage = 3.0F + material.getDamageVsEntity();
        
	}
    

	   public float getDamageVsEntity() {
        final BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
        if(container.getStoredPower() > 0) {
            return attackDamagecharged;

        } else {
            return this.toolMaterial.getDamageVsEntity();
        }
    }
    
	
	
	
	
	
	
	
	
	
	
	
	
	   @Override
	    public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
	        
	        super.addInformation(stack, playerIn, tooltip, advanced);
	        final BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
	        
	        tooltip.add(I18n.format("tooltip.teslaarsenal.itemteslapickaxe.normal", container.getStoredPower(), container.getCapacity()));
	    }
	    
	    @Override
	    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) {
	        
	        return new BaseTeslaContainerProvider(new BaseTeslaContainer());
	    }


	    /*
	     * Class of the capability for our battery
	     */
	    public static class CapabilityProvider implements INBTSerializable<NBTTagCompound>, ICapabilityProvider {

	    	
	        private BaseTeslaContainer container;

	        public CapabilityProvider(ItemStack stack) {
	        }

	        @Override
	        public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
	            if (capability == TeslaCapabilities.CAPABILITY_HOLDER || capability == TeslaCapabilities.CAPABILITY_PRODUCER || capability == TeslaCapabilities.CAPABILITY_CONSUMER)
	                return true;
	            return false;
	        }
			@Override
	        public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

	            if (capability == TeslaCapabilities.CAPABILITY_HOLDER || capability == TeslaCapabilities.CAPABILITY_PRODUCER || capability == TeslaCapabilities.CAPABILITY_CONSUMER)
	                return (T) container;
	            return null;
	        }

	        @Override
	        public NBTTagCompound serializeNBT() {


	            if (container != null) {
	                NBTTagCompound compound = new NBTTagCompound();
	                NBTBase data = container.serializeNBT();
	                if (data != null) {
	                    compound.setTag("TAContainer", data);
	                }
	                return compound;
	            } else
	                return new NBTTagCompound();
	        }

	        @Override
	        public void deserializeNBT(NBTTagCompound nbt) {


	            if (container != null && nbt.hasKey("TAContainer"))
	                this.container = new BaseTeslaContainer(nbt);
	        }
	    }
	    
	    
	    
	    
	    @Override
	    public boolean showDurabilityBar(ItemStack stack) {
	        return true;
	    }


	    @Override
	    public double getDurabilityForDisplay(ItemStack stack) {
	        final BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);

	        return 1d - ((double) container.getStoredPower() / (double) container.getCapacity());
	    }


	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
