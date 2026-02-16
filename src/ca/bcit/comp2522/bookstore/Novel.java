package ca.bcit.comp2522.bookstore;

public final class Novel implements Comparable<Novel>
{
    private static final int EARLIEST_BOOK_PUBLISHED_YEAR = 868;
    private static final int CURRENT_YEAR = 2026;

    private final String title;
    private final String authorName;
    private final int yearPublished;

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

    public String getTitle()
    {
        return title;
    }

    public String getAuthorName()
    {
        return authorName;
    }
    public int getYearPublished()
    {
        return yearPublished;
    }

    @Override
    public String toString()
    {
        return "Book{title='" + title + "Author= " + authorName + "', Year Published=" + yearPublished + "}";
    }

    @Override
    public int compareTo(final Novel otherNovel) {
       final String o;

       o = otherNovel.getTitle();

       return this.title.compareToIgnoreCase(o);
    }

    private static void validateTitle(final String title)
    {
        if (title == null||
        title.isBlank())
        {
            throw new IllegalArgumentException("Invalid title");
        }
    }

    private static void validateAuthorName(final String authorName)
    {
        if (authorName == null ||
        authorName.isBlank())
        {
            throw new IllegalArgumentException("Invalid name of author");
        }
    }

    private static void validateYearPublished(final int yearPublished)
    {
        if( yearPublished < EARLIEST_BOOK_PUBLISHED_YEAR ||
        yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Invalid publication year");
        }
    }
}
