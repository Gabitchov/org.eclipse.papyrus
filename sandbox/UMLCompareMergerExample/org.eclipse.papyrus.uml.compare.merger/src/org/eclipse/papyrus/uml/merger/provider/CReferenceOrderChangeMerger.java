package org.eclipse.papyrus.uml.merger.provider;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.ReferenceOrderChangeMerger;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.compare.diff.metamodel.ReferenceOrderChange;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class CReferenceOrderChangeMerger extends ReferenceOrderChangeMerger {
	
	@Override
	public void doUndoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			final ReferenceOrderChange theDiff = (ReferenceOrderChange)this.diff;
			final EObject rightElement = theDiff.getRightElement();

			final Collection<EObject> target = Lists.newArrayList(Collections2.filter(theDiff.getRightTarget(),
					new Predicate<EObject>() {
						public boolean apply(EObject input) {
							return !input.eIsProxy()
									|| !DefaultMerger.isEMFCompareProxy(((InternalEObject)input).eProxyURI());
						}
					}));

			TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
//			try {
//				EFactory.eSet(rightElement, theDiff.getReference().getName(), target);
			
			Command command = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, rightElement, theDiff.getReference(), target);
			domain.getCommandStack().execute(command );
//			} catch (final FactoryException e) {
//				EMFComparePlugin.log(e, true);
//			}
		} else {
			super.doUndoInTarget();
		}
	}

	@Override
	public void doApplyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			final ReferenceOrderChange theDiff = (ReferenceOrderChange)this.diff;
			final EObject leftElement = theDiff.getLeftElement();

			final Collection<EObject> target = Lists.newArrayList(Collections2.filter(theDiff.getLeftTarget(),
					new Predicate<EObject>() {
						public boolean apply(EObject input) {
							return !input.eIsProxy()
									|| !DefaultMerger.isEMFCompareProxy(((InternalEObject)input).eProxyURI());
						}
					}));
			TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
//			try {
//				EFactory.eSet(leftElement, theDiff.getReference().getName(), target);
			Command command = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, leftElement, theDiff.getReference(), target);
			domain.getCommandStack().execute(command );
//			} catch (final FactoryException e) {
//				EMFComparePlugin.log(e, true);
//			}
		} else {
			super.doApplyInOrigin();
		}
	}
}
