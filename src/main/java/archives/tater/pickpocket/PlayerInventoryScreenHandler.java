package archives.tater.pickpocket;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import org.jetbrains.annotations.Nullable;

public class PlayerInventoryScreenHandler implements MenuProvider {
    private final Player targetPlayer;

    public PlayerInventoryScreenHandler(Player targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    @Override
    public Component getDisplayName() {
        return targetPlayer.getName();
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new ChestMenu(MenuType.GENERIC_9x4, syncId, playerInventory, targetPlayer.getInventory(), 4);
    }
}
