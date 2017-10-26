package io.github.lukas2005.DeviceModApps;

import java.util.HashMap;

import com.mrcrayfish.device.api.utils.RenderUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author lukas2005
 *
 */
public enum Emoji
{
	CHROME('ﻼ'),
	SMILE('ﻻ');
	
    public static final ResourceLocation ICON_ASSET = new ResourceLocation(Reference.MOD_ID,"textures/gui/emoji.png");

    public static final int ICON_SIZE = 10;
    public static final int GRID_SIZE = 2;

    public static HashMap<Character, Emoji> emojiMapping = new HashMap<>(); 

    public char assignedChar;
    
    private Emoji(char assignedChar) {
    	this.assignedChar = assignedChar;
	}
    
    public static void init() {
    	CHROME.addToMapping();
    	SMILE.addToMapping();
    }
    
    public int getU()
    {
        return (ordinal() % GRID_SIZE) * ICON_SIZE;
    }

    public int getV()
    {
        return (ordinal() / GRID_SIZE) * ICON_SIZE;
    }

    public void draw(Minecraft mc, float x, float y)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(ICON_ASSET);
        RenderUtil.drawRectWithTexture(x, y, getU(), getV(), ICON_SIZE, ICON_SIZE, ICON_SIZE, ICON_SIZE, 200, 200);
    }

    public void addToMapping() {
    	emojiMapping.put(assignedChar, this);
    }
    
}