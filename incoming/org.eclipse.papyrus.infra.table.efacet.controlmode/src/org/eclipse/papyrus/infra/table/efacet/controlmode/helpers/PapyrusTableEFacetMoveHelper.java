/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.controlmode.helpers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.widgets.table.metamodel.v0_2_0.table.FeatureColumn;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.core.modelsetquery.ModelSetQuery;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.notation.NotationModel;
import org.eclipse.papyrus.infra.core.resource.notation.NotationUtils;
import org.eclipse.papyrus.infra.core.sashwindows.di.PageRef;
import org.eclipse.papyrus.infra.core.sashwindows.di.SashWindowsMngr;
import org.eclipse.papyrus.infra.core.sashwindows.di.exception.SashEditorException;
import org.eclipse.papyrus.infra.core.sashwindows.di.util.DiUtils;
import org.eclipse.papyrus.infra.services.controlmode.history.HistoryModel;
import org.eclipse.papyrus.infra.services.controlmode.history.utils.HistoryUtils;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.ControledResource;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.historyFactory;
import org.eclipse.papyrus.infra.services.controlmode.mm.history.historyPackage;
import org.eclipse.papyrus.infra.table.efacet.common.utils.AdditionalContentsFacetSetUtils;
import org.eclipse.papyrus.infra.table.efacet.controlmode.Activator;
import org.eclipse.papyrus.infra.table.efacet.controlmode.messages.Messages;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTable;
import org.eclipse.papyrus.infra.table.efacet.metamodel.papyrustable.PapyrusTableUtils;


/**
 * Helper used to move the tables into the right resources when controlling a package.
 */
public class PapyrusTableEFacetMoveHelper {


	/**
	 * Instantiates a new papyrus table move helper.
	 */
	private PapyrusTableEFacetMoveHelper() {
		//to prevent instanciation
	}

