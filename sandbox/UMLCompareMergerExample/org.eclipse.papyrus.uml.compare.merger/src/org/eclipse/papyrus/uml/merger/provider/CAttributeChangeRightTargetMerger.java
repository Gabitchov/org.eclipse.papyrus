package org.eclipse.papyrus.uml.merger.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.compare.EMFComparePlugin;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.internal.merge.impl.AttributeChangeRightTargetMerger;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.uml.compare.merger.utils.MergerUtils;


public class CAttributeChangeRightTargetMerger extends AttributeChangeRightTargetMerger {



	@Override
	public void doApplyInOrigin() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			Command cmd;
			final AttributeChangeRightTarget theDiff = (AttributeChangeRightTarget)this.diff;
			final EObject origin = theDiff.getLeftElement();
			final Object value = theDiff.getRightTarget();
			final EAttribute attr = theDiff.getAttribute();


			//			try {
			int valueIndex = -1;
			if(attr.isMany()) {
				final EObject rightElement = theDiff.getRightElement();
				final Object rightValues = rightElement.eGet(attr);
				if(rightValues instanceof List) {
					final List rightValuesList = (List)rightValues;
					valueIndex = rightValuesList.indexOf(value);
				}
				final Object manyValue = origin.eGet(attr);
				final List<Object> newValue = new ArrayList<Object>((Collection<?>)manyValue);
				if(manyValue instanceof List<?>) {//code adapted from EFactory.eAdd
					final List<Object> list = (List<Object>)manyValue;
					final int listSize = list.size();
					if(valueIndex > -1 && valueIndex < listSize) {
						newValue.add(valueIndex, value);
					} else {
						newValue.add(value);
					}
				} else if(manyValue instanceof Collection<?>) {
					newValue.add(value);
				}
				cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, origin, attr, newValue);
			} else {
				cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, origin, attr, value);
			}
			domain.getCommandStack().execute(cmd);
		} else {
			super.doApplyInOrigin();
		}
	}

	@Override
	public void doUndoInTarget() {
		if(MergerUtils.usePapyrusMerger()) {
			final TransactionalEditingDomain domain = MergerUtils.getEditingDomain();
			Command cmd = null;
			final AttributeChangeRightTarget theDiff = (AttributeChangeRightTarget)this.diff;
			final EObject target = theDiff.getRightElement();
			final Object value = theDiff.getRightTarget();
			final EAttribute attr = theDiff.getAttribute();

			final Object list = target.eGet(attr);

			if(list instanceof List) {
				if(value != null) {
					final List<Object> newValue = new ArrayList<Object>((List<?>)list);
					newValue.remove(value);
					cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, attr, newValue);
				}
			} else {
				cmd = PapyrusMergeCommandProvider.INSTANCE.getSetCommand(domain, target, attr, null);
			}
			if(cmd != null) {
				domain.getCommandStack().execute(cmd);
			}

		} else {
			super.doUndoInTarget();
		}
	}
}
