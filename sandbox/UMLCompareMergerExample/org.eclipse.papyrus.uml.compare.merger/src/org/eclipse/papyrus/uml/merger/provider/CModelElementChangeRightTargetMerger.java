package org.eclipse.papyrus.uml.merger.provider;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.ModelElementChangeRightTargetMerger;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;
import org.eclipse.papyrus.uml.compare.merger.utils.PapyrusEFactory;


public class CModelElementChangeRightTargetMerger extends ModelElementChangeRightTargetMerger {

	@Override
	public void doApplyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			CompoundCommand cmd = new CompoundCommand("ModelElementChangeRightTargetCommand#doApplyInOrigin");
			final ModelElementChangeRightTarget theDiff = (ModelElementChangeRightTarget)this.diff;
			final EObject origin = theDiff.getLeftParent();
			final EObject element = theDiff.getRightElement();
			final EObject newOne = copy(element);
			final EReference ref = element.eContainmentFeature();
			if(ref != null) {
				try {
					int expectedIndex = -1;
					if(ref.isMany()) {
						final Object containmentRefVal = element.eContainer().eGet(ref);
						if(containmentRefVal instanceof List<?>) {
							@SuppressWarnings("unchecked")
							final List<EObject> listVal = (List<EObject>)containmentRefVal;
							expectedIndex = listVal.indexOf(element);
						}
					}
					//					EFactory.eAdd(origin, ref.getName(), newOne, expectedIndex, true);
					//					setXMIID(newOne, getXMIID(element));
					cmd.append(PapyrusEFactory.getEAddCommand(origin, ref.getName(), newOne, expectedIndex, true));
					cmd.append(PapyrusMergeCommandProvider.INSTANCE.getSetXMIIDCommand(domain, newOne, getXMIID(element)));
				} catch (final FactoryException e) {
					EMFComparePlugin.log(e, true);
				}
			} else if(origin == null && getDiffModel().getLeftRoots().size() > 0) {
				//				getDiffModel().getLeftRoots().get(0).eResource().getContents().add(newOne);
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getAddToResourceCommand(domain, getDiffModel().getLeftRoots().get(0).eResource(), newOne));
			} else if(origin != null) {
				//				origin.eResource().getContents().add(newOne);
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getAddToResourceCommand(domain, origin.eResource(), newOne));
			} else {
				throw new UnsupportedOperationException(NLS.bind("We can't merge this diff : {0}", theDiff));
			}
			// we should now have a look for AddReferencesLinks needing this object
			final Iterator<EObject> siblings = getDiffModel().eAllContents();
			while(siblings.hasNext()) {
				final DiffElement op = (DiffElement)siblings.next();
				if(op instanceof ReferenceChangeRightTarget) {
					final ReferenceChangeRightTarget link = (ReferenceChangeRightTarget)op;
					// now if I'm in the target References I should put my copy in the origin
					if(link.getLeftTarget() != null && link.getLeftTarget() == element) {
						link.setRightTarget(newOne);
					}
				} else if(op instanceof ReferenceOrderChange) {
					final ReferenceOrderChange link = (ReferenceOrderChange)op;
					if(link.getLeftElement() == origin && link.getReference() == ref) {
						final ListIterator<EObject> targetIterator = link.getLeftTarget().listIterator();
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
			domain.getCommandStack().execute(cmd);
		} else {
			super.doApplyInOrigin();
		}

	}


	@Override
	public void doUndoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			final ModelElementChangeRightTarget theDiff = (ModelElementChangeRightTarget)this.diff;
			final EObject element = theDiff.getRightElement();
			//			final EObject parent = theDiff.getRightElement().eContainer();
			//			EcoreUtil.remove(element);
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			final Command cmd = PapyrusMergeCommandProvider.INSTANCE.getDestroyCommand(domain, element);
			domain.getCommandStack().execute(cmd);
		} else {
			super.doUndoInTarget();
		}
	}
}
