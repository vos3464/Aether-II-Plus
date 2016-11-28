package com.SomethingBasic.aetheriiplus.client;

import java.util.Iterator;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.SomethingBasic.aetheriiplus.AetherIIPlus;
import com.SomethingBasic.aetheriiplus.common.CommonProxy;
import com.SomethingBasic.aetheriiplus.common.blocks.Blocks;
import com.SomethingBasic.aetheriiplus.common.items.Items;

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
        for(Item item : Items.getItems())
        {
        	registerRenderer(item);
        }
        
        Iterator iterator = Blocks.getBlocks().entrySet().iterator();
    	
    	while(iterator.hasNext())
    	{
            Entry pair = (Entry)iterator.next();
          
            Block block = (Block)pair.getKey();
            
            registerRenderer(block);
    	}
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
     * If you call this in anywhere except ClientProxy, I will find you, and I will kill you.
     * 
     * @param object The item/block you wish to register the model for.
     */
    public static void registerRenderer(Object object)
    {
    	if(object instanceof Item)
    	{
    		Item item = (Item)object;
    		
    		AetherIIPlus.INSTANCE.getLogger().info("Registering renderer for ITEM " + item.getRegistryName());
    		
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    	}
    	else if(object instanceof Block)
    	{
    		Block block = (Block)object;
    		
    		AetherIIPlus.INSTANCE.getLogger().info("Registering renderer for BLOCK " + block.getRegistryName());
    		
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    	}
    	else
    	{
    		//Some idiot is registering a renderer for something that isn't a block nor item.
    		return;
    	}
    }
}
