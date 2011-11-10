/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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

package org.eclipse.papyrus.uml.diagram.common.part;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.ContributeToPaletteOperation;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.SpecializationType;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.core.utils.PapyrusTrace;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeConnectionTool;
import org.eclipse.papyrus.uml.diagram.common.service.AspectUnspecifiedTypeCreationTool;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.uml.diagram.common.service.IProfileDependantPaletteProvider;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService.ProviderDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;

/**
 * Utility class for palette.
 */
public class PaletteUtil {

	/**
	 * Returns the parent container by its ID
	 * 
	 * @param entry
	 *        the palette container for which parent container is looked
	 * @param parentID
	 *        the id of the parent container
	 * @return the parent
	 */
	public static PaletteContainer getContainerByID(PaletteContainer container, String parentID) {
		// check this element is the searched parent;
		if(parentID.equals(container.getId())) {
			return container;
		}

		// element is not the parent. Look its children
		Iterator<PaletteContainer> it = getDirectChildContainers(container).iterator();
		while(it.hasNext()) {
			PaletteContainer tmp = getContainerByID(it.next(), parentID);
			if(tmp != null) {
				return tmp;
			}
		}
		return null;
	}

	/**
	 * Returns the type of metaclasses created by the toolentry
	 * 
	 * @param entry
	 *        the entry for which metaclass created is searched
	 * @return the type of metaclasses created by the toolentry or <code>null</code>.
	 */
	public static EClass getToolMetaclass(ToolEntry entry) {
		Tool tool = entry.createTool();
		List<IElementType> types = null;
		if(tool instanceof AspectUnspecifiedTypeCreationTool) {
			types = ((AspectUnspecifiedTypeCreationTool)tool).getElementTypes();
		} else if(tool instanceof AspectUnspecifiedTypeConnectionTool) {
			types = ((AspectUnspecifiedTypeConnectionTool)tool).getElementTypes();
		}
		if(types != null && types.size() > 0) {
			IElementType type = types.get(0);

			if(type instanceof SpecializationType) {
				type = ((SpecializationType)type).getSpecializedTypes()[0];
			}
			return type.getEClass();
		}
		return null;
	}

	/**
	 * Returns the parent container by its ID
	 * 
	 * @param entry
	 *        the palette entry for which parent container is looked
	 * @param parentID
	 *        the id of the parent container
	 * @return the parent
	 */
	public static PaletteContainer getContainerByID(PaletteEntry entry, String parentID) {
		// retrieve the root
		PaletteContainer root = getRoot(entry);
		return getContainerByID(root, parentID);
	}

	/**
	 * Return the child containers directly contained by the specified container
	 * 
	 * @param container
	 *        the container to look in.
	 * @return the list of directly contained elements
	 */
	@SuppressWarnings("unchecked")
	public static List<PaletteContainer> getDirectChildContainers(PaletteContainer container) {
		List<PaletteContainer> containers = new ArrayList<PaletteContainer>();
		Iterator<PaletteEntry> it = container.getChildren().iterator();
		while(it.hasNext()) {
			PaletteEntry entry = it.next();
			if(entry instanceof PaletteContainer) {
				containers.add((PaletteContainer)entry);
			}
		}
		return containers;
	}

	/**
	 * Retrieves the root element for the given container
	 * 
	 * @param container
	 *        the container for which the root is searched
	 * @return the root of the container
	 */
	public static PaletteContainer getRoot(PaletteContainer container) {
		// if container has a parent, returns it.
		if(container.getParent() != null) {
			return getRoot(container.getParent());
		}
		// else, root element is the container itself.
		return container;
	}

	/**
	 * Retrieves the root element for the given palette entry
	 * 
	 * @param container
	 *        the container for which the root is searched
	 * @return the root of the container
	 */
	public static PaletteContainer getRoot(PaletteEntry entry) {
		return getRoot(entry.getParent());
	}

	/**
	 * Default constructor. Should never be used, as method are static in this
	 * class.
	 */
	// @unused
	private PaletteUtil() {

	}

	/**
	 * return tool entries for the given {@link PaletteContainer} and its
	 * sub-containers
	 * 
	 * @param container
	 *        the container that contains the ToolEntries
	 * @return the list of tool entries or an empty list
	 */
	public static List<ToolEntry> getAllToolEntries(PaletteContainer container) {
		final List<ToolEntry> entries = new ArrayList<ToolEntry>();
		Iterator<PaletteEntry> it = container.getChildren().iterator();
		while(it.hasNext()) {
			PaletteEntry entry = it.next();
			if(entry instanceof ToolEntry) {
				entries.add((ToolEntry)entry);
			}
			if(entry instanceof PaletteContainer) {
				entries.addAll(getAllToolEntries((PaletteContainer)entry));
			}
		}
		return entries;
	}

