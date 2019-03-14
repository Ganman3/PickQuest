package pickquest.data;

import java.util.EnumSet;

import org.bukkit.Material;



public class SafeBlocks {
	
	
	@SuppressWarnings("deprecation")
	private EnumSet<Material> unsafeUnder = EnumSet.of(Material.AIR, Material.LAVA, Material.CAVE_AIR, Material.LEGACY_AIR, Material.OAK_FENCE, Material.SPRUCE_FENCE, Material.DARK_OAK_FENCE,
			Material.BIRCH_FENCE, Material.ACACIA_FENCE, Material.JUNGLE_FENCE, Material.IRON_BARS,  
			Material.GLASS_PANE, Material.BLACK_STAINED_GLASS_PANE, Material.RED_STAINED_GLASS_PANE, Material.LIME_STAINED_GLASS_PANE, Material.GREEN_STAINED_GLASS_PANE,
			Material.PINK_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE, Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.WHITE_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE, Material.LIGHT_GRAY_STAINED_GLASS_PANE,
			Material.ORANGE_STAINED_GLASS_PANE, Material.BROWN_STAINED_GLASS_PANE, Material.CYAN_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE, Material.MAGENTA_STAINED_GLASS_PANE, Material.YELLOW_STAINED_GLASS_PANE, 

			Material.ARMOR_STAND, Material.FLOWER_POT, Material.GRASS, Material.LIGHT_BLUE_CARPET, Material.GRAY_CARPET, Material.LIGHT_GRAY_CARPET, Material.LIME_CARPET, Material.MAGENTA_CARPET, Material.SNOW, Material.ORANGE_CARPET, 
			Material.PINK_CARPET, Material.PURPLE_CARPET, Material.RED_CARPET, Material.WHITE_CARPET, Material.YELLOW_CARPET, Material.BLACK_CARPET, Material.BROWN_CARPET, Material.CYAN_CARPET, Material.GREEN_CARPET, 
			Material.PEONY, Material.LILAC, Material.LARGE_FERN, Material.TALL_GRASS, Material.ALLIUM, Material.BROWN_MUSHROOM, Material.RED_MUSHROOM, Material.POPPY, 
			Material.FERN, Material.WHITE_TULIP, Material.PINK_TULIP, Material.ORANGE_TULIP, Material.RED_TULIP, Material.SUNFLOWER, Material.OXEYE_DAISY, Material.ACACIA_SAPLING, 
			Material.BIRCH_SAPLING, Material.DARK_OAK_SAPLING, Material.JUNGLE_SAPLING, Material.OAK_SAPLING, Material.SPRUCE_SAPLING);
	@SuppressWarnings("deprecation")
	private EnumSet<Material> safeAbove = EnumSet.of(Material.AIR, Material.CAVE_AIR, Material.LEGACY_AIR, Material.WATER, Material.LILAC, Material.SUNFLOWER, Material.LARGE_FERN, Material.PEONY
		,Material.ROSE_BUSH, Material.TALL_GRASS);
	

	@SuppressWarnings("deprecation")
	private EnumSet<Material> safeAt = EnumSet.of(Material.WHEAT, Material.AIR, Material.CAVE_AIR, Material.LEGACY_AIR, Material.WATER, Material.OAK_SAPLING,

			Material.SPRUCE_SAPLING, Material.BIRCH_SAPLING, Material.JUNGLE_SAPLING, Material.DARK_OAK_SAPLING,
			Material.ACACIA_SAPLING, Material.RED_MUSHROOM, Material.BROWN_MUSHROOM, Material.WHEAT, Material.SUGAR_CANE, Material.KELP_PLANT,
			Material.PUMPKIN_STEM, Material.VINE, Material.NETHER_WART, Material.CARROTS, Material.POTATOES, Material.DANDELION,
			Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM, Material.AZURE_BLUET, Material.RED_TULIP, Material.ORANGE_TULIP,
			Material.WHITE_TULIP, Material.PINK_TULIP, Material.OXEYE_DAISY, Material.SUNFLOWER, Material.LILAC, 
			Material.RED_CARPET, Material.YELLOW_CARPET, Material.BLUE_CARPET, Material.LIGHT_BLUE_CARPET,
			Material.GRAY_CARPET, Material.PINK_CARPET, Material.BLACK_CARPET, Material.MAGENTA_CARPET, Material.GREEN_CARPET, 

			Material.CYAN_CARPET, Material.LIME_CARPET, Material.BROWN_CARPET, Material.WHITE_CARPET, Material.ORANGE_CARPET, Material.PURPLE_CARPET,
			Material.FERN, Material.LARGE_FERN, Material.TALL_GRASS 

			

			);
	public EnumSet<Material> getSafeAt() {
		return safeAt;
	}
	public EnumSet<Material> getSafeAbove() {
		return safeAbove;
	}
	public EnumSet<Material> getUnsafeUnder() {
		return unsafeUnder;
	}
	
}

