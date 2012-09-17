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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.diff.internal.merger;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.commands.AddToResourceCommand;
import org.eclipse.papyrus.infra.emf.compare.diff.Activator;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.CopyXMIIDCommand;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.command.PapyrusMergeCommandProvider;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.util.PapyrusEFactory;


/**
 * 
 * Transactional version of the class {@link ModelElementChangeLeftTargetMerger}
 * 
 */
public class ModelElementChangeLeftTargetTransactionalMerger extends DefaultTransactionalMerger {//ModelElementChangeLeftTargetMerger implements ITransactionalMerger {

	//	/**
	//	 * The native implementation, duplicated Code from {@link ModelElementChangeLeftTargetMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	//	 */
	//	@Override
	//	protected void doApplyInOrigin() {
	//		final ModelElementChangeLeftTarget theDiff = (ModelElementChangeLeftTarget)this.diff;
	//		final EObject element = theDiff.getLeftElement();
	//		final EObject parent = theDiff.getLeftElement().eContainer();
	//		EcoreUtil.remove(element);
	//		// now removes all the dangling references
	//		removeDanglingReferences(parent);
	//	}
	//
	//	/**
	//	 * The native implementation, duplicated Code from {@link ModelElementChangeLeftTargetMerger} {@inheritDoc}
	//	 * 
	//	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	//	 */
	//	@Override
	//	protected void doUndoInTarget() {
	//		final ModelElementChangeLeftTarget theDiff = (ModelElementChangeLeftTarget)this.diff;
	//		// we should copy the element to the Origin one.
	//		final EObject origin = theDiff.getRightParent();
	//		final EObject element = theDiff.getLeftElement();
	//		final EObject newOne = copy(element);
	//		final EReference ref = element.eContainmentFeature();
	//		if(ref != null) {
	//			try {
	//				int elementIndex = -1;
	//				if(ref.isMany()) {
	//					final Object containmentRefVal = element.eContainer().eGet(ref);
	//					if(containmentRefVal instanceof List<?>) {
	//						@SuppressWarnings("unchecked")
	//						final List<EObject> listVal = (List<EObject>)containmentRefVal;
	//						elementIndex = listVal.indexOf(element);
	//					}
	//				}
	//				EFactory.eAdd(origin, ref.getName(), newOne, elementIndex, true);
	//				setXMIID(newOne, getXMIID(element));
	//			} catch (final FactoryException e) {
	//				EMFComparePlugin.log(e, true);
	//			}
	//		} else if(origin == null && getDiffModel().getRightRoots().size() > 0) {
	//			getDiffModel().getRightRoots().get(0).eResource().getContents().add(newOne);
	//		} else if(origin != null) {
	//			origin.eResource().getContents().add(newOne);
	//		} else {
	//			// FIXME throw exception : couldn't merge this
	//		}
	//		// we should now have a look for RemovedReferencesLinks needing elements to apply
	//		final Iterator<EObject> siblings = getDiffModel().eAllContents();
	//		while(siblings.hasNext()) {
	//			final Object op = siblings.next();
	//			if(op instanceof ReferenceChangeLeftTarget) {
	//				final ReferenceChangeLeftTarget link = (ReferenceChangeLeftTarget)op;
	//				// now if I'm in the target References I should put my copy in the origin
	//				if(link.getRightTarget() != null && link.getRightTarget() == element) {
	//					link.setLeftTarget(newOne);
	//				}
	//			} else if(op instanceof ReferenceOrderChange) {
	//				final ReferenceOrderChange link = (ReferenceOrderChange)op;
	//				if(link.getRightElement() == origin && link.getReference() == ref) {
	//					final ListIterator<EObject> targetIterator = link.getRightTarget().listIterator();
	//					boolean replaced = false;
	//					while(!replaced && targetIterator.hasNext()) {
	//						final EObject target = targetIterator.next();
	//						if(target.eIsProxy() && equalProxyURIs(((InternalEObject)target).eProxyURI(), EcoreUtil.getURI(element))) {
	//							targetIterator.set(newOne);
	//							replaced = true;
	//						}
	//					}
	//				}
	//			}
	//		}
	//	}

