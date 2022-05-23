package me.jaden.titanium.check.impl.crasher;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.netty.buffer.ByteBufHelper;
import me.jaden.titanium.Settings;
import me.jaden.titanium.check.PacketCheck;
import me.jaden.titanium.data.PlayerData;

public class CrasherD implements PacketCheck {

    //Value from ExploitFixer config
    //https://github.com/2lstudios-mc/ExploitFixer/blob/master/resources/config.yml
    private final int maxBytes = Settings.getSettings().getMaxBytes();

    @Override
    public void handle(PacketReceiveEvent event, PlayerData playerData) {
        //https://netty.io/4.1/api/io/netty/buffer/ByteBuf.html
        //Sequential Access Indexing
        //Where is ByteBufHelper#capacity?
        int writerIndex = ByteBufHelper.writerIndex(event.getByteBuf());
        System.out.println(writerIndex);
        if(writerIndex > maxBytes){
            flag(event, "writerIndex: " + writerIndex);
        }
    }

}
