package satisfy.dragonflame;

import dev.architectury.hooks.item.tool.AxeItemHooks;
import net.minecraft.world.level.block.Blocks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import satisfy.dragonflame.config.DragonflameConfig;
import satisfy.dragonflame.registry.*;
import satisfy.dragonflame.world.dimension.DragonIslandDimension;

public class Dragonflame {

	public static final String MOD_ID = "dragonflame";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static void init() {
		DragonflameConfig.DEFAULT.getConfig();
		//ParticleRegistry.init();
		ObjectRegistry.init();
		BoatAndSignRegistry.init();
		BlockEntityRegistry.init();
		ScreenhandlerTypeRegistry.init();
		SoundEventRegistry.init();
		TabRegistry.init();
		EntityRegistry.init();
		MobEffectRegistry.init();
		EnchantmentRegistry.init();
		PlacerTypesRegistry.init();
		EventRegistry.init();
	}

	public static void commonSetup(){
		DragonflameProperties.init();
		AxeItemHooks.addStrippable(ObjectRegistry.DRAGON_LOG.get(), ObjectRegistry.STRIPPED_DRAGON_LOG.get());
		AxeItemHooks.addStrippable(ObjectRegistry.DRAGON_WOOD.get(), ObjectRegistry.STRIPPED_DRAGON_WOOD.get());
	}
}