package com.SomethingBasic.aetheriiplus.common.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.SomethingBasic.aetheriiplus.AetherIIPlus;

public class Items 
{
	private static List<Item> items;
	//public static Item MY_ITEM;
	
    public static void init()
    {
    	items = new ArrayList<Item>();
    	//items.add(MY_ITEM = new Item().setRegistryName("myitem"));
    	
    	AetherIIPlus.INSTANCE.getLogger().info("Registering items...");
    	
    	register();
    }
    
    private static void register()
    {
        for(Item item : items)
        {
        	if(item.getRegistryName() == null)
        	{
        		AetherIIPlus.INSTANCE.getLogger().info("Setting registry name for item " + item.getUnlocalizedName().substring(5));
        		
        		item.setRegistryName(generateRegistryName(item));
        	}
        	
        	AetherIIPlus.INSTANCE.getLogger().info("Registering item " + item.getRegistryName());
        	
        	GameRegistry.register(item);
        }
    }
    
    public static List<Item> getItems()
    {
    	return items != null ? items : new ArrayList<Item>();
    }
    
    @Deprecated
    /**
     * Generates a registry name.
     */
    private static String generateRegistryName(Item item)
    {
    	Random random = new Random();
    	int i = random.nextInt(99999 - 10000) + 10000;
    	
    	if(item.getUnlocalizedName().equals("item.null"))
    	{
    		AetherIIPlus.INSTANCE.getLogger().error("IMPORTANT: AN ITEM WITHOUT A REGISTRY OR UNLOCALIZED NAME HAS REQUESTED A REGISTRY NAME, WHICH WILL BE RANDOMIZED IN THIS CASE!");
    	}
    	
    	return !item.getUnlocalizedName().equals("item.null") ? item.getUnlocalizedName().substring(5) : "null" + i;
    }
}
