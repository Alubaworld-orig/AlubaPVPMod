package com.aluba.pvp;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderNameplateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;

public class EnemyStats {

    @SubscribeEvent
    public void onRenderName(RenderNameplateEvent event) {
        if (event.getEntity() instanceof PlayerEntity) {
            PlayerEntity target = (PlayerEntity) event.getEntity();
            
            // Считаем ХП и Броню
            float hp = target.getHealth();
            int armor = target.getTotalArmorValue();

            // Создаем красивую строчку: HP: 20 | Armor: 10
            String info = TextFormatting.RED + "❤ " + (int)hp + " " + TextFormatting.BLUE + "🛡 " + armor;
            
            // Добавляем эту строчку к имени игрока
            event.setContent(new StringTextComponent(event.getContent().getString() + " | " + info));
        }
    }
}
