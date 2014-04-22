################################################################################
# Copyright (c) 2014 CEA LIST.
#
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# Contributors:
# Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
#
################################################################################

import os # File handling
import os.path # File path handling
import re # Regular expressions
import sys # System
import xml.dom.minidom # Minimal XML

import console # Console pretty printing
import eclipse # Eclipse API
import xmlutils # XML utilities


# Represents a build target
class Target:
	def __init__(self, name, pom, site, feature):
		# The target's name
		self.name = name
		# The path to the top pom.xml file
		self.pom = pom
		# The path to the repository (update site) project
		self.site = site
		# The target's top feature
		self.feature = feature


# General constants
MAVEN_MODEL_VERSION="4.0.0"

# Product constants
PRODUCT_VERSION = "1.0.0"
PRODUCT_CATEGORY_ID = "org.eclipse.papyrus.category"
PRODUCT_CATEGORY_LABEL = "Papyrus Category"
PRODUCT_CATEGORY_DESC = PRODUCT_CATEGORY_LABEL
PRODUCT_GROUP = "org.eclipse.papyrus"

# Generator targets configuration
TARGETS = [	Target(	"main",
					"releng/top-pom-main.xml",
					"releng/main",
					"org.eclipse.papyrus.sdk.feature"),
			Target(	"extras",
					"releng/top-pom-extras.xml",
					"releng/extras",
					"org.eclipse.papyrus.extra.feature"),
			Target(	"dev",
					"releng/top-pom-dev.xml",
					"releng/dev",
					"org.eclipse.papyrus.dev.feature") ]
# Generator inputs configuration
INPUTS = [
	"plugins",
	"extraplugins",
	"features/papyrus-main-features",
	"features/papyrus-extra-features",
	"features/papyrus-dev-features"
]
# Pattern to recognize required plugin to include in the build
PATTERN_INCLUDE = "org\\.eclipse\\.papyrus\\..*"
# Pattern to recognize required plugin to exclude from the build
PATTERN_EXCLUDE = "(.*\\.source.feature)|(.*\\.tests)"


# Print how to use this script
def printUsage():
	print("Usage:")
	print("  python tycho-generator.py [-h | --help] [--color]")
	print("Options:")
	print("    -h, --help: print this screen")
	print("    --color: activate console color")


# Generate the Tycho data and files
def generate(inputs, targets, includePattern, excludePattern):
	# Build repo
	console.log("== Preparing the repository ...")
	repo = getRepo(inputs, includePattern, excludePattern)
	if repo is None:
		return 1
	# Setup the bundles' target data
	for target in targets:
		addTarget(repo, target.feature, target)
	# Generate all bundles POM
	console.log("== Generating POM for features ...")
	for name in iter(sorted(repo.features)):
		if not generateBundlePOM(repo.features[name], "eclipse-feature"):
			return 2
	console.log("== Generating POM for plugins ...")
	for name in iter(sorted(repo.plugins)):
		if not generateBundlePOM(repo.plugins[name], "eclipse-plugin"):
			return 2
	# Update the targets' top pom.xml
	console.log("== Updating the module references in top POMs ...")
	for target in targets:
		updateModules(repo, target)
	return 0


# Gets an initialized repository of features and plugins
# includePattern is used to identify required plugins and features
# excludePattern is used to ignore MISSING plugins and features
def getRepo(inputs, includePattern, excludePattern):
	# Build the repo
	repo = eclipse.Repository()
	for input in inputs:
		repo.load(input)
	# Check for missing bundles
	missing = repo.check(includePattern, excludePattern)
	for m in missing:
		console.log("Missing bundle " + m, "ERROR")
	if len(missing) > 0:
		return None
	# Initializes the targets
	for name in repo.plugins:
		repo.plugins[name].targets = []
	for name in repo.features:
		repo.features[name].targets = []
	return repo


