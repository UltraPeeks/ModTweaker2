package modtweaker2;

import minetweaker.MineTweakerAPI;
import minetweaker.api.player.IPlayer;
import minetweaker.api.server.ICommandFunction;
import modtweaker2.commands.EntityMappingLogger;
import modtweaker2.mods.auracascade.aura.AuraLogger;
import modtweaker2.mods.botania.commands.BotaniaBrewLogger;
import modtweaker2.mods.botania.commands.BotaniaOrechidLogger;
import modtweaker2.mods.botania.lexicon.commands.LexiconCategoryLogger;
import modtweaker2.mods.botania.lexicon.commands.LexiconKnowledgeTypesLogger;
import modtweaker2.mods.botania.lexicon.commands.LexiconPageLogger;
import modtweaker2.mods.chisel.commands.ChiselGroupLogger;
import modtweaker2.mods.chisel.commands.ChiselVariationLogger;
import modtweaker2.mods.mekanism.gas.GasLogger;
import modtweaker2.mods.tconstruct.MaterialLogger;
import modtweaker2.mods.thaumcraft.commands.AspectLogger;
import modtweaker2.mods.thaumcraft.research.commands.ResearchLogger;
import modtweaker2.utils.TweakerPlugin;

public class Commands {

	public static void registerCommands() {
		if (MineTweakerAPI.server != null) {

			MineTweakerAPI.server.addMineTweakerCommand("tooltips", new String[] { "/minetweaker tooltips", "    Adds tooltips to all items ingame with their mt script name, press ctrl on an item to print to the log" }, new ICommandFunction() {
				@Override
				public void execute(String[] arguments, IPlayer player) {
					ClientEvents.active = !ClientEvents.active;
				}
			});

			MineTweakerAPI.server.addMineTweakerCommand("entities", new String[] { "/minetweaker entities", "    Outputs a list of entities class mapping keys and the entity IDs" }, new EntityMappingLogger());

			if (TweakerPlugin.isLoaded("Mekanism")) {
				MineTweakerAPI.server.addMineTweakerCommand("gases", new String[] { "/minetweaker gases", "    Outputs a list of all gas names in the game to the minetweaker log" }, new GasLogger());
			}

			if (TweakerPlugin.isLoaded("Thaumcraft")) {
				MineTweakerAPI.server.addMineTweakerCommand("research", new String[] { "/minetweaker research", "/minetweaker research [CATEGORY]", "    Outputs a list of all category names in the game to the minetweaker log," + " or outputs a list of all research keys in a category to the log." }, new ResearchLogger());
				MineTweakerAPI.server.addMineTweakerCommand("aspectList", new String[] { "/minetweaker aspectList", "    Outputs a list of all aspects registered to entities and items" }, new AspectLogger());
			}

			if (TweakerPlugin.isLoaded("TConstruct")) {
				MineTweakerAPI.server.addMineTweakerCommand("materials", new String[] { "/minetweaker materials", "    Outputs a list of all Tinker's Construct material names in the game to the minetweaker log" }, new MaterialLogger());
			}

			if (TweakerPlugin.isLoaded("Botania")) {
				MineTweakerAPI.server.addMineTweakerCommand("lexiconCategories", new String[] { "/minetweaker lexiconCategories", "    Outputs a list of lexicon categories" }, new LexiconCategoryLogger());
				MineTweakerAPI.server.addMineTweakerCommand("lexiconPages", new String[] { "/minetweaker lexiconPages", "/minetweaker lexiconPages [ENTRY]", "    Outputs a list of lexicon pages for the entry" }, new LexiconPageLogger());
				MineTweakerAPI.server.addMineTweakerCommand("botaniaBrews", new String[] { "/minetweaker botaniaBrews", "    Outputs a list of keys for botania brews" }, new BotaniaBrewLogger());
				MineTweakerAPI.server.addMineTweakerCommand("lexiconKnowledgeTypes", new String[] { "/minetweaker lexiconKnowledgeTypes", "    Outputs a list of keys for lexicon knowledge types" }, new LexiconKnowledgeTypesLogger());
				MineTweakerAPI.server.addMineTweakerCommand("botaniaOrchid", new String[] { "/minetweaker botaniaOrechid", "    Outputs a list of keys for botania orechid weights" }, new BotaniaOrechidLogger());
			}

			if (TweakerPlugin.isLoaded("chisel")) {
				MineTweakerAPI.server.addMineTweakerCommand("chiselGroups", new String[] { "/minetweaker chiselGroups", "    Outputs a list of chisel groups" }, new ChiselGroupLogger());
				MineTweakerAPI.server.addMineTweakerCommand("chiselVariations", new String[] { "/minetweaker chiselVariations", "/minetweaker chiselVariations [GROUP]", "    Outputs a list of chisel variations" }, new ChiselVariationLogger());
			}
			if (TweakerPlugin.isLoaded("aura")) {
				MineTweakerAPI.server.addMineTweakerCommand("auras", new String[] { "/minetweaker auras", "Outputs a list of Aura Types" }, new AuraLogger());
			}
		}

	}

	public static void registerMineTweakerCommand(String commandName, String[] usages, ICommandFunction commandFunction) {
		MineTweakerAPI.server.addMineTweakerCommand(commandName, usages, commandFunction);
		ModTweaker2.logger.info("\nRegistering command " + commandName + ".");
	}
}
