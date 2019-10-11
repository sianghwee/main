package seedu.address.model.item;

import seedu.address.commons.core.item.Event;
import seedu.address.commons.core.item.Item;

/**
 * Object class to store all the items that are events within the program
 */
public class EventList extends ItemList {
    public EventList() {
        super();
    }

    /**
     * Sorts the event list based on the DTG of the event. If the DTG of the events are the same
     * they are sorted by priority.
     * @return a sorted EventList of the current list
     */
    public ItemList sort() {
        EventList el = new EventList();
        for (Item item: list) {
            el.add(item);
        }

        el.list.sort((item1, item2) -> {
            Event event1 = item1.getEvent().get();
            Event event2 = item2.getEvent().get();

            int diff = event1.getStartDateTime().compareTo(event2.getStartDateTime());

            if (diff != 0) {
                return diff;
            } else {
                return event1.getPriority().compareTo(event2.getPriority());
            }
        });
        
        return el;
    }

    /**
     * Finds a substring within the description of an item.
     * @param searchString a string to be search for within the description of an item
     * @return a new EventList only containing the items that have the search string in their description
     */
    public ItemList find(String searchString) {
        EventList el = new EventList();
        return find(searchString, el);
    }
}
