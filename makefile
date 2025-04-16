Dealer.class: Dealer.java Player.class
	javac Dealer.java

Player.class: Player.java
	javac Player.java

testDealer:
	javac Dealer.java
	java Dealer
save:
	git add *
	git status
	git commit *
	git push origin main

clean:
	rm *.class
