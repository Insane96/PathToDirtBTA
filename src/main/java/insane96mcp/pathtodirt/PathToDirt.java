package insane96mcp.pathtodirt;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.data.tag.Tag;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.tag.ItemTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;


public class PathToDirt implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static Tag<Item> SHOVELS = Tag.of("shovels");

    public static final String MOD_ID = "pathtodirt";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
        LOGGER.info("PathToDirt initialized.");
		ItemTags.TAG_LIST.add(SHOVELS);
		SHOVELS.tag(Item.toolShovelWood);
		SHOVELS.tag(Item.toolShovelStone);
		SHOVELS.tag(Item.toolShovelIron);
		SHOVELS.tag(Item.toolShovelGold);
		SHOVELS.tag(Item.toolShovelDiamond);
		SHOVELS.tag(Item.toolShovelSteel);
    }

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}

	@Override
	public void initNamespaces() {

	}
}
