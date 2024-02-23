package satisfy.dragonflame.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import satisfy.dragonflame.util.DragonflameIdentifier;

public class LootChestScreen extends AbstractContainerScreen<LootChestScreenhandler> {
    private static final ResourceLocation CONTAINER_LOCATION = new DragonflameIdentifier("textures/gui/lootchest.png");
    public LootChestScreen(LootChestScreenhandler abstractContainerMenu, Inventory inventory, Component component) {
        super(abstractContainerMenu, inventory, component);
    }

    protected void init() {
        super.init();
        this.titleLabelX = (this.imageWidth - this.font.width(this.title)) / 2;
    }

    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, i, j, f);
        this.renderTooltip(guiGraphics, i, j);
    }

    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        int k = (this.width - this.imageWidth) / 2;
        int l = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(CONTAINER_LOCATION, k, l, 0, 0, this.imageWidth, this.imageHeight);
    }
}