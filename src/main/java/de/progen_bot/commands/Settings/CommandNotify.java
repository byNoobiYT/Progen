package de.progen_bot.commands.Settings;

import de.progen_bot.command.CommandHandler;
import de.progen_bot.command.CommandManager;
import de.progen_bot.db.entities.config.GuildConfiguration;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandNotify extends CommandHandler {
    public CommandNotify() {super("notify", "get role notify", "description");
    }

    @Override
    public void execute(CommandManager.ParsedCommandString parsedCommand, MessageReceivedEvent event, GuildConfiguration configuration) {
        Member member = event.getMember();
        Guild guild = event.getGuild();

        Role Notify = guild.getRolesByName("Notify", true).get(0);

        event.getGuild().addRoleToMember(event.getMember(), Notify).complete();

        if (parsedCommand.getArgs().equals("Notify")) guild.addRoleToMember(member, Notify).queue();
        else event.getTextChannel().sendMessage(
                super.messageGenerators.generateSuccessfulMsg()
        ).queue();

        

    }

    @Override
    public String help() {
        return null;
    }
}