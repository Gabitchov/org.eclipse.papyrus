/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.common.core.service.ExecutionStrategy;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.ContributeToPaletteOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteService;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.SelectionToolEx;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.ui.IEditorPart;

/**
 * Service that contributes to the palette of a given editor with a given content.
 * <p>
 * It replaces the standard palette service. It provides better preferences management, and better
 * customization possibilities.
 */
public class PapyrusPaletteService extends PaletteService implements IPaletteProvider, IPapyrusPaletteConstant {

	/**
	 * A descriptor for palette providers defined by a configuration element.
	 */
	public static class ProviderDescriptor extends ActivityFilterProviderDescriptor {

		/** the provider configuration parsed from XML */
		private XMLPaletteProviderConfiguration providerConfiguration;

		/**
		 * Constructs a <code>ISemanticProvider</code> descriptor for the specified configuration
		 * element.
		 * 
		 * @param element
		 *            The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);

			this.providerConfiguration = XMLPaletteProviderConfiguration.parse(element);
			Assert.isNotNull(providerConfiguration);
		}

		/**
		 * Returns <code>true</code> if this configuration provides only predefinition of entries
		 * and neither use predefined entries nor creates new entries.
		 * 
		 * @return <code>true</code> if this configuration provides only predefinition of entries
		 *         and neither use predefined entries nor creates new entries.
		 */
		public boolean hasOnlyEntriesDefinition() {
			return providerConfiguration.hasOnlyEntriesDefinition();
		}

		/**
		 * Returns this contribution's name
		 * 
		 * @return this contribution's name
		 */
		public String getContributionName() {
			return providerConfiguration.getName();
		}

		/**
		 * Returns this contribution's id
		 * 
		 * @return this contribution's id
		 */
		public String getContributionID() {
			return providerConfiguration.getID();
		}