	/**
	 * This methods add the tables to the page list in the di file.
	 *
	 * @param domain
	 *        the editing domain
	 * @param selection
	 *        the selection
	 * @param source
	 *        the source resource
	 * @param target
	 *        the target resource
	 * @param windowsMngr
	 *        the windows manager used to add pages
	 * @param commandToModify
	 *        the command to contribute
	 */
	public static void addAllPageRefTableMoveCommands(final TransactionalEditingDomain domain, final EObject selection, final Resource source, final Resource target, final SashWindowsMngr windowsMngr, final CompoundCommand commandToModify) {
		final ModelSet modelSet = (ModelSet)source.getResourceSet();
		final Resource notation = NotationUtils.getNotationModel(modelSet).getResource();

		//1. we get the PapyrusTable to move
		final List<PapyrusTable> tables = PapyrusTableUtils.getPapyrusTable(notation, selection);

		//2. add pages to the page list
		for(final PapyrusTable pTable : tables) {
			final PageRef pageRef = DiUtils.getPageRef(source, pTable);
			final ICommand addPageCommand = new AbstractTransactionalCommand(domain, Messages.PapyrusTableEFacetMoveHelper_AddPageCommand, null) {

				@Override
				protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
					windowsMngr.getPageList().addPage(pageRef.getPageIdentifier());
					try {
						DiUtils.addPageToTabFolder(windowsMngr, pageRef);
					} catch (final SashEditorException e) {
						Activator.log.error(e);
						return CommandResult.newErrorCommandResult(e);
					}
					return CommandResult.newOKCommandResult();
				}
			};

			commandToModify.append(new GMFtoEMFCommandWrapper(addPageCommand));
		}
	}

	/**
	 * This method adds the command to control/uncontrol Table Efacet from a resource to another one into commandToModify.
	 *
	 * @param domain
	 *        the editing domain for the command
	 * @param selection
	 *        the selection
	 * @param source
	 *        the source resource
	 * @param target
	 *        the target resource
	 * @param commandToModify
	 *        the command to modify
	 */
	public static void addAllTableMoveCommands(final EditingDomain domain, final EObject selection, final Resource source, final Resource target, final CompoundCommand commandToModify) {
		//1. we get the PapyrusTable to move
		final List<PapyrusTable> tables = PapyrusTableUtils.getPapyrusTable(source, selection);

		//2. we build the move command for PapyrusTable
		if(!tables.isEmpty()) {
			commandToModify.append(new AddCommand(domain, target.getContents(), tables));

			//3. we look for the additionalFacetSet
			final FacetSet additionalSetSource = AdditionalContentsFacetSetUtils.getAdditionalContentFacetSet(source);
			final FacetSet additionalSetTarget = AdditionalContentsFacetSetUtils.getAdditionalContentFacetSet(target);

			//indicate if we should move the additionalFacetSet from the source to the target
			boolean moveAdditionalFacetSet = false;
			if(additionalSetSource == null && additionalSetTarget == null) {
				//nothing to do
			} else if(additionalSetSource == null && additionalSetTarget != null) {
				//nothing to do
			} else if(additionalSetSource != null) {
				final Iterator<PapyrusTable> iterPTable = tables.iterator();
				while(iterPTable.hasNext() && !moveAdditionalFacetSet) {
					moveAdditionalFacetSet = iterPTable.next().getTable().getFacetSets().contains(additionalSetSource);
				}

				if(moveAdditionalFacetSet) {
					if(additionalSetTarget != null) {
						Command tmp = getMergeAdditionalContentsFacetSetCommand((TransactionalEditingDomain)domain, tables, additionalSetSource, additionalSetTarget);
						if(tmp != null) {
							commandToModify.append(tmp);
						}
						tmp = getUpdateAdditionalContentsFacetSetCommand((TransactionalEditingDomain)domain, tables, additionalSetSource, additionalSetTarget);
						if(tmp != null) {
							commandToModify.append(tmp);
						}
						//the mapping between the merged facetset element is already done by the previous commands
						final Map<EObject, EObject> mapping = createMappingBetweenFacetSets(additionalSetSource, additionalSetTarget);
						commandToModify.append(getUpdateFacetElementReferencesCommand((TransactionalEditingDomain)domain, tables, mapping));

					} else {
						//we should copy the AdditionalContentsFacetSet
						final Copier copier = new Copier();
						final FacetSet copy = (FacetSet)copier.copy(additionalSetSource);
						copier.copyReferences();
						final ICommand addToResource = new AbstractTransactionalCommand((TransactionalEditingDomain)domain, Messages.PapyrusTableEFacetMoveHelper_AddAdditionalContentsFacetSet, null) {

							@Override
							protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
								target.getContents().add(copy);
								return CommandResult.newOKCommandResult();
							}
						};
						commandToModify.append(new GMFtoEMFCommandWrapper(addToResource));
						commandToModify.append(getCopyXMI_IDCommand((TransactionalEditingDomain)domain, copier));
						Command tmp = getUpdateAdditionalContentsFacetSetCommand((TransactionalEditingDomain)domain, tables, additionalSetSource, copy);
						if(tmp != null) {
							commandToModify.append(tmp);
						}
						tmp = getUpdateFacetElementReferencesCommand((TransactionalEditingDomain)domain, tables, copier);
						if(tmp != null) {
							commandToModify.append(tmp);
						}
					}
				}
			}
		}
	}

	/**
	 * Creates the xm i_ i d_ map for facet set contents.
	 *
	 * @param set
	 *        a facetset
	 * @return the map
	 *         a map with the XMI_ID of the facet as key and its eobject as value
	 */
	private static Map<String, EObject> createXMI_ID_MapForFacetSetContents(final FacetSet set) {
		final Map<String, EObject> map = new HashMap<String, EObject>();
		final XMIResource resource = (XMIResource)set.eResource();
		final Iterator<EObject> iter = set.eAllContents();
		while(iter.hasNext()) {
			final EObject key = iter.next();
			final String XMI_ID = resource.getID(key);
			map.put(XMI_ID, key);
		}
		return map;
	}

	/**
	 * Creates the mapping between facet sets.
	 *
	 * @param source
	 *        the source FacetSet (should be the AdditionalContentsFacetSet source
	 * @param target
	 *        the target FacetSet (should be the AdditionalContentsFacetSet target
	 * @return the map
	 *         a map with the source elements as key and the target elements as values
	 */
	private static Map<EObject, EObject> createMappingBetweenFacetSets(final FacetSet source, final FacetSet target) {
		final Map<String, EObject> sourceMap = createXMI_ID_MapForFacetSetContents(source);
		final Map<String, EObject> targetMap = createXMI_ID_MapForFacetSetContents(target);
		final Map<EObject, EObject> mapping = new HashMap<EObject, EObject>();

		for(final String xmi_id : sourceMap.keySet()) {
			final EObject key = sourceMap.get(xmi_id);
			final EObject value = targetMap.get(xmi_id);
			if(value != null) {
				mapping.put(key, value);
			}
		}
		return mapping;
	}

