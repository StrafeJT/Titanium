package me.jaden.titanium.check;

import com.github.retrooper.packetevents.event.PacketReceiveEvent;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.event.ProtocolPacketEvent;
import me.jaden.titanium.data.PlayerData;

public interface Check {

    default void flagPacket(ProtocolPacketEvent event) {
        flagPacket(event, "");
    }

    void flagPacket(ProtocolPacketEvent event, String info);

    void flagPacket(ProtocolPacketEvent event, String info, boolean kick);

    void flagPacket(ProtocolPacketEvent event, boolean kick);

    default void handle(PacketReceiveEvent event, PlayerData playerData) {

    }

    default void handle(PacketSendEvent event, PlayerData playerData) {

    }
}
