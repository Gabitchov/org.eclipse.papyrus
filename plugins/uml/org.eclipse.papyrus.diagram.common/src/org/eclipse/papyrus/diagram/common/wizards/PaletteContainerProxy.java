package org.eclipse.papyrus.diagram.common.wizards;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.papyrus.diagram.common.wizards.LocalPaletteContentPage.EntryType;

/**
 * Proxy class for container entries
 */
public class PaletteContainerProxy extends PaletteEntryProxy {

	/** list of children for this container */
	protected List<PaletteEntryProxy> children = new ArrayList<PaletteEntryProxy>();

	/**
	 * Creates a new PaletteContainer
	 * 
	 * @param drawer
	 *        the drawer to cache
	 */
	public PaletteContainerProxy(PaletteContainer drawer) {
		super(drawer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PaletteContainer getEntry() {
		return (PaletteContainer)super.getEntry();
	}

	/**
	 * Method to add a child proxy to this proxy
	 * 
	 * @param entry
	 *        the entry to add
	 */
	public void addChild(PaletteEntryProxy entry) {
		children.add(entry);
		entry.setParent(this);
	}

	/**
	 * Method to add a child proxy to this proxy, before the given element
	 * 
	 * @param entry
	 *        the entry to add
	 * @param nextElement
	 *        the element that should be just after the entry
	 */
	public void addChild(PaletteEntryProxy entry, PaletteEntryProxy nextElement) {
		children.add(children.indexOf(nextElement), entry);
		entry.setParent(this);
	}

	/**
	 * Remove the specified children from its parent
	 * 
	 * @param proxy
	 *        the proxy to remove
	 */
	public void removeChild(PaletteEntryProxy proxy) {
		children.remove(proxy);
		proxy.setParent(null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntryType getType() {
		return EntryType.DRAWER;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PaletteEntryProxy> getChildren() {
		return children;
	}
}
