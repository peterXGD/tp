package seedu.address.model.util;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.EventTag;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends"),
                getEventTagSet("marketing|marketing dpt|2024-04-01T09:00:00|2024-04-01T09:00:00")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends"),
                getEventTagSet("marketing|marketing dpt|2024-04-01T09:00:00|2024-04-01T09:00:00")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours"),
                getEventTagSet("logistics|logistics dpt|2024-04-01T09:00:00|2024-04-01T09:00:00")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family"),
                getEventTagSet("logistics|logistics dpt|2024-04-01T09:00:00|2024-04-01T09:00:00")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates"),
                getEventTagSet("logistics|logistics dpt|2024-04-01T09:00:00|2024-04-01T09:00:00")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"),
                getEventTagSet("VPD|vice project director|2024-04-01T09:00:00|2024-04-01T09:00:00"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a set of event tags containing the list of strings given.
     */
    public static Set<EventTag> getEventTagSet(String... strings) {
        Set<EventTag> eventTags = new HashSet<>();
        for (String s : strings) {
            // parse string to extract tag name, description, start date, and end date
            // eg. "tagName|description|startDate|endDate"
            String[] parts = s.split("\\|");
            String tagName = parts[0];
            String description = parts[1];
            LocalDateTime startDate = LocalDateTime.parse(parts[2]);
            LocalDateTime endDate = LocalDateTime.parse(parts[3]);

            eventTags.add(new EventTag(tagName, description, startDate, endDate));
        }
        return eventTags;
    }

}
