package de.progen_bot.commands.user;

import de.progen_bot.command.CommandHandler;
import de.progen_bot.command.CommandManager;
import de.progen_bot.core.Main;
import de.progen_bot.db.entities.config.GuildConfiguration;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class UserVotet extends CommandHandler {

    public UserVotet() {
        super("hasvoted", "`hasVotet <user>`", "Shows if a user has voted for Progen");
    }

    @Override
    public void execute(CommandManager.ParsedCommandString parsedCommand, MessageReceivedEvent event, GuildConfiguration configuration) {

        User user;
        try {
            user = event.getMessage().getMentionedMembers().get(0).getUser();
        } catch (IndexOutOfBoundsException e) {
            event.getTextChannel().sendMessage(super.messageGenerators.generateErrorMsgWrongInput()).queue();
            return;
        }
        Main.getTopGG().hasVoted(user, hasVoted -> {
            String msg;
            if (hasVoted) msg = "User " + user.getName() + "has votet! Thank you!";
            else msg = "User "+ user.getName() + " has not voted yet!";
            event.getTextChannel().sendMessage(msg).queue();
        });
    }

    @Override
    public String help() {
        return null;
    }
}