//	/**
//	 * FIXME : duplicated code from infra.service.controlmode
//	 * Get the history resource of the specified eObject
//	 *
//	 * @param eObject
//	 *        the e object
//	 * @param modelSet
//	 *        the model set
//	 * @return the history resource
//	 */
//	private static Resource getHistoryResource(final EObject eObject, final ModelSet modelSet) {
//		if(eObject.eResource() != null) {
//			return modelSet.getResource(eObject.eResource().getURI().trimFileExtension().appendFileExtension(HistoryModel.MODEL_FILE_EXTENSION), true);
//		}
//		return null;
//	}

//	/**
//	 * FIXME : duplicated code from infra.service.controlmode
//	 * Analyze the history model to update the controlled children
//	 *
//	 * @param domain
//	 *        the domain
//	 * @param compoundCommand
//	 *        the compound command
//	 * @param model
//	 *        the model
//	 * @param currentURL
//	 *        the current url
//	 * @param newURL
//	 *        the new url
//	 * @param eObject
//	 *        the e object
//	 */
//	static protected void assignControlledResourceOfCurrentElement(final EditingDomain domain, final CompoundCommand compoundCommand, final Resource model, final String currentURL, final String newURL, final EObject eObject) {
//		if(model == null) {
//			return;
//		}
//		// create relative path
//		final URI uriPath = HistoryUtils.getURIFullPath(currentURL);
//		final String currentURLResolved = HistoryUtils.resolve(uriPath, currentURL);
//		final String newURLResolved = HistoryUtils.resolve(uriPath, newURL);
//
//		final ControledResource child = historyFactory.eINSTANCE.createControledResource();
//		child.setResourceURL(newURLResolved);
//
//		final ControledResource resource = getControledResource(model);
//		Resource parentResource = null;
//
//		// create the controlled resource according to the control action
//		ControledResource parent = null;
//		if(resource == null) {
//			parent = historyFactory.eINSTANCE.createControledResource();
//			parent.setResourceURL(currentURLResolved);
//			parent.getChildren().add(child);
//			parentResource = model;
//			compoundCommand.append(new AddCommand(domain, parentResource.getContents(), Collections.singleton(parent)));
//		} else {
//			if(isCurrentURL(currentURLResolved, resource)) {
//				parent = resource;
//			}
//			if(parent == null) {
//				final EObject modelRoot = getControledResource(model);
//				final Collection<EObject> controled = ModelSetQuery.getObjectsOfType(modelRoot, historyPackage.Literals.CONTROLED_RESOURCE);
//				for(final EObject next : controled) {
//					if(next instanceof ControledResource) {
//						final ControledResource tmp = (ControledResource)next;
//						if(isCurrentURL(currentURLResolved, tmp)) {
//							parent = tmp;
//							break;
//						}
//					}
//				}
//			}
//			if(parent == null) {
//				parent = historyFactory.eINSTANCE.createControledResource();
//				parent.setResourceURL(currentURLResolved);
//				parentResource = resource.eResource();
//				// add controlled resource command for notation is done in assignToChildExistingControledResources
//				if(!currentURLResolved.endsWith(NotationModel.NOTATION_FILE_EXTENSION)) {
//					compoundCommand.append(new AddCommand(domain, parentResource.getContents(), Collections.singleton(parent)));
//				}
//			}
//			if(parent != null) {
//				compoundCommand.append(AddCommand.create(domain, parent, historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, Collections.singleton(child)));
//			}
//		}
//		final List<ControledResource> controledFromParent = new LinkedList<ControledResource>();
//		if(parentResource == null) {
//			parentResource = model;
//		}
//		if(parentResource != null) {
//			for(final EObject e : parentResource.getContents()) {
//				if(e instanceof ControledResource) {
//					final ControledResource aControled = (ControledResource)e;
//					controledFromParent.add(aControled);
//					for(final Iterator<EObject> i = aControled.eAllContents(); i.hasNext();) {
//						final EObject tmp = i.next();
//						if(tmp instanceof ControledResource) {
//							controledFromParent.add((ControledResource)tmp);
//						}
//					}
//				}
//			}
//		}
//		// manage move of existing controlled resources
//		if(!newURL.endsWith(NotationModel.NOTATION_FILE_EXTENSION)) {
//			assignToChildExistingControledResources(domain, compoundCommand, child, newURL, controledFromParent, currentURL, URI.createURI(newURL), uriPath, eObject, (ModelSet)domain.getResourceSet());
//		}
//	}

