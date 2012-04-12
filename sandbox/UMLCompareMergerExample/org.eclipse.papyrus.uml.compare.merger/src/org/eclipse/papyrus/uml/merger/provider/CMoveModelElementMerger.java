package org.eclipse.papyrus.uml.merger.provider;

import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.compare.diff.internal.merge.impl.MoveModelElementMerger;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;

/**
 * 
 * Created for EMF-Compare, for MoveModelElementMerger
 *
 */
public class CMoveModelElementMerger extends MoveModelElementMerger {

	@Override
	public void doUndoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			final MoveModelElement theDiff = (MoveModelElement)this.diff;
			final EObject rightTarget = theDiff.getRightTarget();
			final EObject rightElement = theDiff.getRightElement();
			final EReference ref = theDiff.getLeftElement().eContainmentFeature();
			CompoundCommand cmd = new CompoundCommand("doUndoInTarget for MoveModelElementCommand");
			TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			if(ref != null) {
				// ordering handling:
				int index = -1;
				final EObject leftElementParent = theDiff.getLeftElement().eContainer();
				final Object leftRefValue = leftElementParent.eGet(ref);
				if(leftRefValue instanceof List) {
					final List<Object> refLeftValueList = (List<Object>)leftRefValue;
					index = refLeftValueList.indexOf(theDiff.getLeftElement());
					//testable with MoveModelElementExample1
					cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveWithIndexCommand(domain, rightTarget, rightTarget, ref, rightElement, index));
				}else{
					//					EcoreUtil.remove(rightElement);	
					//					EFactory.eAdd(rightTarget, ref.getName(), rightElement, index, true);
					cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveCommand(domain, rightTarget, rightTarget, ref, rightElement));
				}
				//				try {
				final String elementID = getXMIID(rightElement);
				
				//					setXMIID(rightElement, elementID);
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getSetXMIIDCommand(domain, rightElement, elementID));
				//				} catch (FactoryException e) {
				//					EMFComparePlugin.log(e, true);
				//				}
				domain.getCommandStack().execute(cmd);
			} else {
				// shouldn't be here
				assert false;
			}
		} else {
			super.doUndoInTarget();
		}
	}

	@Override
	public void doApplyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			final MoveModelElement theDiff = (MoveModelElement)this.diff;
			final EObject leftTarget = theDiff.getLeftTarget();
			final EObject leftElement = theDiff.getLeftElement();
			final EReference ref = theDiff.getRightElement().eContainmentFeature();
			CompoundCommand cmd = new CompoundCommand("doApplyInOrigin for MoveModelElementCommand");
			TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			if(ref != null) {
				// ordering handling:
				int index = -1;
				final EObject rightElementParent = theDiff.getRightElement().eContainer();
				final Object rightRefValue = rightElementParent.eGet(ref);
				if(rightRefValue instanceof List) {
					final List<Object> refRightValueList = (List<Object>)rightRefValue;
					index = refRightValueList.indexOf(theDiff.getRightElement());
					//testable with MoveModelElementExample1
					cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveWithIndexCommand(domain, leftTarget, leftTarget, ref, leftElement, index));
				}else{
					cmd.append(PapyrusMergeCommandProvider.INSTANCE.getMoveCommand(domain, leftTarget, leftTarget, ref, leftElement));
				}

				//				try {
				// We'll store the element's ID because moving an element deletes its XMI ID
				final String elementID = getXMIID(leftElement);
				//					EcoreUtil.remove(leftElement);
				//					EFactory.eAdd(leftTarget, ref.getName(), leftElement, index, true);
				
				// Sets anew the element's ID
				//					setXMIID(leftElement, elementID);
				cmd.append(PapyrusMergeCommandProvider.INSTANCE.getSetXMIIDCommand(domain, leftElement, elementID));
				//				} catch (FactoryException e) {
				//					EMFComparePlugin.log(e, true);
				//				}
				domain.getCommandStack().execute(cmd);
			} else {
				// shouldn't be here
				assert false;
			}
		} else {
			super.doApplyInOrigin();
		}
	}
}
