/*
 * 
 */
package org.eclipse.papyrus.diagram.common.parser.custom;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLPackage;

public class SubmachineStateSubmachineNameParser implements ISemanticParser {

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	public String getEditString(IAdaptable element, int flags) {
		return "";
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {

		String printingString = "NO_SUBMACHINE";

		EObject eObject = (EObject) element.getAdapter(EObject.class);

		if (eObject instanceof State) {
			State state = (State) eObject;
			if (state.getSubmachine() != null) {
				printingString = state.getSubmachine().getName();
			}
		}

		return printingString;
	}

	public boolean isAffectingEvent(Object event, int flags) {
		return false;
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// always return
		return new ParserEditStatusimpl();
	}

	class ParserEditStatusimpl implements IParserEditStatus {

		public IStatus[] getChildren() {
			return new IStatus[0];
		}

		public int getCode() {
			return 0;
		}

		public Throwable getException() {
			return null;
		}

		public String getMessage() {
			return "Non editable.";
		}

		public String getPlugin() {
			return null;
		}

		public int getSeverity() {
			return IStatus.OK;
		}

		public boolean isMultiStatus() {
			return false;
		}

		public boolean isOK() {
			return false;
		}

		public boolean matches(int severityMask) {
			return false;
		}

	}

	public boolean areSemanticElementsAffected(EObject listener, Object notification) {
		if (notification instanceof Notification) {
			Notification noti = (Notification) notification;
			if (noti.getNotifier() instanceof StateMachine
					&& noti.getFeature().equals(UMLPackage.eINSTANCE.getNamedElement_Name())) {
				return true;
			}
		}
		return false;
	}

	public List getSemanticElementsBeingParsed(EObject element) {
		if (element == null) {
			return Collections.EMPTY_LIST;
		}
		if (element instanceof State == false) {
			return Collections.EMPTY_LIST;
		}
		State state = (State) element;
		StateMachine stateMachine = state.getSubmachine();
		if (stateMachine == null) {
			return Collections.EMPTY_LIST;
		}
		return Collections.singletonList(stateMachine);
	}
}