		/**
		 * Returns true if this contributor is hidden in the preferences
		 * 
		 * @param operation
		 * @return
		 */
		public boolean isHidden(ContributeToPaletteOperation operation) {
			// checks it is not in the list of hidden palettes for the editor
			List<String> hiddenPalettes = PapyrusPalettePreferences.getHiddenPalettes(operation.getEditor());
			return hiddenPalettes.contains(getContributionID());
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
		 */
		public boolean provides(IOperation operation) {
			if (!super.provides(operation)) {
				return false;
			}
			if (!policyInitialized) {
				policy = getPolicy();
				policyInitialized = true;
			}
			if (policy != null)
				return policy.provides(operation);

			if (operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = (ContributeToPaletteOperation) operation;

				boolean supports = providerConfiguration.supports(o.getEditor(), o.getContent());

				if (!supports) {
					return false;
				}

				if (isHidden(o)) {
					return false;
				}
				return true;
			}

			return false;
		}

		/**
		 * 
		 * @param operation
		 * @return
		 */
		public boolean providesWithVisibility(ContributeToPaletteOperation operation) {
			/**
			 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
			 */
			if (!super.provides(operation)) {
				return false;
			}
			if (!policyInitialized) {
				policy = getPolicy();
				policyInitialized = true;
			}
			if (policy != null)
				return policy.provides(operation);

			if (operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = (ContributeToPaletteOperation) operation;

				boolean supports = providerConfiguration.supports(o.getEditor(), o.getContent());

				if (!supports) {
					return false;
				}

				return true;
			}

			return false;
		}

		/**
		 * @see org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor#getProvider()
		 */
		public IProvider getProvider() {
			if (provider == null) {
				IProvider newProvider = super.getProvider();
				if (provider instanceof IPaletteProvider) {
					IPaletteProvider defaultProvider = (IPaletteProvider) newProvider;
					defaultProvider.setContributions(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

	/**
	 * Sets contribution empty because contributions are stored in the providers
	 * 
	 * @param configElement
	 *            the configuration element that drives this service.
	 */
	public void setContributions(IConfigurationElement configElement) {
		//  
	}

	/** the singleton instance of the palette service */
	private final static PapyrusPaletteService instance = new PapyrusPaletteService();

	static {
		instance.configureProviders(DiagramUIPlugin.getPluginId(), "paletteProviders"); //$NON-NLS-1$
		instance.configureProviders(Activator.ID, PALETTE_DEFINITION); //$NON-NLS-1$
	}

	/** the standard group id */
	public final static String GROUP_STANDARD = "standardGroup"; //$NON-NLS-1$

	/** the standard separator id */
	public final static String SEPARATOR_STANDARD = "standardSeparator"; //$NON-NLS-1$

	/** the standard separator id */
	public final static String TOOL_SELECTION = "selectionTool"; //$NON-NLS-1$

	/**
	 * Creates a new instance of the Palette Service
	 */
	protected PapyrusPaletteService() {
		super();
	}

	/**
	 * gets the singleton instance
	 * 
	 * @return <code>PaletteService</code>
	 */
	public static PapyrusPaletteService getInstance() {
		return instance;
	}

	/**
	 * @see org.eclipse.gmf.runtime.common.core.service.Service#newProviderDescriptor(org.eclipse.core.runtime.IConfigurationElement)
	 */
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#contributeToPalette(org.eclipse.ui.IEditorPart,
	 *      java.lang.Object, org.eclipse.gef.palette.PaletteRoot, Map)
	 */
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {

		PaletteToolbar standardGroup = new PaletteToolbar(Messages.StandardGroup_Label);
		standardGroup.setDescription(""); //$NON-NLS-1$
		standardGroup.setId(GROUP_STANDARD);
		root.add(standardGroup);

		PaletteSeparator standardSeparator = new PaletteSeparator(SEPARATOR_STANDARD);
		standardGroup.add(standardSeparator);

		ToolEntry selectTool = new PanningSelectionToolEntry();
		selectTool.setId(TOOL_SELECTION);
		selectTool.setToolClass(SelectionToolEx.class);
		standardGroup.add(selectTool);
		root.setDefaultEntry(selectTool);

		execute(new ContributeToPaletteOperation(editor, content, root, predefinedEntries));
	}

	/**
	 * Returns the list of providers for this service
	 * 
	 * @return the list of providers for this service
	 */
	@SuppressWarnings("unchecked")
	public List<? extends Service.ProviderDescriptor> getProviders() {
		return getAllProviders();
	}

	/**
	 * Executes the palette operation using the REVERSE execution strategy.
	 * 
	 * @param operation
	 * @return List of results
	 */
	@SuppressWarnings("unchecked")
	private List execute(IOperation operation) {
		return execute(ExecutionStrategy.REVERSE, operation);
	}

	/**
	 * Creates default palette root.
	 * 
	 * @param editor
	 *            the editor for which palette is created
	 * @param content
	 *            the palette content
	 * @return a new palette root with contributions from all providers
	 */
	public PaletteRoot createPalette(final IEditorPart editor, final Object content) {
		final PaletteRoot root = new PaletteRoot();
		try {
			IEditingDomainProvider provider = (IEditingDomainProvider) editor.getAdapter(IEditingDomainProvider.class);
			if (provider != null) {
				EditingDomain domain = provider.getEditingDomain();
				if (domain instanceof TransactionalEditingDomain) {
					((TransactionalEditingDomain) domain).runExclusive(new Runnable() {

						public void run() {
							contributeToPalette(editor, content, root, new HashMap());
						}
					});
				}
			}
		} catch (Exception e) {
			Activator.getDefault().logError("Error in PapyrusPaletteService::createPalette()", e); //$NON-NLS-1$
		}
		return root;
	}

	/**
	 * Updates the palette root given.
	 * 
	 * @param existingRoot
	 *            existing palette root in which to add/remove entries that are now provided for or
	 *            no longer provided for
	 * @param editor
	 *            the editor
	 * @param content
	 *            the palette content
	 */
	public void updatePalette(PaletteRoot existingRoot, final IEditorPart editor, final Object content) {

		PaletteRoot newRoot = createPalette(editor, content);
		updatePaletteContainerEntries(existingRoot, newRoot);
	}

	/**
	 * Updates the children of an existing palette container to match the palette entries in a new
	 * palette container by adding or removing new palette entries only. This method works
	 * recursively on any children that are palette container entries. Existing leaf palette entries
	 * that are to be kept remain the same -- they are not replaced with the new palette entry. This
	 * is so that palette state (such as whether a drawer is pinned or expanded) can be preserved
	 * when the palette is updated.
	 * 
	 * @param existingContainer
	 *            the palette container to be updated with new entries, have obsolete entries
	 *            removed, and whose existing entries will remain the same
	 * @param newContainer
	 *            the new palette entries
	 */
	private void updatePaletteContainerEntries(PaletteContainer existingContainer, PaletteContainer newContainer) {

		HashMap existingEntryIds = new HashMap();
		for (Iterator iter = existingContainer.getChildren().iterator(); iter.hasNext();) {
			PaletteEntry entry = (PaletteEntry) iter.next();
			existingEntryIds.put(entry.getId(), entry);
		}

		int nextNewIndex = 0;
		// cycle through the new entries
		for (Iterator iter = newContainer.getChildren().iterator(); iter.hasNext();) {
			PaletteEntry newEntry = (PaletteEntry) iter.next();

			PaletteEntry existingEntry = (PaletteEntry) existingEntryIds.get(newEntry.getId());
			if (existingEntry != null) { // is already in existing container
				// update the index
				nextNewIndex = existingContainer.getChildren().indexOf(existingEntry) + 1;

				// remove the entry that was just updated from the map
				existingEntryIds.remove(existingEntry.getId());

				if (existingEntry instanceof PaletteContainer && newEntry instanceof PaletteContainer) {
					// look for new/deleted entries in
					// palette containers
					updatePaletteContainerEntries((PaletteContainer) existingEntry, (PaletteContainer) newEntry);
				}
			} else { // this is a new entry that did not previously exist
				existingContainer.add(nextNewIndex++, newEntry);
			}
		}

		// remove existing entries that were not found in the new container
		for (Iterator iter = existingEntryIds.values().iterator(); iter.hasNext();) {
			PaletteEntry entry = (PaletteEntry) iter.next();
			existingContainer.remove(entry);
		}

	}

}
