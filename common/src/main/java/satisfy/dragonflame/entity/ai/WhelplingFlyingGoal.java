package satisfy.dragonflame.entity.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.AirAndWaterRandomPos;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class WhelplingFlyingGoal extends Goal {
    protected final PathfinderMob mob;

    public WhelplingFlyingGoal(PathfinderMob mob) {
        this.setFlags(EnumSet.of(Flag.MOVE));
        this.mob = mob;
    }

    public boolean canUse() {
        return mob.getNavigation().isDone() && mob.getRandom().nextInt(10) == 0;
    }

    public boolean canContinueToUse() {
        return mob.getNavigation().isInProgress();
    }

    @Override
    public void tick() {
        super.tick();
        adjustFlyingHeight();
    }

    public void start() {
        Vec3 vec3 = this.findPos();
        if (vec3 != null) {
            mob.getNavigation().moveTo(mob.getNavigation().createPath(BlockPos.containing(vec3), 1), 1.0);
        }
    }

    @Nullable
    private Vec3 findPos() {
        Vec3 vec32;
        vec32 = mob.getViewVector(0.0F);

        boolean i = true;
        Vec3 vec33 = HoverRandomPos.getPos(mob, 8, 7, vec32.x, vec32.z, 1.5707964F, 3, 1);
        return vec33 != null ? vec33 : AirAndWaterRandomPos.getPos(mob, 8, 4, -2, vec32.x, vec32.z, 1.5707963705062866);
    }

    private void adjustFlyingHeight() {
        BlockPos groundPosition = mob.getCommandSenderWorld().getHeightmapPos(Heightmap.Types.WORLD_SURFACE, mob.blockPosition());
        int desiredHeightAboveGround = 10;
        int currentHeightAboveGround = mob.blockPosition().getY() - groundPosition.getY();
        if (currentHeightAboveGround < desiredHeightAboveGround) {
            Vec3 upVector = new Vec3(0, 1, 0);
            mob.setDeltaMovement(mob.getDeltaMovement().add(upVector.scale(0.1)));
        }
    }
}