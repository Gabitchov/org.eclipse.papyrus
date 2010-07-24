package org.eclipse.papyrus.diagram.common.wizards;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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

	/** key for the property : the icon path has changed */
	public static final String PROPERTY_ICON_PATH = "ICON_PATH";

	/** key for the property : a child has been added */
	public static final String PROPERTY_ADD_CHILDREN = "PROPERTY_ADD_CHILDREN";

	/** key for the property : a child has been removed */
	public static final String PROPERTY_REMOVE_CHILDREN = "PROPERTY_REMOVE_CHILDREN";

	/** proxy palette entry */
	private final PaletteEntry entry;

	/** parent of this proxy */
	private PaletteContainerProxy parent;

	/** PropertyChangeSupport */
	protected PropertyChangeSupport listeners = new PropertyChangeSupport(this);


	/** proxy type */
	private EntryType type;

	public PaletteEntryProxy(PaletteEntry entry) {
		this.entry = entry;
		setType(initType());
	}

	/**
	 * A listener can only be added once. Adding it more than once will do nothing.
	 * 
	 * @param listener
	 *        the PropertyChangeListener that is to be notified of changes
	 * @see java.beans.PropertyChangeSupport#addPropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
		listeners.addPropertyChangeListener(listener);
	}

	/**
	 * @param listener
	 *        the PropertyChangeListener that is not to be notified anymore
	 * @see java.beans.PropertyChangeSupport#removePropertyChangeListener(java.beans.PropertyChangeListener)
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		listeners.removePropertyChangeListener(listener);
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
		if(entry instanceof PaletteDrawer) {
			return EntryType.DRAWER;
		} else if(entry instanceof PaletteSeparator) {
			return EntryType.SEPARATOR;
		} else if(entry instanceof PaletteStack) {
			return EntryType.STACK;
		} else if(entry instanceof AspectCreationEntry) {
			return EntryType.ASPECT_TOOL;
		} else if(entry instanceof ToolEntry) {
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
	 * returns the description of this entry proxy
	 * 
	 * @return the description of this entry proxy
	 */
	public String getDescription() {
		return (entry != null) ? entry.getDescription() : "";
	}

	/**
	 * returns the image path of this entry proxy
	 * 
	 * @return the image path of this entry proxy
	 */
	public String getImagePath() {
		return "";
	}

	/**
	 * Sets the parent for this proxy
	 * 
	 * @param newParent
	 *        the parent proxy
	 */
	public void setParent(PaletteContainerProxy newParent) {
		parent = newParent;
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
	 *        the type to set
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

	/**
	 * Sets the description of the palette entry proxied by this element
	 * 
	 * @param desc
	 *        the new description
	 */
	public void setDescription(String desc) {
		if(getEntry() == null) {
			return;
		}
		String oldDesc = getEntry().getDescription();

		if(oldDesc == null && desc == null) {
			return;
		}

		if(desc == null || !desc.equals(oldDesc)) {
			getEntry().setDescription(desc);
			listeners.firePropertyChange(PaletteEntry.PROPERTY_DESCRIPTION, oldDesc, desc);
		}
	}

	/**
	 * Sets the label of the palette entry proxied by this element
	 * 
	 * @param label
	 *        the new label
	 */
	public void setLabel(String label) {
		if(getEntry() == null) {
			return;
		}
		String oldLabel = getEntry().getLabel();

		if(oldLabel == null && label == null) {
			return;
		}

		if(label == null || !label.equals(oldLabel)) {
			getEntry().setLabel(label);
			listeners.firePropertyChange(PaletteEntry.PROPERTY_LABEL, oldLabel, label);
		}
	}

	/**
	 * Sets the label of the palette entry proxied by this element
	 * 
	 * @param label
	 *        the new label
	 */
	public void setIcon(String path) {
		if(!(getEntry() instanceof AspectCreationEntry)) {
			return;
		}
		String oldPath = ((AspectCreationEntry)getEntry()).getIconPath();

		if(oldPath == null && path == null) {
			return;
		}

		if(path == null || !path.equals(oldPath)) {
			((AspectCreationEntry)getEntry()).setIconPath(path);
			listeners.firePropertyChange(PROPERTY_ICON_PATH, oldPath, path);
		}
	}

	/**
	 * Method to add a child proxy to this proxy
	 * 
	 * @param entry
	 *        the entry to add
	 */
	protected void addChild(PaletteEntryProxy entry) {
		listeners.firePropertyChange(PROPERTY_ADD_CHILDREN, null, entry);
	}

	/**
	 * Method to add a child proxy to this proxy, before the given element
	 * 
	 * @param entry
	 *        the entry to add
	 * @param nextElement
	 *        the element that should be just after the entry
	 */
	protected void addChild(PaletteEntryProxy entry, PaletteEntryProxy nextElement) {
		listeners.firePropertyChange(PROPERTY_ADD_CHILDREN, null, entry);
	}

	/**
	 * Remove the specified children from its parent
	 * 
	 * @param proxy
	 *        the proxy to remove
	 */
	public void removeChild(PaletteEntryProxy proxy) {
		listeners.firePropertyChange(PROPERTY_REMOVE_CHILDREN, proxy, null);
	}
}
