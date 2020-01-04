package de.progen_bot.music;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.entities.Member;


public class AudioInfo {
    private final AudioTrack TRACK;
    private final Member AUTHOR;

    /**
     * Creates an instance of the AudioInfo class.
     *
     * @param track  AudioTrack
     * @param author Member
     */
    public AudioInfo(AudioTrack track, Member author) {
        this.TRACK = track;
        this.AUTHOR = author;
    }

    public AudioTrack getTrack() {
        return TRACK;
    }

    @JsonIgnore
    public Member getAuthor() {
        return AUTHOR;
    }
}