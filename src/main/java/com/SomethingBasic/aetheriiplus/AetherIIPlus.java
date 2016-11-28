package com.SomethingBasic.aetheriiplus;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.SomethingBasic.aetheriiplus.common.CommonProxy;
import com.SomethingBasic.aetheriiplus.common.items.Items;

@Mod(name = AetherIIPlus.NAME, version = AetherIIPlus.VERSION, modid = AetherIIPlus.MOD_ID)
public class AetherIIPlus 
{
	@Instance(AetherIIPlus.MOD_ID)
	public static AetherIIPlus INSTANCE;
	
	@SidedProxy(clientSide = AetherIIPlus.CLIENT_PROXY, serverSide = AetherIIPlus.SERVER_PROXY)
	public static CommonProxy proxy;
	
	/**Don't touch this unless you feel like changing the name, version or modid. I think that defeats the purpose of this message though.**/
	public static final String NAME = "Aether II+", VERSION = "Unidentified", MOD_ID = "aetheriiplus", CLIENT_PROXY = "com.SomethingBasic.aetheriiplus.client.ClientProxy", SERVER_PROXY = "com.SomethingBasic.aetheriiplus.common.CommonProxy";
	
	private Logger logger = LogManager.getLogger("Aether II+");
	
	@EventHandler
	/**
	 * FML pre-initialization.
	 * 
	 * @param event
	 */
	public void preInit(FMLPreInitializationEvent event)
	{
		logger.info("Initiating Aether II+ pre-initialization...");
		
		logger.info("Initiating Aether II+ proxy pre-initialization...");
		proxy.preInit();
	}
	
	@EventHandler
	/**
	 * FML initialization.
	 * 
	 * @param event
	 */
	public void init(FMLInitializationEvent event)
	{
		logger.info("Initiating Aether II+ initialization...");
	
		logger.info("Loading Aether II+ content...");
		Items.init();
		
		logger.info("Initiating Aether II+ proxy initialization...");
		proxy.init();
	}
	
	@EventHandler
	/**
	 * FML post-initialization.
	 * 
	 * @param event
	 */
	public void postInit(FMLPostInitializationEvent event)
	{
		logger.info("Initiating Aether II+ post-initialization...");		
		
		logger.info("Initiating Aether II+ proxy post-initialization...");
		proxy.postInit();
		
		logger.info("Aether II+ initialization complete.");
	}
	
	/**
	 * @return Aether II+ logger object.
	 */
	public Logger getLogger()
	{
		return logger != null ? logger : LogManager.getLogger("Aether II+");
	}
}
