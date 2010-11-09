package org.eclipse.papyrus.diagram.clazz.custom.parsers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.TemplateBinding;


public class RoleInstanceSpecificationLinkSourceParser implements IParser {

	public String getEditString(IAdaptable element, int flags) {
		InstanceSpecification instanceSpecification=((InstanceSpecification)((EObjectAdapter)element).getRealObject());
		if( instanceSpecification.getClassifiers().size()>0){
			if (instanceSpecification.getClassifiers().get(0) instanceof Association){
				Association association=(Association)instanceSpecification.getClassifiers().get(0);
				Slot slotSource=instanceSpecification.getSlots().get(0);
				return slotSource.getValues().get(0).getType().getName();
				
				
			}
		}
		return "<UNSPECIFIED>";
	}

	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		// TODO Auto-generated method stub
		return null;
	}

	public ICommand getParseCommand(IAdaptable element, String newString, int flags) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrintString(IAdaptable element, int flags) {
		InstanceSpecification instanceSpecification=((InstanceSpecification)((EObjectAdapter)element).getRealObject());
		if( instanceSpecification.getClassifiers().size()>0){
			if (instanceSpecification.getClassifiers().get(0) instanceof Association){
				Association association=(Association)instanceSpecification.getClassifiers().get(0);
				Slot slotSource=instanceSpecification.getSlots().get(0);
				return slotSource.getValues().get(0).getType().getName();
			}
		}
		return "<UNSPECIFIED>";
	}

	public boolean isAffectingEvent(Object event, int flags) {
		// TODO Auto-generated method stub
		return true;
	}

	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		// TODO Auto-generated method stub
		return null;
	}

}
