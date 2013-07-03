package org.eclipse.papyrus.qompass.designer.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.papyrus.qompass.designer.core.templates.TemplateUtils;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

/**
 * Check whether an element within a package template is referenced via a type from the outside, i.e. an element that is not
 * within this package template. This reference is only valid in the context of a template binding.
 * (within Qompass, binding is done implicitly via stereotypes - which was perhaps not the best way of doing it)
 * 
 * @author ansgar
 *
 */
public class TemplateRefWithoutBinding extends AbstractModelConstraint {

	@Override
	public IStatus validate(IValidationContext ctx)
	{
		TypedElement te = (TypedElement)ctx.getTarget();
		Type type = te.getType();
		Element owner = type;
		while (owner != null) {
			owner = owner.getOwner();
			if (owner instanceof Package) {
				Package pkg = (Package) owner;
				if (TemplateUtils.getSignatureDirect(pkg) != null) {
					if (!isWithin(pkg, te)) {
						// no composition, but not singleton: warn user to make up a proper deployment plan
						return ctx.createFailureStatus("This element is typed with '" + type.getQualifiedName() + "', but defined outside the package template '" + //$NON-NLS-1$ //$NON-NLS-2$
								pkg.getQualifiedName() + "'"); //$NON-NLS-1$
					}
				}
			}
		}
	
		return ctx.createSuccessStatus();
	}
	
	/**
	 * @param pkg A UML package  
	 * @param e an element that is eventually part of the package
	 * @return if passed element is part of the given package
	 */
	public boolean isWithin(Package pkg, Element e) {
		Element owner = e;
		while (owner != null) {
			owner = owner.getOwner();
			if (owner == pkg) {
				return true;
			}
		}
		return false;
	}
}
