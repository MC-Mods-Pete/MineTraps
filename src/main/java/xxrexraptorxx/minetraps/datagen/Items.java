package xxrexraptorxx.minetraps.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import xxrexraptorxx.minetraps.main.ModBlocks;
import xxrexraptorxx.minetraps.main.ModItems;
import xxrexraptorxx.minetraps.main.References;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, References.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        itemGenerated(ModItems.NAILS);
        itemGenerated(ModItems.TOXIN_BOTTLE);

        itemBlock(ModBlocks.BARBED_WIRE);
        itemBlock(ModBlocks.RAZOR_WIRE);
        itemBlock(ModBlocks.BEAR_TRAP);
        itemBlock(ModBlocks.CHEST_BOMB);
        itemBlock(ModBlocks.EXPLOSIVE_MINE);
        itemBlock(ModBlocks.TOXIC_MINE);
        itemBlock(ModBlocks.MUD);
        itemBlock(ModBlocks.QUICK_SAND);
        itemBlock(ModBlocks.OBSTACLE);
        itemBlock(ModBlocks.NAIL_TRAP);
        itemBlock(ModBlocks.TOXIC_NAIL_TRAP);
        itemBlock(ModBlocks.SPIKES);
        itemBlock(ModBlocks.TOXIC_SPIKES);
        itemBlock(ModBlocks.PITFALL_TRAP);
    }



    private void itemGenerated(RegistryObject item) {
        singleTexture(item.get().getRegistryName().getPath(), new ResourceLocation("item/generated"),"layer0", new ResourceLocation(References.MODID, "item/" + item.get().getRegistryName().toString().substring(References.MODID.length() + 1)));
    }


    private void itemHandheld(RegistryObject item) {
        singleTexture(item.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),"layer0", new ResourceLocation(References.MODID, "item/" + item.get().getRegistryName().toString().substring(References.MODID.length() + 1)));
    }


    private void itemBlock(RegistryObject item) {
        withExistingParent(item.get().getRegistryName().getPath(), new ResourceLocation(References.MODID, "block/" + item.get().getRegistryName().toString().substring(References.MODID.length() + 1)));
    }

}