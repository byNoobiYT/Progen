package de.progen_bot.commands.user;

import de.progen_bot.command.CommandHandler;
import de.progen_bot.command.CommandManager;
import de.progen_bot.db.entities.config.GuildConfiguration;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;


public class Vote extends CommandHandler {

    public Vote() {
        super("vote", "vote", "Get the vote link to support Progen and earn XP!");
    }

    @Override
    public void execute(CommandManager.ParsedCommandString parsedCommand, MessageReceivedEvent event, GuildConfiguration configuration) {

        event.getAuthor().openPrivateChannel().complete().sendMessage("Thank you for your support." + event.getMember().getEffectiveName() + "Here is the link:\n https://discordbots.org/bot/495293590503817237").queue();
        event.getTextChannel().sendMessage("Thank you for voting " + event.getMember().getEffectiveName() + ". We thank you for your support!").queue();

    }

    @Override
    public String help() {
        return null;
    }
}