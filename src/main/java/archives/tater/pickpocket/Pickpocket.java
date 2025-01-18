package archives.tater.pickpocket;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pickpocket implements ModInitializer {
	public static final String MOD_ID = "pickpocket";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		UseEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if (!player.shouldCancelInteraction() || !(entity instanceof PlayerEntity targetPlayer)) return ActionResult.PASS;
			player.openHandledScreen(new PlayerInventoryScreenHandler(targetPlayer));
			return ActionResult.SUCCESS;
		});
	}
}