//	/**
//	 * FIXME : duplicated code from infra.service.controlmode
//	 * Check if an URL is the current one of the specified resource
//	 *
//	 * @param currentURL
//	 *        the current url
//	 * @param resource
//	 *        the resource
//	 * @return true, if is current url
//	 */
//	static protected boolean isCurrentURL(final String currentURL, final ControledResource resource) {
//		return resource.getResourceURL() != null && resource.getResourceURL().equals(currentURL);
//	}

//	/**
//	 * FIXME : duplicated code from infra.service.controlmode
//	 * Get the controlled resource in a specified resource
//	 *
//	 * @param resource
//	 *        the resource
//	 * @return the controled resource
//	 */
//	static protected ControledResource getControledResource(final Resource resource) {
//		for(final EObject e : resource.getContents()) {
//			if(e instanceof ControledResource) {
//				return (ControledResource)e;
//
//			}
//		}
//		return null;
//	}

//	/**
//	 * FIXME : duplicated code from infra.service.controlmode
//	 * FIXME : required?
//	 * Manage move of existing controlled resources
//	 *
//	 * @param domain
//	 *        the domain
//	 * @param compoundCommand
//	 *        the compound command
//	 * @param child
//	 *        the child
//	 * @param controledResourceURL
//	 *        the controled resource url
//	 * @param controledFromParent
//	 *        the controled from parent
//	 * @param parentURL
//	 *        the parent url
//	 * @param controledURIFullPath
//	 *        the controled uri full path
//	 * @param parentURIFullPath
//	 *        the parent uri full path
//	 * @param eObject
//	 *        the e object
//	 * @param modelSet
//	 *        the model set
//	 */
//	static protected void assignToChildExistingControledResources(final EditingDomain domain, final CompoundCommand compoundCommand, final ControledResource child, final String controledResourceURL, final List<ControledResource> controledFromParent, final String parentURL, final URI controledURIFullPath, final URI parentURIFullPath, final EObject eObject, final ModelSet modelSet) {
//		for(final ControledResource r : controledFromParent) {
//			if(r.getResourceURL() != null) {
//				final URI fullPathParent = URI.createURI(r.getResourceURL()).resolve(parentURIFullPath);
//				final Resource resourceLoaded = modelSet.getResource(fullPathParent, false);
//				if(resourceLoaded != null && !resourceLoaded.getContents().isEmpty()) {
//					final EObject top = resourceLoaded.getContents().get(0);
//					if(isInRootHierarchy(top, eObject)) {
//						// manage model
//						final URI newResolvedURIFromChild = fullPathParent.deresolve(controledURIFullPath, false, true, true);
//						final ControledResource aNewOne = historyFactory.eINSTANCE.createControledResource();
//						aNewOne.setResourceURL(newResolvedURIFromChild.toString());
//
//						//TODO
//						final Resource controlledDI = null;
//						// add new control resource to the new history
//						compoundCommand.append(new AddCommand(domain, getControledResource(controlledDI, URI.createURI(controledResourceURL).lastSegment(), compoundCommand, domain), historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, aNewOne));
//						// remove old controlled resource from the parent resource
//						compoundCommand.append(RemoveCommand.create(domain, r.eContainer(), historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, r));
//
//						// manage notation
//						final URI newNotation = newResolvedURIFromChild.trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION);
//						final ControledResource aNewOneNotation = historyFactory.eINSTANCE.createControledResource();
//						aNewOneNotation.setResourceURL(newNotation.toString());
//						// add new control resource to the new history
//						compoundCommand.append(new AddCommand(domain, getControledResource(controlledDI, URI.createURI(URI.createURI(controledResourceURL).trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION).toString()).lastSegment(), compoundCommand, domain), historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, aNewOneNotation));
//						// remove old controlled resource from the parent resource
//						final URI notationParentURL = URI.createURI(r.getParent().getResourceURL()).trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION);
//						final ControledResource notationParent = getControledResource(r.eResource(), notationParentURL.toString(), compoundCommand, domain);
//						for(final ControledResource notationChild : notationParent.getChildren()) {
//							//URI notationURI = newResolvedURIFromChild.trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION);
//							final URI notationURI = URI.createURI(r.getResourceURL()).trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION);
//							if(notationChild.getResourceURL().equals(notationURI.toString())) {
//								compoundCommand.append(RemoveCommand.create(domain, notationParent, historyPackage.Literals.CONTROLED_RESOURCE__CHILDREN, notationChild));
//							}
//						}
//					}
//				}
//			}
//		}
//	}

