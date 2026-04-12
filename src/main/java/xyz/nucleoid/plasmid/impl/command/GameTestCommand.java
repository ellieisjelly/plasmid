package xyz.nucleoid.plasmid.impl.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import me.lucko.fabric.api.permissions.v0.Permissions;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.CompoundTagArgument;
import xyz.nucleoid.plasmid.impl.command.argument.GameConfigArgument;

import static net.minecraft.commands.Commands.argument;
import static net.minecraft.commands.Commands.literal;

public final class GameTestCommand {
    // @formatter:off
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
            literal("game")
                .then(literal("test")
                    .requires(Permissions.require("plasmid.command.game.test", 2))
                    .then(GameConfigArgument.argument("game_config")
                        .executes(GameTestCommand::openTestGame)
                    )
                    .then(argument("game_config_nbt", CompoundTagArgument.compoundTag())
                        .executes(GameTestCommand::openAnonymousTestGame)
                    )
                )
        );
    }
    // @formatter:on

    private static int openTestGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        return GameCommand.openGame(context, true);
    }

    private static int openAnonymousTestGame(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        return GameCommand.openAnonymousGame(context, true);
    }
}
