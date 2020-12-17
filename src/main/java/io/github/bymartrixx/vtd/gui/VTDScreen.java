package io.github.bymartrixx.vtd.gui;

import com.google.gson.JsonObject;
import io.github.bymartrixx.vtd.VTDMod;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;

public class VTDScreen extends Screen {
    private final Screen previousScreen;

    public VTDScreen(Screen previousScreen) {
        super(new LiteralText("VTDownloader"));
        this.previousScreen = previousScreen;
    }

    public void onClose() {
        this.client.openScreen(this.previousScreen);
    }

    protected void init() {
        this.addButton(new ButtonWidget(this.width - 130, this.height - 30, 120, 20, new LiteralText("Done"), button -> this.onClose()));

        for (int i = 0; i < VTDMod.categories.size(); ++i) {
            JsonObject category = VTDMod.categories.get(i).getAsJsonObject();
            String categoryName = category.get("category").getAsString();

            this.addButton(new ButtonWidget(i * 130 + 10, 10, 120, 20, new LiteralText(categoryName), button -> {
                // TODO
            }));
        }
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackgroundTexture(0);
        super.render(matrices, mouseX, mouseY, delta);
    }
}
