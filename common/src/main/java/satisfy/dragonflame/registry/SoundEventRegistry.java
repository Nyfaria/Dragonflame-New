package satisfy.dragonflame.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import satisfy.dragonflame.Dragonflame;
import satisfy.dragonflame.util.DragonflameIdentifier;

public class SoundEventRegistry {
    private static final Registrar<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Dragonflame.MOD_ID, Registries.SOUND_EVENT).getRegistrar();

    public static final RegistrySupplier<SoundEvent> LOOTCHEST_OPEN = create("lootchest_open");
    public static final RegistrySupplier<SoundEvent> LOOTCHEST_CLOSE = create("lootchest_close");
    public static final RegistrySupplier<SoundEvent> IMPROVED_RAID_HORN = create("improved_raid_horn");
    public static final RegistrySupplier<SoundEvent> DRAGON_WHELPLING_AMBIENT = create("dragon_whelpling_ambient");
    public static final RegistrySupplier<SoundEvent> DRAGON_WHELPLING_HURT = create("dragon_whelpling_hurt");
    public static final RegistrySupplier<SoundEvent> DRAGON_WHELPLING_DEATH = create("dragon_whelpling_death");
    public static final RegistrySupplier<SoundEvent> DRAGON_EGG_HATCH = create("dragon_egg_hatch");


    private static RegistrySupplier<SoundEvent> create(String name) {
        final ResourceLocation id = new DragonflameIdentifier(name);
        return SOUND_EVENTS.register(id, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void init() {
    }
}
