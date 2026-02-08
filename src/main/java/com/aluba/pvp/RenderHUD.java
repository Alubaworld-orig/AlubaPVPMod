package com.aluba.pvp;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderHUD {

    @SubscribeEvent
    public void onRenderGui(RenderGameOverlayEvent.Pre event) {
        // Убираем стандартный крестик
        if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            event.setCanceled(true); 
            
            MatrixStack matrixStack = event.getMatrixStack();
            int x = Minecraft.getInstance().getMainWindow().getScaledWidth() / 2;
            int y = Minecraft.getInstance().getMainWindow().getScaledHeight() / 2;

            // Рисуем красное кольцо (квадратик-заглушка, который мы потом закруглим)
            // Цвет в формате ARGB (0xFFFF0000 - ярко-красный)
            AbstractGui.fill(matrixStack, x - 2, y - 2, x + 2, y + 2, 0xFFFF0000);
        }
    }
}
