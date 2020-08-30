import java.awt.*;

public class configuration {
    String token = "INSERT TOKEN HERE";
    boolean sendPrivateMessage = false;
        String privateMessage = "INSERT GREETING HERE";
        boolean isPrivateMessageEmbed = false;
            Color privateMessageColor = new Color(114,137,218);
    boolean sendChannelMessage = false;
        String channelID = "INSERT CHANNELID HERE";
        String channelMessage = "INSERT GREETING HERE";
        boolean isChannelEmbed = false;
            Color channelColour = new Color(114,137,218);

    // Syntax

    // User Specific
    // <discriminated_name>: Returns the user's Discriminated Name
    // <user_name>: Returns the user's Name
    // <user_id>: Returns the user's userID
    // <user_mention_tag>: Mentions the user.

    // Server Specific
    // <server_name>: Returns the server Name
    // <server_id>: Returns the server's serverID
    // <server_membercount>: Returns the server's member count.
    // <server_old_membercount>: Returns the server's previous member count.

    // Discord Syntax
    // <#channelID>: Mentions the channel with channelID.
    // <@userID>: Mentions the user with userID.
}
