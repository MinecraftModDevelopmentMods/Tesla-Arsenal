package com.knoxhack.teslaarsenal.item;

import java.util.List;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import com.knoxhack.teslaarsenal.TeslaArsenal;
import net.minecraft.item.ItemPickaxe;


public class ItemTeslaSword extends ItemPickaxe {

	
	

	public ItemTeslaSword(ToolMaterial material) {
		super(material);
		
		
	
        this.setCreativeTab(TeslaArsenal.tab);
        this.setUnlocalizedName("teslaarsenal.itemteslasword");
        this.setMaxStackSize(1);
        
        
        
        
	}
    

    @Override
    public int getDamage(ItemStack stack) {
        if(stack.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN))
            return (int) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN).getStoredPower();
        else
            return super.getDamage(stack);
    }
	
    @Override
    public int getMaxDamage(ItemStack stack) {
        if(stack.hasCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN))
            return (int) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER,EnumFacing.DOWN).getCapacity()+1;
        else
            return super.getMaxDamage(stack);
    }
    
    
    
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        super.addInformation(stack, playerIn, tooltip, advanced);
        final BaseTeslaContainer container = (BaseTeslaContainer) stack.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
        
        tooltip.add(I18n.format("tooltip.teslaarsenal.itemteslasword.normal", container.getStoredPower(), container.getCapacity()));    }

    
    
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt) {
        return new CapabilityProvider(stack);
    }
    
    
    
    public static class CapabilityProvider implements INBTSerializable<NBTTagCompound>, ICapabilityProvider {
        private BaseTeslaContainer container;

        public CapabilityProvider(ItemStack stack) {

            this.container = new BaseTeslaContainer(10000, 500, 500);
        }

        @Override
        public boolean hasCapability(Capability<?> capability, EnumFacing facing) {


            if (capability == TeslaCapabilities.CAPABILITY_HOLDER || capability == TeslaCapabilities.CAPABILITY_PRODUCER || capability == TeslaCapabilities.CAPABILITY_CONSUMER)
                return true;
            return false;
        }
    
    
    
        @SuppressWarnings("unchecked")
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
                    compound.setTag("TaContainer5", data);
                }
                return compound;
            } else
                return new NBTTagCompound();
        }
    
    
        
        
        @Override
        public void deserializeNBT(NBTTagCompound nbt) {


            if (container != null && nbt.hasKey("TaContainer5"))
                this.container = new BaseTeslaContainer(nbt);
        }
    }
        
        
        
        
        
        
        
    
    
}
