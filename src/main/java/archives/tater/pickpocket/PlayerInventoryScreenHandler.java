package archives.tater.pickpocket;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class PlayerInventoryScreenHandler implements NamedScreenHandlerFactory {
    private final PlayerEntity targetPlayer;

    public PlayerInventoryScreenHandler(PlayerEntity targetPlayer) {
        this.targetPlayer = targetPlayer;
    }

    @Override
    public Text getDisplayName() {
        return targetPlayer.getName();
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new GenericContainerScreenHandler(ScreenHandlerType.GENERIC_9X4, syncId, playerInventory, targetPlayer.getInventory(), 4);
    }
}