# Recursively add a target to a feature, its included features and its plugins
def addTarget(repo, featureName, target):
	# If the feature is missing
	if not featureName in repo.features:
		return
	feature = repo.features[featureName]
	# Add the target is required
	if not target in feature.targets:
		feature.targets.append(target)
	# Traverse all sub-features
	for included in feature.included:
		addTarget(repo, included, target)
	# Traverse all plugins
	for name in feature.plugins:
		if name in repo.plugins:
			plugin = repo.plugins[name]
			if not target in plugin.targets:
				plugin.targets.append(target)


# Generate the pom.xml file for the given bundle and given packaging
def generateBundlePOM(bundle, packaging):
	if len(bundle.targets) == 0:
		console.log("Bundle " + bundle.name + " has no target => skipped", "WARNING")
		return True
	if len(bundle.targets) >= 2:
		console.log("Bundle " + bundle.name + " has more than one target:", "ERROR")
		for target in bundle.targets:
			console.log("\t" + target, "ERROR")
		return False
	if os.path.isfile(os.path.join(bundle.location, "pom.xml")):
		console.log("Bundle " + bundle.name + " already has pom.xml => skipped")
		return True
	relative = os.path.relpath(".", bundle.location)
	relative = os.path.join(relative, bundle.targets[0].pom)
	impl = xml.dom.minidom.getDOMImplementation()
	doc = impl.createDocument(None, "project", None)
	project = doc.documentElement
	appendText(doc, project, "modelVersion", MAVEN_MODEL_VERSION)
	parent = doc.createElement("parent")
	project.appendChild(parent)
	appendTychoRef(doc, parent, PRODUCT_GROUP)
	appendText(doc, parent, "relativePath", relative)
	appendTychoRef(doc, project, bundle.name)
	appendText(doc, project, "packaging", packaging)
	xmlutils.output(doc, os.path.join(bundle.location, "pom.xml"))
	console.log("Bundle " + bundle.name + " POM generated for target " + bundle.targets[0].name)
	return True


# Append an element node with the given tag and content
def appendText(doc, parent, tag, content):
	child = doc.createElement(tag)
	parent.appendChild(child)
	child.appendChild(doc.createTextNode(content))


# Append Tycho-specific data
def appendTychoRef(doc, parent, id):
	appendText(doc, parent, "artifactId", id)
	appendText(doc, parent, "groupId", PRODUCT_GROUP)
	appendText(doc, parent, "version", PRODUCT_VERSION + "-SNAPSHOT")


# Updates the modules for the given target
def updateModules(repo, target):
	doc = xml.dom.minidom.parse(target.pom)
	modules = doc.getElementsByTagName("modules")[0]
	for module in modules.getElementsByTagName("module"):
		modules.removeChild(module)
	for name in iter(sorted(repo.features)):
		feature = repo.features[name]
		if target in feature.targets:
			modules.appendChild(getBundleModuleNode(feature, doc, target))
	for name in iter(sorted(repo.plugins)):
		plugin = repo.plugins[name]
		if target in plugin.targets:
			modules.appendChild(getBundleModuleNode(plugin, doc, target))
	repoNode = doc.createElement("module")
	repoNode.appendChild(doc.createTextNode(target.name))
	modules.appendChild(repoNode)
	xmlutils.output(doc, target.pom)
	console.log("Updated top POM for target " + target.name)

# Get the path to this bundle relatively to the given target's top POM
def getBundleModuleNode(bundle, doc, target):
	child = doc.createElement("module")
	child.appendChild(doc.createTextNode(os.path.join("..", bundle.location)))
	return child


# Main script
if __name__=="__main__":
	# Checks the arguments
	for arg in sys.argv[1:]:
		if arg == "-h" or arg == "--help":
			printUsage()
			sys.exit(0)
		elif arg == console.CLI_COLOR:
			console.USE_COLOR = True
	# Execute the generation
	code = generate(INPUTS, TARGETS, PATTERN_INCLUDE, PATTERN_EXCLUDE)
	sys.exit(code)