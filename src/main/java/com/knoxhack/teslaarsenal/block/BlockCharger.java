package com.knoxhack.teslaarsenal.block;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.knoxhack.teslaarsenal.TeslaArsenal;
import com.knoxhack.teslaarsenal.TeslaArsenalConfig;
import com.knoxhack.teslaarsenal.tileentity.TeslaArsenalContainer;
import com.knoxhack.teslaarsenal.tileentity.TileEntityCharger;
import net.darkhax.tesla.capability.TeslaCapabilities;


public class BlockCharger extends Block implements ITileEntityProvider {
    
    private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D);
    private static final int CHAT_ID = 47194716;
    
    public BlockCharger() {
        
        super(TeslaArsenalConfig.panelWaterDamage ? Material.CIRCUITS : Material.IRON);
        this.isBlockContainer = true;
        this.setUnlocalizedName("teslaarsenal.charger");
        this.setHardness(0.2F);
        this.setSoundType(SoundType.METAL);
        this.setCreativeTab(TeslaArsenal.tab);
        this.setLightOpacity(0);
    }
    
    @Override
    public boolean onBlockActivated (World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        
        if (worldIn.isRemote) {
            
            final TileEntity tile = worldIn.getTileEntity(pos);
            
            if (tile instanceof TileEntityCharger && !tile.isInvalid()) {
                
                final TileEntityCharger charger = (TileEntityCharger) tile;
                final TeslaArsenalContainer container = (TeslaArsenalContainer) charger.getCapability(TeslaCapabilities.CAPABILITY_HOLDER, EnumFacing.DOWN);
                
                sendSpamlessMessage(CHAT_ID, new TextComponentString(String.format(I18n.format("message.teslaarsenal.charger.status"), container.getStoredPower(), container.getCapacity(), TeslaArsenalConfig.chargerPowerGen)));
            }
        }
        
        return true;
    }
    
    @Override
    public void breakBlock (World worldIn, BlockPos pos, IBlockState state) {
        
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }
    
    @SuppressWarnings("deprecation")
	@Override
    public boolean eventReceived (IBlockState state, World worldIn, BlockPos pos, int id, int param) {
        
        super.eventReceived(state, worldIn, pos, id, param);
        final TileEntity tileentity = worldIn.getTileEntity(pos);
        return tileentity == null ? false : tileentity.receiveClientEvent(id, param);
    }
    
    @Override
    public TileEntity createNewTileEntity (World worldIn, int meta) {
        
        return new TileEntityCharger();
    }
    
    @Override
    public AxisAlignedBB getBoundingBox (IBlockState state, IBlockAccess source, BlockPos pos) {
        
        return BOUNDS;
    }
    
    @Override
    public boolean isFullCube (IBlockState state) {
        
        return false;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered (IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        
        return side == EnumFacing.UP ? true : blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? true : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
    
    @Override
    public boolean doesSideBlockRendering (IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
        
        return face == EnumFacing.DOWN;
    }
    

    @SideOnly(Side.CLIENT)
    private static void sendSpamlessMessage (int messageID, ITextComponent message) {
        
        final GuiNewChat chat = Minecraft.getMinecraft().ingameGUI.getChatGUI();
        chat.printChatMessageWithOptionalDeletion(message, messageID);
    }
}