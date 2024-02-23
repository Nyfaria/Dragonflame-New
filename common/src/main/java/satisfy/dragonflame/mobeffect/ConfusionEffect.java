package satisfy.dragonflame.mobeffect;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class ConfusionEffect extends MobEffect {
    private double rotationDirection, motionDirection;

    public ConfusionEffect() {
        super(MobEffectCategory.HARMFUL, 0);
    }

    @Override
    public void applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {
        this.distractEntity(livingEntity);

        this.applyBleeding(livingEntity, amplifier);
    }

    private void distractEntity(LivingEntity livingEntity) {
        double gaussian = livingEntity.level().getRandom().nextGaussian();
        double newMotionDirection = 0.1 * gaussian;
        double newRotationDirection = (Math.PI / 2.0) * gaussian;

        this.rotationDirection = 0.245 * newRotationDirection + (1.1 - 0.245) * this.rotationDirection;
        livingEntity.setYRot((float) (livingEntity.getYRot() + this.rotationDirection));
        livingEntity.setXRot((float) (livingEntity.getXRot() + this.rotationDirection));

        this.motionDirection = 0.15 * newMotionDirection + 0.6 * this.motionDirection;
        livingEntity.setDeltaMovement(livingEntity.getDeltaMovement().add(this.motionDirection, 0, this.motionDirection));

        if (livingEntity.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, Items.RED_CONCRETE.getDefaultInstance()),
                    livingEntity.getX(), livingEntity.getY() + livingEntity.getBbHeight() * 0.8, livingEntity.getZ(),
                    1, 0.0, 0.0, 0.0, 0.0);
        }
    }

    private void applyBleeding(LivingEntity livingEntity, int amplifier) {
        livingEntity.hurt(livingEntity.damageSources().generic(), 0.5F);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
