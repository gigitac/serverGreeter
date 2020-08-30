import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;

import javax.security.auth.login.Configuration;
import java.awt.*;

public class mainClass {
    public static void main(String[] args) {

        //** Do not edit anything below here unless you know what you are doing. **\\

        // Gets the Configuration Settings you Gave
        configuration configuration = new configuration();

        // Logs in with given Token
        DiscordApi api = new DiscordApiBuilder().setToken(configuration.token).login().join();


        // Checks whenever a user joins a server the bot is in.
        api.addServerMemberJoinListener(greeter ->{


           // Private Message                                                                                                           `                                                               `````````````````````
           String updatedPrivateMessage = configuration.privateMessage
                   // User Specific
                   .replaceAll("<discriminated_name>", greeter.getUser().getDiscriminatedName())
                   .replaceAll("<user_name>", greeter.getUser().getName())
                   .replaceAll("<user_id>", greeter.getUser().getIdAsString() )
                   .replaceAll("<user_mention_tag>", greeter.getUser().getMentionTag())
                   // Server Specific
                   .replaceAll("<server_name>", greeter.getServer().getName())
                   .replaceAll("<server_id>", greeter.getServer().getName())
                   .replaceAll("<server_membercount>", greeter.getServer().getName())
                   .replaceAll("<server_old_membercount>", greeter.getServer().getName());

           // Public Message
            String updatedChannelMessage = configuration.channelMessage
                    // User Specific
                    .replaceAll("<discriminated_name>", greeter.getUser().getDiscriminatedName())
                    .replaceAll("<user_name>", greeter.getUser().getName())
                    .replaceAll("<user_id>", greeter.getUser().getIdAsString() )
                    .replaceAll("<user_mention_tag>", greeter.getUser().getMentionTag())
                    // Server Specific
                    .replaceAll("<server_name>", greeter.getServer().getName())
                    .replaceAll("<server_id>", greeter.getServer().getIdAsString())
                    .replaceAll("<server_membercount>", String.valueOf(greeter.getServer().getMemberCount()))
                    .replaceAll("<server_old_membercount>", String.valueOf(greeter.getServer().getMemberCount() - 1));


           if(configuration.sendPrivateMessage){
               if(configuration.isPrivateMessageEmbed){
                   EmbedBuilder privateGreeting = new EmbedBuilder()
                           .setDescription(updatedPrivateMessage)
                           .setColor(configuration.privateMessageColor);
                   greeter.getUser().sendMessage(privateGreeting);
               } else {
                    greeter.getUser().sendMessage(updatedPrivateMessage);
               }
           }
            if(configuration.sendChannelMessage){
                if(configuration.isChannelEmbed){
                    EmbedBuilder publicGreeting = new EmbedBuilder()
                            .setDescription(updatedChannelMessage)
                            .setColor(configuration.channelColour);
                    api.getTextChannelById(configuration.channelID).get().sendMessage(publicGreeting);
                } else {
                    api.getTextChannelById(configuration.channelID).get().sendMessage(updatedChannelMessage);
                }
            }
        });
    }
}