//	/**
//	 * FIXME : duplicated code from infra.service.controlmode
//	 * Check if an EObject start is in root hierarchy of another eObject search
//	 *
//	 * @param start
//	 *        the start
//	 * @param search
//	 *        the search
//	 * @return true, if is in root hierarchy
//	 */
//	protected static boolean isInRootHierarchy(EObject start, final EObject search) {
//		while(start != null && start != search) {
//			start = start.eContainer();
//		}
//		return start != null;
//	}

//	/**
//	 * FIXME : duplicated code from infra.service.controlmode
//	 *
//	 * Get the controlled resource for the specified URL, create it if it doesn't exist
//	 *
//	 * @param resource
//	 *        the resource
//	 * @param controledResourceURL
//	 *        the controled resource url
//	 * @param command
//	 *        the command
//	 * @param domain
//	 *        the domain
//	 * @return the controled resource
//	 */
//	static protected ControledResource getControledResource(final Resource resource, final String controledResourceURL, final CompoundCommand command, final EditingDomain domain) {
//		ControledResource result = null;
//		for(final EObject e : resource.getContents()) {
//			if(e instanceof ControledResource) {
//				final ControledResource controled = (ControledResource)e;
//				if(controledResourceURL != null && controledResourceURL.equals(controled.getResourceURL())) {
//					result = controled;
//				}
//			}
//		}
//		if(result == null) {
//			result = historyFactory.eINSTANCE.createControledResource();
//			result.setResourceURL(controledResourceURL);
//			command.append(new AddCommand(domain, resource.getContents(), result, 0));
//		}
//		return result;
//	}

	/**
	 * Gets the merge additional contents facet set command.
	 *
	 * @param domain
	 *        the editing domain used by the command
	 * @param tables
	 *        the controlled tables
	 * @param source
	 *        the AdditionalContentsFacetSet source
	 * @param target
	 *        the AdditionalContentsFacetSet target
	 * @return the merge additional contents facet set command
	 *         the command to merge the AdditionalContentsFacetSet source into the target or <code>null</code> if there is nothing to do
	 */
	private static Command getMergeAdditionalContentsFacetSetCommand(final TransactionalEditingDomain domain, final Collection<PapyrusTable> tables, final FacetSet source, final FacetSet target) {
		final CompoundCommand compoundCommand = new CompoundCommand(Messages.PapyrusTableEFacetMoveHelper_MergeAdditionalContentsFacetSet);
		//1. we init the maps
		final Map<String, FacetSet> sourceMap = createXMI_ID_Map_ForFirstFacetSets(source);
		final Map<String, FacetSet> targeteMap = createXMI_ID_Map_ForFirstFacetSets(target);

		//2. we look for the facet set to create
		for(final String XMI_ID : sourceMap.keySet()) {
			final FacetSet sourceFacetSet = sourceMap.get(XMI_ID);
			final FacetSet targetFacetSet = targeteMap.get(XMI_ID);
			if(targetFacetSet == null) {
				//we create the facetset
				final Copier copier = new Copier();
				final FacetSet copy = (FacetSet)copier.copy(sourceFacetSet);
				copier.copyReferences();
				targeteMap.put(XMI_ID, copy);
				final ICommand addFacetSetToAdditionalContentsFacetSet = new AbstractTransactionalCommand(domain, null, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						target.getESubpackages().add(copy);
						return CommandResult.newOKCommandResult();
					}
				};
				compoundCommand.append(new GMFtoEMFCommandWrapper(addFacetSetToAdditionalContentsFacetSet));
				compoundCommand.append(getCopyXMI_IDCommand(domain, copier));
				final Command tmp = getUpdateFacetElementReferencesCommand(domain, tables, copier);
				if(tmp != null) {
					compoundCommand.append(tmp);
				}
			}
		}
		if(compoundCommand.isEmpty()) {
			return null;
		} else {
			return compoundCommand;
		}
	}

	/**
	 * Creates the xm i_ i d_ map_ for first facet sets.
	 *
	 * @param set
	 *        a facetset
	 * @return the map
	 *         a map with the XMI_ID of the owned subFacetSet (first level only) as key and the corresponding FacetSet as value
	 */
	private static Map<String, FacetSet> createXMI_ID_Map_ForFirstFacetSets(final FacetSet set) {
		final Map<String, FacetSet> map = new HashMap<String, FacetSet>();
		final XMIResource sourceRes = (XMIResource)set.eResource();
		for(final EPackage current : set.getESubpackages()) {
			if(current instanceof FacetSet) {
				final String XMI_ID = sourceRes.getID(current);
				map.put(XMI_ID, (FacetSet)current);
			}
		}
		return map;
	}

	/**
	 * Gets the update additional contents facet set command.
	 *
	 * @param domain
	 *        the editing domain
	 * @param papyrusTables
	 *        the controlled tables
	 * @param oldAdditionalContentsFacetSet
	 *        the old AdditionalContentsFacetSet
	 * @param newAdditionalContentsFacetSet
	 *        the old AdditionalContentsFacetSet
	 * @return the update additional contents facet set command
	 *         the command to replace calls to the old AdditionalContentsFacetSet by calls to the new AdditionalContentsFacetSet or <code>null</code>
	 *         if there is nothing to do
	 */
	private static Command getUpdateAdditionalContentsFacetSetCommand(final TransactionalEditingDomain domain, final Collection<PapyrusTable> papyrusTables, final FacetSet oldAdditionalContentsFacetSet, final FacetSet newAdditionalContentsFacetSet) {
		final CompoundCommand updateCommand = new CompoundCommand(Messages.PapyrusTableEFacetMoveHelper_UpdateAdditionalContentsFacetSet);
		for(final PapyrusTable pTable : papyrusTables) {
			final List<FacetSet> currentFacetSets = new ArrayList<FacetSet>(pTable.getTable().getFacetSets());
			if(currentFacetSets.contains(oldAdditionalContentsFacetSet)) {
				final ICommand replaceUsedFacetSet = new AbstractTransactionalCommand(domain, Messages.PapyrusTableEFacetMoveHelper_ReplaceCalls, null) {

					@Override
					protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
						final int index = currentFacetSets.indexOf(oldAdditionalContentsFacetSet);
						currentFacetSets.remove(index);
						currentFacetSets.add(index, newAdditionalContentsFacetSet);
						pTable.getTable().getFacetSets().clear();
						pTable.getTable().getFacetSets().addAll(currentFacetSets);
						return CommandResult.newOKCommandResult();
					}
				};
				updateCommand.append(new GMFtoEMFCommandWrapper(replaceUsedFacetSet));
			}

		}
		if(updateCommand.isEmpty()) {
			return null;
		} else {
			return updateCommand;
		}
	}

	/**
	 * Gets the copy xm i_ id command.
	 *
	 * @param domain
	 *        the editing domain for the command
	 * @param map
	 *        the map with the source object as key and the target object as value
	 * @return the copy xm i_ id command
	 *         the command set the XMI_ID of the source eobject to the target eobject
	 */
	private static Command getCopyXMI_IDCommand(final TransactionalEditingDomain domain, final Map<EObject, EObject> map) {
		final ICommand copyXMI_ID_Command = new AbstractTransactionalCommand(domain, Messages.PapyrusTableEFacetMoveHelper_CopyXMIIDCommand, null) {

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				for(final EObject sourceValue : map.keySet()) {
					final EObject targetValue = map.get(sourceValue);
					Assert.isNotNull(targetValue);
					final XMIResource sourceRes = (XMIResource)sourceValue.eResource();
					final XMIResource targetRes = (XMIResource)targetValue.eResource();
					assert sourceRes != null;
					assert targetRes != null;
					final String XMI_ID = sourceRes.getID(sourceValue);
					targetRes.setID(targetValue, XMI_ID);
				}
				return CommandResult.newOKCommandResult();
			}
		};
		return new GMFtoEMFCommandWrapper(copyXMI_ID_Command);
	}

	/**
	 * Gets the update facet element references command.
	 *
	 * @param domain
	 *        the editing domain
	 * @param papyrusTables
	 *        the list of the controlled tables
	 * @param sourceToTarget
	 *        the map with the source element as key and the target element as value
	 * @return the update facet element references command
	 *         the command to replace each call to source element by a call to target element in the managed tables or <code>null</code> if there is
	 *         nothing to do
	 */
	private static Command getUpdateFacetElementReferencesCommand(final TransactionalEditingDomain domain, final Collection<PapyrusTable> papyrusTables, final Map<EObject, EObject> sourceToTarget) {
		final CompoundCommand updateCommand = new CompoundCommand(Messages.PapyrusTableEFacetMoveHelper_UpdateReferenceToFacetElementCommand);
		for(final PapyrusTable pTable : papyrusTables) {
			for(final EObject eobjectSource : sourceToTarget.keySet()) {
				final Object eobjectTarget = sourceToTarget.get(eobjectSource);
				if(!(eobjectTarget instanceof EStructuralFeature || eobjectTarget instanceof FacetSet)) {
					continue;
				}
				final ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(eobjectSource);
				for(final Setting setting : adapter.getNonNavigableInverseReferences(eobjectSource)) {
					final EObject eobject = setting.getEObject();
					if(!(eobject instanceof FeatureColumn)) {
						continue;
					}
					boolean shouldReplace = false;
					if(eobject instanceof FeatureColumn && pTable.getTable().getColumns().contains(eobject)) {
						shouldReplace = true;
					}
					if(shouldReplace) {
						final ICommand cmd = new AbstractTransactionalCommand(domain, null, null) {

							@Override
							protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
								EcoreUtil.replace(setting, eobjectSource, eobjectTarget);
								return CommandResult.newOKCommandResult();
							}
						};
						updateCommand.append(new GMFtoEMFCommandWrapper(cmd));
					}
				}
			}
		}
		if(updateCommand.isEmpty()) {
			return null;
		}
		return updateCommand;
	}
}
