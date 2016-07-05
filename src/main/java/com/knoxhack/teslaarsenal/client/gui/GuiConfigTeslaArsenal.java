package com.knoxhack.teslaarsenal.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import com.knoxhack.teslaarsenal.TeslaArsenalConfig;
import com.knoxhack.teslaarsenal.lib.Constants;
public class GuiConfigTeslaArsenal extends GuiConfig {
    
    private static Configuration cfg = TeslaArsenalConfig.config;
    
    public GuiConfigTeslaArsenal(GuiScreen parent) {
        
        super(parent, generateConfigList(), Constants.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(cfg.toString()));
    }
    

    public static List<IConfigElement> generateConfigList () {
        
        final ArrayList<IConfigElement> elements = new ArrayList<IConfigElement>();
        
        for (final String name : cfg.getCategoryNames())
            elements.add(new ConfigElement(cfg.getCategory(name)));
            
        return elements;
    }
}