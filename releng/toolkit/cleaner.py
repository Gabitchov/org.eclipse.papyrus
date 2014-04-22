################################################################################
# Copyright (c) 2013 CEA LIST.
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
import shutil # File handling
import sys # System
import subprocess # Process handling
import xml.dom.minidom # Minimal XML

import console # Console pretty printing
import eclipse # Eclipse API
import xmlutils # XML utilities


# Print how to use this script
def printUsage():
	print("Usage:")
	print("  python cleaner.py [-h | --help] [--color] <targets>")
	print("  <targets> is the list of files and directories to clean")
	print("Options:")
	print("    -h, --help: print this screen")
	print("    --color: activate console color")


# Cleanup the given bundle
def cleanup(bundle):
	cleanupClasspath(bundle)
	cleanupBuildProperties(bundle)

# Cleanup the bundle's class path
def cleanupClasspath(bundle):
	subs = os.listdir(bundle.location)
	if not ".classpath" in subs:
		return
	doc = xml.dom.minidom.parse(os.path.join(bundle.location, ".classpath"))
	dirty = False
	for entry in doc.getElementsByTagName("classpathentry"):
		data = entry.getAttribute("excluding")
		folder = entry.getAttribute("path")
		if data is not None and len(data)>0:
			files = data.split("|")
			for file in files:
				if file is not None and len(file)>0:
					dirty = True
					full = os.path.join(bundle.location, os.path.join(folder, os.path.join(file)))
					print("Found " + full)
					if full.endswith("/"):
						subprocess.call(["git", "rm", "-r", full])
					else:
						subprocess.call(["git", "rm", full])
			entry.parentNode.removeChild(entry)
	if dirty:
		xmlutils.output(doc, os.path.join(bundle.location, ".classpath"))
		console.log("Bundle " + bundle.name + " => Fixed .classpath to remove excluded sources")

# Cleanup the bundle's build properties
def cleanupBuildProperties(bundle):
	subs = os.listdir(bundle.location)
	if not "build.properties" in subs:
		return
	properties = open(os.path.join(bundle.location, "build.properties"), "r")
	found = False
	for line in properties:
		if line.find("src.includes") != -1:
			found = True
			break
	properties.close()
	if not found:
		if not "about.html" in subs:
			shutil.copy("about.html", os.path.join(bundle.location, "about.html"))
		properties = open(os.path.join(bundle.location, "build.properties"), "a")
		properties.write("src.includes = about.html\n")
		properties.close()
		console.log("Bundle " + bundle.name + " => Fixed build.properties to add src.includes")

# Execute the cleanup
def execute(targets):
	# Build the repo
	repo = eclipse.Repository()
	for target in targets:
		repo.load(target)
	# Do the cleanup
	for name in repo.plugins:
		cleanup(repo.plugins[name])
	for name in repo.features:
		cleanup(repo.features[name])

# Main script
if __name__=="__main__":
	# Checks the arguments
	nb = len(sys.argv)
	if nb <= 1:
		printUsage()
		sys.exit(1)
	
	targets = []
	# Parse the arguments
	for arg in sys.argv[1:]:
		if arg == "-h" or arg == "--help":
			printUsage()
			sys.exit(0)
		elif arg == console.CLI_COLOR:
			console.USE_COLOR = True
		else:
			targets.append(arg)
	# Execute
	code = execute(targets)
	sys.exit(code)