	/**
	 * Looks for the memento with the correct id from the root momento
	 * 
	 * @param rootMemento
	 *        the root memento from which the memento is searched
	 * @param id
	 *        the id of the memento to search
	 * @return the memento with the given ID or <code>null</code> if no memento
	 *         was found
	 */
	// @unused
	public static IMemento getMemento(IMemento rootMemento, String id) {
		IMemento memento = null;
		memento = rootMemento.getChild(id);
		return memento;
	}

	/**
	 * Return all entries from a palette
	 * 
	 * @param paletteRoot
	 *        the root from which tools are retrieved
	 * @return the list of entries
	 */
	public static List<PaletteEntry> getAllEntries(PaletteContainer container) {
		List<PaletteEntry> elements = new ArrayList<PaletteEntry>();
		for(Object object : container.getChildren()) {
			if(object instanceof PaletteContainer) {
				elements.add((PaletteContainer)object);
				elements.addAll(getAllEntries((PaletteContainer)object));
			} else if(object instanceof ToolEntry) {
				elements.add((ToolEntry)object);
			}
		}
		return elements;
	}

	/**
	 * Returns all available entries for the given editor ID
	 * 
	 * @param editorID
	 *        the editor to be contributed
	 * @param priority
	 *        the priority max for the entries
	 * @return the set of available entries
	 */
	public static Set<? extends PaletteEntry> getAvailableEntries(IEditorPart part, ProviderPriority priority) {
		Set<? extends PaletteEntry> entries = new HashSet<PaletteEntry>();

		// retrieve all provider for the given editor ID
		PaletteRoot root = new PaletteRoot();
		List<? extends PapyrusPaletteService.ProviderDescriptor> providers = (List<? extends ProviderDescriptor>)PapyrusPaletteService.getInstance().getProviders();
		ContributeToPaletteOperation operation = new ContributeToPaletteOperation(part, part.getEditorInput(), root, new HashMap<Object, Object>());

		// generate for each provider, according to priority
		@SuppressWarnings("unchecked")
		List<PapyrusPaletteService.ProviderDescriptor> providerList = (List<PapyrusPaletteService.ProviderDescriptor>)PapyrusPaletteService.getInstance().getProviders();
		for(PapyrusPaletteService.ProviderDescriptor descriptor : providerList) {
			int compare = descriptor.getPriority().compareTo(priority);
			if(compare < 0) {
				if(descriptor.providesWithVisibility(operation)) {
					((IPaletteProvider)descriptor.getProvider()).contributeToPalette(part, part.getEditorInput(), root, new HashMap<Object, Object>());
				}
			}
		}
		return entries;
	}

	/**
	 * Returns all available entries for the given editor ID
	 * 
	 * @param editorID
	 *        the editor to be contributed
	 * @param priority
	 *        the priority max for the entries
	 * @return the set of available entries
	 */
	public static Map<String, PaletteEntry> getAvailableEntriesSet(IEditorPart part, ProviderPriority priority) {
		Map<String, PaletteEntry> entries = new HashMap<String, PaletteEntry>();

		// retrieve all provider for the given editor ID
		PaletteRoot root = new PaletteRoot();
		List<? extends PapyrusPaletteService.ProviderDescriptor> providers = (List<? extends ProviderDescriptor>)PapyrusPaletteService.getInstance().getProviders();
		ContributeToPaletteOperation operation = new ContributeToPaletteOperation(part, part.getEditorInput(), root, entries);

		// generate for each provider, according to priority
		@SuppressWarnings("unchecked")
		List<PapyrusPaletteService.ProviderDescriptor> providerList = (List<PapyrusPaletteService.ProviderDescriptor>)PapyrusPaletteService.getInstance().getProviders();
		for(PapyrusPaletteService.ProviderDescriptor descriptor : providerList) {
			int compare = descriptor.getPriority().compareTo(priority);
			if(compare <= 0) {
				if(descriptor.providesWithVisibility(operation)) {
					((IPaletteProvider)descriptor.getProvider()).contributeToPalette(part, part.getEditorInput(), root, entries);
				}
			}
		}
		return entries;
	}

	/**
	 * Returns the list of stereotypes String from a serialize string form
	 * 
	 * @param serializedForm
	 *        the serialized form of the list of stereotypes
	 * @return the list of stereotypes String from a serialize string form
	 */
	public static List<String> getStereotypeListFromString(String serializedForm) {
		StringTokenizer tokenizer = new StringTokenizer(serializedForm, ",");
		List<String> list = new ArrayList<String>();
		while(tokenizer.hasMoreElements()) {
			list.add(tokenizer.nextToken().trim());
		}
		return list;
	}

