package com.SomethingBasic.aetheriiplus.common.blocks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.SomethingBasic.aetheriiplus.AetherIIPlus;

public class Blocks 
{
	private static Map<Block, ItemBlock> blocks;
	//public static Block MY_BLOCK;
	//public static ItemBlock MY_BLOCK_ITEM;
	
    public static void init()
    {
    	blocks = new HashMap<Block, ItemBlock>();
    	
    	//MY_BLOCK = new Block(Material.?).setRegistryName("myblock");
    	//MY_BLOCK_ITEM = new ItemBlock(MY_BLOCK);
    	//MY_BLOCK_ITEM.setRegistryName("myblock");
    	//blocks.put(MY_BLOCK, MY_BLOCK_ITEM);
    	
    	AetherIIPlus.INSTANCE.getLogger().info("Registering blocks...");
    	
    	register();
    }
    
    private static void register()
    {
    	Iterator iterator = blocks.entrySet().iterator();
    	
    	while(iterator.hasNext())
    	{
            Entry pair = (Entry)iterator.next();
          
            Block block = (Block)pair.getKey();
            ItemBlock item = (ItemBlock)pair.getValue();
            
        	if(block.getRegistryName() == null)
        	{
        		AetherIIPlus.INSTANCE.getLogger().info("Setting registry name for block " + block.getUnlocalizedName().substring(5));
        		
        		block.setRegistryName(generateRegistryName(block));
        	}
        	
        	AetherIIPlus.INSTANCE.getLogger().info("Registering block " + block.getRegistryName());
        	
        	GameRegistry.register(block);
        	
        	if(item.getRegistryName() == null)
        	{
        		AetherIIPlus.INSTANCE.getLogger().info("Setting registry name for itemblock " + item.getUnlocalizedName().substring(5));
        		
        		item.setRegistryName(generateRegistryName(item));
        	}
        	
        	AetherIIPlus.INSTANCE.getLogger().info("Registering itemblock " + item.getRegistryName());
        	
        	GameRegistry.register(item);
        }
    }
    
    public static Map<Block, ItemBlock> getBlocks()
    {
    	return blocks != null ? blocks : new HashMap<Block, ItemBlock>();
    }
    
    @Deprecated
    /**
     * Generates a registry name.
     */
    private static String generateRegistryName(Object object)
    {
    	Random random = new Random();
    	int i = random.nextInt(99999 - 10000) + 10000;
    	
    	if(object instanceof Block)
    	{
    		Block block = (Block)object;
    		
        	if(block.getUnlocalizedName().equals("tile.null"))
        	{
        		AetherIIPlus.INSTANCE.getLogger().error("IMPORTANT: A BLOCK WITHOUT A REGISTRY OR UNLOCALIZED NAME HAS REQUESTED A REGISTRY NAME, WHICH WILL BE RANDOMIZED IN THIS CASE!");
        	}
        	
        	return !block.getUnlocalizedName().equals("tile.null") ? block.getUnlocalizedName().substring(5) : "null" + i;
    	}
    	else if(object instanceof ItemBlock)
     	{
            ItemBlock item = (ItemBlock)object;
    		
        	if(item.getUnlocalizedName().equals("item.null"))
        	{
        		AetherIIPlus.INSTANCE.getLogger().error("IMPORTANT: AN ITEMBLOCK WITHOUT A REGISTRY OR UNLOCALIZED NAME HAS REQUESTED A REGISTRY NAME, WHICH WILL BE RANDOMIZED IN THIS CASE!");
        	}
        	
        	return !item.getUnlocalizedName().equals("item.null") ? item.getUnlocalizedName().substring(5) : "null" + i;
    	}
    	
    	return "you:areanidiot";
    }
}
