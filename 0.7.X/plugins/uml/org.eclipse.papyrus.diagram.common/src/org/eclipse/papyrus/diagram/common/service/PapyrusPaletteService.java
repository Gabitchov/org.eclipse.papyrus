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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.IPreferenceChangeListener;
import org.eclipse.core.runtime.preferences.IEclipsePreferences.PreferenceChangeEvent;
import org.eclipse.core.runtime.preferences.InstanceScope;
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
import org.eclipse.gmf.runtime.common.core.service.ProviderChangeEvent;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.common.ui.services.util.ActivityFilterProviderDescriptor;
import org.eclipse.gmf.runtime.common.ui.util.ActivityUtil;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.ContributeToPaletteOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteService;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.SelectionToolEx;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.part.IPaletteDescription;
import org.eclipse.papyrus.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.ui.IEditorPart;

/**
 * Service that contributes to the palette of a given editor with a given content.
 * <p>
 * It replaces the standard palette service. It provides better preferences management, and better customization possibilities.
 */
public class PapyrusPaletteService extends PaletteService implements IPaletteProvider, IPapyrusPaletteConstant, IPreferenceChangeListener {

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
		 *        The configuration element describing the provider.
		 */
		public ProviderDescriptor(IConfigurationElement element) {
			super(element);

			if(element != null) {
				this.providerConfiguration = XMLPaletteProviderConfiguration.parse(element);
				Assert.isNotNull(providerConfiguration);
			}
		}

		/**
		 * Returns <code>true</code> if this configuration provides only predefinition of entries
		 * and neither use predefined entries nor creates new entries.
		 * 
		 * @return <code>true</code> if this configuration provides only predefinition of entries
		 *         and neither use predefined entries nor creates new entries.
		 */
		// @unused
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
		 * {@inheritDoc}
		 */
		@Override
		public boolean provides(IOperation operation) {
			if(!super.provides(operation)) {
				return false;
			}
			if(!policyInitialized) {
				policy = getPolicy();
				policyInitialized = true;
			}
			if(policy != null) {
				return policy.provides(operation);
			}

			if(operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = (ContributeToPaletteOperation)operation;

				IEditorPart part = o.getEditor();
				if(!(part instanceof DiagramEditorWithFlyOutPalette)) {
					return false;
				}
				boolean supports = providerConfiguration.supports(o.getEditor(), o.getContent());

				if(!supports) {
					return false;
				}

				if(isHidden(o)) {
					return false;
				}
				
				if(!PaletteUtil.areRequiredProfileApplied(part, this)) {
					return false;
				}
				
				return true;
			}

			return false;
		}

