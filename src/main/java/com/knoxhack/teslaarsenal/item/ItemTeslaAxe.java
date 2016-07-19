package com.knoxhack.teslaarsenal.item;
import com.google.common.collect.Sets;
import com.knoxhack.teslaarsenal.ModInfo;
import com.knoxhack.teslaarsenal.TeslaArsenal;
import com.knoxhack.teslaarsenal.TeslaArsenalTeslaUtilities;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;
public class ItemTeslaAxe extends ItemTesla
{
    public long cost = 10;
    public static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE});

    public ItemTeslaAxe()
    {
        super(0F, 0F, ToolMaterial.DIAMOND, EFFECTIVE_ON, 10000, 200, 200);
        setUnlocalizedName("teslaarsenal.itemteslaaxe");
        setRegistryName("itemteslaaxe");
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
    	TeslaArsenalTeslaUtilities.usePower(stack, cost);
        return true;
    }

    @Override
    public boolean canHarvestBlock(IBlockState state)
    {
        return Items.DIAMOND_AXE.canHarvestBlock(state);
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        if (TeslaArsenalTeslaUtilities.getStoredPower(stack) < cost)
        {
            return 0.5F;
        }
        if (Items.WOODEN_AXE.getStrVsBlock(stack, state) > 1.0F )
        {
            return 5.5F;
        }
        else
        {
            return super.getStrVsBlock(stack, state);
        }
    }
}