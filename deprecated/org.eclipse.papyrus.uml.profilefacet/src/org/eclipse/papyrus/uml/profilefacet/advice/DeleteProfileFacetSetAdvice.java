/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.profilefacet.advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.FacetStructuralFeature;
import org.eclipse.emf.facet.infra.query.ModelQuery;
import org.eclipse.emf.facet.infra.query.ModelQuerySet;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableInstance;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance.TableinstancePackage;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.TableInstance2;
import org.eclipse.emf.facet.widgets.nattable.instance.tableinstance2.Tableinstance2Package;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.ProfileFacetSet;
import org.eclipse.papyrus.uml.profilefacet.metamodel.profilefacet.StereotypeFacet;

/**
 * 
 * This advice helper destroy the {@link ProfileFacetSet} used in a table if the destroyed table is the last one to use it
 * This advice helper destroy the {@link EPackage} which contains the destroyed {@link ProfileFacetSet} used in a table if the destroyed
 * {@link ProfileFacetSet} is the last
 * one owned by the {@link EPackage}
 * 
 * We assume that the EPackage contains only {@link ProfileFacetSet}, which contains only {@link StereotypeFacet}
 * 
 * @author Vincent Lorenzo
 * 
 */
public class DeleteProfileFacetSetAdvice extends AbstractEditHelperAdvice {

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeDestroyDependentsCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		final EObject objectToDestroy = request.getElementToDestroy();
		if(objectToDestroy == null) {
			return null;
		}


		//the destroyed element is a PapyrusTableInstace
		if(objectToDestroy instanceof TableInstance2) {
			final TableInstance2 instance = (TableInstance2)objectToDestroy;
			final Collection<FacetSet> rootFacetSetToDestroy = new ArrayList<FacetSet>();
			final Collection<ModelQuerySet> querySetToDestroy = new HashSet<ModelQuerySet>();
			final Collection<Facet> allStereotypeFacetsUsedInTheTable = new ArrayList<Facet>();
			allStereotypeFacetsUsedInTheTable.addAll(instance.getFacets2());

			final Collection<FacetSet> rootFacetSets = new HashSet<FacetSet>();
			final Collection<EPackage> rootPackages = new HashSet<EPackage>();
			for(Facet facet : allStereotypeFacetsUsedInTheTable) {
				if(facet instanceof StereotypeFacet) {
					EObject container = facet.eContainer();
					while(container.eContainer() != null && container.eContainer() instanceof FacetSet) {
						container = container.eContainer();
					}
					assert container instanceof FacetSet;
					EObject rootPackage = container.eContainer();
					if(rootPackage != null) {// null for the provided Sysml ProfileFacetSet
						assert (rootPackage instanceof EPackage && rootPackage.eContainer() == null);
						rootFacetSets.add((FacetSet)container);
						rootPackages.add((EPackage)rootPackage);
					}
				}
			}

			if(rootFacetSets.size() != 0) {//the table references StereotypeFacet
				final TransactionalEditingDomain domain = request.getEditingDomain();

				//we must execute this code during the command execution, because if we are destroying several tables in the same time which references the same ProfileFacetSet, this one will be not destroyed
				final ICommand cmd = new AbstractTransactionalCommand(domain, "Destroy ProfileFacetSet Command", null) { //$NON-NLS-1$

					@Override
					protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
						final Collection<EPackage> epackageToDestroy = new ArrayList<EPackage>();
						for(final EPackage currentRoot : rootPackages) {
							for(final EObject current : currentRoot.eContents()) {
								if(current instanceof FacetSet) {
									if(!isUsed(instance, (FacetSet)current)) {
										rootFacetSetToDestroy.add((FacetSet)current);
										final ModelQuerySet querySet = getQuerySet((FacetSet)current);
										if(querySet != null) {
											querySetToDestroy.add(querySet);
										}
									}
								}
							}

							final Collection<EObject> currentContents = new ArrayList<EObject>(currentRoot.eContents());
							currentContents.removeAll(rootFacetSetToDestroy);
							if(currentContents.isEmpty()) {
								epackageToDestroy.add(currentRoot);
							}
						}


						CompositeCommand destroyCommand = new CompositeCommand("Destroy ProfileFacetSet command"); //$NON-NLS-1$

						for(final EObject element : querySetToDestroy) {
							final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
							final DestroyElementRequest destroyRequest = new DestroyElementRequest(element, false);
							destroyCommand.add(provider.getEditCommand(destroyRequest));
						}

						for(final EObject element : rootFacetSetToDestroy) {
							final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(element);
							final DestroyElementRequest destroyRequest = new DestroyElementRequest(element, false);
							destroyCommand.add(provider.getEditCommand(destroyRequest));
						}
						for(EPackage ePackage : epackageToDestroy) {
							final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(ePackage);
							final DestroyElementRequest destroyRequest = new DestroyElementRequest(ePackage, false);
							destroyCommand.add(provider.getEditCommand(destroyRequest));
						}


						if(!destroyCommand.isEmpty()) {
							domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(destroyCommand));
						}
						return CommandResult.newOKCommandResult();
					}
				};
				return cmd;

			}

		}
		return null;
	}

	/**
	 * 
	 * @param deletedTableInstance
	 *        the deleted table instance
	 * @param facetSet
	 *        a facetset
	 * @return
	 *         <code>true</code> if the facetset is used by another table
	 */
	protected boolean isUsed(final TableInstance deletedTableInstance, final FacetSet facetSet) {
		boolean isUsed = false;
		for(final Facet facet : facetSet.getFacets()) {
			final ECrossReferenceAdapter crossReferencerAdapter = CrossReferenceAdapter.getCrossReferenceAdapter(facet);
			final Collection<Setting> settings = crossReferencerAdapter.getNonNavigableInverseReferences(facet, true);
			Iterator<Setting> iterator = settings.iterator();
			while(iterator.hasNext() && !isUsed) {
				final Setting current = iterator.next();
				EObject object = current.getEObject();
				EStructuralFeature feature = current.getEStructuralFeature();
				if(object != deletedTableInstance || (feature != TableinstancePackage.eINSTANCE.getTableInstance_Facets() && feature != Tableinstance2Package.eINSTANCE.getTableInstance2_Facets2())) {
					isUsed = true;
				}
			}
		}
		if(!isUsed) {
			for(final EPackage subPackage : facetSet.getESubpackages()) {
				if(subPackage instanceof FacetSet && !isUsed) {
					isUsed = isUsed(deletedTableInstance, (FacetSet)subPackage);
				}
			}
		}
		return isUsed;
	}

	/**
	 * 
	 * @param facetset
	 *        a facetset
	 * @return
	 *         the {@link ModelQuerySet} used by this facetset
	 */
	protected ModelQuerySet getQuerySet(final FacetSet facetset) {
		ModelQuerySet querySet = null;
		TreeIterator<EObject> iterator = facetset.eAllContents();
		while(iterator.hasNext() && querySet == null) {
			final EObject current = iterator.next();
			if(current instanceof FacetStructuralFeature) {
				ModelQuery modelQuery = ((FacetStructuralFeature)current).getValueQuery();
				querySet = modelQuery.getModelQuerySet();
			}
		}

		return querySet;
	}
}
