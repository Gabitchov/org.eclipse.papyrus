package org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.validation;
 
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.marte.vsl.validation.VSLJavaValidator;
import org.eclipse.xtext.validation.ComposedChecks;

@ComposedChecks(validators= {org.eclipse.xtext.validation.ImportUriValidator.class, org.eclipse.xtext.validation.NamesAreUniqueValidator.class})
public class AbstractStereotypeApplicationWithVSLJavaValidator extends VSLJavaValidator {

	@Override
	protected List<EPackage> getEPackages() {
	    List<EPackage> result = new ArrayList<EPackage>();
	    result.add(org.eclipse.papyrus.stereotypeapplicationwithvsl.editor.xtext.stereotypeApplicationWithVSL.StereotypeApplicationWithVSLPackage.eINSTANCE);
		return result;
	}

}
