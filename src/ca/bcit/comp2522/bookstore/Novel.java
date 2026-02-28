package ca.bcit.comp2522.bookstore;

/**
 * Represents a novel with a title, the author's name, and the year it was published.
 * <p>
 * A {@code Novel} instance is immutable: its title, author name, and publication
 * year are validated during construction and cannot be changed afterward.
 * The class also provides natural ordering based on the novel's title,
 * ignoring case differences.
 * <p>
 * Input validation ensures:
 * <ul>
 *     <li>The title is non-{@code null} and not blank.</li>
 *     <li>The author's name is non-{@code null} and not blank.</li>
 *     <li>The publication year falls within the valid range from
 *         {@code EARLIEST_BOOK_PUBLISHED_YEAR} to {@code CURRENT_YEAR}.</li>
 * </ul>
 *
 * This class implements {@link Comparable} to allow novels to be sorted
 * lexicographically by title, ignoring case.
 */
public final class Novel implements Comparable<Novel>
{
    private static final int EARLIEST_BOOK_PUBLISHED_YEAR = 868;
    private static final int CURRENT_YEAR = 2026;

    private final String title;
    private final String authorName;
    private final int yearPublished;

    /**
     * Constructs a novel.
     *
     * @param title         novel's title: must be valid.
     * @param authorName    novel's author: must be valid.
     * @param yearPublished novel's year published: must be valid.
     */
    public Novel(final String title,
                 final String authorName,
                 final int yearPublished)
    {
        validateTitle(title);
        validateAuthorName(authorName);
        validateYearPublished(yearPublished);

        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    /**
     * Returns novel's title.
     *
     * @return novel's title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns author's name.
     *
     * @return author's name
     */
    public String getAuthorName()
    {
        return authorName;
    }

    /**
     * Returns novel's year published.
     *
     * @return novel's year published
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Returns formatted title string.
     *
     * @return formatted title string.
     */
    @Override
    public String toString()
    {
        return title;
    }

    /**
     * Compares this novel to another novel based on their titles, ignoring case.
     * <p>
     * The comparison is performed using {@link String#compareToIgnoreCase(String)},
     * so the result reflects lexicographical ordering without considering case
     * differences.
     *
     * @param otherNovel the novel to compare against; must not be {@code null}
     * @return a negative integer, zero, or a positive integer as this novel's title
     *         is lexicographically less than, equal to, or greater than the title
     *         of {@code otherNovel}, ignoring case
     * @throws NullPointerException if {@code otherNovel} is {@code null}
     */
    @Override
    public int compareTo(final Novel otherNovel) {
       final String o;

       o = otherNovel.getTitle();

       return this.title.compareToIgnoreCase(o);
    }

    /**
     * Validates the given title to ensure it is neither {@code null} nor blank.
     * <p>
     * A title is considered invalid if it is {@code null} or contains only
     * whitespace characters. If the title is invalid, this method throws an
     * {@link IllegalArgumentException}.
     *
     * @param title the title string to validate
     * @throws IllegalArgumentException if the title is {@code null} or blank
     */
    private static void validateTitle(final String title)
    {
        if (title == null||
        title.isBlank())
        {
            throw new IllegalArgumentException("Invalid title");
        }
    }

    /**
     * Validates the provided author name to ensure it is neither {@code null}
     * nor blank.
     * <p>
     * An author name is considered invalid if it is {@code null} or consists
     * only of whitespace characters. If the name is invalid, this method
     * throws an {@link IllegalArgumentException}.
     *
     * @param authorName the author's name to validate
     * @throws IllegalArgumentException if {@code authorName} is {@code null} or blank
     */
    private static void validateAuthorName(final String authorName)
    {
        if (authorName == null ||
        authorName.isBlank())
        {
            throw new IllegalArgumentException("Invalid name of author");
        }
    }

    /**
     * Validates that the provided publication year falls within the allowed range.
     * <p>
     * The year is considered invalid if it is earlier than
     * {@code EARLIEST_BOOK_PUBLISHED_YEAR} or later than {@code CURRENT_YEAR}.
     * If the year is outside this range, an {@link IllegalArgumentException} is thrown.
     *
     * @param yearPublished the publication year to validate
     * @throws IllegalArgumentException if {@code yearPublished} is earlier than
     *         {@code EARLIEST_BOOK_PUBLISHED_YEAR} or greater than {@code CURRENT_YEAR}
     */
    private static void validateYearPublished(final int yearPublished)
    {
        if( yearPublished < EARLIEST_BOOK_PUBLISHED_YEAR ||
        yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid publication year");
        }
    }
}
