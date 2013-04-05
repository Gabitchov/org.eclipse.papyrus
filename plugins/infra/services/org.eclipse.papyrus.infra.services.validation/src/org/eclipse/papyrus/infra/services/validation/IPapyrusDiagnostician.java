package org.eclipse.papyrus.infra.services.validation;

import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;


public interface IPapyrusDiagnostician extends  EValidator.SubstitutionLabelProvider, EValidator{

	/**
	 * comes from {@link org.eclipse.emf.ecore.util.Diagnostician}
	 */
	public Map<Object, Object> createDefaultContext();

	/**
	 * comes from {@link org.eclipse.emf.ecore.util.Diagnostician}
	 */
	public BasicDiagnostic createDefaultDiagnostic(EObject eObject);

	/**
	 * use to initialize with the good context during the execution of a command
	 * @param adapterFactory
	 * @param progressMonitor
	 */
	public void initialize (final AdapterFactory adapterFactory, final IProgressMonitor progressMonitor);
}
