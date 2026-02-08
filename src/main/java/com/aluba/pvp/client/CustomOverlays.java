package com.aluba.pvp.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CustomOverlays {

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Pre event) {
        // 1. Отключаем стандартный прицел
        if (event.getType() == RenderGameOverlayEvent.ElementType.CROSSHAIRS) {
            event.setCanceled(true); 

            // 2. Считаем центр экрана
            int x = Minecraft.getInstance().getMainWindow().getScaledWidth() / 2;
            int y = Minecraft.getInstance().getMainWindow().getScaledHeight() / 2;
            MatrixStack matrix = event.getMatrixStack();

            // 3. Рисуем "Кольцо" (4 линии вокруг центра)
            // Цвет 0xFFFF0000 — это непрозрачный красный
            int color = 0xFFFF0000;
            
            // Левая палочка
            AbstractGui.fill(matrix, x - 5, y - 1, x - 2, y + 1, color);
            // Правая
            AbstractGui.fill(matrix, x + 2, y - 1, x + 5, y + 1, color);
            // Верхняя
            AbstractGui.fill(matrix, x - 1, y - 5, x + 1, y - 2, color);
            // Нижняя
            AbstractGui.fill(matrix, x - 1, y + 2, x + 1, y + 5, color);
        }
    }
              }
