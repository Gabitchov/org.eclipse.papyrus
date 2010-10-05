package org.eclipse.papyrus.property.editor.xtext.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.property.editor.xtext.validation.UmlPropertyJavaValidator;
import org.eclipse.papyrus.umlutils.MultiplicityElementUtil;
import org.eclipse.papyrus.umlutils.NamedElementUtil;
import org.eclipse.papyrus.umlutils.PropertyUtil;
import org.eclipse.papyrus.umlutils.TypeUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.Package ;

public class UMLPropertyEditorPropertyUtil extends PropertyUtil {

	public static String getLabel(Property property) {
		StringBuffer buffer = new StringBuffer();
		// visibility
		buffer.append(" ");
		buffer.append(NamedElementUtil.getVisibilityAsSign(property));

		// derived property
		buffer.append(getDerived(property));

		// name
		buffer.append(" ");
		buffer.append(getName(property));

		// type
		if(property.getType() != null) {
			buffer.append(" : " + getTypeLabel(property.getType()));
		} else {
			buffer.append(" : " + TypeUtil.UNDEFINED_TYPE_NAME);
		}

		// multiplicity -> do not display [1]
		String multiplicity = MultiplicityElementUtil.getMultiplicityAsString(property);
		if(!multiplicity.trim().equals("[1]")) {
			buffer.append(multiplicity);
		}

		// default value
		if(property.getDefault() != null) {
			buffer.append(" = ");
			buffer.append(property.getDefault());
		}

		// property modifiers
		buffer.append(" ") ;
		buffer.append(PropertyUtil.getModifiersAsString(property, false));

		
		
		return buffer.toString();
	}
	
	public static String getTypeLabel(Type type) {
		String label = "" ;
		
		Namespace model = UmlPropertyJavaValidator.getModel() ;
		List<Package> importedPackages = new ArrayList<Package>(model.getImportedPackages()) ;
		
		List<Package> visitedPackages = new ArrayList<Package>() ;
		Package currentPackage = type.getNearestPackage() ;
		
		boolean rootFound = false ;
		
		while (currentPackage != null && !rootFound) {
			visitedPackages.add(currentPackage) ;
			if (importedPackages.contains(currentPackage) || currentPackage == model) {
				rootFound = true ;
			}
			Element owner = currentPackage.getOwner() ;
			while (owner != null && !(owner instanceof Package))
				owner = owner.getOwner() ;
			
			currentPackage = owner != null ? (Package)owner : null ;
		}
		
		for (int i = visitedPackages.size() - 1 ; i >= 0 ; i--) {
			label += visitedPackages.get(i).getName() + "::" ; 
		}
		
		return label + type.getName() ;
	}
}