	//TODO verify that I use this method in the transactional version
	/**
	 * The native implementation, duplicated Code from {@link ModelElementChangeLeftTargetMerger} {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#getDependencies(boolean)
	 */
	@Override
	protected List<DiffElement> getDependencies(boolean applyInOrigin) {
		if(!applyInOrigin) {
			return diff.getRequires();
		}
		return super.getDependencies(applyInOrigin);
	}

	public Command getDoApplyInOriginCommand(final TransactionalEditingDomain domain) {
		final ModelElementChangeLeftTarget theDiff = (ModelElementChangeLeftTarget)this.diff;
		final EObject element = theDiff.getLeftElement();
		return PapyrusMergeCommandProvider.INSTANCE.getDestroyCommand(domain, element);
		//removeDanglingReferences(parent); not used
	}

	public Command getDoUndoInTargetCommand(final TransactionalEditingDomain domain) {
		CompoundCommand cmd = new CompoundCommand("Command CModelElementChangeLeftTargetMerger#getDoUndoInTargetCommand"); //$NON-NLS-1$
		final ModelElementChangeLeftTarget theDiff = (ModelElementChangeLeftTarget)this.diff;
		// we should copy the element to the Origin one.
		final EObject origin = theDiff.getRightParent();
		final EObject element = theDiff.getLeftElement();
		final ICommand copyCommand = getCopyWithReferenceCommand(element);
		cmd.append(new GMFtoEMFCommandWrapper(copyCommand));
		final EObject newOne = (EObject)copyCommand.getCommandResult().getReturnValue();
		final EReference ref = element.eContainmentFeature();
		if(ref != null) {
			try {
				int elementIndex = -1;
				if(ref.isMany()) {
					final Object containmentRefVal = element.eContainer().eGet(ref);
					if(containmentRefVal instanceof List<?>) {
						@SuppressWarnings("unchecked")
						final List<EObject> listVal = (List<EObject>)containmentRefVal;
						elementIndex = listVal.indexOf(element);
					}
				}
				//				EFactory.eAdd(origin, ref.getName(), newOne, elementIndex, true);
				//				setXMIID(newOne, getXMIID(element));
				cmd.append(PapyrusEFactory.getEAddCommand(domain, origin, ref.getName(), newOne, elementIndex, true));
				cmd.append(new CopyXMIIDCommand(element, newOne));
			} catch (final FactoryException e) {
				Activator.log.error(e);
			}
		} else if(origin == null && getDiffModel().getRightRoots().size() > 0) {
			//			getDiffModel().getRightRoots().get(0).eResource().getContents().add(newOne);
			cmd.append(new AddToResourceCommand(getDiffModel().getRightRoots().get(0).eResource(), newOne));
		} else if(origin != null) {
			//			origin.eResource().getContents().add(newOne);
			cmd.append(new AddToResourceCommand(origin.eResource(), newOne));
		} else {
			// FIXME throw exception : couldn't merge this
		}
		cmd.append(new GMFtoEMFCommandWrapper(new AbstractTransactionalCommand(domain, "", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
				// we should now have a look for RemovedReferencesLinks needing elements to apply
				final DiffModel diffModel = getDiffModel();//see bug 385263: [UML Compare] NPE merging a DiffGroup owning a UMLStereotypeApplicationAddition/Removal
				if(diffModel != null) {
					final Iterator<EObject> siblings = diffModel.eAllContents();
					while(siblings.hasNext()) {
						final Object op = siblings.next();
						if(op instanceof ReferenceChangeLeftTarget) {
							final ReferenceChangeLeftTarget link = (ReferenceChangeLeftTarget)op;
							// now if I'm in the target References I should put my copy in the origin
							if(link.getRightTarget() != null && link.getRightTarget() == element) {
								link.setLeftTarget(newOne);
							}
						} else if(op instanceof ReferenceOrderChange) {
							final ReferenceOrderChange link = (ReferenceOrderChange)op;
							if(link.getRightElement() == origin && link.getReference() == ref) {
								final ListIterator<EObject> targetIterator = link.getRightTarget().listIterator();
								boolean replaced = false;
								while(!replaced && targetIterator.hasNext()) {
									final EObject target = targetIterator.next();
									if(target.eIsProxy() && equalProxyURIs(((InternalEObject)target).eProxyURI(), EcoreUtil.getURI(element))) {
										targetIterator.set(newOne);
										replaced = true;
									}
								}
							}
						}
					}
				}
				return CommandResult.newOKCommandResult();
			}
		}));

		return cmd;
	}

}
