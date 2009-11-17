package org.eclipse.papyrus.diagram.common.wizards;

import java.util.List;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.service.AspectCreationEntry;
import org.eclipse.papyrus.diagram.common.wizards.LocalPaletteContentPage.EntryType;
import org.eclipse.swt.graphics.Image;

/**
 * Proxy class for palette entries
 */
public class PaletteEntryProxy {

	/** proxy palette entry */
	private final PaletteEntry entry;

	/** parent of this proxy */
	private PaletteContainerProxy parent;

	/** proxy type */
	private EntryType type;

	public PaletteEntryProxy(PaletteEntry entry) {
		this.entry = entry;
		setType(initType());
	}

	/**
	 * Returns the entry cached by this class
	 * 
	 * @return the palette entry
	 */
	public PaletteEntry getEntry() {
		return entry;
	}

	/**
	 * Inits the entry type for this proxy
	 * 
	 * @return the entry type for this proxy
	 */
	protected EntryType initType() {
		if (entry instanceof PaletteDrawer) {
			return EntryType.DRAWER;
		} else if (entry instanceof PaletteSeparator) {
			return EntryType.SEPARATOR;
		} else if (entry instanceof PaletteStack) {
			return EntryType.STACK;
		} else if (entry instanceof AspectCreationEntry) {
			return EntryType.ASPECT_TOOL;
		} else if (entry instanceof ToolEntry) {
			return EntryType.TOOL;
		}
		return EntryType.TOOL;
	}

	/**
	 * returns the label of the cached entry
	 * 
	 * @return the label of the cached entry
	 */
	public String getLabel() {
		return entry.getLabel();
	}

	/**
	 * returns the id of the cached entry
	 * 
	 * @return the id of the cached entry
	 */
	public String getId() {
		return entry.getId();
	}

	/**
	 * returns the small icon of the cached entry
	 * 
	 * @return the small icon of the cached entry
	 */
	public Image getImage() {
		return Activator.getPluginIconImage(Activator.ID, entry.getSmallIcon());
	}

	/**
	 * Sets the parent for this proxy
	 * 
	 * @param parent
	 *            the parent proxy
	 */
	public void setParent(PaletteContainerProxy parent) {
		this.parent = parent;
	}

	/**
	 * Returns the parent of this proxy
	 * 
	 * @return the parent of this proxy
	 */
	public PaletteContainerProxy getParent() {
		return parent;
	}

	/**
	 * Returns the list of children for this entry. By default, entries do not have children.
	 * 
	 * @return the list of children for this entry
	 */
	public List<PaletteEntryProxy> getChildren() {
		return null;
	}

	/**
	 * Sets the king of tool it is.
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(EntryType type) {
		this.type = type;
	}

	/**
	 * Returns the kind of entry
	 * 
	 * @return the kind of entry
	 */
	public EntryType getType() {
		return type;
	}
}
