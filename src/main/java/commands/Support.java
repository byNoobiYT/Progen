package commands;

import command.CommandHandler;
import command.CommandManager;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class Support extends CommandHandler {
    public Support() {
        super("support","support","Join the Support Server");
    }

    @Override
    public void execute(CommandManager.ParsedCommandString parsedCommand , MessageReceivedEvent event)
    { event.getTextChannel().sendMessage("Join our Community: https://discord.gg/9nkTsZh").queue();
        System.out.println("[Info] Command pb!support wird ausgeführt!");

    }

    @Override
    public String help() {
        return null;
    }
}
