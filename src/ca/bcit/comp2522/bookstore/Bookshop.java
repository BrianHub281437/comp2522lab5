package ca.bcit.comp2522.bookstore;

import java.util.*;

/**
 * Represents a bookshop that processes a collection of novels by storing,
 * filtering, and sorting them based on their titles.
 * <p>
 * When a {@code Bookshop} instance is created, it:
 * <ol>
 *     <li>Stores each {@link Novel} in a map keyed by its title.</li>
 *     <li>Removes any novel whose title contains the substring
 *         {@code "the"} (case-insensitive).</li>
 *     <li>Creates a sorted list of the remaining titles in lexicographical order.</li>
 *     <li>Prints the sorted novels without titles containing {@code "the"}.</li>
 * </ol>
 *
 * <p>This class is primarily intended for demonstrating
 * <code>Map</code>, <code>Set</code>, iterators, and sorting operations.</p>
 */
public class Bookshop
{
    private final Map <String, Novel> novelMap;
    private final Set <String> key;
    private final List<String> keyList;

/**
 * Constructs a Bookshop that stores, filters, and prints novels
 * according to the assignment requirements.
 *
 * @param novels the list of novels to load
 */
    Bookshop (List<Novel> novels) {
        novelMap = new HashMap<>();
        key = novelMap.keySet();

        for (final Novel n : novels) {
            novelMap.put(n.getTitle(), n);
        }

        System.out.println("All titles BEFORE removal: ");
        for (final String title : key)
        {
            System.out.println(title);
        }

        Iterator<String> it;
        it = key.iterator();
        while (it.hasNext()) {
            String title;
            title = it.next();

            if (title.toLowerCase().contains("the")) {
                it.remove();
            }
        }

        keyList = new ArrayList<>(key);

        Collections.sort(keyList);

        System.out.println("Sorted novels with no the");
        for (final String sortedTitle : keyList)
        {
            System.out.println(novelMap.get(sortedTitle));
        }

    }
}