	/**
	 * Returns the list of stereotypes String under a serialized form
	 * 
	 * @param list
	 *        the list of stereotypes to serialize
	 * @return the list of stereotypes String under a serialized form
	 */
	public static String getSerializedStereotypeListFromList(List<String> list) {
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = list.listIterator();
		while(it.hasNext()) {
			buffer.append(it.next());
			if(it.hasNext()) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns the name of the profile from the given stereotype qualified Name
	 * 
	 * @param stereotypeName
	 *        the name of the stereotype to parse
	 * @return the qualified name of the profile from the given stereotype
	 *         qualified Name
	 */
	public static String findProfileNameFromStereotypeName(String stereotypeName) {
		return stereotypeName.substring(0, stereotypeName.lastIndexOf(NamedElement.SEPARATOR));
	}

	/**
	 * Returns the list of profile Qualified Names String under a serialized
	 * form
	 * 
	 * @param list
	 *        the list of profiles to serialize
	 * @return the list of profiles String under a serialized form
	 */
	public static String getSerializedProfileListFromSet(Set<String> profiles) {
		StringBuffer buffer = new StringBuffer();
		Iterator<String> it = profiles.iterator();
		while(it.hasNext()) {
			buffer.append(it.next());
			if(it.hasNext()) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns the list of profiles String from a serialize string form
	 * 
	 * @param serializedForm
	 *        the serialized form of the list of stereotypes
	 * @return the list of profiles String from a serialize string form
	 */
	public static Set<String> getProfileSetFromString(String serializedForm) {
		StringTokenizer tokenizer = new StringTokenizer(serializedForm, ",");
		Set<String> list = new HashSet<String>();
		while(tokenizer.hasMoreElements()) {
			list.add(tokenizer.nextToken());
		}
		return list;
	}

	/**
	 * returns <code>true</code> if the descriptor have all necessary profiles
	 * 
	 * @param part
	 *        the editor part for which the palette is shown
	 * @param papyrusProviderDesc
	 *        the current provider descriptor to test
	 * @return <code>true</code> if all required profile are present
	 */
	public static boolean areRequiredProfileApplied(IEditorPart part, PapyrusPaletteService.ProviderDescriptor papyrusProviderDesc) {
		if(!(part instanceof DiagramEditorWithFlyOutPalette)) {
			PapyrusTrace.log(IStatus.WARNING, "trying to check a papyrus palette descriptor outside papyrus framework");
			return false;
		}
		if(papyrusProviderDesc instanceof PapyrusPaletteService.LocalProviderDescriptor) {
			IPaletteDescription description = ((PapyrusPaletteService.LocalProviderDescriptor)papyrusProviderDesc).getDescription();
			// checks the presence of required profile
			Diagram diagram = ((DiagramEditorWithFlyOutPalette)part).getDiagram();
			EObject element = diagram.getElement();
			if(element instanceof Element) {
				org.eclipse.uml2.uml.Package package_ = ((Element)element).getNearestPackage();
				List<Profile> appliedProfiles = package_.getAllAppliedProfiles();
				List<String> appliedProfilesNames = new ArrayList<String>();
				for(Profile profile : appliedProfiles) {
					appliedProfilesNames.add(profile.getQualifiedName());
				}

				// compare to the list of profiles used by the palette
				Map<String, String> properties = description.getProperties();
				if(description != null) {
					String requiredProfilesList = properties.get(IPapyrusPaletteConstant.PROFILE_LIST);
					if(requiredProfilesList != null) {
						// parse requiredProfile string (profile1QN, profile2QN,
						// etc.)
						Set<String> requiredProfiles = PaletteUtil.getProfileSetFromString(requiredProfilesList);
						for(String requiredProfileName : requiredProfiles) {
							if(!appliedProfilesNames.contains(requiredProfileName)) {
								return false;
							}
						}
					}
				}
			}
		} else {
			IProvider provider = papyrusProviderDesc.getProvider();
			if(provider instanceof IProfileDependantPaletteProvider) {
				Diagram diagram = ((DiagramEditorWithFlyOutPalette)part).getDiagram();
				EObject element = diagram.getElement();
				if(element instanceof Element) {
					org.eclipse.uml2.uml.Package package_ = ((Element)element).getNearestPackage();
					List<Profile> appliedProfiles = package_.getAllAppliedProfiles();
					List<String> appliedProfilesNames = new ArrayList<String>();
					for(Profile profile : appliedProfiles) {
						appliedProfilesNames.add(profile.getQualifiedName());
					}
					// not null also
					Collection<String> requiredProfiles = ((IProfileDependantPaletteProvider)provider).getRequiredProfiles();
					for(String requiredProfileName : requiredProfiles) {
						if(!appliedProfilesNames.contains(requiredProfileName)) {
							return false;
						}
					}
				}
				return true;
			}
		}
		// by default, returns true if the descriptor is not a local descriptor,
		// as they do not use
		// profile
		return true;
	}

}
