package com.AdvilEngine.InventoryHelper;

public class PlayerInventory {

	private int selectedInventorySlot = 0;
	private int maxInventorySlots = 9;

	private Item[] items = new Item[maxInventorySlots];

	// setters
	
	// update array when resizing slots
	public void setMaxInventorySlots(int maxInventorySlotsSet) {
		if (maxInventorySlotsSet <= 0) {
			throw new IllegalArgumentException("Max inventory slots must be greater than 0");
		}

		Item[] newItems = new Item[maxInventorySlotsSet];

		for (int i = 0; i < Math.min(items.length, newItems.length); i++) {
			newItems[i] = items[i];
		}

		items = newItems;
		maxInventorySlots = maxInventorySlotsSet;

		if (selectedInventorySlot >= maxInventorySlots) {
			selectedInventorySlot = maxInventorySlots - 1;
		}
	}

	public void setSelectedSlot(int selectedSlot) {
		if (selectedSlot < 0 || selectedSlot >= maxInventorySlots) {
			throw new IllegalArgumentException(
					"Selected slot " + selectedSlot + " is out of bounds 0-" + (maxInventorySlots - 1));
		}

		selectedInventorySlot = selectedSlot;
	}

	// Item methods
	public void setItem(int slot, Item item) {
		if (slot < 0 || slot >= maxInventorySlots) {
			throw new IndexOutOfBoundsException("Slot out of range");
		}
		items[slot] = item;
	}

	public Item getItem(int slot) {
		if (slot < 0 || slot >= maxInventorySlots) {
			throw new IndexOutOfBoundsException("Slot out of range");
		}
		return items[slot];
	}

	public Item getSelectedItem() {
		return items[selectedInventorySlot];
	}
	
	// getters
	public int getMaxInventorySlots() {
		return maxInventorySlots;
	}

	public int getSelectedSlot() {
		return selectedInventorySlot;
	}
}