package org.eclipse.papyrus.qompass.modellibs.core.bindinghelpers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.FCM.util.IBindingHelper;
import org.eclipse.papyrus.qompass.designer.core.listeners.PreCopyListener;
import org.eclipse.papyrus.qompass.designer.core.templates.BindingUtils;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;
import org.eclipse.papyrus.qompass.modellibs.core.Activator;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.TemplateBinding;

/**
 * Bind an operation to an actual, i.e. evaluate the Acceleo template within the opaque behavior associated with
 * the operation.
 */
public class BindOperation implements IBindingHelper, PreCopyListener {

	private TemplateBinding binding;
	
	@Override
	public EObject preCopyEObject(LazyCopier copy, EObject sourceEObj) {
		
		if(sourceEObj instanceof Operation) {
			Operation operation = (Operation) sourceEObj;
			Classifier actual = TemplateUtils.getFirstActualFromBinding(binding);

			Operation newOperation = BindingUtils.instantiateOperation(copy, actual, operation);
			for(Behavior method : operation.getMethods()) {
				if(method instanceof OpaqueBehavior) {
					try {
						Behavior newBehavior =
							BindingUtils.instantiateBehavior(copy, actual, (OpaqueBehavior)method);
						newBehavior.setSpecification(newOperation);
					}
					catch (TransformationException e) {
						Activator.log.error(e);
					}
				}
			}
			return newOperation;
		}
		return sourceEObj;
	}

	@Override
	public void handleElement(TemplateBinding binding, Element object) {
		this.binding = binding;
	}
}