		/**
		 * checks if this provider is providing elements, even if this should be hidden
		 * 
		 * @param operation
		 *        the operation to contribute
		 * @return <code>true</code> if this provider contributes to the operation
		 */
		public boolean providesWithVisibility(ContributeToPaletteOperation operation) {
			if(!super.provides(operation)) {
				return false;
			}
			if(!policyInitialized) {
				policy = getPolicy();
				policyInitialized = true;
			}
			if(policy != null) {
				return policy.provides(operation);
			}

			// FIXME: that statement is always true (let's see the method's parameter).
			// => Remove the test
			if(operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = operation;

				// FIXME returns directly the result
				boolean supports = providerConfiguration.supports(o.getEditor(), o.getContent());

				if(!supports) {
					return false;
				}

				return true;
			}

			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if(provider == null) {
				IProvider newProvider = super.getProvider();
				if(provider instanceof IPaletteProvider) {
					IPaletteProvider defaultProvider = (IPaletteProvider)newProvider;
					defaultProvider.setContributions(getElement());
				}
				return newProvider;
			}
			return super.getProvider();
		}
	}

	/**
	 * Provider descriptor for a local palette definition.
	 * <p>
	 * It has no configuration element attached to it, it should not be used everywhere without checks.
	 * </p>
	 */
	public static class LocalProviderDescriptor extends ProviderDescriptor {

		/** palette description */
		private final IPaletteDescription description;

		/**
		 * Creates a new Local Palette Descriptor
		 * 
		 * @param description
		 *        the description of the palette
		 */
		public LocalProviderDescriptor(IPaletteDescription description) {
			super(null);
			this.description = description;
		}

		/**
		 * Returns <code>true</code> if this configuration provides only predefinition of entries
		 * and neither use predefined entries nor creates new entries.
		 * 
		 * @return <code>false</code> as local palettes are never defining tools
		 */
		@Override
		public boolean hasOnlyEntriesDefinition() {
			return false;
		}

		/**
		 * Returns the description of this palette provider
		 * 
		 * @return the description of this palette provider
		 */
		public IPaletteDescription getDescription() {
			return description;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getContributionName() {
			return description.getName();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getContributionID() {
			return description.getPaletteID();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isHidden(ContributeToPaletteOperation operation) {
			// checks it is not in the list of hidden palettes for the editor
			List<String> hiddenPalettes = PapyrusPalettePreferences.getHiddenPalettes(operation.getEditor());
			return hiddenPalettes.contains(getContributionID());
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean provides(IOperation operation) {
			boolean isEnable = ActivityUtil.isEnabled(getContributionID(), Activator.ID);

			if(!isEnable) {
				return false;
			}

			if(operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = (ContributeToPaletteOperation)operation;

				IEditorPart part = o.getEditor();
				if(!(part instanceof DiagramEditorWithFlyOutPalette)) {
					return false;
				}

				// will never work, ID of the site is the multi diagram editor...
				if(description.getContributionEditorID() != null) {
					if(!description.getContributionEditorID().equals(((DiagramEditorWithFlyOutPalette)part).getContributorId())) {
						return false;
					}
				}

				if(!PaletteUtil.areRequiredProfileApplied(part, this)) {
					return false;
				}

				if(isHidden(o)) {
					return false;
				}
				return true;
			}

			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean providesWithVisibility(ContributeToPaletteOperation operation) {
			/**
			 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
			 */
			boolean isEnable = ActivityUtil.isEnabled(getContributionID(), Activator.ID);

			if(!isEnable) {
				return false;
			}
			// FIXME: that statement is always true (let's see the method's parameter).
			// => Remove the test
			if(operation instanceof ContributeToPaletteOperation) {
				ContributeToPaletteOperation o = operation;

				IEditorPart part = o.getEditor();
				if(!(part instanceof DiagramEditorWithFlyOutPalette)) {
					return false;
				}

				// will never work, ID of the site is the multi diagram editor...
				if(description.getContributionEditorID() != null) {
					if(!description.getContributionEditorID().equals(((DiagramEditorWithFlyOutPalette)part).getContributorId())) {
						return false;
					}
				}

				return true;
			}

			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public IProvider getProvider() {
			if(provider == null) {
				provider = new LocalPaletteProvider();
				((LocalPaletteProvider)provider).setContributions(description);
			}
			return provider;
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setContributions(IConfigurationElement configElement) {
		//  
	}

	/** the singleton instance of the palette service */
	private static PapyrusPaletteService instance;

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

		IEclipsePreferences prefs = new InstanceScope().getNode(Activator.ID);
		prefs.addPreferenceChangeListener(this);
	}

	/**
	 * add providers for local palettes
	 */
	protected void configureLocalPalettes() {
		// read the preference field that indicates where the local palettes
		// are, their IDs, etc...
		List<IPaletteDescription> localPalettes = PapyrusPalettePreferences.getLocalPalettes();
		// create the providers linked to these configuration

		// remove all local descriptors
		for(org.eclipse.gmf.runtime.common.core.service.Service.ProviderDescriptor descriptor : getProviders()) {
			if(descriptor instanceof LocalProviderDescriptor) {
				removeProvider(descriptor);
			}
		}

		// create new list
		for(IPaletteDescription palette : localPalettes) {
			LocalProviderDescriptor descriptor = new LocalProviderDescriptor(palette);
			addProvider(palette.getPriority(), descriptor);
		}

	}

	/**
	 * gets the singleton instance
	 * 
	 * @return <code>PaletteService</code>
	 */
	public static synchronized PapyrusPaletteService getInstance() {
		if(instance == null) {
			instance = new PapyrusPaletteService();
			instance.configureProviders(DiagramUIPlugin.getPluginId(), "paletteProviders"); //$NON-NLS-1$
			instance.configureProviders(Activator.ID, PALETTE_DEFINITION);
			instance.configureLocalPalettes();
		}
		return instance;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Service.ProviderDescriptor newProviderDescriptor(IConfigurationElement element) {
		return new ProviderDescriptor(element);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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
	 * Returns all contibution IDs from all palette contribution
	 * 
	 * @param editor
	 *        the editor to be contributed
	 * @param content
	 *        the content of the editor
	 * @param root
	 *        the palette root for the palette viewer of the editor
	 * @return the list of contributions
	 */
	public Map<String, PaletteEntry> getAllContributionsIds(IEditorPart editor, Object content, PaletteRoot root) {
		Map<String, PaletteEntry> entries = new HashMap<String, PaletteEntry>();
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
		ContributeToPaletteOperation operation = new ContributeToPaletteOperation(editor, content, root, entries);
		execute(operation);

		return entries;
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
	 * {@inheritDoc}
	 */
	@Override
	public PaletteRoot createPalette(final IEditorPart editor, final Object content) {
		final PaletteRoot root = new PaletteRoot();
		try {
			IEditingDomainProvider provider = (IEditingDomainProvider)editor.getAdapter(IEditingDomainProvider.class);
			if(provider != null) {
				EditingDomain domain = provider.getEditingDomain();
				if(domain instanceof TransactionalEditingDomain) {
					((TransactionalEditingDomain)domain).runExclusive(new Runnable() {

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
	 * {@inheritDoc}
	 */
	@Override
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
	 *        the palette container to be updated with new entries, have obsolete entries
	 *        removed, and whose existing entries will remain the same
	 * @param newContainer
	 *        the new palette entries
	 */
	protected void updatePaletteContainerEntries(PaletteContainer existingContainer, PaletteContainer newContainer) {
		HashMap existingEntryIds = new HashMap();
		for(Iterator iter = existingContainer.getChildren().iterator(); iter.hasNext();) {
			PaletteEntry entry = (PaletteEntry)iter.next();
			existingEntryIds.put(entry.getId(), entry);
		}

		int nextNewIndex = 0;
		// cycle through the new entries
		for(Iterator iter = newContainer.getChildren().iterator(); iter.hasNext();) {
			PaletteEntry newEntry = (PaletteEntry)iter.next();

			PaletteEntry existingEntry = (PaletteEntry)existingEntryIds.get(newEntry.getId());
			if(existingEntry != null) { // is already in existing container
				// update the index
				nextNewIndex = existingContainer.getChildren().indexOf(existingEntry) + 1;

				// remove the entry that was just updated from the map
				existingEntryIds.remove(existingEntry.getId());

				if(existingEntry instanceof PaletteContainer && newEntry instanceof PaletteContainer) {
					// look for new/deleted entries in
					// palette containers
					updatePaletteContainerEntries((PaletteContainer)existingEntry, (PaletteContainer)newEntry);
				}
			} else { // this is a new entry that did not previously exist
				existingContainer.add(nextNewIndex++, newEntry);
			}
		}

		// remove existing entries that were not found in the new container
		for(Iterator iter = existingEntryIds.values().iterator(); iter.hasNext();) {
			PaletteEntry entry = (PaletteEntry)iter.next();
			existingContainer.remove(entry);
		}

	}

	/**
	 * Returns the list of all providers that are really contributing to the palette
	 * 
	 * @param part
	 *        the editor part fopr which the palette is displayed
	 * @param root
	 *        the palette root of the current palette
	 * @return the list of all providers that are really contributing to the palette
	 */
	public List<PapyrusPaletteService.ProviderDescriptor> getContributingProviders(IEditorPart part, PaletteRoot root) {
		// init...
		// 1. inits the return list of providers contributing to the specified
		// editor part
		// 2. inits the operation used to check if the provider really provides
		// to this service
		// 3. inits the list of ids of hidden palettes
		List<PapyrusPaletteService.ProviderDescriptor> descriptors = new ArrayList<PapyrusPaletteService.ProviderDescriptor>();
		final ContributeToPaletteOperation o = new ContributeToPaletteOperation(part, part.getEditorInput(), root, new HashMap());
		// For each provider, checks it contributes to the palette of this editor part
		Iterator<? extends Service.ProviderDescriptor> it = getProviders().iterator();
		while(it.hasNext()) {
			Service.ProviderDescriptor provider = it.next();
			if(provider instanceof PapyrusPaletteService.ProviderDescriptor) {

				PapyrusPaletteService.ProviderDescriptor papyrusProviderDesc = (PapyrusPaletteService.ProviderDescriptor)provider;

				// get provider name
				String name = papyrusProviderDesc.getContributionName();
				if(name == null || name.equals("")) {
					name = papyrusProviderDesc.getContributionID();
				}

				// check if the name of the descriptor does not correspond to the name of a palette
				// that should not be removed
				boolean add = isChangeable(papyrusProviderDesc, name);

				// check if this provider is really contributing this palette
				add = add && isContributing(papyrusProviderDesc, o);

				if(add) {
					descriptors.add(papyrusProviderDesc);
				}
			} else {
				Activator.getDefault().logInfo("impossible to cast this provider: " + provider);
			}
		}

		return descriptors;
	}

	/**
	 * Checks if the name does not belong to a set of names that should not be in the action list
	 * 
	 * @param provider
	 *        the provider to check
	 * @param name
	 *        the name of the provider to check
	 * @return <code>true</code> if the provider should appear in the list of actions
	 */
	protected boolean isChangeable(PapyrusPaletteService.ProviderDescriptor provider, String name) {
		assert name != null;
		final String[] providersToRemove = new String[]{ "<Unnamed>", "Presentation Palette", "Geoshapes", "org.eclipse.papyrus.diagram.common" };
		final List<String> providersList = Arrays.asList(providersToRemove);

		// if the name is in the list, it is not changeable
		if(providersList.contains(name)) {
			return false;
		}
		// if it contains predefined entries in its name, it should return false
		return name.indexOf("Predefined Entries") == -1;
	}

	/**
	 * Checks if the provider descriptor is able to fill the palette for the current active diagram
	 * 
	 * @param provider
	 *        the provider to check
	 * @return <code>true</code> if the provider is able to fill the palette for the current active
	 *         diagram
	 */
	protected boolean isContributing(PapyrusPaletteService.ProviderDescriptor provider, ContributeToPaletteOperation o) {
		return provider.providesWithVisibility(o);
	}

	/**
	 * {@inheritDoc}
	 */
	public void preferenceChange(PreferenceChangeEvent event) {
		// listen for local palette preferences...

		String id = event.getKey();
		if(IPapyrusPaletteConstant.PALETTE_LOCAL_DEFINITIONS.equals(id)) {
			// refresh available palette table viewer
			getInstance().configureLocalPalettes();
			providerChanged(new ProviderChangeEvent(this));
		} else if(IPapyrusPaletteConstant.PALETTE_CUSTOMIZATIONS_ID.equals(id)) {
			// refresh available palette table viewer
			providerChanged(new ProviderChangeEvent(this));
		}
	}

}
