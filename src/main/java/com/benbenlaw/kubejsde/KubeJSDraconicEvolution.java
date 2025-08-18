package com.benbenlaw.kubejsde;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(KubeJSDraconicEvolution.MOD_ID)
public class KubeJSDraconicEvolution {
    public static final String MOD_ID = "kubejsde";
    private static final Logger LOGGER = LogUtils.getLogger();

    public KubeJSDraconicEvolution(final IEventBus eventBus, final ModContainer modContainer) {
    }
}