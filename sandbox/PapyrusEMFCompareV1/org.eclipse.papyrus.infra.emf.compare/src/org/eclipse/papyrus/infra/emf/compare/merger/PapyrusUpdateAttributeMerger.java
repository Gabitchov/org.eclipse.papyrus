package org.eclipse.papyrus.infra.emf.compare.merger;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.UpdateAttributeMerger;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.merger.provider.PapyrusMergeCommandProvider;
import org.eclipse.papyrus.infra.emf.compare.utils.Utils;


public class PapyrusUpdateAttributeMerger extends UpdateAttributeMerger {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	 */
	@Override
	public void doApplyInOrigin() {
		final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
		final EObject element = theDiff.getRightElement();
		final EObject origin = theDiff.getLeftElement();
		final EAttribute attr = theDiff.getAttribute();
		if(Utils.useEditService()) {
			final TransactionalEditingDomain domain = Utils.getConfiguration().getEditingDomain();
			Command cmd = null;
			try {
				cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, origin, origin.eClass().getEStructuralFeature(attr.getName()), EFactory.eGet(element, attr.getName()));
			} catch (final FactoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			domain.getCommandStack().execute(cmd);
		} else {
			try {
				EFactory.eSet(origin, attr.getName(), EFactory.eGet(element, attr.getName()));
			} catch (final FactoryException e) {
				EMFComparePlugin.log(e, true);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	 */
	@Override
	public void doUndoInTarget() {
		final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
		final EObject element = theDiff.getRightElement();
		final EObject origin = theDiff.getLeftElement();
		final EAttribute attr = theDiff.getAttribute();
		if(Utils.useEditService()) {
			final TransactionalEditingDomain domain = Utils.getConfiguration().getEditingDomain();
			Command cmd = null;
			try {
				cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, element, element.eClass().getEStructuralFeature(attr.getName()), EFactory.eGet(origin, attr.getName()));
			} catch (final FactoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			domain.getCommandStack().execute(cmd);
		} else {
			try {
				EFactory.eSet(element, attr.getName(), EFactory.eGet(origin, attr.getName()));
			} catch (final FactoryException e) {
				EMFComparePlugin.log(e, true);
			}
		}
	}
}
