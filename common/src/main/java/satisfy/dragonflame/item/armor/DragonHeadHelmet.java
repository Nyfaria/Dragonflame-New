package satisfy.dragonflame.item.armor;

import de.cristelknight.doapi.common.item.CustomHatItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import satisfy.dragonflame.registry.ArmorRegistry;
import satisfy.dragonflame.util.DragonflameIdentifier;

import java.util.List;


public class DragonHeadHelmet extends CustomHatItem {
    public DragonHeadHelmet(ArmorMaterial material, Properties settings) {
        super(material, Type.HELMET, settings);
    }

    @Override
    public ResourceLocation getTexture() {
        return new DragonflameIdentifier("textures/models/armor/dragon_head_helmet.png");
    }

    @Override
    public Float getOffset() {
        return -1.5f;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, @NotNull List<Component> tooltip, TooltipFlag context) {
        Component combined1 = Component.literal("")
                .append(Component.translatable("tooltip.dragonflame.equip").withStyle(ChatFormatting.GRAY))
                .append(Component.translatable("item.dragonflame.tooltip1." + this.getDescriptionId()).withStyle(ChatFormatting.GREEN));
        tooltip.add(combined1);
        Component combined2 = Component.literal("")
                .append(Component.translatable("tooltip.dragonflame.equip").withStyle(ChatFormatting.GRAY))
                .append(Component.translatable("item.dragonflame.tooltip2." + this.getDescriptionId()).withStyle(ChatFormatting.GREEN));
        tooltip.add(combined2);
        Component combined3 = Component.literal("")
                .append(Component.translatable("tooltip.dragonflame.equip").withStyle(ChatFormatting.GRAY))
                .append(Component.translatable("item.dragonflame.tooltip3." + this.getDescriptionId()).withStyle(ChatFormatting.GREEN));
        tooltip.add(combined3);
        tooltip.add(Component.empty());
        tooltip.add(Component.translatable("lore.dragonflame.dragon_head_helmet").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
    }
}