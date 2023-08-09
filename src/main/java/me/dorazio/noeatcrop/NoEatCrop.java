package me.dorazio.noeatcrop;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class NoEatCrop implements ModInitializer {
	@Override
	public void onInitialize() {
		UseItemCallback.EVENT.register((PlayerEntity player, World world, Hand hand) -> {
			if (player.getStackInHand(hand).getItem() == Items.POTATO || player.getStackInHand(hand).getItem() == Items.CARROT) {
				return new TypedActionResult<>(ActionResult.FAIL, player.getStackInHand(hand));
			}
			return new TypedActionResult<>(ActionResult.PASS, player.getStackInHand(hand));
		});
	}
}