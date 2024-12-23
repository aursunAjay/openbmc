# Define default values for v and i if they are not provided
v ?= 1.0   # Default version if not provided
i ?= "Release"   # Default tag message if not provided

all:
	git add meta-krutrim/ Makefile
	git commit -m "local"
	git checkout main  # Ensure you're on the main branch
	git tag -a v$(v)-dev-main -m "$(i)"  # Create tag with version v and message i
	git push --tags   # Push the tag to remote

info:
	git add meta-krutrim/ Makefile
	git commit -m "local"
	git checkout main  # Ensure you're on the main branch
	git tag -a v$(v)-dev-main -m "$(i)"  # Create tag with version v and message i
	git push --tags   # Push the tag to remote

