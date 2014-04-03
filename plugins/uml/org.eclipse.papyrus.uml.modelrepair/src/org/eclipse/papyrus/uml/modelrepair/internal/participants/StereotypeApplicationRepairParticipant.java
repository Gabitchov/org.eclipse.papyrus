/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.modelrepair.internal.participants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.papyrus.infra.emf.resource.IDependencyReplacementParticipant;
import org.eclipse.papyrus.infra.emf.resource.Replacement;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.uml2.common.util.UML2Util;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.internal.operations.PackageOperations;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;


/**
 * This is the StereotypeApplicationRepairParticipant type. Enjoy.
 */
//extending UML-internal PackageOperations class to access protected API
@SuppressWarnings("restriction")
public class StereotypeApplicationRepairParticipant extends PackageOperations implements IDependencyReplacementParticipant {

	public StereotypeApplicationRepairParticipant() {
		super();
	}

	public void postProcessReplacements(Collection<? extends Replacement> replacements, Collection<? extends Resource> resources, IProgressMonitor monitor, DiagnosticChain diagnostics) {
		monitor = SubMonitor.convert(monitor, "Updating stereotype applications ...", replacements.size() + 1);

		Map<ProfileApplication, Replacement> applicationsToDefinitions = Maps.newHashMap();

		for(Replacement next : replacements) {
			if(next.getEStructuralFeature() == UMLPackage.Literals.PROFILE_APPLICATION__APPLIED_PROFILE) {
				ProfileApplication application = (ProfileApplication)next.getEObject();
				if(application.getApplyingPackage() != null) {
					if(!applicationsToDefinitions.containsKey(application)) {
						applicationsToDefinitions.put(application, next);
					} // else we processed the applied-definition annotation, first
				} else if(diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING, Activator.PLUGIN_ID, 0, "Profile application has no applying package: " + application, null)); //$NON-NLS-1$
				}
			} else if(next.getEStructuralFeature() == EcorePackage.Literals.EANNOTATION__REFERENCES) {
				if(next.getOldValue() instanceof EPackage) {
					EObject application = ((EAnnotation)next.getEObject()).getEModelElement();
					if(application instanceof ProfileApplication) {
						applicationsToDefinitions.put((ProfileApplication)application, next);
					}
				}
			}
		}

		for(Map.Entry<ProfileApplication, Replacement> next : applicationsToDefinitions.entrySet()) {
			ProfileApplication application = next.getKey();
			EPackage oldDefinition = (EPackage)next.getValue().getOldValue();

			migrateStereotypeApplications(application, application.getApplyingPackage(), oldDefinition, diagnostics);
			monitor.worked(1);
		}

		monitor.done();
	}

	protected void migrateStereotypeApplications(ProfileApplication profileApplication, Package applyingPackage, EPackage oldDefinition, DiagnosticChain diagnostics) {
		Profile newProfile = profileApplication.getAppliedProfile();
		if(newProfile.eIsProxy()) {
			// the profile's ID has changed. Try to locate the new one
			newProfile = resolveNewProfile(profileApplication.eResource().getResourceSet(), newProfile, oldDefinition);
			if(newProfile != profileApplication.getAppliedProfile()) {
				// Found a new profile. Update the profile application
				profileApplication.setAppliedProfile(newProfile);
			}
		}

		EPackage definition = profileApplication.getAppliedDefinition();
		EPackage newDefinition = newProfile.getDefinition();
		if((newDefinition != null) && (newDefinition != definition)) {
			// Update the profile application's applied definition
			EList<EObject> references = getEAnnotation(profileApplication, UML2_UML_PACKAGE_2_0_NS_URI, true).getReferences();

			if(references.isEmpty()) {
				references.add(newDefinition);
			} else {
				references.set(0, newDefinition);
			}
		}

		EcoreUtil.Copier copier = new StereotypeApplicationRepairCopier(newProfile, diagnostics);

		List<EObject> oldStereotypeApplications = Lists.newArrayList();
		for(TreeIterator<EObject> iter = getAllContents(applyingPackage, true, false); iter.hasNext();) {
			EObject element = iter.next();

			// stereotypes are only applicable to Elements
			if(element instanceof Element) {
				for(EStructuralFeature.Setting setting : EMFHelper.getUsages(element)) {
					EObject owner = setting.getEObject();
					if(isStereotypeApplicationExtensionSetting(owner, setting)) {
						// Looks like a stereotype application.  Do we need to rebuild it?
						if(owner.eClass().getEPackage() == oldDefinition) {
							oldStereotypeApplications.add(owner);
							EObject newInstance = copier.copy(owner);
							if((newInstance != null) && (newInstance != owner)) {
								// Depends how we copied the stereotype instance (by applying again or not),
								// it may not be attached, yet
								if(newInstance.eResource() == null) {
									EcoreUtil.replace(owner, newInstance);
								}
							}
						}
					}
				}
			} else {
				// non-Elements do not contain Elements, or if they do, they have no meaning in the model
				iter.prune();
			}
		}

		copier.copyReferences();

		UML2Util.destroyAll(oldStereotypeApplications);

		if(!newProfile.getOwnedExtensions(true).isEmpty()) {
			// Ensure that required stereotypes of the new profile are applied
			applyAllRequiredStereotypes(profileApplication.getApplyingPackage());
		}
	}

	protected boolean isStereotypeApplicationExtensionSetting(EObject owner, EStructuralFeature.Setting setting) {
		EStructuralFeature feature = setting.getEStructuralFeature();
		return !(owner instanceof Element) && (feature instanceof EReference) && feature.getName().startsWith("base_") && UMLPackage.Literals.ELEMENT.isSuperTypeOf(((EReference)feature).getEReferenceType());
	}

	protected Profile resolveNewProfile(ResourceSet context, Profile proxy, EPackage oldDefinition) {
		Profile result = proxy;

		if(context != null) {
			try {
				Resource res = context.getResource(EcoreUtil.getURI(proxy).trimFragment(), true);
				if(res != null) {
					Profile oldProfile = (Profile)getNamedElement(oldDefinition);
					String qname = (oldProfile != null) ? getQualifiedName(oldProfile) : getQualifiedName(oldDefinition, NamedElement.SEPARATOR);
					Collection<Profile> resolved = findNamedElements(res, qname);
					if(!resolved.isEmpty()) {
						result = resolved.iterator().next();
					} else {
						Profile profile = (Profile)EcoreUtil.getObjectByType(res.getContents(), UMLPackage.Literals.PROFILE);
						if(profile != null) {
							result = profile;
						}
					}
				}
			} catch (Exception e) {
				// Couldn't resolve.  Fine
				Activator.log.error(e);
			}
		}

		return result;
	}

	//
	// Nested types
	//

	protected static class StereotypeApplicationRepairCopier extends StereotypeApplicationCopier {

		private static final long serialVersionUID = 1L;

		private final DiagnosticChain diagnostics;

		/**
		 * @param profile
		 * @param diagnostics
		 *        may be {@code null}
		 */
		public StereotypeApplicationRepairCopier(Profile profile, DiagnosticChain diagnostics) {
			super(profile);
			this.diagnostics = diagnostics;
		}

		@Override
		protected EObject createCopy(EObject eObject) {
			try {
				return super.createCopy(eObject);
			} catch (IllegalStateException e) {
				// target EClass does not exist in the profile
				if(diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, e.getLocalizedMessage(), null));
				}
				return null;
			}
		}

		@Override
		protected EClass getTarget(EClass eClass) {
			NamedElement namedElement = getNamedElement(eClass, profile);
			NamedElement newNamedElement = getSameNamedElement(namedElement, profile);
			EClass definition = (newNamedElement == null) ? null : (EClass)profile.getDefinition(newNamedElement);

			if(definition != null) {
				return definition;
			} else {
				String qname = (namedElement != null) ? getQualifiedName(namedElement) : getQualifiedName(eClass, NamedElement.SEPARATOR);
				throw new IllegalStateException(String.format("Definition for stereotype/class '%s' not found in profile '%s'", //$NON-NLS-1$
					qname, getQualifiedName(profile)));
			}
		}

		@Override
		protected EStructuralFeature getTarget(EStructuralFeature eStructuralFeature) {
			NamedElement namedElement = getNamedElement(eStructuralFeature, profile);
			NamedElement newNamedElement = getSameNamedElement(namedElement, profile);
			EStructuralFeature definition = (newNamedElement == null) ? null : (EStructuralFeature)profile.getDefinition(newNamedElement);

			if(definition != null) {
				return definition;
			} else {
				String qname = (namedElement != null) ? getQualifiedName(namedElement) : getQualifiedName(eStructuralFeature, NamedElement.SEPARATOR);
				throw new IllegalStateException(String.format("Definition for property '%s' not found in profile '%s'", //$NON-NLS-1$
					qname, getQualifiedName(profile)));
			}
		}

		protected NamedElement getSameNamedElement(NamedElement namedElement, Package package_) {
			if(namedElement == null) {
				return null;
			}

			return findNamedElement(package_, namedElement.getQualifiedName(), namedElement.eClass());
		}

		// FIXME: Add overrideable handleException() method to the superclass
		@Override
		protected void copyAttribute(EAttribute eAttribute, EObject eObject, EObject copyEObject) {

			if(!eAttribute.isUnsettable() || eObject.eIsSet(eAttribute)) {

				try {
					if(eAttribute.getEType().eClass().getClassifierID() == EcorePackage.EENUM) {
						copyEEnumAttribute(eAttribute, eObject, copyEObject);
					} else {
						copyEDataTypeAttribute(eAttribute, eObject, copyEObject);
					}
				} catch (Exception e) {
					// target EClass does not have this attribute in the profile
					if(diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, e.getLocalizedMessage(), null));
					}
				}
			}
		}

		// FIXME: Add overrideable handleException() method to the superclass
		@Override
		protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {

			if(eObject.eIsSet(eReference)) {
				Object value = eObject.eGet(eReference);

				try {
					EReference targetEReference = (EReference)getTarget(eReference);

					if(targetEReference != null && targetEReference.isChangeable()) {

						if(targetEReference.isMany()) {
							@SuppressWarnings("unchecked")
							EList<EObject> copyValues = (EList<EObject>)copyEObject.eGet(targetEReference);

							if(eReference.isMany()) {
								@SuppressWarnings("unchecked")
								EList<EObject> values = (EList<EObject>)value;
								copyValues.addAll(copyAll(values));
							} else if(value != null) {
								copyValues.add(copy((EObject)value));
							}
						} else {

							if(eReference.isMany()) {
								@SuppressWarnings("unchecked")
								EList<EObject> values = (EList<EObject>)value;
								copyEObject.eSet(targetEReference, copy(values.get(0)));
							} else {
								copyEObject.eSet(targetEReference, copy((EObject)value));
							}
						}
					}
				} catch (Exception e) {
					// target EClass does not have this containment reference in the profile
					if(diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, e.getLocalizedMessage(), null));
					}
				}
			}
		}

		// FIXME: Add overrideable handleException() method to the superclass
		@Override
		protected void copyReference(EReference eReference, EObject eObject, EObject copyEObject) {

			if(eObject.eIsSet(eReference)) {
				Object value = eObject.eGet(eReference);

				try {
					EReference targetEReference = (EReference)getTarget(eReference);

					if(targetEReference != null && targetEReference.isChangeable()) {

						if(targetEReference.isMany()) {
							@SuppressWarnings("unchecked")
							InternalEList<EObject> copyValues = (InternalEList<EObject>)copyEObject.eGet(targetEReference);

							if(eReference.isMany()) {
								EReference targetEOpposite = targetEReference.getEOpposite();
								int index = 0;

								@SuppressWarnings("unchecked")
								Iterator<EObject> v = ((EList<EObject>)value).iterator();

								while(v.hasNext()) {
									value = v.next();
									EObject copyValue = get(value);

									if(copyValue == null) {

										if(targetEOpposite == null) {
											copyValues.addUnique(index++, (EObject)value);
										}
									} else {

										if(targetEOpposite != null) {
											int position = copyValues.indexOf(copyValue);

											if(position == -1) {
												copyValues.addUnique(index++, copyValue);
											} else if(position != index) {
												copyValues.move(index++, copyValue);
											}
										} else {
											copyValues.addUnique(index++, copyValue);
										}
									}
								}
							} else if(value != null) {
								EObject copyValue = get(value);

								if(copyValue == null) {

									if(targetEReference.getEOpposite() == null) {
										copyValues.addUnique((EObject)value);
									}
								} else {
									copyValues.addUnique(copyValue);
								}
							}
						} else {

							if(eReference.isMany()) {
								@SuppressWarnings("unchecked")
								EList<EObject> values = (EList<EObject>)value;
								value = values.get(0);
							}

							Object copyValue = get(value);

							if(copyValue == null) {

								if(targetEReference.getEOpposite() == null) {
									copyEObject.eSet(targetEReference, value);
								}
							} else {
								copyEObject.eSet(targetEReference, copyValue);
							}
						}
					}
				} catch (Exception e) {
					// target EClass does not have this reference in the profile
					if(diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, e.getLocalizedMessage(), null));
					}
				}
			}
		}

		private static NamedElement findNamedElement(NamedElement search, String qualifiedName, EClass metaclass) {
			NamedElement result = null;

			int separator = qualifiedName.indexOf(NamedElement.SEPARATOR);
			if(separator < 0) {
				// last segment
				if(qualifiedName.equals(search.getName()) && metaclass.isInstance(search)) {
					result = search;
				}
			} else {
				String nextSegment = qualifiedName.substring(0, separator);
				String rest = qualifiedName.substring(separator + NamedElement.SEPARATOR.length());

				// Must be a namespace if we are to look for another segment
				if(nextSegment.equals(search.getName()) && (search instanceof Namespace)) {
					for(NamedElement next : ((Namespace)search).getMembers()) {
						result = findNamedElement(next, rest, metaclass);
						if(result != null) {
							break;
						}
					}
				}
			}

			return result;
		}
	}
}
