run: Program.class Venue.class
	java Program

Program.class: Program.java Venue.class
	javac Program.java

Venue.class: Venue.java
	javac Venue.java

save:
	git add *
	git status
	git commit
	git push origin main

clean:
	rm *.class
