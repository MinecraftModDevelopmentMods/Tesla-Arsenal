package com.knoxhack.teslaarsenal.item;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.minecraft.nbt.NBTTagCompound;

public class ItemTeslaContainer2 extends BaseTeslaContainer {
    public ItemTeslaContainer2() {
        this(5000,50,0);
    }

    public ItemTeslaContainer2(long capacity, long input, long output) {
        this(0,capacity,input,output);
    }

    public ItemTeslaContainer2(long power, long capacity, long input, long output) {
        super(power, capacity, input, output);
    }

    public ItemTeslaContainer2(NBTTagCompound dataTag) {
        super(dataTag);
    }

    public boolean canUseEnergy(long input) {
        return input <= getStoredPower();
    }
}