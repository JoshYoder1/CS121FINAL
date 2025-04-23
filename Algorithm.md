# Algorithm
## Program.java
### Start
Get an input from the user to call related functions including search, filter, and tour.
Also include an info option and an exit.
### menu
Take a menu type parameter, and call the related menu to be printed.
### set filter
Create a while loop to get a choice from the user.
Use the choice to determine if they want to set the city, capacity, or genre filter.
Also use the choice to Exit the function.
In the city filter get the first three letters because the database doesn't cover every city in indiana.
Remove the filter if there are more than 4 characters.
In capacity filter get a min and max but they dont need both.
If a letter is entered remove the filter for the respective factor.
In genre filter take any string, but if 0 is entered remove filter.
When exiting apply all filters by iterating through either the full venue list or if its not empty the filtered list.
May need temporary arraylists to add filtered venues to, then make the filtered list the temporary list.
### search
Iterate through the not empty filtered list or full list of venues.
Give option for next, add to tour, and exit.
### openTour
Iterate through the arraylist using the built in iterator.
Show each venue, and give the option for next, remove, and exit.
