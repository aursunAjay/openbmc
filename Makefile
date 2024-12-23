
all:
	git add .
	git commit -m "local"
	git tag -a v$(v)-dev-main -m "$(i)"	 
	git push --tags
	git push
	
main:
	git add meta-krutrim/
	git commit -m "local"
	git branch -a
	git tag
	git push  

info:
	git add meta-krutrim/
	git commit -m "local"
	git tag -a v0.1-dev-main -m "$(MESSAGE)"
	git branch -a
	git tag
	git push --tags

