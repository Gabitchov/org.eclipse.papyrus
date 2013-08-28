package org.eclipse.papyrus.uml.xtext.integration.validation;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;

public class ClientSelector implements IClientSelector {

	public boolean selects(Object object) {
		if((object instanceof Element)){
		return true;}
		else{
			return false;}
	}
}
