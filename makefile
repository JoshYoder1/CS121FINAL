Dealer.class: Dealer.java Player.class
	javac Dealer.java

Player.class: Player.java
	javac Player.java

testDealer:
	javac Dealer.java
	java Dealer.class
save:
	git add *
	git status
	git commit *
	git push origin main
