package org.eclipse.papyrus.qompass.designer.core.templates;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Classifier;

import Cpp.CppInclude;
import FCM.Template;
import FCM.TemplateKind;

import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.acceleo.AcceleoDriver;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationContext;
import org.eclipse.papyrus.qompass.designer.core.transformations.TransformationException;

/**
 * Synchronize derived realizations (after copying). If re-synchronization is not done, the
 * relationship would point to wrong interface, if it is derived and depending on a formal parameter
 * (e.g. derived push interface with formal parameter T would be at wrong location).
 * => TODO: incomplete explication, re-think about location of derived interface
 * 
 * @author ansgar
 * 
 */
public class InstantiateCppIncludeWOB implements CopyListener {

	public static InstantiateCppIncludeWOB getInstance() {
		if(instance == null) {
			instance = new InstantiateCppIncludeWOB();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject targetEObj) {
		// if (copy.get(sourceEObj) isWithinTemplate)
		if(targetEObj instanceof Classifier) {
			// TODO: C++ specific code!
			Classifier targetCl = (Classifier)targetEObj;
			Template template = StUtils.getApplication(targetCl, Template.class);
			// apply, in case of pass-classifier
			if((template != null) && (template.getKind() == TemplateKind.PASS_CLASSIFIER)) {
				try {
					CppInclude cppInclude = StUtils.getApplication(targetCl, CppInclude.class);
					TransformationContext.classifier = targetCl;
					String newBody = AcceleoDriver.evaluate(cppInclude.getBody(), targetCl, null);
					String newPreBody = AcceleoDriver.evaluate(cppInclude.getPreBody(), targetCl, null);
					String newHeader = AcceleoDriver.evaluate(cppInclude.getHeader(), targetCl, null);
					cppInclude.setBody(newBody);
					cppInclude.setPreBody(newPreBody);
					cppInclude.setHeader(newHeader);
				} catch (TransformationException e) {
					// create nested exception
					throw new RuntimeException(e);
				}
			}
		}
		return targetEObj;
	}

	private static InstantiateCppIncludeWOB instance = null;
}
