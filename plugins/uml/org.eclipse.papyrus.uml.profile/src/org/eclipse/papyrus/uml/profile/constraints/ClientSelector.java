package org.eclipse.papyrus.uml.profile.constraints;

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
