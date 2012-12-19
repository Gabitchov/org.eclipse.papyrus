package org.eclipse.papyrus.uml.textedit.operation.xtext.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.uml.alf.validation.AlfJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.papyrus.uml.alf.validation.AlfJavaValidator.class})
public class AbstractOperationJavaValidator extends AlfJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.papyrus.uml.textedit.operation.xtext.operation.OperationPackage.eINSTANCE);
		return result;
	}

}
