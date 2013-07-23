package org.eclipse.papyrus.robotml.validation.constraints;

import org.eclipse.papyrus.RobotML.RobotMLPackage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.util.UMLUtil;

public  class ConstraintsUtil {
	public static Boolean verifyRobotMLApplied(Element elt){
		Boolean isRobotmlModel = false;
		Model model = elt.getModel();
		if ((model != null)&& (model instanceof Package)){			

				Profile robotml = UMLUtil.getProfile(RobotMLPackage.eINSTANCE, model);

				if(((Package)model).isProfileApplied(robotml)) {
					isRobotmlModel = true;
				}
					
			
		
		}
		return isRobotmlModel;
	}

}
