package com.knoxhack.teslaarsenal.item;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Sets;
import com.knoxhack.teslaarsenal.TeslaArsenal;
import com.sun.istack.internal.Nullable;

import gnu.trove.set.hash.THashSet;
import net.darkhax.tesla.api.ITeslaConsumer;
import net.darkhax.tesla.api.ITeslaHolder;
import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.darkhax.tesla.capability.TeslaCapabilities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Loader;


public class ItemTeslaPickaxe extends ItemPickaxe {

	
	




	private BaseTeslaContainer container;
	private int TYPE_CREATIVE = 1;

    private static final Set<Material> effectiveMaterials = Sets.newHashSet(Material.ANVIL, Material.CLAY, Material.CRAFTED_SNOW, Material.GLASS, Material.DRAGON_EGG, Material.GRASS, Material.GROUND, Material.ICE, Material.SNOW, Material.IRON, Material.ROCK, Material.SAND, Material.CORAL, Material.WOOD, Material.CLOTH, Material.GOURD);

    private static final ToolTier tier = ToolTier.FLUX_CRUSHER;


	public THashSet<Block> effectiveBlocksCharged = new THashSet<Block>();
	public int energyPerUse = 200;


	public ItemTeslaPickaxe(ToolMaterial material, Enchantment enchantment) {
		super(material);
		
		
	
        this.setCreativeTab(TeslaArsenal.tab);
        this.setUnlocalizedName("teslaarsenal.itemteslapickaxe");
        this.setMaxStackSize(1);
        this.getItemEnchantability();
        this.setMaxDamage(5000);
        
        
        
        
        
        
	}
    

	public ItemTeslaPickaxe() {
        super(tier.material);
		
	}

	
	
    public int getItemEnchantability(Enchantment unbreaking) {
        return this.toolMaterial.getEnchantability();
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

	    
	    @Override
	    public boolean showDurabilityBar(ItemStack stack) {
	        return true;
	    }


	    @Override
	    public double getDurabilityForDisplay(ItemStack stack) {
	        return 1d - ((double) getEnergyStored(stack) / (double) getMaxEnergyStored(stack));
	    }

	


	    private double getMaxEnergyStored(ItemStack stack2) {
			// TODO Auto-generated method stub
			return 0;
		}






		private double getEnergyStored(ItemStack stack) {
			// TODO Auto-generated method stub
			return container.getStoredPower();
		}






		@Override
	    public boolean isDamaged(ItemStack stack) {
	        return stack.getItemDamage() != TYPE_CREATIVE;
	    }

	    @Override
	    public void setDamage(ItemStack stack, int damage) {
	        // NO OP
	    }

	    @Override
	    public boolean isDamageable() {
	        return true;
	    }

	    @Override
	    public boolean isRepairable() {
	        return false;
	    }


	    	
	    	

	    
	    
	    



		class TeslaEnergy implements ITeslaHolder, ITeslaConsumer {
	        private ItemStack stack;

	        public TeslaEnergy(ItemStack stack) {
	            this.stack = stack;
	        }

	        @Override
	        public long getStoredPower() {
	            return (long) getEnergyStored(stack);
	        }

	        private long getEnergyStored(ItemStack stack2) {
				return container.getStoredPower();
			}

			@Override
	        public long getCapacity() {
	            return (long) getMaxEnergyStored(stack);
	        }

	        private long getMaxEnergyStored(ItemStack stack2) {
				return container.getCapacity();
			}

			@Override
	        public long givePower(long power, boolean simulated) {
	            return receiveEnergy(stack, (int) power, simulated);
	        }
	    }








		public long receiveEnergy(ItemStack stack, int power, boolean simulated) {
			return container.getInputRate();
		}


	    class ToolCapabilityProvider implements ICapabilityProvider {
	        private ItemStack stack;

	        public ToolCapabilityProvider(ItemStack stack) {
	            this.stack = stack;
	        }

	        @Override
	        public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
	            return TeslaArsenal.hasTesla() && (capability == TeslaCapabilities.CAPABILITY_HOLDER || capability == TeslaCapabilities.CAPABILITY_CONSUMER);
	        }

	        @SuppressWarnings("unchecked")
			@Override
	        public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
	            if (TeslaArsenal.hasTesla() && (capability == TeslaCapabilities.CAPABILITY_HOLDER || capability == TeslaCapabilities.CAPABILITY_CONSUMER)) {
	                return (T) new TeslaEnergy(stack);
	            }

	            return null;
	        }
	    
	    }
	    
	    @Override
	    public int getHarvestLevel(ItemStack stack, String toolClass) {
	        if(getToolClasses(stack).contains(toolClass) && getEnergyStored(stack) >= tier.energyPerBlock)
	            return super.getHarvestLevel(stack, toolClass);
	        else
	            return -1;
	    }

	    @SuppressWarnings("deprecation")
		public boolean canHarvestBlock(Block block, ItemStack stack2) {
	        return getEnergyStored(stack2) >= getEnergyPerUseWithMode(stack2) && effectiveMaterials.contains(block.getMaterial(null));
	    }

	    private int getEnergyPerUseWithMode(ItemStack stack2){
	        int energy = getEnergyPerUse(stack2);
	        switch (getMode(stack2)){
	            case 0: break;
	            case 1: energy = energy * 5; break;
	            case 2: energy = energy * 10; break;
	        }
	        return energy;
	    }


	    public int getMode(ItemStack stack){
	        if(!tier.hasModes) return 0;
	        if(getEnergyStored(stack) == 0) return 0;
	        if(stack.getTagCompound() == null) return 0;

	            return 0;
	        }
	    

		private int getEnergyPerUse(ItemStack stack) {
			// TODO Auto-generated method stub
			return energyPerUse;
		}


		@SuppressWarnings("deprecation")
		public float func_150893_a(ItemStack stack, Block block) {
	        return getEnergyStored(stack) >= getEnergyPerUseWithMode(stack) && effectiveMaterials.contains(block.getMaterial(null)) ? efficiencyOnProperMaterial : 1.0F;
	    }
	    

	}
	    
	    

	    
	    

	

