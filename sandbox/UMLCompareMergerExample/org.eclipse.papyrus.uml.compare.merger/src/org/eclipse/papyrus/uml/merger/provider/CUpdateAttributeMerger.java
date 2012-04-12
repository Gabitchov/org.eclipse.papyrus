package org.eclipse.papyrus.uml.merger.provider;



import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.UpdateAttributeMerger;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.compare.merger.Activator;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;


public class CUpdateAttributeMerger extends UpdateAttributeMerger {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doApplyInOrigin()
	 */
	@Override
	public void doApplyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
			final EObject element = theDiff.getRightElement();
			final EObject origin = theDiff.getLeftElement();
			final EAttribute attr = theDiff.getAttribute();
		
			Command cmd = null;
			try {
				cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, origin, origin.eClass().getEStructuralFeature(attr.getName()), EFactory.eGet(element, attr.getName()));
			} catch (final FactoryException e) {
				Activator.log.error(e);
			}
			domain.getCommandStack().execute(cmd);
		} else {
			super.doApplyInOrigin();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.api.AbstractMerger#doUndoInTarget()
	 */
	@Override
	public void doUndoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			final UpdateAttribute theDiff = (UpdateAttribute)this.diff;
			final EObject element = theDiff.getRightElement();
			final EObject origin = theDiff.getLeftElement();
			final EAttribute attr = theDiff.getAttribute();
			Command cmd = null;
			try {
				cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, element, element.eClass().getEStructuralFeature(attr.getName()), EFactory.eGet(origin, attr.getName()));
			} catch (final FactoryException e) {
				Activator.log.error(e);
			}
			domain.getCommandStack().execute(cmd);
		} else {
			super.doUndoInTarget();
		}
	}
	
}
