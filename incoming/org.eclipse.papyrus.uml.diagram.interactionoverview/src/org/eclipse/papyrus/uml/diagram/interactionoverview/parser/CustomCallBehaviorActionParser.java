package org.eclipse.papyrus.uml.diagram.interactionoverview.parser;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.activity.parser.custom.CallBehaviorActionParser;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLPackage;


public class CustomCallBehaviorActionParser extends CallBehaviorActionParser {

	public CustomCallBehaviorActionParser() {
		super(new EAttribute[]{});
	}

	@Override
	public String getPrintString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		if(obj instanceof CallBehaviorAction) {
			CallBehaviorAction action = (CallBehaviorAction)obj;
			String behaviorName = "";
			if(action.getBehavior() != null && action.getBehavior().getName() != null) {
				behaviorName = action.getBehavior().getName();
			}
			// display behavior name alone if name is not specified differently
			if(!"".equals(behaviorName)) {
				return behaviorName;
			}
		}
		return " ";
	}

	@Override
	public String getEditString(IAdaptable element, int flags) {
		Object obj = element.getAdapter(EObject.class);
		if(obj instanceof CallBehaviorAction) {
			CallBehaviorAction action = (CallBehaviorAction)obj;
			String behaviorName = "";
			if(action.getBehavior() != null && action.getBehavior().getName() != null) {
				behaviorName = action.getBehavior().getName();
			}
			// display behavior name alone if name is not specified differently
			if(!"".equals(behaviorName)) {
				return behaviorName;
			}
		}
		return " ";
	}

	@Override
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		if(newString == null) {
			return UnexecutableCommand.INSTANCE;
		}
		EObject element = (EObject)adapter.getAdapter(EObject.class);
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);
		if(editingDomain == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(editingDomain, "Set Values"); //$NON-NLS-1$
		if(element instanceof CallBehaviorAction) {
			Interaction interactionUse = (Interaction)(((CallBehaviorAction)element).getBehavior());
			command.compose(getModificationCommand(interactionUse, UMLPackage.eINSTANCE.getNamedElement_Name(), newString));
		}
		return command;
	}

}
