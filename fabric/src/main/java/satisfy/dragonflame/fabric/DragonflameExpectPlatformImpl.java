package satisfy.dragonflame.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class DragonflameExpectPlatformImpl {

    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
