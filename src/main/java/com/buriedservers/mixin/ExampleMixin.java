package com.buriedservers.mixin;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Function;

@Mixin(MinecraftServer.class)
public class ExampleMixin {
    @Inject(method = "startServer", at = @At("HEAD"), cancellable = true)
    private static void init(Function<?, ?> function, CallbackInfoReturnable<MinecraftServer> cir) {
        System.out.println("MinecraftServer is starting!");
        // You can cancel the startServer call if needed by:
        // cir.cancel();
    }
}