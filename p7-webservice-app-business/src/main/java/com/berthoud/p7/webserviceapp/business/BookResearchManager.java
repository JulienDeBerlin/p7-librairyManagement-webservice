package com.berthoud.p7.webserviceapp.business;

import com.berthoud.p7.webserviceapp.consumer.contract.BookReferenceDAO;
import com.berthoud.p7.webserviceapp.model.entities.Book;
import com.berthoud.p7.webserviceapp.model.entities.BookReference;
import com.berthoud.p7.webserviceapp.model.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * This class is dedicated to the research of books in the catalog of the librairies.
 * It gathers all methods required for the book research.
 */
@Service
public class BookResearchManager {

    @Autowired
    BookReferenceDAO bookReferenceDAO;

    /**
     * This method is use to perform a book research. There are 3 research parameters ( author, title or keywords also called tags)
     * and 1 filter by librairy. At least 1 research parameter should be indicated otherwise an exception is thrown.
     *
     * @param authorSurname research parameter: authorSurname is the exact name of the author, NOT case sensitive
     * @param titleElement, research parameter: titleElement is the title or part of it, NOT case sensitive
     * @param librairyId,   filter, librairyId is the ID of the librairy. It the research should be extended to all librairies, use id = -1
     * @param tags,         research parameter, tags is a list of tags ( 0 to unlimited)
     * @return a list of BookReference that match with the research-parameters.
     */
    public List<BookReference> findBookMultiParameters(String authorSurname, String titleElement, int librairyId, List<String> tags) {

        List<BookReference> bookReferenceList = new ArrayList<>();

        Set<String> tagsHashSet = convertListStringIntoSetString(tags);

        // 3 parameters
        if (authorSurname != "" && titleElement != "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTagsAndTitleElementAndAuthor(tagsHashSet, tagsHashSet.size(), titleElement, authorSurname);
        }

        // 2 parameters
        else if (authorSurname != "" && titleElement != "" && tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findByAuthorSurnameAndTitleContainsAllIgnoreCase(authorSurname, titleElement);
        } else if (authorSurname == "" && titleElement != "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTagsAndTitleElement(tagsHashSet, tagsHashSet.size(), titleElement);
        } else if (authorSurname != "" && titleElement == "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTagsAndAuthor(tagsHashSet, tagsHashSet.size(), authorSurname);
        }

        // only 1 parameter
        else if (authorSurname != "" && titleElement == "" && tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findByAuthorSurnameIgnoreCase(authorSurname);
        } else if (authorSurname == "" && titleElement != "" && tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findByTitleContainsIgnoreCase(titleElement);
        } else if (authorSurname == "" && titleElement == "" && !tags.isEmpty()) {
            bookReferenceList = bookReferenceDAO.findBookReferenceByTags(tagsHashSet, tagsHashSet.size());
        }

        // 0 parameter
        else {
            // THROW EXCEPTION
        }

        // Filter through librairy
        return filterBookReferenceListByLibrairy(bookReferenceList, librairyId);
    }


    /**
     * This method takes as input a list of BookReferences and a librairy Id. It checks if the selected librairy owes at least one
     * book matching with the selected BookReference. If no, the BookReference is sorted out from the list.
     *
     * @param bookReferenceList the list of BookReference objects to be filtered
     * @param librairyId        the id of the selected librairy
     * @return a list of BookReferences containing only books that can be found in the selected librairy.
     */
    public List<BookReference> filterBookReferenceListByLibrairy(List<BookReference> bookReferenceList, int librairyId) {

        if (librairyId != -1) {

            Iterator<BookReference> i = bookReferenceList.iterator();
            while (i.hasNext()) {
                BookReference br = i.next();

                int test = 0;
                Iterator<Book> j = br.getBooks().iterator();
                while (j.hasNext()) {
                    Book book = j.next();
                    if (book.getLibrairy().getId() == librairyId) {
                        test++;
                        break;
                    }
                }

                if (test == 0) {
                    i.remove();
                }
            }
        }
        return bookReferenceList;
    }



//    public Set<Tag> convertListStringIntoSetTag(List<String> keywords) {
//
//        Set<Tag> tagHashSet = new HashSet<Tag>();
//
//        //create a tag for every keyword of the list:
//        for (String s : keywords) {
//            Tag newTag = new Tag();
//            newTag.setName(s);
//
//            // add the tag to the HashSet:
//            tagHashSet.add(newTag);
//        }
//
//        return tagHashSet;
//    }


    /**
     * This is a small tool to convert a List of String into a set of strings
     * @param keywords the list to be converted
     * @return
     */
    public Set<String> convertListStringIntoSetString(List<String> keywords) {
        return new HashSet<>(keywords);
    }


}
