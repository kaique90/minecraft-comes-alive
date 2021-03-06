/*******************************************************************************
 * GuiHandlerInventory.java
 * Copyright (c) 2014 WildBamaBoy.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MCA Minecraft Mod license.
 ******************************************************************************/

package mca.core.forge;

import mca.client.gui.GuiInventory;
import mca.core.Constants;
import mca.entity.AbstractEntity;
import mca.inventory.ContainerInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Handles the inventory GUI.
 */
public class GuiHandlerInventory implements IGuiHandler
{
	/** The ID of the entity whose inventory is being edited. */
	private final int entityId;

	/**
	 * Constructor
	 * 
	 * @param entityId The ID of the entity whose inventory is being edited.
	 */
	public GuiHandlerInventory(int entityId)
	{
		this.entityId = entityId;
	}

	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int posX, int posY, int posZ)
	{
		final AbstractEntity entity = (AbstractEntity) world.getEntityByID(entityId);

		if (guiId == Constants.ID_GUI_INVENTORY)
		{
			return new ContainerInventory(player.inventory, entity.inventory, entity);
		}

		else
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int posX, int posY, int posZ)
	{
		final AbstractEntity entity = (AbstractEntity) world.getEntityByID(entityId);

		if (guiId == Constants.ID_GUI_INVENTORY)
		{
			return new GuiInventory(entity, player.inventory, entity.inventory, false);
		}

		else
		{
			return null;
		}
	}
}
