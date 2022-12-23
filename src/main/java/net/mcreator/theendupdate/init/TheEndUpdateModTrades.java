
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.theendupdate.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TheEndUpdateModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Blocks.MANGROVE_PLANKS), new ItemStack(Blocks.BLACKSTONE_WALL),
					new ItemStack(Blocks.BIRCH_WOOD), 10, 5, 0.05f));
		}
	}
}
