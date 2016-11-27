package com.SomethingBasic.aetheriiplus.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.SomethingBasic.aetheriiplus.AetherIIPlus;
import com.SomethingBasic.aetheriiplus.common.CommonProxy;

/**
 * Use this to add stuff that only the client should have, such as renderers.
 */
public class ClientProxy extends CommonProxy
{
    /**
     * @see CommonProxy.java
     */
    @Override
    public void preInit()
    {
    	
    }
    
    /**
     * @see CommonProxy.java
     */
    @Override
    public void init()
    {
        //registerItemRenderer() should happen HERE!
    }
    
    /**
     * @see CommonProxy.java
     */
    @Override
    public void postInit()
    {
    	
    }
    
    /**
     * This method registers an item/block renderer.
     * If you call this in AetherIIPlus.java I will kill you.
     * 
     * @param object The item/block you wish to register the model for.
     */
    public static void registerRenderer(Object object)
    {
    	if(object instanceof Item)
    	{
    		Item item = (Item)object;
    		
    		AetherIIPlus.INSTANCE.getLogger().info("Registering renderer for ITEM " + item.getUnlocalizedName().substring(5));
    		
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    	}
    	else if(object instanceof Block)
    	{
    		Block block = (Block)object;
    		
    		AetherIIPlus.INSTANCE.getLogger().info("Registering renderer for BLOCK " + block.getUnlocalizedName().substring(5));
    		
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    	}
    	else
    	{
    		//Some idiot is registering a renderer for something that isn't a block nor item.
    		return;
    	}
    }
}
