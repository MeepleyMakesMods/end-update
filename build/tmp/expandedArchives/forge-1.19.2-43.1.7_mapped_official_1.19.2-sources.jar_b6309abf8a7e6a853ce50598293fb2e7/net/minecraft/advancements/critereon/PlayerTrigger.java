package net.minecraft.advancements.critereon;

import com.google.gson.JsonObject;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class PlayerTrigger extends SimpleCriterionTrigger<PlayerTrigger.TriggerInstance> {
   final ResourceLocation id;

   public PlayerTrigger(ResourceLocation p_222616_) {
      this.id = p_222616_;
   }

   public ResourceLocation getId() {
      return this.id;
   }

   public PlayerTrigger.TriggerInstance createInstance(JsonObject p_222621_, EntityPredicate.Composite p_222622_, DeserializationContext p_222623_) {
      return new PlayerTrigger.TriggerInstance(this.id, p_222622_);
   }

   public void trigger(ServerPlayer p_222619_) {
      this.trigger(p_222619_, (p_222625_) -> {
         return true;
      });
   }

   public static class TriggerInstance extends AbstractCriterionTriggerInstance {
      public TriggerInstance(ResourceLocation p_222631_, EntityPredicate.Composite p_222632_) {
         super(p_222631_, p_222632_);
      }

      public static PlayerTrigger.TriggerInstance located(LocationPredicate p_222636_) {
         return new PlayerTrigger.TriggerInstance(CriteriaTriggers.LOCATION.id, EntityPredicate.Composite.wrap(EntityPredicate.Builder.entity().located(p_222636_).build()));
      }

      public static PlayerTrigger.TriggerInstance located(EntityPredicate p_222634_) {
         return new PlayerTrigger.TriggerInstance(CriteriaTriggers.LOCATION.id, EntityPredicate.Composite.wrap(p_222634_));
      }

      public static PlayerTrigger.TriggerInstance sleptInBed() {
         return new PlayerTrigger.TriggerInstance(CriteriaTriggers.SLEPT_IN_BED.id, EntityPredicate.Composite.ANY);
      }

      public static PlayerTrigger.TriggerInstance raidWon() {
         return new PlayerTrigger.TriggerInstance(CriteriaTriggers.RAID_WIN.id, EntityPredicate.Composite.ANY);
      }

      public static PlayerTrigger.TriggerInstance avoidVibration() {
         return new PlayerTrigger.TriggerInstance(CriteriaTriggers.AVOID_VIBRATION.id, EntityPredicate.Composite.ANY);
      }

      public static PlayerTrigger.TriggerInstance walkOnBlockWithEquipment(Block p_222638_, Item p_222639_) {
         return located(EntityPredicate.Builder.entity().equipment(EntityEquipmentPredicate.Builder.equipment().feet(ItemPredicate.Builder.item().of(p_222639_).build()).build()).steppingOn(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_222638_).build()).build()).build());
      }
   }
}