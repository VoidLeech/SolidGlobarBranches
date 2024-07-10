package com.github.voidleech.solidglobarbranches;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(SolidGlobarBranches.MOD_ID)
public class SolidGlobarBranches
{
    public static final String MOD_ID = "solidglobarbranches";

    public SolidGlobarBranches()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
